package net.bigmir;

public class BlackList {
	private Class bList[] = new Class [4];
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
		for (int j = 0; j <i; j++) {
			if (cl.equals(bList[j])) {
				ob = bList[j];
				bList[j] = null;
			}
		}
		i--;
		System.out.println("You deleted from BlackList " + ob);

	}

	public boolean checkObject(Object obj) {
		for (int j = 0; j < i; j++) {
			if(bList[j] == null) {
				continue;
			}
			if (bList[j].equals(obj.getClass())) {
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
