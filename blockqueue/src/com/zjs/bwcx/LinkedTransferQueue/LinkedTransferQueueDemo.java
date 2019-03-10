package com.zjs.bwcx.LinkedTransferQueue;

public class LinkedTransferQueueDemo {
	/*
	 * 这个是JDK7才定义的一个节点，LinkedTransferQueue实现了这个接口，其新特性也就与之有关。通常阻塞队里中，
	 * 生产者放入元素，消费者使用元素，这两个部分是分离的。这里的分离意思如下：厨师做好了菜放在柜台上，服务员端走，
	 * 厨师是不需要管有没有人取走做的菜，服务员也不需要管厨师有没有做好菜，没做好菜阻塞就行了。上面就是个人所说的分
	 * 离的意思。TransferQueue接口定义的相关内容就是厨师会知道做好的菜有没有被取走。
	 * 
	 * 
	 * 
	 * 1.tryTransfer(E)：将元素立刻给消费者。准确的说就是立刻给一个等待接收元素的线程，如果没有消费者就会返回 false，而不将元素放入队列。
	 * 
	 * 2.transfer(E)：将元素给消费者，如果没有消费者就会等待。
	 * 
	 * 3.tryTransfer(E,long,TimeUnit)：将元素立刻给消费者，如果没有就等待指定时间。给失败返回false。
	 * 
	 * 4.hasWaitingConsumer()：返回当前是否有消费者在等待元素。
	 * 
	 * 5.getWaitingConsumerCount()：返回等待元素的消费者个数。
	 */
}
