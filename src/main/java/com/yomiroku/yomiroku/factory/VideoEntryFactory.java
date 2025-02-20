package com.yomiroku.yomiroku.factory;

import com.yomiroku.yomiroku.domain.VideoEntry;

import java.time.LocalDate;

public class VideoEntryFactory {
    public static VideoEntry createVideoEntry(String name, double videoDuration, String videoUrl){
        VideoEntry videoEntry = new VideoEntry.Builder()
                .setName(name)
                .setEntryDate(LocalDate.now())
                .setVideoUrl(videoUrl)
                .setVideoDuration(videoDuration)
                .build();
        System.out.println(videoEntry.toString());
        return videoEntry;
    }
}
