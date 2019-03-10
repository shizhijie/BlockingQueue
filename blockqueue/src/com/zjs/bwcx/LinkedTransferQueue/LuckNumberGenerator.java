package com.zjs.bwcx.LinkedTransferQueue;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class LuckNumberGenerator {
	
	public static void main(String[] args) {
		
		TransferQueue<String> queue = new LinkedTransferQueue<String>();
		Thread producerThread = new Thread(new Producer(queue));
		producerThread.setDaemon(true);//设置为守护线程使得线程执行结束后程序自动结束运行
		producerThread.start();
		for (int i = 0; i < 10; i++) {
			Thread consumer = new Thread(new Consumer(queue));
			consumer.setDaemon(true);
			consumer.start();
			try {
				//消费者进程休眠一秒钟，使得生产者获得cup，从而生产数据
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
