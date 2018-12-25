package net.bigmir;

import java.util.Arrays;

public class StackContainer {
	private Object[] obj = new Object[6];
	private int i = 0;
	private BlackList blackList;

	public StackContainer(Object[] obj, int i, BlackList blackList) {
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
		isOverFlow();
		if (obj != null && blackList.checkObject(obj)) {
			System.out.println("This object is in the BlackList");
		} else if (obj != null && !blackList.checkObject(obj)) {
			this.obj[i] = obj;

			System.out.println("You have been added to the stack " + obj.getClass());
		}
		i++;
	}

	public void isOverFlow() {
		if (i > obj.length - 1) {
			System.err.print("StackOverFlow ");
		}
	}

	public Object popAndGet() {
		Object ob = null;
		if (obj[i - 1] == null) {
			for (int j = i; j < obj.length; j--) {
				if (obj[j] != null) {
					ob = obj[j].getClass();
					obj[j] = null;
					return ob;
				}
			}
		}
		ob = this.obj[i - 1].getClass();
		this.obj[i - 1] = null;
		return ob;
	}

	public Object getTop() {
		if (obj[i - 1] == null) {
			for (int j = i; j < obj.length; j--) {
				if (obj[j] != null) {
					return obj[j].getClass();
				}
			}
		}
		Object ob = this.obj[i - 1].getClass();
		return ob;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[ ");
		for(int i = 0;i<obj.length;i++) {
			if(obj[i] == null) {
				continue;
			}
			sb.append(obj[i]);
			sb.append(";");
		}
		sb.append(" ]");
		return "StackContainer " + sb.toString();
	}

}
