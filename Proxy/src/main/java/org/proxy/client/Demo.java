package org.proxy.client;

import org.proxy.downloader.YouTubeDownloader;
import org.proxy.lib.ThirdPartyYouTubeClass;
import org.proxy.proxy.YouTubeCacheProxy;

public class Demo {

  public static void main(String[] args) {
    System.out.println("### Testing Naive Downloader (No Proxy) ###");
    YouTubeDownloader naiveDownloader = new YouTubeDownloader(new ThirdPartyYouTubeClass());
    long naiveTime = test(naiveDownloader);
    System.out.println("Naive Downloader finished in: " + naiveTime + "ms");
    System.out.println("=========================================\n");

    System.out.println("### Testing Smart Downloader (With Proxy) ###");
    YouTubeCacheProxy cacheProxy = new YouTubeCacheProxy();
    YouTubeDownloader smartDownloader = new YouTubeDownloader(cacheProxy);
    long smartTime = test(smartDownloader);
    System.out.println("Smart Downloader finished in: " + smartTime + "ms");
    System.out.println("=========================================\n");

    System.out.println("Time saved by caching proxy: " + (naiveTime - smartTime) + "ms");
  }

  private static long test(YouTubeDownloader downloader) {
    long startTime = System.currentTimeMillis();

    System.out.println("--> Requesting popular videos...");
    downloader.renderPopularVideos();

    System.out.println("--> Requesting video page 'catzzzzzzzzz'...");
    downloader.renderVideoPage("catzzzzzzzzz");

    System.out.println("--> Requesting popular videos again...");
    downloader.renderPopularVideos();

    System.out.println("--> Requesting video page 'dancesvideoo'...");
    downloader.renderVideoPage("dancesvideoo");

    System.out.println("--> Requesting video page 'catzzzzzzzzz' again...");
    downloader.renderVideoPage("catzzzzzzzzz");

    System.out.println("--> Requesting video page 'someothervid'...");
    downloader.renderVideoPage("someothervid");

    long estimatedTime = System.currentTimeMillis() - startTime;
    System.out.print("\nTest completed. ");
    return estimatedTime;
  }
} 