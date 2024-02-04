package dev.morling.onebrc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.SortedMap;
import dev.morling.onebrc.CalculateAverage_jonathanaotearoa.TemperatureData;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Name hash: -1988763642
 * Entry index: 15245
 * Entry offset: 457350
 */
class UnsafeRepositoryTest {

    private Path filePath;

    @BeforeEach
    void setUp() {
        filePath = Path.of("./src/test/resources/test-data/unsafe-repo-test-1.txt");
        assertTrue(Files.isRegularFile(filePath));
    }

    @Test
    void test() throws IOException {
        final SortedMap<String, TemperatureData> result = CalculateAverage_jonathanaotearoa.processFile(filePath);
        assertEquals(1, result.size());
        final Map.Entry<String, TemperatureData> entry0 = result.entrySet().iterator().next();
        assertEquals("Christchurch", entry0.getKey());
        assertEquals(-99.9, entry0.getValue().getMin());
        assertEquals(99.9, entry0.getValue().getMax());
        assertEquals(0.0, entry0.getValue().getMean());
    }
}
