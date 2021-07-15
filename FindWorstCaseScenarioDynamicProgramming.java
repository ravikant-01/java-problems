package com.java.se.kattis;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class FindWorstCaseScenarioDynamicProgramming {

	private static int MAX_NO_OF_BATTERY = 2;

	private static int MIN_PER_LINE = 1;
	private static int MAX_PER_LINE = 4711;

	private static Integer END_OF_INPUT = 0;

	public static void main(String[] args) {

		List<Integer> inputList = new ArrayList<Integer>();

		int caseNumberArray[][] = getAllWorstCaseNumberOfTests(MAX_PER_LINE-1, MAX_NO_OF_BATTERY);
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
			int input = sc.nextInt();
			// terminate in case file has 0
			if(END_OF_INPUT == input) {
				break;
			} else {
				inputList.add(input);
			}
		} 

		for(int inputListItr = 0; inputListItr < inputList.size(); inputListItr++) {
			int input = inputList.get(inputListItr);
			System.out.println(getWorstCaseNumberOfTests(caseNumberArray, input-1));

		}

	}
	
	/**
	 * Utility to find worst case number
	 * @param caseNumberArray
	 * @param input
	 * @return
	 */
	
	private static int getWorstCaseNumberOfTests(int caseNumberArray[][],int input) {
		return caseNumberArray[input][MAX_NO_OF_BATTERY];
	}

	/**
	 * Utility to find all worst case number
	 * @param input
	 * @param noOfBatery
	 * @return
	 */
	private static int[][] getAllWorstCaseNumberOfTests(int input,int noOfBatery) {
		int INFINITY = 1000000;
		
		int[][] caseNumberArray = new int[input + 1][noOfBatery + 1];
		for (int inputItr = 1; inputItr <= input; ++inputItr) {
			caseNumberArray[inputItr][0] = INFINITY;
		}

		for (int inputItr = 1; inputItr <= input; ++inputItr) {
			for (int noOfBateryItr = 1; noOfBateryItr <= noOfBatery; ++noOfBateryItr) {
				caseNumberArray[inputItr][noOfBateryItr] = INFINITY;

				for (int itr = 1; itr <= inputItr; ++itr) {
					int result = Math.max(caseNumberArray[itr - 1][noOfBateryItr - 1], caseNumberArray[inputItr - itr][noOfBateryItr]) + 1;
					caseNumberArray[inputItr][noOfBateryItr] = Math.min(caseNumberArray[inputItr][noOfBateryItr], result);
				}
			}
		}

		return caseNumberArray;
	}

}
