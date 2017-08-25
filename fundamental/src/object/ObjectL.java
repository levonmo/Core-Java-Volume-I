package object;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ObjectL  {
	
	//构建一个可以被用来保护临界区的可重入锁
	private Lock bankLock = new ReentrantLock();
	/*
	 * 还有一个构造函数是可以传人一个boolean的参数的，那是构建一个公平策略的锁。一个公平策略锁偏爱等待时间最长的线程。
	 * 	但是，这一个公平的保证将大大降低性能。所以，在默认的情况下，锁没有被强制为公平的。
	 * 	
	 */
	
	public void method(){
		bankLock.lock();
		try
		{
		System.out.println("method正在运行");	
		}
		finally
		{
			bankLock.unlock();
		}
	}
	/*
	 * 这里需要注意的是：
	 * 	每一个ObjectL对象都有自己的ReentrantLock对象。如果两个线程试图访问同一个ObjectL对象，那么锁是以串行方式提供服务。
	 * 		但是，如果两个线程访问不同的ObjectL对象，每一个线程得到的锁对象就不一样了，两个线程就不会发生阻塞。
	 * 		锁是可以重入的，一个锁保护的代码可以调用另外一个使用的相同锁的方法。
	 * 
	 */
	
}
