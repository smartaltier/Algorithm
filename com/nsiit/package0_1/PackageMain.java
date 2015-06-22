package com.nsiit.package0_1;

/**
 * 0——1背包问题
 * 
 * @author Smartaltier
 *
 */
public class PackageMain {
	public static int totalCapacity = 150;
	public static int current_weight = 0;
	public static int current_price = 0;

	public static void main(String[] args) {
		Goods[] allGoods = Goods.initGoods();
		greedyAlgo(allGoods);
		printResult(allGoods);
	}

	public static void printResult(Goods[] allGoods) {
		for (int i = 0; i < allGoods.length; i++) {
			if (allGoods[i].status == 1) {
				System.out.println(allGoods[i].weight + "\t"
						+ allGoods[i].price);
			} else {
				System.out.println("==" + allGoods[i].weight + "\t"
						+ allGoods[i].price + "\tstatus" + allGoods[i].status);
			}
		}
		System.out.println("totalWeight:" + current_weight + "\ttotalPrice:"
				+ current_price);
	}

	/**
	 * 计算主函数
	 * 
	 * @param allGoods
	 */
	public static void greedyAlgo(Goods[] allGoods) {
		int goods_index = -1;
		while ((goods_index = selGoodsByPrice(allGoods)) != -1) {
			if (current_weight + allGoods[goods_index].weight <= totalCapacity) {
				allGoods[goods_index].status = 1;
				current_weight += allGoods[goods_index].weight;
				current_price += allGoods[goods_index].price;
			} else {
				allGoods[goods_index].status = 2;
			}

		}

	}

	/**
	 * 按照价格最高优先选择
	 * 
	 * @param allGoods
	 * @return
	 */
	public static int selGoodsByPrice(Goods[] allGoods) {
		int index = -1;
		int max_price = 0;
		for (int i = 0; i < allGoods.length; i++) {
			if (allGoods[i].status == 0 && allGoods[i].price > max_price) {
				max_price = allGoods[i].price;
				index = i;
			}
		}
		return index;
	}

	/**
	 * 按照最轻重量优先选择
	 * 
	 * @param allGoods
	 * @return
	 */
	public static int selGoodsByWeight(Goods[] allGoods) {
		int index = -1;
		int min_weight = totalCapacity;
		for (int i = 0; i < allGoods.length; i++) {
			if (allGoods[i].status == 0 && allGoods[i].price < min_weight) {
				min_weight = allGoods[i].weight;
				index = i;
			}
		}
		return index;
	}

	/**
	 * 按照重价比选择
	 * 
	 * @param allGoods
	 * @return
	 */
	public static int selGoodsByBalance(Goods[] allGoods) {
		int index = -1;
		float balance = 0, max_balance = 0;

		for (int i = 0; i < allGoods.length; i++) {
			balance = (float) allGoods[i].price / (float) allGoods[i].weight;
			if (allGoods[i].status == 0 && balance > max_balance) {
				max_balance = balance;
				index = i;
			}
		}
		return index;
	}
}
