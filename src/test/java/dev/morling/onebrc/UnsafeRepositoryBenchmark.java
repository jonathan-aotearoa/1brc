package dev.morling.onebrc;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;

import java.io.IOException;

@BenchmarkMode(Mode.AverageTime)
@Fork(1)
public class UnsafeRepositoryBenchmark {

    @Benchmark
    public void process() throws IOException {
        CalculateAverage_jonathanaotearoa.main(new String[]{});
    }
}
