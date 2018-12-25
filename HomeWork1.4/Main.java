package net.bigmir;

public class Main {

	public static void main(String[] args) {
		Phone phoneNumberOne = new Phone(38029327);
		phoneNumberOne.register();
		Phone phoneNumberTwo = new Phone(38013456);
		phoneNumberTwo.register();
		phoneNumberOne.call(phoneNumberTwo);
		Phone phoneNumberThree = new Phone(38052414);
		phoneNumberOne.call(phoneNumberThree);
		phoneNumberOne.call(phoneNumberOne);		
	}

}
