package net.bigmir;

public class StackContainer {
	private Object[] obj = new Object[4];
	private int i = 0;
	private BlackList blackList;

	public StackContainer(BlackList blackList) {
		super();
		this.blackList = blackList;
	}

	public StackContainer() {
		super();
	}

	public void setBlackList(BlackList blackList) {
		this.blackList = blackList;
	}

	public void push(Object obj) {
		if (i < this.obj.length) {
			if (obj != null && blackList.checkObject(obj)) {
				System.out.println("This object is in the BlackList");
			} else if (obj != null && !blackList.checkObject(obj)) {
				this.obj[i] = obj;
				i++;
				System.out.println("You have been added to the stack " + obj);
			}
		} else {
			System.out.println("StackOverFlow");
		}

	}

	public Object popAndGet() {
		if (i > 0) {
			Object ob = obj[i - 1];
			obj[i - 1] = null;
			i--;
			return "You poped " + ob;
		}
		if (i < 1) {
			return "The stack is empty";
		}
		return null;

	}

	public Object getTop() {
		if (i > 0) {
			return obj[i - 1];
		}
		if (i < 1) {
			return "The stack is empty";
		}
		return null;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[ ");
		for (int i = 0; i < obj.length; i++) {
			if (obj[i] == null) {
				continue;
			}
			sb.append(obj[i]);
			sb.append(";");
		}
		sb.append(" ]");
		return "StackContainer " + sb.toString();
	}

}
