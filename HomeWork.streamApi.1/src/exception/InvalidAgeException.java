package exception;

public class InvalidAgeException extends Exception{

	@Override
	public String getMessage() {
		return "Error, input age beetween 0 and 100 ";
	}

}