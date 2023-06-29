package com.example.myapplication;

public class AlphabetModel {
    private  final Integer iconId;
    private final String letters;

    public AlphabetModel(Integer iconId, String letters) {
        this.iconId = iconId;
        this.letters = letters;
    }

    public Integer getIconId() {
        return iconId;
    }

    public String getLetters() {
        return letters;
    }
}
