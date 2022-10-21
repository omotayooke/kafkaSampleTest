package com.example.kafkaTest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * this entity is a shared dto that represents a "result" of linkman operation
 * it's basically a shortened copy of the Event record
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LinkmanResult {

    private String url;
    private String eventId;

    private String createdBy;
    private Date dateAdded;
    private Date dateUpdated;
    private Date dateSentFingerprint;
    private Date dateFingerprinted;
    private Date dateAddedToDashboard;

    protected Integer linkType;
    protected Long clipDuration; // the "original" clip duration (best guess)
    protected Long fileDuration; // the duration of the file we possess
    protected Float matchPercentage;
    protected Float matchPercentageAudio;
    protected String matchReferenceId;
    protected String matchReferenceIdAudio;
    protected String uploader;
    protected String channelId;
    private String status;

    private String fingerprintVerificationId;

    private String fingerprintAudioVerificationId;

    private String caseId;
    private Map<String, String> downloadMetadata;

    public Map<String, String> getDownloadMetadata() {
        if (downloadMetadata == null) {
            return new HashMap<>();
        }
        return downloadMetadata;
    }
}
