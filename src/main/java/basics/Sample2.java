package basics;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Sample2 {
	public static void main(String[] args) {

		ExecutorService executor = Executors.newFixedThreadPool(2);

		CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(Sample2::magicWait);
		CompletableFuture<String> supplyAsync2 = CompletableFuture.supplyAsync(Sample2::magicWait, executor);

		CompletableFuture<Void> runAsync = CompletableFuture.runAsync(() -> System.out.println("runAsync: " + magicWait()));
		CompletableFuture<Void> runAsync2 = CompletableFuture.runAsync(() -> System.out.println("runAsync2: " + magicWait()), executor);

		System.out.println("supplyAsync: " + supplyAsync.join());
		System.out.println("supplyAsync2: " + supplyAsync2.join());
		runAsync.join();
		runAsync2.join();
	}

	private static String magicWait() {
		long timeout = (long) (Math.random() * 1000);
		try {
			TimeUnit.MILLISECONDS.sleep(timeout);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return String.format("Hi, my name is %s and I wait %dms", Thread.currentThread()
				.getName(), timeout);
	}
}
