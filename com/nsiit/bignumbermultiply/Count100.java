package com.nsiit.bignumbermultiply;

import java.util.ArrayList;
import java.util.List;

/**
 * 问题：在1..9,0这10个树中插入+/-或空，不改变数字顺序，使计算结果为100，求所有方案<br/>
 * 思路：<br/>
 * 在9个数之间插入3种符号，穷举情况，计算结果，<br/>
 * 问题：<br/>
 * 1.如何穷举，记录已尝试结果
 * 2.如何计算结果
 * @author Administrator
 *
 */
public class Count100 {
	public static List<String> fuHao = new ArrayList<String>();
	static{
		fuHao.add("");
		fuHao.add("+");
		fuHao.add("-");
	}
	/**
	 * 使用9位的三进制数来记录每位的状态
	 * @param args
	 */
	public static void main(String[] args) {
		StringBuffer sb = null;
		//循环次数是有极限的。
		for (int i = 0; i < Math.pow(3, 9); i++) {
			sb = new StringBuffer();
			int san[] = SanPlus.getArray(i).san;
			for (int j = 0; j < san.length; j++) {
				sb.append((j+1)%10).append(fuHao.get(san[j]));
			}
			sb.append("0");
			cal(sb.toString());
		}
	}
	/**
	 * 结果计算，输出结果为100的式子
	 * @param str
	 */
	public static void cal(String str){
		char[] c = str.toCharArray();
		StringBuffer int_sb = new StringBuffer();
		int total = 0;
		List<Integer> shu = new ArrayList<Integer>();
		List<String> fu = new ArrayList<String>();
		//获得数字和符号的集合
		for (int i = 0; i < c.length; i++) {
			if (!fuHao.contains(String.valueOf(c[i]))) {
				int_sb.append(c[i]);
			}else{
				shu.add(Integer.parseInt(int_sb.toString()));
				fu.add(String.valueOf(c[i]));
				int_sb = new StringBuffer();
			}
		}
		shu.add(Integer.parseInt(int_sb.toString()));
		
		//计算
		total = shu.get(0);
		for (int i = 1; i < shu.size(); i++) {
			total = fu.get(i-1).equals("+")?(total+shu.get(i)):(total-shu.get(i));
		}
		if (total==100) {
			System.out.println(str+"=100");
		}
	}
}
