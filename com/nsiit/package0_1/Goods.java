package com.nsiit.package0_1;

/**
 * 商品中的物品信息
 * 
 * @author Smartaltier
 *
 */
public class Goods {
	int weight;
	int price;
	int status;
	public Goods(int a,int b,int c ) {
		weight = a;
		price = b;
		status = c;//保存物品状态0未使用，1已使用,2不可用
	}
	public static Goods[] initGoods(){
		 Goods packages[] = {
			new Goods(35,10,0),
			new Goods(30,40,0),
			new Goods(60,30,0),
			new Goods(50,50,0),
			new Goods(40,35,0),
			new Goods(10,40,0),
			new Goods(25,30,0)
		 };
		 return packages;
	}
}
