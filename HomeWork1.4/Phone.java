package net.bigmir;

public class Phone {
	private long phoneNumber;
	private Network networkOne = new Network();

	public Phone(long phoneNumber) {
		super();
		this.phoneNumber = phoneNumber;
	}

	public Phone() {
		super();
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void register() {
		networkOne.addNumber(this);
	}
	public void call(Phone phoneNumberTwo) {
		
		if(!(networkOne.check(phoneNumberTwo))) {
			System.out.println("The number " + phoneNumberTwo + " is not registered");
		}else if(this == phoneNumberTwo) {
				System.out.println("You are calling to yourself!");
			}else {
	System.out.println("Abonent +" +this.getPhoneNumber() + " is calling to " + phoneNumberTwo);
	}
	}
	@Override
	public String toString() {
		return "Phone +"  + phoneNumber;
	}
}
