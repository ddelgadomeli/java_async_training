package basics;

import java.util.concurrent.CompletableFuture;

public class Sample3 {
	public static void main(String[] args) {
		CompletableFuture<String> thenApply = CompletableFuture.supplyAsync(() -> "World")
				.thenApplyAsync(name -> "Hello " + name + "!")
				.thenApply(greeting -> greeting + " Welcome to CompletableFutures!");

		CompletableFuture<Void> thenAccept = thenApply.thenAccept(System.out::println);
		thenAccept.join();
	}
}
