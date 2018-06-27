package basics;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Sample1 {
	public static void main(String[] args) {

		CompletableFuture<String> completedFuture = CompletableFuture.completedFuture("Manual Completion Test");

		try {
			System.out.println(completedFuture.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		try {
			System.out.println(completedFuture.get(10, TimeUnit.SECONDS));
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			e.printStackTrace();
		}

		System.out.println(completedFuture.join());
	}
}
