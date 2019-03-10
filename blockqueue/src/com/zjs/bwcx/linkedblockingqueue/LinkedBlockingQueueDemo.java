package com.zjs.bwcx.linkedblockingqueue;

import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueueDemo {
	public static void main(String[] args) throws InterruptedException {
		long start = System.currentTimeMillis();
		LinkedBlockingQueue<String> bq = new LinkedBlockingQueue<String>();
		for (int i = 0; i < 4; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						while(true) {
							String log = bq.take();
							parseLog(log);
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
		for (int i = 0; i < 16; i++) {
			String log = (i+1)+"-->  ";
			bq.put(log);
		}
		System.out.println(System.currentTimeMillis()-start);
	}

	public static void parseLog(String log) {
		System.out.println(log+System.currentTimeMillis());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
