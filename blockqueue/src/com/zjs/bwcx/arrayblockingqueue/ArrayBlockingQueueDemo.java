package com.zjs.bwcx.arrayblockingqueue;

import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueueDemo {
	
	public static void main(String[] args) throws InterruptedException {
		long start = System.currentTimeMillis();
		final ArrayBlockingQueue<String> bq = new ArrayBlockingQueue<String>(16);
		for (int i = 0; i < 4; i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					while (true) {
						try {
							String log = bq.take();
							parseLog(log);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
					}
					
				}
			}).start();;
		}
		for (int i = 0; i < 16; i++) {
			String logString = (i+1)+"--> ";
			bq.put(logString);
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
