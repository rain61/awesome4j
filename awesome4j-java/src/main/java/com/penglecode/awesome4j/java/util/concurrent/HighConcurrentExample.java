package com.penglecode.awesome4j.java.util.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class HighConcurrentExample {

	public static class Worker implements Runnable {

		private final CountDownLatch countDownLatch;
		
		public Worker(CountDownLatch countDownLatch) {
			super();
			this.countDownLatch = countDownLatch;
		}

		@Override
		public void run() {
			try {
				LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(50));
				System.out.println(String.format("【%s】>>> work done", Thread.currentThread().getName()));
			} finally {
				countDownLatch.countDown();
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		int clients = 10000;
		int threads = 18;
		final ExecutorService executorService = Executors.newFixedThreadPool(threads);
		final CountDownLatch countDownLatch = new CountDownLatch(clients);
		Worker worker = new Worker(countDownLatch);
		
		long start = System.currentTimeMillis();
		for(int i = 0; i < clients; i++) {
			executorService.execute(worker);
		}
		long submited = System.currentTimeMillis();
		countDownLatch.await();
		long finished = System.currentTimeMillis();
		System.out.println(String.format(">>> all worker submited used %s ms ... ", (submited - start)));
		System.out.println(String.format(">>> all worker finished used %s ms ... ", (finished - start)));
		executorService.shutdown();
	}

}
