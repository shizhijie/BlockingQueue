package com.zjs.bwcx.LinkdBlockingDeque;

public class LinkdBlockingDequeDemo {
	/*
	 * LinkedBlockingDeque是一个由链表结构组成的双向阻塞队列。所谓双向队列指的你可以从队列的两端掺入和移出元素。
	 * 双端对列应为多了一个操作队列的入口，
	 * 在多线程同时入队时，也就减少了一般的竞争。相比于其他阻塞队列，LinkedBlockingDeque多了addFirst、addLast、
	 * peekFirst、peekLast等方法，
	 * 以first结尾的方法，表示插入、获取获移除双端队列的第一个元素。以last结尾的方法，表示插入、获取获移除双端队列的最后一个元素。
	 * LinkedBlockingDeque是可选容量的，在初始化时可以设置容量防止其过度膨胀，如果不设置，默认容量大小为Integer.MAX_VALUE。
	 * 另外，双向阻塞队列可以运用在 “工作窃取”模式中
	 */

}
