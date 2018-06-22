package benchmark;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public interface BenchmarkUtils {
	static final int DURATION_IN_MILLIS = 1000;
	static final int TEST_LIMIT = 10;

	static List<SleepTask> generateTasks() {
		return IntStream.range(0, TEST_LIMIT)
				.mapToObj(i -> new SleepTask(DURATION_IN_MILLIS))
				.collect(Collectors.toList());
	}
}
