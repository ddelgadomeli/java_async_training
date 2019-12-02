package benchmark;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public interface BenchmarkUtils {
	int DURATION_IN_MILLIS = 1000;
	int TEST_LIMIT = 10;
	boolean PRINT_THREAD_NAME = false;

	static List<SleepTask> generateTasks() {
		return IntStream.range(0, TEST_LIMIT)
				.mapToObj(i -> new SleepTask(DURATION_IN_MILLIS, PRINT_THREAD_NAME))
				.collect(Collectors.toList());
	}
}
