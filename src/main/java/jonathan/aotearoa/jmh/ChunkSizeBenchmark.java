package jonathan.aotearoa.jmh;

import org.openjdk.jmh.annotations.*;

import java.io.IOException;
import java.lang.foreign.Arena;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.stream.LongStream;

import static jonathan.aotearoa.MyUnsafe.UNSAFE;

@BenchmarkMode(Mode.SingleShotTime)
@Fork(1)
@Warmup(iterations = 2)
@Measurement(iterations = 2)
@State(Scope.Thread)
public class ChunkSizeBenchmark {

    @Param({ "4096", "32768", "262144", "2097152" })
    public int chunkSize;

    Path filePath;

    @Setup
    public void setUp() {
        filePath = Path.of("./measurements.txt");
    }

    @Benchmark
    public void read() throws IOException, InterruptedException {
        try (final FileChannel fc = FileChannel.open(filePath, StandardOpenOption.READ)) {
            final long fileSize = fc.size();
            final long fileStart = fc.map(FileChannel.MapMode.READ_ONLY, 0, fileSize, Arena.global()).address();
            final long fileEnd = fileStart + fileSize;
            LongStream.iterate(fileStart, ptr -> ptr < fileEnd - chunkSize, ptr -> ptr + chunkSize)
                    .parallel()
                    .forEach(ptr -> {
                        for (long chunkEnd = ptr + chunkSize; ptr < chunkEnd; ptr += Long.BYTES) {
                            sink(UNSAFE.getLong(ptr));
                        }
                    });
        }
    }

    @CompilerControl(CompilerControl.Mode.DONT_INLINE)
    private static void sink(final long word) {
    }
}
