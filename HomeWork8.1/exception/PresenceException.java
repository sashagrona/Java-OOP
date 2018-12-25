package net.bigmir.exception;

public class PresenceException extends Exception {

	@Override
	public String getMessage() {
		return "Error, this student is already in a group";
	}

}
