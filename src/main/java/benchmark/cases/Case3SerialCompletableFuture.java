package benchmark.cases;

import benchmark.BenchmarkUtils;
import benchmark.SleepTask;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Case3SerialCompletableFuture {

	public static void main(String[] args) {
		List<SleepTask> tasks = BenchmarkUtils.generateTasks();
		System.out.printf("[Case3 - SerialCompletableFuture] Processed %d tasks in %d millis%n", BenchmarkUtils.TEST_LIMIT, process(tasks));
	}

	public static long process(List<SleepTask> tasks) {
		long start = System.currentTimeMillis();

		tasks.stream()
				.map(t -> CompletableFuture.runAsync(t::sleep))
				.forEach(CompletableFuture::join);

		return (System.currentTimeMillis() - start);
	}
}
