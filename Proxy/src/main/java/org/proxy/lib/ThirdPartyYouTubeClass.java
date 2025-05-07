package org.proxy.lib;

import java.util.HashMap;

public class ThirdPartyYouTubeClass implements ThirdPartyYouTubeLib {

  @Override
  public HashMap<String, Video> popularVideos() {
    connectToServer("http://www.youtube.com");
    return getRandomVideos();
  }

  @Override
  public Video getVideo(String videoId) {
    connectToServer("http://www.youtube.com/" + videoId);
    return getSomeVideo(videoId);
  }

  // Fake methods to simulate network activity.

  private int random(int min, int max) {
    return min + (int) (Math.random() * ((max - min) + 1));
  }

  private void experienceNetworkLatency() {
    int randomLatency = random(5, 10);
    System.out.println("(Simulating network latency of " + randomLatency * 100 + "ms)");
    for (int i = 0; i < randomLatency; i++) {
      try {
        Thread.sleep(100);
      } catch (InterruptedException ex) {
        Thread.currentThread().interrupt();
        System.err.println("Thread interrupted during latency simulation");
      }
    }
  }

  private void connectToServer(String server) {
    System.out.print("Connecting to " + server + "... ");
    experienceNetworkLatency();
    System.out.println("Connected!");
  }

  private HashMap<String, Video> getRandomVideos() {
    System.out.print("Downloading popular videos list... ");
    experienceNetworkLatency();
    HashMap<String, Video> hmap = new HashMap<>();
    hmap.put("catzzzzzzzzz", new Video("sadgahasgdas", "Catzzzz.avi"));
    hmap.put("mkafksangasj", new Video("mkafksangasj", "Dog play with ball.mp4"));
    hmap.put("dancesvideoo", new Video("asdfas3ffasd", "Dancing video.mpq"));
    hmap.put("dlsdk5jfslaf", new Video("dlsdk5jfslaf", "Barcelona vs RealM.mov"));
    hmap.put("3sdfgsd1j333", new Video("3sdfgsd1j333", "Programming lesson #1.avi"));
    System.out.println("Done!");
    return hmap;
  }

  private Video getSomeVideo(String videoId) {
    System.out.print("Downloading video details for " + videoId + "... ");
    experienceNetworkLatency();
    HashMap<String, Video> popular = getRandomVideos();
    Video video = popular.get(videoId);
    if (video == null) {
      video = new Video(videoId, "Video Title for " + videoId);
      System.out.println("(Video not in popular list, created generic info)");
    } else {
      video.data = "Specific video data for " + video.title;
    }

    System.out.println("Done!");
    return video;
  }
} 