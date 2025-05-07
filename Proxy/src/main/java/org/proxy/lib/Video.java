package org.proxy.lib;

public class Video {
  public String id;
  public String title;
  public String data;

  public Video(String id, String title) {
    super();
    this.id = id;
    this.title = title;
    this.data = "Random video data for " + title;
  }
} 