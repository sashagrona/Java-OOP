package net.bigmir;

public class Letter {
	private char let;
	private int count;


	public Letter(char let, int count) {
		super();
		this.let = let;
		this.count = count;
	}

	public Letter() {
		super();
	}

	public Character getLet() {
		return let;
	}

	public void setLet(Character let) {
		this.let = let;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Letter: " + let + " has met " + count + " times";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + count;
		result = prime * result + let;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Letter other = (Letter) obj;
		if (count != other.count)
			return false;
		if (let != other.let)
			return false;
		return true;
	}
	
	
}
