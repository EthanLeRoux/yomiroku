package com.soft.yomirokualt.domain;

import java.io.Serializable;
import java.time.LocalDate;

public class VideoEntry extends Entry implements Serializable {
    private String name;
    private LocalDate entryDate;
    private String videoUrl;
    private double videoDuration;

    public String getVideoUrl() {
        return videoUrl;
    }

    public double getVideoDuration() {
        return videoDuration;
    }

    @Override
    public String toString() {
        return "VideoEntry{" +
                "videoUrl='" + videoUrl + '\'' +
                ", videoDuration=" + videoDuration +
                ", name='" + name + '\'' +
                ", entryDate=" + entryDate +
                '}';
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public LocalDate getEntryDate() {
        return entryDate;
    }

    public VideoEntry(Builder builder) {
        name = builder.name;
        entryDate = builder.entryDate;
        videoUrl = builder.videoUrl;
        videoDuration = builder.videoDuration;
    }

    public static class Builder {
        private String name;
        private String videoUrl;
        private double videoDuration;
        private LocalDate entryDate;


        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setVideoUrl(String videoUrl) {
            this.videoUrl = videoUrl;
            return this;
        }

        public Builder setVideoDuration(double videoDuration) {
            this.videoDuration = videoDuration;
            return this;
        }

        public Builder setEntryDate(LocalDate entryDate) {
            this.entryDate = entryDate;
            return this;
        }

        public VideoEntry build() {
            return new VideoEntry(this);
        }
    }


}
