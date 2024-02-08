## java -jar --enable-preview target/benchmarks.jar Chunk -prof perf

```
# JMH version: 1.37
# VM version: JDK 21.0.2, Java HotSpot(TM) 64-Bit Server VM, 21.0.2+13-LTS-jvmci-23.1-b30
# VM invoker: /home/jonathan/.sdkman/candidates/java/21.0.2-graal/bin/java
# VM options: -XX:ThreadPriorityPolicy=1 -XX:+UnlockExperimentalVMOptions -XX:+EnableJVMCIProduct -XX:-UnlockExperimentalVMOptions --enable-preview
# Blackhole mode: compiler (auto-detected, use -Djmh.blackhole.autoDetect=false to disable)
# Warmup: 2 iterations, single-shot each
# Measurement: 2 iterations, single-shot each
# Timeout: 10 min per iteration
# Threads: 1 thread
# Benchmark mode: Single shot invocation time
# Benchmark: jonathan.aotearoa.jmh.ChunkSizeBenchmark.read
# Parameters: (chunkSize = 4096)

# Run progress: 0.00% complete, ETA 00:00:00
# Fork: 1 of 1
# Preparing profilers: LinuxPerfProfiler
# Profilers consume stderr from target VM, use -v EXTRA to copy to console
# Warmup Iteration   1: 8.539 s/op
# Warmup Iteration   2: 8.084 s/op
Iteration   1: 8.125 s/op
Iteration   2: 8.000 s/op
# Processing profiler results: LinuxPerfProfiler


Secondary result "jonathan.aotearoa.jmh.ChunkSizeBenchmark.read:perf":
Perf stats:
--------------------------------------------------

         70,985.20 msec task-clock                       #    2.183 CPUs utilized             
           384,811      context-switches                 #    5.421 K/sec                     
            60,549      cpu-migrations                   #  852.981 /sec                      
           898,687      page-faults                      #   12.660 K/sec                     
282,010,441,971      cycles                           #    3.973 GHz                         (32.91%)
1,881,259,993      stalled-cycles-frontend          #    0.67% frontend cycles idle        (33.15%)
52,473,112,243      stalled-cycles-backend           #   18.61% backend cycles idle         (33.25%)
272,518,817,378      instructions                     #    0.97  insn per cycle            
#    0.19  stalled cycles per insn     (33.63%)
54,154,575,245      branches                         #  762.900 M/sec                       (33.96%)
2,855,880,634      branch-misses                    #    5.27% of all branches             (33.82%)
112,067,168,255      L1-dcache-loads                  #    1.579 G/sec                       (33.98%)
1,891,923,885      L1-dcache-load-misses            #    1.69% of all L1-dcache accesses   (34.11%)
<not supported>      LLC-loads                                                             
<not supported>      LLC-load-misses                                                       
40,590,981,556      L1-icache-loads                  #  571.823 M/sec                       (33.94%)
56,074,604      L1-icache-load-misses            #    0.14% of all L1-icache accesses   (33.59%)
177,280,016      dTLB-loads                       #    2.497 M/sec                       (33.62%)
29,795,733      dTLB-load-misses                 #   16.81% of all dTLB cache accesses  (33.22%)
1,488,979      iTLB-loads                       #   20.976 K/sec                       (32.97%)
4,017,716      iTLB-load-misses                 #  269.83% of all iTLB cache accesses  (32.80%)
1,316,950,469      L1-dcache-prefetches             #   18.552 M/sec                       (32.83%)
<not supported>      L1-dcache-prefetch-misses

      32.511942970 seconds time elapsed

      15.044751000 seconds user
      57.274960000 seconds sys




# JMH version: 1.37
# VM version: JDK 21.0.2, Java HotSpot(TM) 64-Bit Server VM, 21.0.2+13-LTS-jvmci-23.1-b30
# VM invoker: /home/jonathan/.sdkman/candidates/java/21.0.2-graal/bin/java
# VM options: -XX:ThreadPriorityPolicy=1 -XX:+UnlockExperimentalVMOptions -XX:+EnableJVMCIProduct -XX:-UnlockExperimentalVMOptions --enable-preview
# Blackhole mode: compiler (auto-detected, use -Djmh.blackhole.autoDetect=false to disable)
# Warmup: 2 iterations, single-shot each
# Measurement: 2 iterations, single-shot each
# Timeout: 10 min per iteration
# Threads: 1 thread
# Benchmark mode: Single shot invocation time
# Benchmark: jonathan.aotearoa.jmh.ChunkSizeBenchmark.read
# Parameters: (chunkSize = 32768)

# Run progress: 25.00% complete, ETA 00:01:40
# Fork: 1 of 1
# Preparing profilers: LinuxPerfProfiler
# Profilers consume stderr from target VM, use -v EXTRA to copy to console
# Warmup Iteration   1: 5.350 s/op
# Warmup Iteration   2: 6.632 s/op
Iteration   1: 7.068 s/op
Iteration   2: 7.312 s/op
# Processing profiler results: LinuxPerfProfiler


Secondary result "jonathan.aotearoa.jmh.ChunkSizeBenchmark.read:perf":
Perf stats:
--------------------------------------------------

         62,251.66 msec task-clock                       #    2.372 CPUs utilized             
           318,456      context-switches                 #    5.116 K/sec                     
            54,124      cpu-migrations                   #  869.439 /sec                      
           905,461      page-faults                      #   14.545 K/sec                     
245,049,278,253      cycles                           #    3.936 GHz                         (33.69%)
1,526,883,335      stalled-cycles-frontend          #    0.62% frontend cycles idle        (33.67%)
46,234,636,691      stalled-cycles-backend           #   18.87% backend cycles idle         (33.72%)
250,775,898,830      instructions                     #    1.02  insn per cycle            
#    0.18  stalled cycles per insn     (33.31%)
49,273,645,767      branches                         #  791.523 M/sec                       (33.34%)
2,363,722,246      branch-misses                    #    4.80% of all branches             (33.28%)
104,389,959,727      L1-dcache-loads                  #    1.677 G/sec                       (33.23%)
1,550,043,898      L1-dcache-load-misses            #    1.48% of all L1-dcache accesses   (33.70%)
<not supported>      LLC-loads                                                             
<not supported>      LLC-load-misses                                                       
33,727,492,242      L1-icache-loads                  #  541.793 M/sec                       (33.59%)
49,535,835      L1-icache-load-misses            #    0.15% of all L1-icache accesses   (33.55%)
174,407,100      dTLB-loads                       #    2.802 M/sec                       (33.45%)
30,816,217      dTLB-load-misses                 #   17.67% of all dTLB cache accesses  (33.53%)
1,305,542      iTLB-loads                       #   20.972 K/sec                       (33.02%)
3,776,055      iTLB-load-misses                 #  289.23% of all iTLB cache accesses  (33.57%)
1,239,607,969      L1-dcache-prefetches             #   19.913 M/sec                       (33.55%)
<not supported>      L1-dcache-prefetch-misses

      26.244927752 seconds time elapsed

      15.825750000 seconds user
      48.028135000 seconds sys




# JMH version: 1.37
# VM version: JDK 21.0.2, Java HotSpot(TM) 64-Bit Server VM, 21.0.2+13-LTS-jvmci-23.1-b30
# VM invoker: /home/jonathan/.sdkman/candidates/java/21.0.2-graal/bin/java
# VM options: -XX:ThreadPriorityPolicy=1 -XX:+UnlockExperimentalVMOptions -XX:+EnableJVMCIProduct -XX:-UnlockExperimentalVMOptions --enable-preview
# Blackhole mode: compiler (auto-detected, use -Djmh.blackhole.autoDetect=false to disable)
# Warmup: 2 iterations, single-shot each
# Measurement: 2 iterations, single-shot each
# Timeout: 10 min per iteration
# Threads: 1 thread
# Benchmark mode: Single shot invocation time
# Benchmark: jonathan.aotearoa.jmh.ChunkSizeBenchmark.read
# Parameters: (chunkSize = 262144)

# Run progress: 50.00% complete, ETA 00:01:00
# Fork: 1 of 1
# Preparing profilers: LinuxPerfProfiler
# Profilers consume stderr from target VM, use -v EXTRA to copy to console
# Warmup Iteration   1: 5.106 s/op
# Warmup Iteration   2: 4.652 s/op
Iteration   1: 4.464 s/op
Iteration   2: 5.053 s/op
# Processing profiler results: LinuxPerfProfiler


Secondary result "jonathan.aotearoa.jmh.ChunkSizeBenchmark.read:perf":
Perf stats:
--------------------------------------------------

         60,043.92 msec task-clock                       #    3.134 CPUs utilized             
           233,764      context-switches                 #    3.893 K/sec                     
            57,488      cpu-migrations                   #  957.432 /sec                      
           919,975      page-faults                      #   15.322 K/sec                     
238,994,773,058      cycles                           #    3.980 GHz                         (33.23%)
1,533,686,825      stalled-cycles-frontend          #    0.64% frontend cycles idle        (33.51%)
45,272,689,426      stalled-cycles-backend           #   18.94% backend cycles idle         (33.46%)
234,723,363,768      instructions                     #    0.98  insn per cycle            
#    0.19  stalled cycles per insn     (33.83%)
47,850,411,472      branches                         #  796.923 M/sec                       (33.84%)
1,966,673,638      branch-misses                    #    4.11% of all branches             (33.82%)
92,990,072,252      L1-dcache-loads                  #    1.549 G/sec                       (33.29%)
1,243,379,325      L1-dcache-load-misses            #    1.34% of all L1-dcache accesses   (33.20%)
<not supported>      LLC-loads                                                             
<not supported>      LLC-load-misses                                                       
27,193,781,103      L1-icache-loads                  #  452.898 M/sec                       (33.31%)
36,750,350      L1-icache-load-misses            #    0.14% of all L1-icache accesses   (33.49%)
163,061,828      dTLB-loads                       #    2.716 M/sec                       (33.30%)
29,236,905      dTLB-load-misses                 #   17.93% of all dTLB cache accesses  (33.59%)
1,079,239      iTLB-loads                       #   17.974 K/sec                       (33.73%)
3,760,839      iTLB-load-misses                 #  348.47% of all iTLB cache accesses  (33.22%)
1,174,241,981      L1-dcache-prefetches             #   19.556 M/sec                       (33.06%)
<not supported>      L1-dcache-prefetch-misses

      19.160876936 seconds time elapsed

      18.931497000 seconds user
      43.742145000 seconds sys




# JMH version: 1.37
# VM version: JDK 21.0.2, Java HotSpot(TM) 64-Bit Server VM, 21.0.2+13-LTS-jvmci-23.1-b30
# VM invoker: /home/jonathan/.sdkman/candidates/java/21.0.2-graal/bin/java
# VM options: -XX:ThreadPriorityPolicy=1 -XX:+UnlockExperimentalVMOptions -XX:+EnableJVMCIProduct -XX:-UnlockExperimentalVMOptions --enable-preview
# Blackhole mode: compiler (auto-detected, use -Djmh.blackhole.autoDetect=false to disable)
# Warmup: 2 iterations, single-shot each
# Measurement: 2 iterations, single-shot each
# Timeout: 10 min per iteration
# Threads: 1 thread
# Benchmark mode: Single shot invocation time
# Benchmark: jonathan.aotearoa.jmh.ChunkSizeBenchmark.read
# Parameters: (chunkSize = 2097152)

# Run progress: 75.00% complete, ETA 00:00:27
# Fork: 1 of 1
# Preparing profilers: LinuxPerfProfiler
# Profilers consume stderr from target VM, use -v EXTRA to copy to console
# Warmup Iteration   1: 4.508 s/op
# Warmup Iteration   2: 4.748 s/op
Iteration   1: 5.820 s/op
Iteration   2: 5.151 s/op
# Processing profiler results: LinuxPerfProfiler


Secondary result "jonathan.aotearoa.jmh.ChunkSizeBenchmark.read:perf":
Perf stats:
--------------------------------------------------

         58,420.85 msec task-clock                       #    2.893 CPUs utilized             
           251,955      context-switches                 #    4.313 K/sec                     
            57,772      cpu-migrations                   #  988.894 /sec                      
           936,328      page-faults                      #   16.027 K/sec                     
230,714,534,353      cycles                           #    3.949 GHz                         (33.73%)
1,466,867,333      stalled-cycles-frontend          #    0.64% frontend cycles idle        (33.81%)
42,041,088,947      stalled-cycles-backend           #   18.22% backend cycles idle         (33.89%)
219,605,260,538      instructions                     #    0.95  insn per cycle            
#    0.19  stalled cycles per insn     (33.80%)
45,884,089,485      branches                         #  785.406 M/sec                       (34.00%)
1,977,838,983      branch-misses                    #    4.31% of all branches             (33.73%)
89,331,735,926      L1-dcache-loads                  #    1.529 G/sec                       (33.18%)
1,262,159,049      L1-dcache-load-misses            #    1.41% of all L1-dcache accesses   (33.07%)
<not supported>      LLC-loads                                                             
<not supported>      LLC-load-misses                                                       
27,300,741,216      L1-icache-loads                  #  467.312 M/sec                       (33.42%)
38,686,209      L1-icache-load-misses            #    0.14% of all L1-icache accesses   (33.27%)
167,314,537      dTLB-loads                       #    2.864 M/sec                       (32.95%)
28,601,166      dTLB-load-misses                 #   17.09% of all dTLB cache accesses  (33.42%)
1,008,997      iTLB-loads                       #   17.271 K/sec                       (33.49%)
3,338,469      iTLB-load-misses                 #  330.87% of all iTLB cache accesses  (33.30%)
1,119,686,266      L1-dcache-prefetches             #   19.166 M/sec                       (33.17%)
<not supported>      L1-dcache-prefetch-misses

      20.190394677 seconds time elapsed

      17.603879000 seconds user
      45.260303000 seconds sys




# Run complete. Total time: 00:01:42

REMEMBER: The numbers below are just data. To gain reusable insights, you need to follow up on
why the numbers are the way they are. Use profilers (see -prof, -lprof), design factorial
experiments, perform baseline and negative tests that provide experimental control, make sure
the benchmarking environment is safe on JVM/OS/HW level, ask for reviews from the domain experts.
Do not assume the numbers tell you what you want them to tell.

NOTE: Current JVM experimentally supports Compiler Blackholes, and they are in use. Please exercise
extra caution when trusting the results, look into the generated code to check the benchmark still
works, and factor in a small probability of new VM bugs. Additionally, while comparisons between
different JVMs are already problematic, the performance difference caused by different Blackhole
modes can be very significant. Please make sure you use the consistent Blackhole mode for comparisons.

Benchmark                     (chunkSize)  Mode  Cnt  Score   Error      Units
ChunkSizeBenchmark.read              4096    ss    2  8.063               s/op
ChunkSizeBenchmark.read:cpi          4096    ss       1.035          clks/insn
ChunkSizeBenchmark.read:ipc          4096    ss       0.966          insns/clk
ChunkSizeBenchmark.read:perf         4096    ss         NaN                ---
ChunkSizeBenchmark.read             32768    ss    2  7.190               s/op
ChunkSizeBenchmark.read:cpi         32768    ss       0.977          clks/insn
ChunkSizeBenchmark.read:ipc         32768    ss       1.023          insns/clk
ChunkSizeBenchmark.read:perf        32768    ss         NaN                ---
ChunkSizeBenchmark.read            262144    ss    2  4.758               s/op
ChunkSizeBenchmark.read:cpi        262144    ss       1.018          clks/insn
ChunkSizeBenchmark.read:ipc        262144    ss       0.982          insns/clk
ChunkSizeBenchmark.read:perf       262144    ss         NaN                ---
ChunkSizeBenchmark.read           2097152    ss    2  5.485               s/op
ChunkSizeBenchmark.read:cpi       2097152    ss       1.051          clks/insn
ChunkSizeBenchmark.read:ipc       2097152    ss       0.952          insns/clk
ChunkSizeBenchmark.read:perf      2097152    ss         NaN                ---
```

