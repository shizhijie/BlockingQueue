package com.zjs.bwcx;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
	
	public static void main(String[] args) {
		
		CyclicBarrier cyclicBarrier = new CyclicBarrier(3,new TotalTask());
		BillTask billTask1 = new BillTask("111", cyclicBarrier);
		BillTask billTask2 = new BillTask("222", cyclicBarrier);
		BillTask billTask3 = new BillTask("333", cyclicBarrier);
		billTask1.start();
		billTask2.start();
		billTask3.start();
		System.out.println("Main Thread end!!");
	}
	static class TotalTask extends Thread{

		@Override
		public void run() {
			System.out.println("所有子任务都执行完了，就开始执行主任务了。");
		}
	}
	static class BillTask extends Thread{
		private String billName;
		private CyclicBarrier barrier;
		
		public BillTask(String billName, CyclicBarrier barrier) {
			this.billName = billName;
			this.barrier = barrier;
		}
		

		@Override
		public void run() {
			try {
				System.out.println("市区："+billName+"运算开始：");
				Thread.sleep(1000l);//模仿第一次运算
				System.out.println("市区："+billName+"运算完成，等待中。。。");
				barrier.await();//假设第一次运算不完，第二次要依赖第一次的运算结果。都到达这个节点之后才会继续执行
				System.out.println("全部都结束，市区"+billName+"才开始后面的工作");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
