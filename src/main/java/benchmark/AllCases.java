package benchmark;

import benchmark.cases.Case1Stream;
import benchmark.cases.Case2ParallelStream;
import benchmark.cases.Case3SerialCompletableFuture;
import benchmark.cases.Case4CompletableFuture;
import benchmark.cases.Case5CompletableFutureWithExecutor;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class AllCases {

	private static final String LINE_TEMPLATE = "| %-30s | %-8s |%n";

	public static void main(String[] args) {
		System.out.println("CPU Core: " + Runtime.getRuntime()
				.availableProcessors());
		System.out.println("CommonPool Parallelism: " + ForkJoinPool.commonPool()
				.getParallelism());
		System.out.println("CommonPool Common Parallelism: " + ForkJoinPool.getCommonPoolParallelism());

		System.out.println("Tasks Count: " + BenchmarkUtils.TEST_LIMIT);
		System.out.println("Task Sleep in millis: " + BenchmarkUtils.DURATION_IN_MILLIS);
		System.out.println();

		List<SleepTask> tasks = BenchmarkUtils.generateTasks();

		System.out.format("+--------------------------------+----------+%n");
		System.out.format(LINE_TEMPLATE, "Case", "millis");
		System.out.format("+--------------------------------+----------+%n");

		System.out.format(LINE_TEMPLATE, "Stream", Case1Stream.process(tasks));
		System.out.format(LINE_TEMPLATE, "ParallelStream", Case2ParallelStream.process(tasks));
		System.out.format(LINE_TEMPLATE, "SerialCompletableFuture", Case3SerialCompletableFuture.process(tasks));
		System.out.format(LINE_TEMPLATE, "CompletableFuture", Case4CompletableFuture.process(tasks));
		System.out.format(LINE_TEMPLATE, "CompletableFutureWithExecutor", Case5CompletableFutureWithExecutor.process(tasks));
		System.out.format("+--------------------------------+----------+%n");
	}
}
