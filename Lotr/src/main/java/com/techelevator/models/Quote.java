package com.techelevator.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Quote {
    private int quoteId;
    @JsonProperty("_id")
    private String theOneQuoteId;
    private String dialog;
    @JsonProperty("movie")
    private String theOneMovieId;
    @JsonProperty("character")
    private String theOneCharacterId;

    public Quote() {
    }

    public Quote(int quoteId, String theOneQuoteId, String dialog, String theOneMovieId, String theOneCharacterId) {
        this.quoteId = quoteId;
        this.theOneQuoteId = theOneQuoteId;
        this.dialog = dialog;
        this.theOneMovieId = theOneMovieId;
        this.theOneCharacterId = theOneCharacterId;
    }

    public int getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(int quoteId) {
        this.quoteId = quoteId;
    }

    public String getTheOneQuoteId() {
        return theOneQuoteId;
    }

    public void setTheOneQuoteId(String theOneQuoteId) {
        this.theOneQuoteId = theOneQuoteId;
    }

    public String getDialog() {
        return dialog;
    }

    public void setDialog(String dialog) {
        this.dialog = dialog;
    }

    public String getTheOneMovieId() {
        return theOneMovieId;
    }

    public void setTheOneMovieId(String theOneMovieId) {
        this.theOneMovieId = theOneMovieId;
    }

    public String getTheOneCharacterId() {
        return theOneCharacterId;
    }

    public void setTheOneCharacterId(String theOneCharacterId) {
        this.theOneCharacterId = theOneCharacterId;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "quoteId=" + quoteId +
                ", theOneQuoteId='" + theOneQuoteId + '\'' +
                ", dialog='" + dialog + '\'' +
                ", theOneMovieId='" + theOneMovieId + '\'' +
                ", theOneCharacterId='" + theOneCharacterId + '\'' +
                '}';
    }
}

