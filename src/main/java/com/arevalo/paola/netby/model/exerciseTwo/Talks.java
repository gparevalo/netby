package com.arevalo.paola.netby.model.exerciseTwo;

import com.arevalo.paola.netby.util.TrackConfig;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Paola Arevalo <p.arevaloq@hotmail.com>
 * @version 1.0
 * @date 04/06/2024
 */
@Builder
@Getter
@Setter
public class Talks {

    private int minutes;
    private String title;
    private int id;
    private boolean lunchFlag = false;
    private String networkingTitle;
    private boolean networkingFlag = false;
    private String sessionTime;
    private String lunchTitle;
    private String trackTitle;

    public Talks() {
    }

    public Talks(int minutes, String title, int id, boolean lunchFlag, String networkingTitle, boolean networkingFlag, String sessionTime, String lunchTitle, String trackTitle) {
        this.minutes = minutes;
        this.title = title;
        this.id = id;
        this.lunchFlag = lunchFlag;
        this.networkingTitle = networkingTitle;
        this.networkingFlag = networkingFlag;
        this.sessionTime = sessionTime;
        this.lunchTitle = lunchTitle;
        this.trackTitle = trackTitle;
    }

    public Talks(int id, String inputData) {

        var separatorLine = inputData.lastIndexOf(" ");
        var minutesStr = inputData.substring(separatorLine + 1);
        int minutes = "lightning".equals(minutesStr) ? TrackConfig.LIGHTNING_MIN : Integer.parseInt(inputData.replaceAll("\\D+", ""));

        this.minutes = minutes;
        this.title = inputData.substring(0, separatorLine);
        this.id = id;

    }

}
