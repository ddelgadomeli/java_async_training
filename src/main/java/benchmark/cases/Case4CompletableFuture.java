package benchmark.cases;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import benchmark.BenchmarkUtils;
import benchmark.SleepTask;

public class Case4CompletableFuture {

	public static void main(String[] args) {
		List<SleepTask> tasks = BenchmarkUtils.generateTasks();

		long start = System.currentTimeMillis();

		List<CompletableFuture<Void>> futures = tasks.stream()
			.map(t -> CompletableFuture.runAsync(() -> t.sleep()))
			.collect(Collectors.toList());

		futures.stream()
			.forEach(CompletableFuture::join);

		long duration = (System.currentTimeMillis() - start);
		System.out.printf("Processed %d tasks in %d millis\n", BenchmarkUtils.TEST_LIMIT, duration);
	}
}
