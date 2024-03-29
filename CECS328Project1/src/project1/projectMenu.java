package project1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import project1.Algorithms;

public class projectMenu {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		boolean isRunning = true;
		int choice = -1;
		printMenu();
		while(isRunning) {
			choice = in.nextInt();
			while(choice < 1 || choice > 4){
				System.out.println("Please select one of the valid options 1-4");
				printMenu();
				choice = in.nextInt();
			}
			switch(choice) {
			case 1:
				userInputMSS();
				break;
			case 2:
				randArrMSS();
				break;
			case 3:
				randArrSingleMSS();
				break;
			case 4:
				System.out.println("Program has quit.");
				isRunning = false;
				break;
			}
		}
	}
	
	//Option 3
	private static void randArrSingleMSS() {
		Scanner in = new Scanner(System.in);
		int length = 0;
		System.out.println("Please designate a length to a randomly generated array");
		length = in.nextInt();
		int[] newA = createRandArr(length);
		//Printing out array
//		for(int i = 0; i < newA.length;i++) {
//			System.out.println(newA[i]);
//		}
		//Solution 1
		int mSS1 = Algorithms.Solution1(newA);
		System.out.println("MSS from Solution 1: " + mSS1);
	}

	//Option 2
	private static void randArrMSS() {
		Scanner in = new Scanner(System.in);
		int length = 0;
		System.out.println("Please designate a length to a randomly generated array");
		length = in.nextInt();
		int[] newA = createRandArr(length);
		for(int i = 0; i < newA.length;i++) {
			System.out.println(newA[i]);
		}
	}

	//Option 1
	private static void userInputMSS() {
		Scanner in = new Scanner(System.in);
		System.out.println("Please input a comma-delimited array on ints");
		String userInput = in.nextLine();
		int[] arr = userInToIntArray(userInput);
		//Solution 1
		int mSS1 = Algorithms.Solution1(arr);
		System.out.println("MSS from Solution 1: " + mSS1);
	}

	private static int[] userInToIntArray(String userInput) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		String none = "";
		userInput.replaceAll("\\s+","");
		for(int i = 0; i < userInput.length(); i++) {
			if(userInput.charAt(i) != ',') {
				none += userInput.charAt(i); 
			}else {
				arr.add(Integer.parseInt(none));
				none = "";
			}	
		}
		arr.add(Integer.parseInt(none));
		for(int i : arr) {
			System.out.println(i);
		}
		int [] a = new int[arr.size()];
		for(int i= 0;i < arr.size();i++) {
			a[i] = arr.get(i);
		}
		return a;
	}

	private static void printMenu() {
		System.out.println("MAIN MENU\n"
				+ "Select One of the Four Options to find MSS\n"
				+ "1. MSS of all 4 Solutions from user-inputted array\n"
				+ "2. Select which Solution on Randomly Gen. Arrays\n"
				+ "3. Select One of Four to find MSS\n"
				+ "4. Quit");
	}
	
	public static int[] createRandArr(int length){
		Random random = new Random();
		int[] randArr = new int[length];
		for(int i = 0; i < length; i++) {
			int randInt = random.nextInt(1000);
			randArr[i]= randInt;
		}
		return randArr;
	}

}
