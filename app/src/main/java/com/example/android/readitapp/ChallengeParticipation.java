package com.example.android.readitapp;

public class ChallengeParticipation
{
    private Challenge challenge;
    private Integer gems;


    public ChallengeParticipation() {}

    public ChallengeParticipation(Challenge challenge, Integer gems) {
        this.challenge = challenge;
        this.gems = gems;
    }

    public Challenge getChallenge() {
        return challenge;
    }

    public Integer getGems() {
        return gems;
    }
}
