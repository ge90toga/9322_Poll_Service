package com.badbanana.poll.api.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by langley on 10/5/17.
 */
public class PollDTO {

    @Setter @Getter String jobID;

    @Setter @Getter List<String> applicationIDs;

    @Setter @Getter List<String> applicantIDs;

    @Setter @Getter String title;

    @Setter @Getter List<String> pollOptions;

    @Override
    public String toString() {
        return "PollDTO{" +
                "jobID='" + jobID + '\'' +
                ", applicationIDs=" + applicationIDs +
                ", applicantIDs=" + applicantIDs +
                ", title='" + title + '\'' +
                ", pollOptions=" + pollOptions +
                '}';
    }
}
