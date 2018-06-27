package basics;

import java.util.concurrent.CompletableFuture;

public class Sample4 {
	public static void main(String[] args) {
		CompletableFuture<String> composed = CompletableFuture.supplyAsync(() -> "Hello")
				.thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " World"));

		System.out.println("composed: " + composed.join());

		CompletableFuture<String> one = CompletableFuture.supplyAsync(() -> "Hello");
		CompletableFuture<String> two = CompletableFuture.supplyAsync(() -> " World");
		CompletableFuture<String> combined = one.thenCombine(two, (s1, s2) -> s1 + s2);

		System.out.println("combined: " + combined.join());
	}
}
