package com.zjs.bwcx.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
	
	public static void main(String[] args) {
		final Semaphore semaphore = new Semaphore(3);//一次只运行3个人进行访问
		for (int i = 0; i < 10; i++) {
			final int no = i;
			Runnable threadRunnable = new Runnable() {
				
				@Override
				public void run() {
					try {
						System.out.println("用户"+no+"连接上了：");
						Thread.sleep(300L);
						semaphore.acquire();//获取接下来执行的许可
						System.out.println("用户"+no+"开始访问后台程序。。。");
						Thread.sleep(1000L);//模仿用户访问服务过程
						semaphore.release();//释放允许下一个线程访问进入后台，
						System.out.println("用户"+no+"访问结束");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
			new Thread(threadRunnable).start();
		}
		System.out.println("Main Thread End!!!");
	}
}
