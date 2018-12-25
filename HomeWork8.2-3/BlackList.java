package net.bigmir;

public class BlackList {
	private Class bList[] = new Class [5];
	private int i = 0;

	public BlackList() {
		super();
	}

	public void addToBlackList(Class cl) {
		bList[i]=cl;
		i++;
	}

	public void delFromBlackList(Class cl) {
		Class ob = null;
		for (int i = 0; i < bList.length; i++) {
			if (cl.equals(bList[i])) {
				ob = bList[i];
				bList[i] = null;
			}
		}
		System.out.println("You deleted from BlackList " + ob);

	}

	public boolean checkObject(Object obj) {
		for (int i = 0; i < bList.length; i++) {
			if(bList[i] == null) {
				continue;
			}
			if (bList[i].equals(obj.getClass())) {
				return true;
			}
			
		}
		return false;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[ ");
		for(int i = 0;i<bList.length;i++) {
			if(bList[i] == null) {
				continue;
			}
			sb.append(bList[i]);
			sb.append(";");
		}
		sb.append(" ]");
		return "BlackList" + sb.toString();
	}

}
