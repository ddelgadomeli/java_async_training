package benchmark.cases;

import benchmark.BenchmarkUtils;
import benchmark.SleepTask;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class Case5CompletableFutureWithExecutor {
	private static ExecutorService executor = Executors.newFixedThreadPool(Math.min(BenchmarkUtils.TEST_LIMIT, 10));

	public static void main(String[] args) {
		List<SleepTask> tasks = BenchmarkUtils.generateTasks();
		System.out.printf("[Case5 - CompletableFutureWithExecutor] Processed %d tasks in %d millis%n", BenchmarkUtils.TEST_LIMIT, process(tasks));
	}

	public static long process(List<SleepTask> tasks) {
		long start = System.currentTimeMillis();

		List<CompletableFuture<Void>> futures = tasks.stream()
				.map(t -> CompletableFuture.runAsync(t::sleep, executor))
				.collect(Collectors.toList());

		futures.forEach(CompletableFuture::join);

		return (System.currentTimeMillis() - start);
	}
}
