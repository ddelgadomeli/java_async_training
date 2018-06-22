package benchmark.cases;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import benchmark.BenchmarkUtils;
import benchmark.SleepTask;

public class Case3SerialCompletableFuture {

	public static void main(String[] args) {
		List<SleepTask> tasks = BenchmarkUtils.generateTasks();

		long start = System.currentTimeMillis();

		tasks.stream()
			.map(t -> CompletableFuture.runAsync(() -> t.sleep()))
			.forEach(CompletableFuture::join);

		long duration = (System.currentTimeMillis() - start);
		System.out.printf("Processed %d tasks in %d millis\n", BenchmarkUtils.TEST_LIMIT, duration);
	}
}
