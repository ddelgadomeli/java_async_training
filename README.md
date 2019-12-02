# ForkJoinPool vs ExecutorService Benchmark

[Basic Samples](src/main/java/basics)

[Benchmark Cases](src/main/java/benchmark/cases)

[Benchmark Starter](src/main/java/benchmark/AllCases.java)

Sample run:
```
CPU Core: 4
CommonPool Parallelism: 3
CommonPool Common Parallelism: 3
Tasks Count: 10
Task Sleep in millis: 1000

+--------------------------------+----------+
| Case                           | millis   |
+--------------------------------+----------+
| Stream                         | 10051    |
| ParallelStream                 | 3051     |
| SerialCompletableFuture        | 10047    |
| CompletableFuture              | 4012     |
| CompletableFutureWithExecutor  | 1003     |
+--------------------------------+----------+
```

