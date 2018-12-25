package net.bigmir;

public interface NotNull {
	public int NOT_NULL = 2;
	public static int notNull(Object o1, Object o2) {
		if (o1 == null && o2 != null) {
			return -1;
		}
		if (o1 != null && o2 == null) {
			return 1;
		}
		if (o1 == null && o2 == null) {
			return 0;
		}
		return NOT_NULL;
	}
}
