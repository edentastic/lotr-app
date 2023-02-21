package com.techelevator.models;

public class Character {
    private int characterId;
    private String theOneCharacterId;
    private String height;
    private String race;
    private String name;
    private String wikiUrl;

    public Character() {
    }

    public Character(int characterId, String theOneCharacterId, String height, String race, String name, String wikiUrl) {
        this.characterId = characterId;
        this.theOneCharacterId = theOneCharacterId;
        this.height = height;
        this.race = race;
        this.name = name;
        this.wikiUrl = wikiUrl;
    }

    public int getCharacterId() {
        return characterId;
    }

    public void setCharacterId(int characterId) {
        this.characterId = characterId;
    }

    public String getTheOneCharacterId() {
        return theOneCharacterId;
    }

    public void setTheOneCharacterId(String theOneCharacterId) {
        this.theOneCharacterId = theOneCharacterId;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWikiUrl() {
        return wikiUrl;
    }

    public void setWikiUrl(String wikiUrl) {
        this.wikiUrl = wikiUrl;
    }

    @Override
    public String toString() {
        return "Character{" +
                "characterId=" + characterId +
                ", theOneCharacterId='" + theOneCharacterId + '\'' +
                ", height='" + height + '\'' +
                ", race='" + race + '\'' +
                ", name='" + name + '\'' +
                ", wikiUrl='" + wikiUrl + '\'' +
                '}';
    }
}
