import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Thread> threadList = new ArrayList<>();

    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	
    	System.out.println("url: ");
    	String first_url = scanner.nextLine();
    	
    	System.out.println("max depth: ");
        int maxDepth = scanner.nextInt();
        
        System.out.println("number of threads: ");
        int numberOfThreads = scanner.nextInt();
        
        System.out.println("max patience: ");
        int maxPatience = scanner.nextInt();


        URLPool urlPool = new URLPool(maxDepth);
        try {
        	urlPool.put(new UrlDepthPair(new URL(first_url), 0));
        } catch (MalformedURLException e) {
            System.out.println(e);
        }

        for (int i = 0; i < numberOfThreads; i++) {
            WebCrawler crawler = new WebCrawler(urlPool, maxPatience);
            Thread thread = new Thread(crawler);
            threadList.add(thread);
            thread.start();
        }

        while (urlPool.getWaitingThreads() != numberOfThreads) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Interrupted exception");
            }
        }

        urlPool.seen().stream().forEach(System.out::println);

        threadList.stream().forEach(Thread::interrupt);
    }
}