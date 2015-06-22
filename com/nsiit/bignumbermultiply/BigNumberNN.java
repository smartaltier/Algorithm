package com.nsiit.bignumbermultiply;



/**
 * 大数相乘N方时间复杂度算法<br/>
 * 基本想法：<br/>
 * 手动运算，去除小数，分位想成，各位相加，进位处理，小数处理，结果输出
 * 
 * @author Smartaltier
 *
 */
public class BigNumberNN {
	public static void main(String[] args) {
		String multiplier = "1231.2310";
		String do_multiplicator = "";
		multiply(multiplier, do_multiplicator);
	}
	
	/**
	 * 乘法处理
	 * @param number1
	 * @param number2
	 */
	public static void multiply(String number1,String number2){
		if (checkNumber(number1)||checkNumber(number2)) {
			return ;
		}
		int len_xiaoshu = getXiaoshu(number1) + getXiaoshu(number2);
		
	}
	
	/**
	 * 检查数字的正确性
	 * @param number
	 * @return
	 */
	public static boolean checkNumber(String number){
		String reg = "(\\d+|^\\d+\\.\\d+$)";
		if (number.matches(reg)) {
			return false;
		}
		return true;
	}
	/**
	 * 获取小数位长度
	 * @param number
	 * @return
	 */
	public static int getXiaoshu(String number){
		return number.length() - number.indexOf(".") - 1;
	}
}
