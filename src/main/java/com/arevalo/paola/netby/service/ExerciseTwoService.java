package com.arevalo.paola.netby.service;

import com.arevalo.paola.netby.model.exerciseTwo.Conference;
import com.arevalo.paola.netby.model.exerciseTwo.Talks;
import com.arevalo.paola.netby.util.Functions;
import com.arevalo.paola.netby.util.TrackConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Paola Arevalo <p.arevaloq@hotmail.com>
 * @version 1.0
 * @date 04/06/2024
 */
@Service
public class ExerciseTwoService {
    private static final Logger log = LogManager.getLogger(ExerciseTwoService.class);

    public String solveExerciseTwo(String inputData) {

        Conference conference = new Conference(inputData);
        int numberOfTracks = conference.getCountTrack();
        int startTalkIndex = 0;

        // Schedule the Talks into Tracks.
        for (int trackCount = 0; trackCount < numberOfTracks; trackCount++) {
            startTalkIndex = scheduleTalksIntoTracks(trackCount, conference.getTrackTalks(), conference.getCountTrack(), startTalkIndex, conference.getCountTalks());
        }

        outputOfTalksIntoTracks(conference.getTrackTalks());
        return "OK";
    }


    public int scheduleTalksIntoTracks(int trackCountIndex,
                                       List<Talks> trackTalks,
                                       int trackCount,
                                       int startTalkIndex,
                                       int totalTalkCount) {

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm a");
        Calendar cal = new GregorianCalendar();
        cal.set(Calendar.HOUR, 9);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.AM_PM, Calendar.AM);

        int sum180 = TrackConfig.MORNING_TIME_MINUTES;
        int sum240 = TrackConfig.AFTERNOON_TIME_MINUTES;

        int TalkIndex;

        String sessionTime;
        String SessionTitle;

        for (TalkIndex = startTalkIndex; TalkIndex < totalTalkCount; TalkIndex++) {


            // Get the combination of 180 and fill it
            if (sum180 >= trackTalks.get(TalkIndex).getMinutes()) {
                sum180 = sum180 - trackTalks.get(TalkIndex).getMinutes();
                sessionTime = sdf.format(cal.getTime()) + " " + trackTalks.get(TalkIndex).getTitle() + " " + trackTalks.get(TalkIndex).getMinutes() + "min";
                trackTalks.get(TalkIndex).setTitle(sessionTime);
                cal.add(Calendar.MINUTE, trackTalks.get(TalkIndex).getMinutes());
                SessionTitle = "Track" + " " + (trackCountIndex + 1);
                trackTalks.get(TalkIndex).setTrackTitle(SessionTitle);
            }
            if (sum180 < trackTalks.get(TalkIndex).getMinutes())
                break;

            if (sum180 > 0)
                continue;

            if (sum180 <= 0)
                break;
        }

        trackTalks.get(TalkIndex).setLunchFlag(true);
        sessionTime = "12:00 PM" + " " + "Lunch";
        trackTalks.get(TalkIndex).setLunchTitle(sessionTime);
        cal.add(Calendar.MINUTE, 60);

        TalkIndex++;

        for (; TalkIndex < totalTalkCount; TalkIndex++) { 
            if (sum240 >= trackTalks.get(TalkIndex).getMinutes()) {
                sum240 = sum240 - trackTalks.get(TalkIndex).getMinutes();
                sessionTime = sdf.format(cal.getTime()) + " " + trackTalks.get(TalkIndex).getTitle() + " " + trackTalks.get(TalkIndex).getMinutes() + "min";
                trackTalks.get(TalkIndex).setTitle(sessionTime);
                cal.add(Calendar.MINUTE, trackTalks.get(TalkIndex).getMinutes());
                SessionTitle = "Track" + " " + (trackCountIndex + 1);
                trackTalks.get(TalkIndex).setTrackTitle(SessionTitle);
            }
            if (sum240 < trackTalks.get(TalkIndex).getMinutes())
                break;

            if (sum240 > 0)
                continue;

            if (sum240 <= 0)
                break;
        }

        if (totalTalkCount == (TalkIndex))
            --TalkIndex;
        trackTalks.get(TalkIndex).setNetworkingFlag(true);
        sessionTime = "5:00 PM" + " " + "Networking Event";
        trackTalks.get(TalkIndex).setNetworkingTitle(sessionTime);
        TalkIndex++;
        return TalkIndex;

    }


    public void outputOfTalksIntoTracks(List<Talks> trackTalks) {

        log.info("Test Output :");
        final String[] trackTitle = {"dummyValue"};

        trackTalks.stream().map(x -> {

            // Print the Track Title
            if (!trackTitle[0].equals(x.getTrackTitle())) {
                log.info(x.getTrackTitle() + ":");
                trackTitle[0] = x.getTrackTitle();
            }

            log.info(x.getTitle());

            if (x.isLunchFlag()) {
                log.info(x.getLunchTitle());
            }

            if (x.isNetworkingFlag()) {
                log.info(x.getNetworkingTitle());
            }
            return x;
        }).collect(Collectors.toList());
    }
}
