package com.abhi.rpsls.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.abhi.rpsls.model.Result.Outcome;

public class Referee {
	
	private static final Map<String, Collection<String>> defeatMap = new HashMap<String, Collection<String>>();
	static {
		defeatMap.put("Rock", Arrays.asList("Paper","Spock"));
		defeatMap.put("Paper", Arrays.asList("Scissors","Lizard"));
		defeatMap.put("Scissors", Arrays.asList("Rock","Spock"));
		defeatMap.put("Lizard", Arrays.asList("Rock","Scissors"));
		defeatMap.put("Spock", Arrays.asList("Paper","Lizard"));
	}

	public Result determineWinner(String one, String two) {
		Result r = new Result();
		if(defeatMap.get(one).contains(two)){
			r.setWinner(two);
			r.setOutcome(Outcome.WIN);
		}else if (defeatMap.get(two).contains(one)){
			r.setWinner(one);
			r.setOutcome(Outcome.WIN);
		}else{
			r.setOutcome(Outcome.TIE);
		}
		
		return r;
	}

}
