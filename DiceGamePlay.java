package dice_test;

import java.util.Map;

public class DiceGamePlay {

	public static void main(String[] args) {
		
		
		final int num_plays=10000;
		final int num_dice=5;
		
		long startTime = System.currentTimeMillis();
		GamePlayer player = new GamePlayer(num_dice,num_plays);
		
		
		Map<Integer,Integer> scoreMap = player.runPlay();
		
		long endTime = System.currentTimeMillis();
		
		double last = (endTime - startTime)/1000.0;
		
		System.out.println("play num: " + num_plays + " using "+num_dice + " dice.");
		int totalPlays = scoreMap.values().stream().mapToInt(Integer::intValue).sum();
		
		
		
		scoreMap.keySet().stream().sorted().forEach(score -> {
			
			int count = scoreMap.get(score);
			
			
			double probability = (double) count/totalPlays;
			
			
			
			System.out.println("Total = " + score + ", occures = " + probability + ", occured " + count);
		});
		
		
		
		System.out.println(" Duration time = " + last);
		

	}

}
