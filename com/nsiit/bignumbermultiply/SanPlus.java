package com.nsiit.bignumbermultiply;
/**
 * 九位三进制数
 * @author Administrator
 *
 */
public class SanPlus {
	int[] san = new int[9];
	public static SanPlus getArray(int integer){
		SanPlus sanPlus = new SanPlus();
		int rest = integer;
		for (int i = 0; i < sanPlus.san.length; i++) {
			sanPlus.san[i] = rest%3;
			rest = rest/3;
		}
		return sanPlus;
	}
}
