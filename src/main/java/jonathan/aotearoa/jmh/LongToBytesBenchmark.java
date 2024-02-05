package jonathan.aotearoa.jmh;

import org.openjdk.jmh.annotations.*;

import java.nio.ByteBuffer;

/**
 * <pre>
 * Benchmark                            Mode  Cnt          Score   Error  Units
 * LongToBytesBenchmark.byteBuffer     thrpt    2  750505152.137          ops/s
 * LongToBytesBenchmark.forLoopShifts  thrpt    2  299600011.755          ops/s
 * LongToBytesBenchmark.shifts         thrpt    2  299027086.597          ops/s
 * </pre>
 */
@BenchmarkMode(Mode.Throughput)
@Fork(1)
@Warmup(iterations = 2)
@Measurement(iterations = 2)
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
    public byte[] forLoopShifts() {
        final byte[] bytes = new byte[Long.BYTES];
        for (int i = 7, shift = 0; i >= 0; i--, shift += Byte.SIZE) {
            bytes[i] = (byte) (l >> shift);
        }
        return bytes;
    }

    @Benchmark
    public byte[] shifts() {
        final byte[] bytes = new byte[Long.BYTES];
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
