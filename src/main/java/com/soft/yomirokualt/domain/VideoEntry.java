package com.soft.yomirokualt.domain;

import java.time.LocalDate;

public class VideoEntry extends Entry {
    private String videoUrl;
    private double videoDuration;

    @Override
    public String toString() {
        return "VideoEntry{" +
                "videoUrl='" + videoUrl + '\'' +
                ", videoDuration=" + videoDuration +
                ", name='" + name + '\'' +
                ", entryDate=" + entryDate +
                '}';
    }

    public VideoEntry(Builder builder) {
        super.name = builder.name;
        super.entryDate = builder.entryDate;
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
