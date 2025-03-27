package ex08class;

import ex09package.study.buyer.FruitBuyer4;

import ex09package.study.seller.FruitSeller4;

public class E06FruitSalesMain4 {
	
	public static void main(String[] args) {		
		/*
		생성자를 사용해서 인스턴스를 생성하몀 생성과 동시에 초기화할 수 있으므로
		초기화 메서드를 사용하는것보다 편리하게 코드를 작성할 수있다.
		 */
		FruitSeller4 seller1 = new FruitSeller4(0, 100, 1000);
		FruitSeller4 seller2 = new FruitSeller4(0, 80, 500);
		FruitBuyer4 buyer = new FruitBuyer4(10000, 0);
		
		System.out.println("구매행위가 일어나기 전의 상태");
		seller1.showSaleResult();
		seller2.showSaleResult();
		buyer.showBuyResult();
		
		//각각의 판매자에게 5000원씩 지불한 후 사과 구매
		buyer.buyApple(seller1, 5000);
		buyer.buyApple(seller2, 5000);
		
		System.out.println("구매행위가 일어난 후의 상태");
		seller1.showSaleResult();//5개 판매한다
		seller2.showSaleResult();//10개를 판매한다.
		//10,000원을 내고 15개를 구매한다
		buyer.showBuyResult();
	}
}
