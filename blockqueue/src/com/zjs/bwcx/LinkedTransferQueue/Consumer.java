package com.zjs.bwcx.LinkedTransferQueue;

import java.util.concurrent.TransferQueue;

public class Consumer implements Runnable{
	
	
	private final TransferQueue<String> queue;
	
	public Consumer(TransferQueue<String> queue) {
		super();
		this.queue = queue;
	}



	@Override
	public void run() {
		try {
			System.out.println("consumer"+Thread.currentThread().getName()+queue.take());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
