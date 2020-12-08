

import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawler implements Runnable {
    private static URLPool urlPool;
    private static final int WEBPORT = 80;
    private static final String REGEX = "href=\"(.*?)\"";
    private volatile boolean running = true;
    private int maxPatience;

    public WebCrawler(URLPool urlPool, int maxPatience) {
        this.urlPool = urlPool;
        this.maxPatience = maxPatience;
    }

    public boolean isUrlValid(String url) {
        return url.startsWith(UrlDepthPair.URL_PREFIX);
    }

    public void run() {
        while (running) {
            try {
                UrlDepthPair currentPair = urlPool.get();
                processWebPage(currentPair);
            } catch (IOException e) {
                System.out.println(e);
            } catch (InterruptedException e) {
                running = false;
            }
        }
    }

    private void processWebPage(UrlDepthPair webpage) throws IOException {
        Socket sock = new Socket(webpage.getWebHost(), WEBPORT);
        sock.setSoTimeout(maxPatience);

        // отправка данных на тот конец
        OutputStream os = sock.getOutputStream();
        PrintWriter writer = new PrintWriter(os, true);

        // отправка запроса
        String docPath = webpage.getDepth() == 0 ? "/" : webpage.getDocPath();

        writer.println("GET " + docPath + " HTTP/1.1");
        writer.println("Host: " + webpage.getWebHost());
        writer.println("Connection: close\n");

        // считываем ответ
        InputStream is = sock.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        while (true) {
            String line = br.readLine();
            if (line == null) {
                break;
            }

            Pattern p = Pattern.compile(REGEX);
            Matcher m = p.matcher(line);
            while (m.find()) {
                String url = m.group(1);
                if (isUrlValid(url)) {
                    UrlDepthPair current = new UrlDepthPair(new URL(url),
                            webpage.getDepth() + 1);

                    if (!urlPool.seen(current)) {
                        int depth = webpage.getDepth();
                        if (depth < urlPool.getMaxDepth()) {
                            urlPool.put(current);
                        }
                    }
                }
            }
        }
        sock.close();
    }
}
