package jonathan.aotearoa.jmh;

import org.openjdk.jmh.annotations.*;

import java.nio.ByteBuffer;

import static jonathan.aotearoa.MyUnsafe.UNSAFE;

/**
 * <pre>
 * Benchmark                            Mode  Cnt           Score          Error  Units
 * LongToBytesBenchmark.byteBuffer     thrpt    6   748843295.528 ± 17490904.818  ops/s
 * LongToBytesBenchmark.forLoopShifts  thrpt    6  2109963099.899 ± 67142762.844  ops/s
 * LongToBytesBenchmark.shifts         thrpt    6  1573924244.386 ± 61308901.916  ops/s
 * LongToBytesBenchmark.unsafePutLong  thrpt    6  1548136262.496 ± 10463857.252  ops/s
 * </pre>
 */
@BenchmarkMode(Mode.Throughput)
@Fork(2)
@Warmup(iterations = 3, time = 3)
@Measurement(iterations = 3, time = 3)
@State(Scope.Thread)
public class LongToBytesBenchmark {

    long l;
    ByteBuffer bb;
    byte[] bytes;

    @Setup
    public void setUp() {
        final byte[] srcBytes = new byte[]{ 1, 2, 3, 4, 5, 6, 7, 8 };
        l = ByteBuffer.wrap(srcBytes).getLong();
        bb = ByteBuffer.allocate(Long.BYTES);
        bytes = new byte[Long.BYTES];
    }

    @Benchmark
    public byte[] byteBuffer() {
        return bb.putLong(0, l).array();
    }

    @Benchmark
    public byte[] unsafePutLong() {
        UNSAFE.putLong(bytes, UNSAFE.arrayBaseOffset(bytes.getClass()), Long.reverseBytes(l));
        return bytes;
    }

    @Benchmark
    public byte[] forLoopShifts() {
        for (int i = 7, shift = 0; i >= 0; i--, shift += Byte.SIZE) {
            bytes[i] = (byte) (l >> shift);
        }
        return bytes;
    }

    @Benchmark
    public byte[] shifts() {
        bytes[7] = (byte) l;
        bytes[6] = (byte) (l >> 8);
        bytes[5] = (byte) (l >> 16);
        bytes[4] = (byte) (l >> 24);
        bytes[3] = (byte) (l >> 32);
        bytes[2] = (byte) (l >> 40);
        bytes[1] = (byte) (l >> 48);
        bytes[0] = (byte) (l >> 56);
        return bytes;
    }
}
