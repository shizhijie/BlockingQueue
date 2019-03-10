package com.zjs.bwcx.delayqueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Student implements Delayed,Comparable<Delayed>{
	
	/**
	   * 必须实现Delayed  Comparable
	 * 1.缓存队列的设计，可以用delayqueue 保存元素的有效期，使用一个线程循环查询delayqueue,
	   *       一旦能从delayqueue中获取元素时，表示缓存有效期到了
	 * 2.定时任务调度，受用delay保存当天将会执行的任务和执行时间，一但从delayqueue中获取到的任务
	   *       就开始  执行，比如timmerqueue就是使用delayqueue实现的
	 */
	
	private String name;
	private long subtime;//交卷时间
	private long workTime;//考试时间
	public String getName() {
		return this.name +"交卷，用时"+workTime;
	}
	
	public Student(String name, long subtime) {
		super();
		this.name = name;
		this.workTime = subtime;
		this.subtime = TimeUnit.NANOSECONDS.convert(subtime, TimeUnit.MILLISECONDS)+System.currentTimeMillis();
		System.out.println(this.name +"交卷，用时"+workTime);
	}
	
	//必须实现getDelay
	@SuppressWarnings("static-access")
	@Override
	public long getDelay(TimeUnit unit) {
		//返回一个延迟时间
		return unit.convert(subtime-System.nanoTime(),unit.NANOSECONDS);
	}
	//必须实现compareTo
	@Override
	public int compareTo(Delayed o) {
		// 比较方法
		Student that = (Student) o;
		return subtime>that.subtime?1:(subtime<that.subtime?-1:0);
	}
}
