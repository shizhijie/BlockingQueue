package com.zjs.bwcx.priorityblockingqueue;

public class PriorityBlockingQueueDemo {
	//此队列可支持排序不会阻塞生产者，只会在没有可消费的数据时阻塞数据的消费者。
	//注意 生产者生产数据的速度绝对不能快于消费者的消费数据的速度，否则时间一长，会最终
	//消耗尽所有可用的堆内存空间，内部控制线程同步的锁采用的是公平锁
}
