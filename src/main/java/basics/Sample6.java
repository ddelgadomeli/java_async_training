package basics;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class Sample6 {
	public static void main(String[] args) throws InterruptedException {
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
				.handle((s, t) -> {
					if (t instanceof RuntimeException) {
						// bla bla
					}

					return s != null ? s : "handled!";
				});

		System.out.println(completableFuture.join());
		System.out.println(completableFuture2.join());

		CompletableFuture<String> completableFuture3 = CompletableFuture.supplyAsync(() -> {
			if (name == null) {
				throw new RuntimeException("Computation error!");
			}
			return "Hello, " + name;
		});

		TimeUnit.SECONDS.sleep(2);

		completableFuture3.join();
	}
}
