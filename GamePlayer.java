package dice_test;

import java.util.*;

public class GamePlayer {
	
	private final int numDice;
	private final int numPlay;
	private final Random rand;
	
	
	
	public GamePlayer(int numDice, int numPlay) {
		this.numDice = numDice;
		this.numPlay = numPlay;
		this.rand = new Random();
	}
	
	
	public Map<Integer,Integer> runPlay(){
		Map<Integer,Integer> scoreCounts = new HashMap<>();
		for(int i=0; i<numPlay; i++) {
			int score = playGame();
			scoreCounts.put(score, scoreCounts.getOrDefault(score, 0)+1);
		}
		return scoreCounts;
		
		
		
	}
	
	private int playGame() {
		
		List<Integer> dice = rollDice(numDice);
		int totalScore = 0;
		
		while(!dice.isEmpty()) {
			
			if(dice.contains(3)) {
				dice.removeIf(die-> die==3);
			}else {
				int min = Collections.min(dice);
				totalScore +=min;
				dice.remove(Integer.valueOf(min));
			}
			
			dice = rollDice(dice.size());
			
		}
		
		return totalScore;
		
		
		
	}
	
	
	private List<Integer> rollDice(int n) {
		
		List<Integer> result = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			
			result.add(rand.nextInt(6)+1);
		}
		
		return result;
		
		
		
	}
	

	
	
}
