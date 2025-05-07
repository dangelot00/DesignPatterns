package org.proxy.proxy;

import org.proxy.lib.ThirdPartyYouTubeClass;
import org.proxy.lib.ThirdPartyYouTubeLib;
import org.proxy.lib.Video;

import java.util.HashMap;

public class YouTubeCacheProxy implements ThirdPartyYouTubeLib {
  private ThirdPartyYouTubeLib youtubeService;
  private HashMap<String, Video> cachePopular = null;
  private HashMap<String, Video> cacheAll = new HashMap<>();

  public YouTubeCacheProxy() {
    // Here, we initialize the proxy but not the real service yet.
  }

  // Lazy initialization for the real service
  private ThirdPartyYouTubeLib getService() {
    if (youtubeService == null) {
      System.out.println("Proxy: Initializing real YouTube service object...");
      youtubeService = new ThirdPartyYouTubeClass();
    }
    return youtubeService;
  }

  @Override
  public HashMap<String, Video> popularVideos() {
    System.out.println("Proxy: Attempting to get popular videos...");
    if (cachePopular == null) {
      System.out.println("Proxy: Cache miss for popular videos. Fetching from real service...");
      cachePopular = getService().popularVideos();
    } else {
      System.out.println("Proxy: Retrieved popular videos list from cache.");
    }
    return new HashMap<>(cachePopular);
  }

  @Override
  public Video getVideo(String videoId) {
    System.out.println("\nProxy: Attempting to get video details for ID: " + videoId);
    Video video = cacheAll.get(videoId);
    if (video == null) {
      System.out.println("Proxy: Cache miss for video ID: " + videoId + ". Fetching from real service...");
      video = getService().getVideo(videoId);
      cacheAll.put(videoId, video);
    } else {
      System.out.println("Proxy: Retrieved video details for ID: " + videoId + " from cache.");
    }
    return video;
  }

  public void resetCache() {
    System.out.println("\nProxy: Resetting cache.");
    cachePopular = null;
    cacheAll.clear();
  }
} 