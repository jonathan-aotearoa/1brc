package jonathan.aotearoa.jmh;

import org.openjdk.jmh.annotations.*;

import static jonathan.aotearoa.MyUnsafe.UNSAFE;

/**
 * <pre>
 * Benchmark                         Mode  Cnt         Score   Error  Units
 * LongAddition.array               thrpt    2  75181798.641          ops/s
 * LongAddition.localVariables      thrpt    2  75238801.255          ops/s
 * LongAddition.unsafeNativeMemory  thrpt    2  41609345.498          ops/s
 * </pre>
 */
@BenchmarkMode(Mode.Throughput)
@Fork(1)
@Warmup(iterations = 2)
@Measurement(iterations = 2)
@State(Scope.Thread)
public class LongAccessAndUpdateBenchmark {

    private long address;

    @Setup
    public void setUp() {
        final int byteCount = 10 * Long.BYTES;
        address = UNSAFE.allocateMemory(byteCount);
        UNSAFE.setMemory(null, address, byteCount, (byte) 0);
    }

    @TearDown
    public void tearDown() {
        UNSAFE.freeMemory(address);
    }

    @Benchmark
    public long[] localVariables() {
        long l0 = 0;
        long l1 = 0;
        long l2 = 0;
        long l3 = 0;
        long l4 = 0;
        long l5 = 0;
        long l6 = 0;
        long l7 = 0;
        long l8 = 0;
        long l9 = 0;

        for (int i = 0, n = 10; i < n; i++) {
            l0 += 10;
            l1 += 10;
            l2 += 10;
            l3 += 10;
            l4 += 10;
            l5 += 10;
            l6 += 10;
            l7 += 10;
            l8 += 10;
            l9 += 10;
        }

        return new long[]{ l0, l1, l2, l3, l4, l5, l6, l7, l8, l9 };
    }

    @Benchmark
    public long[] array() {
        final long[] a = new long[]{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        for (int i = 0, n = 10; i < n; i++) {
            a[i] += 10;
        }
        return new long[]{ a[0], a[1], a[2], a[3], a[4], a[5], a[6], a[7], a[8], a[9] };
    }

    @Benchmark
    public long[] unsafeNativeMemory() {
        for (int offset = 0, i = 0; i < 10; i++, offset += Long.BYTES) {
            UNSAFE.getAndAddLong(null, address + offset, 10L);
        }

        return new long[]{
                UNSAFE.getLong(address),
                UNSAFE.getLong(address + 8),
                UNSAFE.getLong(address + 16),
                UNSAFE.getLong(address + 24),
                UNSAFE.getLong(address + 32),
                UNSAFE.getLong(address + 40),
                UNSAFE.getLong(address + 48),
                UNSAFE.getLong(address + 56),
                UNSAFE.getLong(address + 64),
                UNSAFE.getLong(address + 72)
        };
    }
}
