package jonathan.aotearoa.jmh;

import org.openjdk.jmh.annotations.*;

import static jonathan.aotearoa.jmh.MyUnsafe.UNSAFE;

@BenchmarkMode(Mode.Throughput)
@Fork(1)
@Warmup(iterations = 2)
public class PerfBenchmark1 {

    @Benchmark
    public long[] stackVariables() {
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
    public long[] heapArray() {
        final long[] a = new long[]{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        for (int i = 0, n = 10; i < n; i++) {
            a[i] += 10;
        }
        return new long[]{ a[0], a[1], a[2], a[3], a[4], a[5], a[6], a[7], a[8], a[9] };
    }

    @Benchmark
    public long[] offHeapMemory() {
        final long byteCount = 10 * Long.BYTES;
        final long address = UNSAFE.allocateMemory(byteCount);
        UNSAFE.setMemory(null, address, byteCount, (byte) 0);

        for (int offset = 0; offset < byteCount; offset += Long.BYTES) {
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
