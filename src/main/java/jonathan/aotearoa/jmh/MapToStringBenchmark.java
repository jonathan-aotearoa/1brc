package jonathan.aotearoa.jmh;

import dev.morling.onebrc.CalculateAverage_jonathanaotearoa;
import org.openjdk.jmh.annotations.*;

import java.util.*;
import java.util.stream.Collectors;

import dev.morling.onebrc.CalculateAverage_jonathanaotearoa.TemperatureData;

/**
 * Surprising results:
 * <p>
 * <pre>
 * Benchmark                              Mode  Cnt      Score   Error  Units
 * MapToStringBenchmark.customToString1  thrpt    2  10446.738          ops/s
 * MapToStringBenchmark.customToString2  thrpt    2  12580.338          ops/s
 * MapToStringBenchmark.customToString3  thrpt    2  12121.699          ops/s
 * MapToStringBenchmark.hashMapToString  thrpt    2  10188.179          ops/s
 * </pre>
 * </p>
 */
@BenchmarkMode(Mode.Throughput)
@Fork(1)
@Warmup(iterations = 2)
@Measurement(iterations = 2)
@State(Scope.Thread)
public class MapToStringBenchmark {

    private Map<String, TemperatureData> data;

    @Setup
    public void setUp() {
        final Random r = new Random();
        data = new TreeMap<>();
        for (int i = 0; i < 500; i++) {
            final String key = UUID.randomUUID().toString();
            final short min = (short) r.nextInt(-999, 0);
            final short max = (short) r.nextInt(0, 999);
            data.put(key, new TemperatureData(min, max, min + max, 2));
        }
    }

    @Benchmark
    public String hashMapToString() {
        return data.toString();
    }

    @Benchmark
    public String customToString1() {
        final Iterator<Map.Entry<String, CalculateAverage_jonathanaotearoa.TemperatureData>> i = data.entrySet().iterator();
        if (!i.hasNext()) {
            System.out.println("{}");
        }
        final StringBuilder sb = new StringBuilder(30_000).append('{');
        while (i.hasNext()) {
            Map.Entry<String, CalculateAverage_jonathanaotearoa.TemperatureData> e = i.next();
            sb.append(e.getKey())
                    .append('=')
                    .append(e.getValue().getMin())
                    .append('/')
                    .append(e.getValue().getMean())
                    .append('/')
                    .append(e.getValue().getMax());
            if (i.hasNext()) {
                sb.append(',').append(' ');
            }
        }
        sb.append('}');
        return sb.toString();
    }

    @Benchmark
    public String customToString2() {
        return data.entrySet().stream()
                .map(e -> e.getKey() + "=" + e.getValue().getMin() + "/" + e.getValue().getMean() + "/" + e.getValue().getMax())
                .collect(Collectors.joining(", ", "{", "}"));
    }

    @Benchmark
    public String customToString3() {
        return data.entrySet().stream()
                .map(e -> STR."\{e.getKey()}=\{e.getValue().getMin()}/\{e.getValue().getMean()}/\{e.getValue().getMax()}")
                .collect(Collectors.joining(", ", "{", "}"));
    }
}
