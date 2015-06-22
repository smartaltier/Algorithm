package com.nsiit.editDistance;


/**
 * 增加状态记录，减少递归次数，动态规划
 * 
 * @author Administrator
 *
 */
public class EditDistance_2 {
	static String str1 = "asd1f";
	static String str2 = "asdf1";
	public static MemoRecord[][] memo = new MemoRecord[str1.length()][str2.length()];
	public static void main(String[] args) {
		char[] src = str1.toCharArray();
		char[] tar = str2.toCharArray();
		for (int i = 0; i < tar.length; i++) {
			for (int j = 0; j < src.length; j++) {
				memo[j][i] = new MemoRecord();//初始化结果表
			}
		}
		System.out.println(editDistance(src, tar, 0, 0));
	}

	public static int editDistance(char[] src, char[] tar, int src_index, int tar_index) {
		if (memo[src_index][tar_index].refCount != 0) {
			memo[src_index][tar_index].refCount ++ ;
			return memo[src_index][tar_index].distance;
		}
		int distance = 0;
		if (src.length-1 == src_index){
			distance = Math.abs(tar.length - tar_index);
		}else if( tar.length-1 == tar_index){
			distance = Math.abs(src.length - src_index);
		}else if (src[src_index] == tar[tar_index]) {
			distance = editDistance(src, tar, src_index + 1, tar_index + 1);
		}else{
			int insert = editDistance(src, tar, src_index, tar_index + 1) + 1;
			int delete = editDistance(src, tar, src_index + 1, tar_index) + 1;
			int replac = editDistance(src, tar, src_index + 1, tar_index + 1) + 1;
			distance = Math.min(Math.min(insert, delete), replac);
		}
		memo[src_index][tar_index].distance = distance;
		memo[src_index][tar_index].refCount = 1;
		return distance;
	}

}
