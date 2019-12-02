package benchmark.cases;

import benchmark.BenchmarkUtils;
import benchmark.SleepTask;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class Case4CompletableFuture {

	public static void main(String[] args) {
		List<SleepTask> tasks = BenchmarkUtils.generateTasks();
		System.out.printf("[Case4 - CompletableFuture] Processed %d tasks in %d millis%n", BenchmarkUtils.TEST_LIMIT, process(tasks));
	}

	public static long process(List<SleepTask> tasks) {
		long start = System.currentTimeMillis();

		List<CompletableFuture<Void>> futures = tasks.stream()
				.map(t -> CompletableFuture.runAsync(t::sleep))
				.collect(Collectors.toList());

		futures.forEach(CompletableFuture::join);

		return (System.currentTimeMillis() - start);
	}
}
