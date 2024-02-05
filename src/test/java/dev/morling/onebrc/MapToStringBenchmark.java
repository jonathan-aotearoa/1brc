package dev.morling.onebrc;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.IntPredicate;

import dev.morling.onebrc.CalculateAverage_jonathanaotearoa.TemperatureData;
import org.openjdk.jmh.annotations.State;

@State(Scope.Thread)
public class MapToStringBenchmark {

    private Map<String, TemperatureData> data;

    @Setup
    public void setUp() {
        final Random r = new Random();
        data = new TreeMap<>();
        for (int i = 0; i < 10_000; i++) {
            final String key = randmonString();
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
    public String customToString() {
        final Iterator<Map.Entry<String, CalculateAverage_jonathanaotearoa.TemperatureData>> i = data.entrySet().iterator();
        if (!i.hasNext()) {
            System.out.println("{}");
        }
        // Capacity based the output for measurements.txt.
        final StringBuilder sb = new StringBuilder(1100).append('{');
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

    private static String randmonString() {
        final IntPredicate isLetter = i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97);
        final Random random = ThreadLocalRandom.current();

        return random.ints('a', 'z' + 1)
                .filter(isLetter)
                .limit(50)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
