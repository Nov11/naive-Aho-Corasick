[![Build Status](https://travis-ci.org/Nov11/naive-Aho-Corasick.svg?branch=master)](https://travis-ci.org/Nov11/naive-Aho-Corasick)
[![Coverage Status](https://coveralls.io/repos/github/Nov11/naive-Aho-Corasick/badge.svg?branch=master)](https://coveralls.io/github/Nov11/naive-Aho-Corasick?branch=master)

#### Benchmark
File: AhoCorasickTest leveraging JUnitBenchmarks
* Input: 
    - text string: kjv bible
    - word list: words in this bible
* Output:
    - matched words

```
AhoCorasickTest.robert_bor_aho_corasick: [measured 10 out of 15 rounds, threads: 1 (sequential)]
 round: 0.29 [+- 0.05], round.block: 0.00 [+- 0.00], round.gc: 0.00 [+- 0.00], GC.calls: 7, GC.time: 0.51, time.total: 5.76, time.warmup: 2.89, time.bench: 2.86
AhoCorasickTest.match: [measured 10 out of 15 rounds, threads: 1 (sequential)]
 round: 0.00 [+- 0.00], round.block: 0.00 [+- 0.00], round.gc: 0.00 [+- 0.00], GC.calls: 0, GC.time: 0.00, time.total: 0.00, time.warmup: 0.00, time.bench: 0.00
AhoCorasickTest.benchmarkTest: [measured 10 out of 15 rounds, threads: 1 (sequential)]
 round: 0.28 [+- 0.00], round.block: 0.00 [+- 0.00], round.gc: 0.00 [+- 0.00], GC.calls: 0, GC.time: 0.00, time.total: 4.20, time.warmup: 1.42, time.bench: 2.78

Process finished with exit code 0
```
