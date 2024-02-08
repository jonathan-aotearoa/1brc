package jonathan.aotearoa.jmh;

import org.openjdk.jmh.annotations.*;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * <pre>
 * Benchmark                          (size)   Mode  Cnt          Score   Error  Units
 * HashBenchmark.bytesArraysHashCode       8  thrpt    2  271153443.678          ops/s
 * HashBenchmark.bytesArraysHashCode      48  thrpt    2   84812315.044          ops/s
 * HashBenchmark.bytesArraysHashCode      96  thrpt    2  107446064.763          ops/s
 * HashBenchmark.longsArraysHashCode       8  thrpt    2  882497546.222          ops/s
 * HashBenchmark.longsArraysHashCode      48  thrpt    2  275373741.879          ops/s
 * HashBenchmark.longsArraysHashCode      96  thrpt    2  260060228.668          ops/s
 * </pre>
 */
@BenchmarkMode(Mode.Throughput)
@Fork(1)
@Warmup(iterations = 2)
@Measurement(iterations = 2)
@State(Scope.Thread)
public class HashBenchmark {

    @Param({ "8", "48", "96" })
    public int nBytes;

    byte[] bytes;
    long[] longs;

    @Setup
    public void setUp() {
        bytes = new byte[nBytes];
        ThreadLocalRandom.current().nextBytes(bytes);
        longs = new long[nBytes / 8];
        ByteBuffer.wrap(bytes).asLongBuffer().get(longs);
    }

    @Benchmark
    public int bytesArraysHashCode() {
        return Arrays.hashCode(bytes);
    }

    @Benchmark
    public int longsArraysHashCode() {
        return Arrays.hashCode(longs);
    }
}
