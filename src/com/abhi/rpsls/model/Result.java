package com.abhi.rpsls.model;

public class Result {
	private String winner;
	private Outcome outcome;
	
	public static enum Outcome{
		WIN,
		TIE,
		INVALID
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

	public Outcome getOutcome() {
		return outcome;
	}

	public void setOutcome(Outcome outcome) {
		this.outcome = outcome;
	}
	
	
}
