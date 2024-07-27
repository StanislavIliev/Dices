package dices;

import java.util.Random;

public class Main {

	public static void main(String[] args) {

		// This code is for representational purposes only. It show the result in plenty
		// of games and as shows in the console , the results are slightly different
		// game to
		// game. The second place to the right of the decimal point is sometimes
		// different
		// but the rest is the same at all the time which is approx. 49.3%.

		int success = 0; // count the number of win
		int failure = 0; // the total number of losses
		// we do a lot of games/throws , so can see in average what would be the result.
		for (int i = 0; i < 3600000; i++) {
			Random random = new Random();
			int dice1 = random.nextInt(6) + 1;
			int dice2 = random.nextInt(6) + 1;
			int sum = dice1 + dice2;

			if (sum == 2 || sum == 3 || sum == 12) {
				failure++;
			} else if (sum == 7 || sum == 11) {
				success++;
			} else if (sum == 4 || sum == 5 || sum == 6 || sum == 8 || sum == 9 || sum == 10) {
				dice1 = random.nextInt(6) + 1;
				dice2 = random.nextInt(6) + 1;
				int sum2 = dice1 + dice2;
				if (sum2 == 7) {
					failure++;
					// check if the game end on the second throw basically
				} else if (sum2 == sum) {
					success++;
					// check if the game is won on the second throw basically
				} else {
					// loop until 7 or the total sum is not reached. Then the game ends win or loose
					while (sum2 != 7 || sum2 != sum) {
						dice1 = random.nextInt(6) + 1;
						dice2 = random.nextInt(6) + 1;
						sum2 = dice1 + dice2;
						if (sum2 == 7) {
							failure++;
							break;
						} else if (sum2 == sum) {
							success++;
							break;
						}
					}
				}
			}
		}
		double procent = (double) success / 3600000;
		// Probability of win is all chance divided by the amount of the games.
		System.out.printf("The chance of win is approximately %.2f%%.%n", 100 * procent, "%");
		// multiply by 100 to receive in percent. And 2 decimal places to be printed.
		double percent = (double) failure / 3600000;
		System.out.printf("The chance of loose is approximately %.2f%%.%n", 100 * percent, "%");

	}
}
