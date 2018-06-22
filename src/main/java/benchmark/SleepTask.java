package benchmark;

import java.util.concurrent.TimeUnit;

public class SleepTask {
	private final long millis;

	public SleepTask(long millis) {
		this.millis = millis;
	}

	public long sleep() {
		System.out.println(Thread.currentThread().getName());
		try {
			TimeUnit.MILLISECONDS.sleep(millis);
		} catch (final InterruptedException e) {
			throw new RuntimeException(e);
		}
		return millis;
	}
}