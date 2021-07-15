package com.java.se.kattis;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class FindMiles {

	private static int MIN_PAIR_VALUE = 1;
	private static int MAX_PAIR_VALUE = 10;

	private static int MIN_SPEED_IN_MILES_VALUE = 1;
	private static int MAX_SPEED_IN_MILES_VALUE = 90;

	private static int MIN_ELAPSED_TIME_VALUE = 1;
	private static int MAX_ELAPSED_TIME_VALUE = 12;

	private static String END_OF_INPUT = "-1";

	public static void main(String[] args) {

		List<String> inputList = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String input = sc.nextLine();
			// terminate look in case file has -1
			if(END_OF_INPUT.equals(input)) {
				break;
			} else {
				inputList.add(input);
			}

		}
		// Loop for each element in file
		for(int inputListItr = 0; inputListItr < inputList.size(); inputListItr++) {

			int pairsValue = Integer.parseInt(inputList.get(inputListItr));
			if(pairsValue >= MIN_PAIR_VALUE && pairsValue <= MAX_PAIR_VALUE) {
				int oldElapsedTime = 0;
				int totalMilesTravelled = 0;
				for(int pairsValueItr = inputListItr+1; pairsValueItr<= inputListItr+pairsValue; pairsValueItr++) {
					String item = inputList.get(pairsValueItr);
					// check if input item don't have spped in miles and elapsed time then terminate it 
					if(!item.contains(" ")) {
						break;
					}

					int speedInMiles = Integer.parseInt(item.substring(0,item.indexOf(" ")));
					int elapsedTime = Integer.parseInt(item.substring(item.indexOf(" ")+1));
					if((speedInMiles >= MIN_SPEED_IN_MILES_VALUE && speedInMiles <=MAX_SPEED_IN_MILES_VALUE) 
							&&  (elapsedTime >= MIN_ELAPSED_TIME_VALUE && elapsedTime <= MAX_ELAPSED_TIME_VALUE)) {
						totalMilesTravelled = totalMilesTravelled + speedInMiles * (elapsedTime - oldElapsedTime);
						oldElapsedTime = elapsedTime;
					}

				}
				System.out.println(totalMilesTravelled+" miles");
				inputListItr = inputListItr + pairsValue;
			}

		}
	}
}
