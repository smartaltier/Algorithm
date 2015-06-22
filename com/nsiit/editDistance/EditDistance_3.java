package com.nsiit.editDistance;
/**
 * 实际手算的实现<br/>
 * 为每个字母标号，1-n,<br/>
 * 从1，1位开始计算<br/>
 * 1.相等，i,j就等于左上角的值，
 * 2.不等，为上，左，左上，三个位置的最小值加1<br/>
 * 3.最后n,m处的值即为最小编辑路径
 * @author Administrator
 *
 */
public class EditDistance_3 {
	static String str1 = "asd1f";
	static String str2 = "asdf1";
	static int d[][] = new int[str1.length()+str2.length()][str1.length()+str2.length()];

	public static void main(String[] args) {
		char[] src = str1.toCharArray();
		char[] tar = str2.toCharArray();
		System.out.println(editDistance(src, tar, 0, 0));
	}

	public static int editDistance(char[] src, char[] tar, int src_index, int tar_index) {
		for (int i = 1; i < src.length; i++) {
			d[i][0] = i;
		}
		for (int i = 1; i < tar.length; i++) {
			d[0][i] = i;
		}

		for (int i = 1; i <= src.length; i++) {
			for (int j = 1; j <= tar.length; j++) {
				if (src[i - 1] == tar[j - 1]) {
					d[i][j] = d[i - 1][j - 1];
				} else {
					int insert = d[i][j - 1] + 1;
					int delete = d[i - 1][j] + 1;
					int replac = d[i - 1][j - 1] + 1;
					d[i][j] = Math.min(Math.min(insert, delete), replac);
				}
			}
		}
		return d[src.length][tar.length];
	}
}
