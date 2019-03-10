package com.zjs.bwcx.delayqueue;

import java.util.concurrent.DelayQueue;

public class DelayQueueDemo {
	public static void main(String[] args) throws InterruptedException {
		//新建一个等待队列
		final DelayQueue<Student> bq = new DelayQueue<Student>();
		for (int i = 0; i < 5; i++) {
			Student student = new Student(i+"学生", Math.round(Math.random()*10+i));
			bq.put(student);//将数据存入队列
		}
		//获取但不移除次队列的头部，；如果次队列为空，则返回null
		System.out.println("bq.peek()"+bq.peek().getName());
		//获取并移除队列的头部，在可从队列获得到延迟的元素，或者到达指定 的等待时间之前一直等待（如有必要）
		//Student poll = bq.poll(10000, TimeUnit.MILLISECONDS);
		//System.out.println(poll.getName());
		System.out.println(bq.size());
	}
}
