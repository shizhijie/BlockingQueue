package com.zjs.bwcx.CountDownLanch;

import java.util.concurrent.CountDownLatch;

public class CountDownLanchDemo {
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch countDownLatch = new CountDownLatch(3);
		Worker worker1 = new Worker("jack 程序员1", countDownLatch);
		Worker worker2 = new Worker("rose 程序员2", countDownLatch);
		Worker worker3 = new Worker("json 程序员3", countDownLatch);
		worker1.start();
		worker2.start();
		worker3.start();
		//countDownLatch.await(500, TimeUnit.MILLISECONDS);
		countDownLatch.await();
		System.out.println("Main Thread end!!!");
	}
	static class Worker extends Thread{
		private String workerName;
		private CountDownLatch launch;
		
		public Worker(String workerName, CountDownLatch launch) {
			this.workerName = workerName;
			this.launch = launch;
		}

		@Override
		public void run() {
			try {
				System.out.println("worker:"+workerName+" is begin.");
				Thread.sleep(1000);//模仿干活
				System.out.println("worker:"+workerName+" is end.");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			launch.countDown();
		}
		
	}
}
