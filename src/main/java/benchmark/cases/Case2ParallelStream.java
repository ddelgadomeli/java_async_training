package benchmark.cases;

import java.util.List;

import benchmark.BenchmarkUtils;
import benchmark.SleepTask;

public class Case2ParallelStream {
	public static void main(String[] args) {
		List<SleepTask> tasks = BenchmarkUtils.generateTasks();

		long start = System.currentTimeMillis();
		
		tasks.parallelStream().forEach(SleepTask::sleep);
		
		long duration = (System.currentTimeMillis() - start);
		System.out.printf("Processed %d tasks in %d millis\n", BenchmarkUtils.TEST_LIMIT, duration);
	}
}
