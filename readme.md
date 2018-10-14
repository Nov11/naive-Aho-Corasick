[![Build Status](https://travis-ci.org/Nov11/naive-Aho-Corasick.svg?branch=master)](https://travis-ci.org/Nov11/naive-Aho-Corasick)
[![Coverage Status](https://coveralls.io/repos/github/Nov11/naive-Aho-Corasick/badge.svg?branch=master)](https://coveralls.io/github/Nov11/naive-Aho-Corasick?branch=master)

#### Benchmark
File: AhoCorasickTest leveraging JUnitBenchmarks
* Input: 
    - text string: kjv bible
    - word list: words in this bible
* Output:
    - matched words

On my laptop
~~~
BenchMarkTest.benchmarkTest: [measured 10 out of 15 rounds, threads: 1 (sequential)]
 round: 0.31 [+- 0.01], round.block: 0.00 [+- 0.00], round.gc: 0.00 [+- 0.00], GC.calls: 3, GC.time: 0.01, time.total: 4.82, time.warmup: 1.77, time.bench: 3.05
BenchMarkTest.benchmarkTestRobertBors: [measured 10 out of 15 rounds, threads: 1 (sequential)]
 round: 0.30 [+- 0.10], round.block: 0.00 [+- 0.00], round.gc: 0.00 [+- 0.00], GC.calls: 9, GC.time: 0.66, time.total: 4.39, time.warmup: 1.41, time.bench: 2.98
~~~

~~~
-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running io.nov11.BenchMarkGCBeforeEveryRoundTest
BenchMarkGCBeforeEveryRoundTest.benchmarkTest: [measured 40 out of 60 rounds, threads: 1 (sequential)]
 round: 0.26 [+- 0.01], round.block: 0.00 [+- 0.00], round.gc: 0.05 [+- 0.01], GC.calls: 156, GC.time: 1.80, time.total: 18.11, time.warmup: 5.97, time.bench: 12.14
BenchMarkGCBeforeEveryRoundTest.benchmarkTestRobertBors: [measured 40 out of 60 rounds, threads: 1 (sequential)]
 round: 0.24 [+- 0.01], round.block: 0.00 [+- 0.00], round.gc: 0.87 [+- 0.04], GC.calls: 118, GC.time: 33.90, time.total: 66.63, time.warmup: 23.21, time.bench: 43.42
Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 85.075 sec
Running io.nov11.AhoCorasickTest
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0 sec
Running io.nov11.BenchMarkTest
BenchMarkTest.benchmarkTest: [measured 40 out of 60 rounds, threads: 1 (sequential)]
 round: 0.28 [+- 0.00], round.block: 0.00 [+- 0.00], round.gc: 0.00 [+- 0.00], GC.calls: 0, GC.time: 0.00, time.total: 16.79, time.warmup: 5.61, time.bench: 11.19
BenchMarkTest.benchmarkTestRobertBors: [measured 40 out of 60 rounds, threads: 1 (sequential)]
 round: 0.25 [+- 0.03], round.block: 0.00 [+- 0.00], round.gc: 0.00 [+- 0.00], GC.calls: 19, GC.time: 1.20, time.total: 16.77, time.warmup: 6.60, time.bench: 10.18
Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 34.108 sec

Results :

Tests run: 5, Failures: 0, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 02:00 min
[INFO] Finished at: 2018-10-14T12:53:09+08:00
[INFO] Final Memory: 19M/301M
[INFO] ------------------------------------------------------------------------

~~~

On travis
```
-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running io.nov11.BenchMarkTest
BenchMarkTest.benchmarkTest: [measured 10 out of 15 rounds, threads: 1 (sequential)]
 round: 0.49 [+- 0.05], round.block: 0.00 [+- 0.00], round.gc: 0.00 [+- 0.00], GC.calls: 4, GC.time: 0.06, time.total: 7.60, time.warmup: 2.79, time.bench: 4.81
BenchMarkTest.benchmarkTestRobertBors: [measured 10 out of 15 rounds, threads: 1 (sequential)]
 round: 1.12 [+- 0.13], round.block: 0.00 [+- 0.00], round.gc: 0.00 [+- 0.00], GC.calls: 19, GC.time: 3.98, time.total: 17.31, time.warmup: 6.07, time.bench: 11.24
Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 25.915 sec
Running io.nov11.AhoCorasickTest
Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.002 sec
Results :
Tests run: 4, Failures: 0, Errors: 0, Skipped: 0
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 29.823 s
[INFO] Finished at: 2018-10-14T02:44:05Z
[INFO] Final Memory: 15M/51M
[INFO] ------------------------------------------------------------------------
```
```
-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running io.nov11.BenchMarkGCBeforeEveryRoundTest
BenchMarkGCBeforeEveryRoundTest.benchmarkTest: [measured 40 out of 60 rounds, threads: 1 (sequential)]
 round: 0.47 [+- 0.01], round.block: 0.00 [+- 0.00], round.gc: 0.26 [+- 0.00], GC.calls: 118, GC.time: 10.11, time.total: 44.43, time.warmup: 15.42, time.bench: 29.00
BenchMarkGCBeforeEveryRoundTest.benchmarkTestRobertBors: [measured 40 out of 60 rounds, threads: 1 (sequential)]
 round: 1.00 [+- 0.06], round.block: 0.00 [+- 0.00], round.gc: 0.86 [+- 0.02], GC.calls: 185, GC.time: 47.30, time.total: 111.19, time.warmup: 37.68, time.bench: 73.52
Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 156.763 sec
Running io.nov11.BenchMarkTest
BenchMarkTest.benchmarkTest: [measured 40 out of 60 rounds, threads: 1 (sequential)]
 round: 0.47 [+- 0.02], round.block: 0.00 [+- 0.00], round.gc: 0.00 [+- 0.00], GC.calls: 5, GC.time: 0.07, time.total: 29.05, time.warmup: 10.22, time.bench: 18.83
BenchMarkTest.benchmarkTestRobertBors: [measured 40 out of 60 rounds, threads: 1 (sequential)]
 round: 1.15 [+- 0.18], round.block: 0.00 [+- 0.00], round.gc: 0.00 [+- 0.00], GC.calls: 68, GC.time: 15.75, time.total: 70.85, time.warmup: 24.76, time.bench: 46.09
Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 100.178 sec
Running io.nov11.AhoCorasickTest
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.006 sec
Results :
Tests run: 5, Failures: 0, Errors: 0, Skipped: 0
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 04:21 min
[INFO] Finished at: 2018-10-14T04:49:43Z
[INFO] Final Memory: 16M/53M
[INFO] ------------------------------------------------------------------------
```