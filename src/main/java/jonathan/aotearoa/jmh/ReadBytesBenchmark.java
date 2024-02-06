package jonathan.aotearoa.jmh;

import org.openjdk.jmh.annotations.*;

import java.io.IOException;
import java.lang.foreign.Arena;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import static jonathan.aotearoa.MyUnsafe.UNSAFE;

/**
 * <pre>
 * Benchmark                           Mode  Cnt   Score   Error  Units
 * ReadBytesBenchmark.unsafeGetByte      ss    2  24.740           s/op
 * ReadBytesBenchmark.unsafeGetLongV1    ss    2  23.795           s/op
 * ReadBytesBenchmark.unsafeGetLongV2    ss    2  22.896           s/op
 * </pre>
 */
@BenchmarkMode(Mode.SingleShotTime)
@Fork(1)
@Warmup(iterations = 2)
@Measurement(iterations = 2)
@State(Scope.Thread)
public class ReadBytesBenchmark {

    private Path filePath;

    @Setup
    public void setUp() {
        filePath = Path.of("./measurements.txt");
    }

    // @Benchmark
    public void unsafeGetByte() throws IOException {
        try (final FileChannel fc = FileChannel.open(filePath, StandardOpenOption.READ)) {
            final long fileSize = fc.size();
            final long fileStart = fc.map(FileChannel.MapMode.READ_ONLY, 0, fileSize, Arena.global()).address();
            final long fileEnd = fileStart + fileSize;
            for (long ptr = fileStart; ptr < fileEnd; ptr++) {
                sink(UNSAFE.getByte(ptr));
            }
        }
    }

    // @Benchmark
    public void unsafeGetLongV1() throws IOException {
        try (final FileChannel fc = FileChannel.open(filePath, StandardOpenOption.READ)) {
            final long fileSize = fc.size();
            final long fileStart = fc.map(FileChannel.MapMode.READ_ONLY, 0, fileSize, Arena.global()).address();
            final long fileEnd = fileStart + fileSize;
            for (long ptr = fileStart; ptr < fileEnd - Long.BYTES; ptr += Long.BYTES) {
                long word = UNSAFE.getLong(ptr);
                for (int i = 7; i >= 0; i--) {
                    sink((byte) word);
                    word >>= Byte.SIZE;
                }
            }
        }
    }

    @Benchmark
    public void unsafeGetLongV2() throws IOException {
        try (final FileChannel fc = FileChannel.open(filePath, StandardOpenOption.READ)) {
            final long fileSize = fc.size();
            final long fileStart = fc.map(FileChannel.MapMode.READ_ONLY, 0, fileSize, Arena.global()).address();
            final long fileEnd = fileStart + fileSize;
            for (long ptr = fileStart; ptr < fileEnd - Long.BYTES;) {
                ptr = readWord(ptr, fileEnd);
                ptr = readWord(ptr, fileEnd);
                ptr = readWord(ptr, fileEnd);
                ptr = readWord(ptr, fileEnd);
                ptr = readWord(ptr, fileEnd);
                ptr = readWord(ptr, fileEnd);
                ptr = readWord(ptr, fileEnd);
                ptr = readWord(ptr, fileEnd);
                ptr = readWord(ptr, fileEnd);
                ptr = readWord(ptr, fileEnd);
                ptr = readWord(ptr, fileEnd);
                ptr = readWord(ptr, fileEnd);
                ptr = readWord(ptr, fileEnd);
                ptr = readWord(ptr, fileEnd);
                ptr = readWord(ptr, fileEnd);
                ptr = readWord(ptr, fileEnd);
            }
        }
    }

    private static long readWord(final long ptr, final long fileEnd) {
        if (ptr < fileEnd - Long.BYTES) {
            final long word = UNSAFE.getLong(ptr);
            sink((byte) (word >> 56));
            sink((byte) (word >> 48));
            sink((byte) (word >> 40));
            sink((byte) (word >> 32));
            sink((byte) (word >> 24));
            sink((byte) (word >> 16));
            sink((byte) (word >> 8));
            sink((byte) word);
            return ptr + Long.BYTES;
        }
        return ptr;
    }

    @CompilerControl(CompilerControl.Mode.DONT_INLINE)
    private static void sink(final byte b) {
    }
}
