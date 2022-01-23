package com.example.hw1android3.data.models;

import com.google.gson.annotations.SerializedName;

public class FilmModel {
    String id;
    String title;
    @SerializedName("original_title")
    String originalTitle;
    @SerializedName("description")
    String description;

    @SerializedName("director")
    String director;
    @SerializedName("producer")
    String producer;
    @SerializedName("running_time")
    String duration;
    @SerializedName("rt_score")
    String rtScore;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getRtScore() {
        return rtScore;
    }

    public void setRtScore(String rtScore) {
        this.rtScore = rtScore;
    }
}
