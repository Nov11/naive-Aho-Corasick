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
```
BenchMarkTest.benchmarkTest: [measured 10 out of 15 rounds, threads: 1 (sequential)]
 round: 0.31 [+- 0.01], round.block: 0.00 [+- 0.00], round.gc: 0.00 [+- 0.00], GC.calls: 3, GC.time: 0.01, time.total: 4.82, time.warmup: 1.77, time.bench: 3.05
BenchMarkTest.benchmarkTestRobertBors: [measured 10 out of 15 rounds, threads: 1 (sequential)]
 round: 0.30 [+- 0.10], round.block: 0.00 [+- 0.00], round.gc: 0.00 [+- 0.00], GC.calls: 9, GC.time: 0.66, time.total: 4.39, time.warmup: 1.41, time.bench: 2.98
```
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
