package com.arevalo.paola.netby.model.exerciseTwo;

import com.arevalo.paola.netby.util.TrackConfig;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Paola Arevalo <p.arevaloq@hotmail.com>
 * @version 1.0
 * @date 04/06/2024
 */
@Builder
@Getter
@Setter
public class Conference {
    private List<Talks> trackTalks = new ArrayList<>();
    private int totalTrackMinutes;
    private int countTrack;
    private int countTalks;
    private String title;

    public Conference() {
    }

    public Conference(List<Talks> trackTalks, int totalTrackMinutes, int countTrack, int countTalks, String title) {
        this.trackTalks = trackTalks;
        this.totalTrackMinutes = totalTrackMinutes;
        this.countTrack = countTrack;
        this.countTalks = countTalks;
        this.title = title;
    }

    public Conference(String inputData) {
        String[] inputArr = inputData.split(",");
        int id = 0;
        int totalMinutes = 0;
        int noOfTracks = 0;

        for (String s : inputArr) {
            id = id + 1;
            Talks singleTalk = new Talks(id, s.trim());
            totalMinutes = totalMinutes + singleTalk.getMinutes();
            this.trackTalks.add(singleTalk);
        }

        this.countTalks = id;
        this.totalTrackMinutes = totalMinutes;

        Double numberOfTracks = (totalMinutes * 1.0) / TrackConfig.TOTAL_CONFERENCE_TALKS_TRACK_MINUTES;
        double integralPart = numberOfTracks - (numberOfTracks % 1);
        int leftMinutes = totalMinutes - (int) integralPart * TrackConfig.TOTAL_CONFERENCE_TALKS_TRACK_MINUTES.intValue();
        noOfTracks = (int) integralPart;

        if (leftMinutes > 0) {
            noOfTracks = (int) integralPart + 1;
        }

        this.countTrack = noOfTracks;

        Collections.sort(this.getTrackTalks(), new TalksCompare());
    }
}
