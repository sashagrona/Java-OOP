package net.bigmir;

public class Network {
	private  static Phone[] allNumbers = new Phone[10];
	private static int i = 0;

	public void addNumber(Phone phoneNumber) {
		if (i < allNumbers.length - 1) {
			allNumbers[i] = phoneNumber;
			System.out.println("You have added next number " + phoneNumber);
		} else {
			System.out.println("Our company can register only 10 abonents");
		}
		i++;
	}
	public  boolean check(Phone phoneNumber) {
		for( int i = 0;i<allNumbers.length;i++) {
			if(allNumbers[i] == phoneNumber) {
				return true;
			}
		}return false;
	}
	
}
