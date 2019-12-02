package benchmark;

import java.util.concurrent.TimeUnit;

public class SleepTask {
	private final long millis;
	private final boolean printThreadName;

	public SleepTask(long millis, boolean printThreadName) {
		this.millis = millis;
		this.printThreadName = printThreadName;
	}

	public void sleep() {
		if (printThreadName) {
			System.out.println("Thread: " + Thread.currentThread()
					.getName());
		}
		try {
			TimeUnit.MILLISECONDS.sleep(millis);
		} catch (final InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}