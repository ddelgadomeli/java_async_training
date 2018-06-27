package basics;

import java.util.concurrent.CompletableFuture;

public class Sample6 {
	public static void main(String[] args) {
		String name = null;

		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
			if (name == null) {
				throw new RuntimeException("Computation error!");
			}
			return "Hello, " + name;
		})
				.exceptionally(t -> "Exceptionally handled!");

		CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(() -> {
			if (name == null) {
				throw new RuntimeException("Computation error!");
			}
			return "Hello, " + name;
		})
				.handle((s, t) -> s != null ? s : "handled!");

		System.out.println(completableFuture.join());
		System.out.println(completableFuture2.join());
	}
}
