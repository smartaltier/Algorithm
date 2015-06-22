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
		String do_multiplicator = "1212";
		multiply(multiplier, do_multiplicator);
	}

	/**
	 * 乘法处理
	 * 
	 * @param number1
	 * @param number2
	 */
	public static void multiply(String number1, String number2) {
		if (checkNumber(number1) || checkNumber(number2)) {
			System.out.println("Input Error!");
			return;
		}
		int len_xiaoshu = getXiaoshu(number1) + getXiaoshu(number2);

		String number1_1 = number1.replace(".", "");
		String number2_1 = number2.replace(".", "");

		System.out.println(number1_1 + "==" + number2_1);

		int maxlen_result = number1.length() + 3 + number2.length();// 结果最大长度
		int result[] = new int[maxlen_result];
		// 乘法处理，每位放置的数值
		for (int i = 0; i < number1_1.length(); i++) {
			int cheng_1 = getChengShu(number1_1, i);
			for (int j = 0; j < number2_1.length(); j++) {
				int cheng_2 = getChengShu(number2_1, j);
				result[i + j] += cheng_1 * cheng_2;
			}
		}
		// 进位处理
		for (int i = 0; i < result.length - 1; i++) {
			int jin_wei = 0;
			if (result[i] > 10) {
				jin_wei = result[i] / 10;
				result[i] = result[i] % 10;
			}
			result[i + 1] += jin_wei;
		}
		// 查找第一位的位置
		int len_result = 0;
		for (int i = result.length - 1; i >= 0; i--) {
			if (result[i] != 0) {
				len_result = i;
				break;
			}
		}
		// 结果输出
		for (int i = len_result; i >= 0; i--) {
			if (i == len_xiaoshu - 1) {
				System.out.print(".");
			}
			System.out.print(result[i]);
		}
	}

	/**
	 * 获取指定位置的数字，当成乘数
	 * 
	 * @param number
	 * @param i
	 * @return
	 */
	public static int getChengShu(String number, int i) {
		return Integer.parseInt(number.substring(number.length() - i - 1,
				number.length() - i));
	}

	/**
	 * 检查数字的正确性
	 * 
	 * @param number
	 * @return
	 */
	public static boolean checkNumber(String number) {
		String reg = "(\\d+|^\\d+\\.\\d+$)";
		if (number.matches(reg)) {
			return false;
		}
		return true;
	}

	/**
	 * 获取小数位长度
	 * 
	 * @param number
	 * @return
	 */
	public static int getXiaoshu(String number) {
		if (number.indexOf(".") == -1) {
			return 0;
		}
		return number.length() - number.indexOf(".") - 1;
	}
}
