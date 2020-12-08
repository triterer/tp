

import java.net.URL;

public class UrlDepthPair {
    public static final String URL_PREFIX = "https://";
    private URL url;
    private int depth;

    public UrlDepthPair(URL url, int depth) {
        this.url = url;
        this.depth = depth;
    }

    public int getDepth() {
        return this.depth;
    }

    @Override
    public String toString() {
        return "url: " + url + " search depth: " + depth;
    }

    public String getWebHost() {
        return url.getHost();
    }

    public String getDocPath() {
        return url.getPath();
    }
}