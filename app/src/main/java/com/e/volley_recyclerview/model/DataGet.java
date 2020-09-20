package com.e.volley_recyclerview.model;

public class DataGet {
    private String name;
    private String description;
    private String Rating;
    private String episode;
    private String categorie;
    private String studio;
    private String img;

    public DataGet(){

    }

    public DataGet(String name, String description, String rating, String episode, String categorie, String studio, String img) {
        this.name = name;
        this.description = description;
        Rating = rating;
        this.episode = episode;
        this.categorie = categorie;
        this.studio = studio;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getRating() {
        return Rating;
    }

    public String getEpisode() {
        return episode;
    }

    public String getCategorie() {
        return categorie;
    }

    public String getStudio() {
        return studio;
    }

    public String getImg() {
        return img;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRating(String rating) {
        Rating = rating;
    }

    public void setEpisode(String episode) {
        this.episode = episode;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
