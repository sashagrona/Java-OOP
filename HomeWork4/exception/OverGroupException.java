package net.bigmir.exception;

public class OverGroupException extends Exception{

	@Override
	public String getMessage() {
		return "Error, try to add to the group more students, than should be";
	}

}
