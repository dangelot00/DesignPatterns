package org.proxy.downloader;

import org.proxy.lib.ThirdPartyYouTubeLib;
import org.proxy.lib.Video;

import java.util.HashMap;

public class YouTubeDownloader {
  private ThirdPartyYouTubeLib api;

  public YouTubeDownloader(ThirdPartyYouTubeLib api) {
    this.api = api;
  }

  public void renderVideoPage(String videoId) {
    Video video = api.getVideo(videoId);
    if (video == null) {
      System.out.println("\n-------------------------------");
      System.out.println("Error: Video not found for ID: " + videoId);
      System.out.println("-------------------------------\n");
      return;
    }
    System.out.println("\n-------------------------------");
    System.out.println("Video page (imagine fancy HTML)");
    System.out.println("ID: " + video.id);
    System.out.println("Title: " + video.title);
    System.out.println("Video Data: " + video.data);
    System.out.println("-------------------------------\n");
  }

  public void renderPopularVideos() {
    HashMap<String, Video> list = api.popularVideos();
    System.out.println("\n-------------------------------");
    System.out.println("Most popular videos on YouTube (imagine fancy HTML)");
    if (list == null || list.isEmpty()) {
      System.out.println("No popular videos found.");
    } else {
      for (Video video : list.values()) {
        System.out.println("ID: " + video.id + " / Title: " + video.title);
      }
    }
    System.out.println("-------------------------------\n");
  }
} 