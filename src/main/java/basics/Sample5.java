package basics;

import java.util.concurrent.CompletableFuture;

public class Sample5 {
	public static void main(String[] args) {
		CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> System.out.println("Future 1"));
		CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> System.out.println("Future 2"));
		CompletableFuture<Void> future3 = CompletableFuture.runAsync(() -> System.out.println("Future 3"));
		CompletableFuture<String> future4 = CompletableFuture.supplyAsync(() -> "Future 4");

		CompletableFuture<Void> all = CompletableFuture.allOf(future1, future2, future3, future4);
		all.join();

		System.out.println(future4.join());
	}
}
