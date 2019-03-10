package com.zjs.bwcx.synchronousqueue;

import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueDemo {
	/**
	 * SynchronousQueue是一个不存元素的阻塞队列，每一个put操作必须等待一个take操作
	   *    否则不能 继续添加元素SynchronousQueue可以看成一个传球手，负责把生产者线程处理的数据
	   *    直接   传递给消费者线程 队列本身不存储任何元素，非常适合于传递场景，比如在一个线程中处理的数据
	   *    传递给另外一个线程使用，SynchronousQueue的吞吐量高于LinkedBlockingQueue，ArrayBlockingQueue
	 */
	public static void main(String[] args) {
		System.out.println("begin:"+(System.currentTimeMillis()/1000));
		//定义一个SynchronousQueue
		final SynchronousQueue<String> sq = new SynchronousQueue<String>();
		//定义一个数量为1的信号源，起作用相当于一个互斥锁
		final Semaphore semaphore = new Semaphore(1);
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						semaphore.acquire();
						String input = sq.take();
						String output = TestDo.doSome(input);
						System.out.println(Thread.currentThread().getName()+":"+output);
						semaphore.release();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();;
		}
		for (int i = 0; i < 10; i++) {//不能改动
			String inputString = i+"";//不能改动
			try {
				sq.put(inputString);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
//不能改动
class TestDo{

	public static String doSome(String input) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return input+":"+(System.currentTimeMillis()/1000);
	}
	
}
