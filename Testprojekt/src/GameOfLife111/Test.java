package GameOfLife111;

import java.util.LinkedList;

public class Test {

	public static void main(String[] args) {
		int number = 111111;
		LinkedList<Integer> allNumbers = new LinkedList<Integer>();
		while(number < 1000000) {
			if (checkNumber(number)) {
				allNumbers.add(number);
				System.out.println("Hit: " + number);
			};
			number++;
		}
		System.out.println("==================================================");
		System.out.println("======================RESULT======================");
		System.out.println("==================================================");
		System.out.println("Highest Number: " + allNumbers.getLast());
		System.out.println("Lowest Number: " + allNumbers.getFirst());
		System.out.println("Sum of all possilbe Numbers: " + allNumbers.size());

	}
	
	static int[] intToIntArray(int wert) {
		String temp = Integer.toString(wert);
		int[] newArray = new int[temp.length()];
		for (int i = 0; i < temp.length(); i++)
			{newArray[i] = temp.charAt(i) -'0';
			}
		return newArray;
	}
	
	static int intArrayToInt(int[] arrayNumber) {
		String num = "";
		for (int i = 0; i<arrayNumber.length;i++) {
			num += arrayNumber[i];
		}
		return Integer.parseInt(num);
	}
	
	static int[] intArrayFlip(int[] arrayNumber) {
		int[] arrayNumberBack = new int[arrayNumber.length];
		int j = 0;
		for (int i = arrayNumber.length - 1; i>=0; i--) {
			arrayNumberBack[j] = arrayNumber[i];
			j++;
		}
		return arrayNumberBack;
	}
	
	static boolean hasZeros(int[] arrayNumber) {
		boolean check = false;
		for (int i = 0; i < arrayNumber.length; i++) {
			if (arrayNumber[i] == 0) {
				check = true;
				break;
			}
		}
		return check;
	}
	
	static boolean hasNonUniqueNumbers(int[] arrayNumber) {
		boolean check = false;
		for (int i = 0; i < arrayNumber.length; i++){
			for (int j = 0; j < arrayNumber.length; j++) {
				if (arrayNumber[i] == arrayNumber[j] && i != j) {
					check = true;
					break;
				}
			}
			if (check) {
				break;
			}
		}
		return check;
	}
	
	static boolean checkNumber(int number) {
		int[] arrayNumber = intToIntArray(number);
		// check if Number has 0
		if (hasZeros(arrayNumber)) {
			return false;
		}
		// flip number
		int[] arrayNumberBack = intArrayFlip(arrayNumber);
		// check if number is higher than the flipped number
		if (number < intArrayToInt(arrayNumberBack)) {
			return false;
		}
		int sum = intArrayToInt(arrayNumberBack) + intArrayToInt(arrayNumber);
		int diff = intArrayToInt(arrayNumber) - intArrayToInt(arrayNumberBack); // always positve or 0 because arrayNumberBack 
																				// is smaller than arrayNumber at this point
		// check if diff or sum has 6 numbers
		if (diff < 100000 || diff > 999999 || sum < 100000 || sum > 999999) {
			return false;
		}
		if (hasNonUniqueNumbers(intToIntArray(diff)) || hasNonUniqueNumbers(intToIntArray(sum))) {
			return false;
		}
		
		return true;
	}

	public static void main(String[] args) {
		status
	}
}
