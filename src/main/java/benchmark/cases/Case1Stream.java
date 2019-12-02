package benchmark.cases;

import benchmark.BenchmarkUtils;
import benchmark.SleepTask;
import java.util.List;

public class Case1Stream {

	public static void main(String[] args) {
		List<SleepTask> tasks = BenchmarkUtils.generateTasks();
		System.out.printf("[Case1 - Stream] Processed %d tasks in %d millis%n", BenchmarkUtils.TEST_LIMIT, process(tasks));
	}

	public static long process(List<SleepTask> tasks) {
		long start = System.currentTimeMillis();

		tasks.forEach(SleepTask::sleep);

		return (System.currentTimeMillis() - start);
	}
}
