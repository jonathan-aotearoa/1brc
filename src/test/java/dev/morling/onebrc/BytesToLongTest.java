package dev.morling.onebrc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.ByteBuffer;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BytesToLongTest {

    private byte[] bytes;
    private long expected;

    @BeforeEach
    void setUp() {
        bytes = new byte[] {1,2,3,4,5,6,7,8};
        expected = ByteBuffer.wrap(bytes).getLong();
    }

    @Test
    void test() {
        final long actual = (bytes[0] & 0xFFL) << 56
                | (bytes[1] & 0xFFL) << 48
                | (bytes[2] & 0xFFL) << 40
                | (bytes[3] & 0xFFL) << 32
                | (bytes[4] & 0xFFL) << 24
                | (bytes[5] & 0xFFL) << 16
                | (bytes[6] & 0xFFL) << 8
                | (bytes[7] & 0xFFL);
        assertEquals(expected, actual);
    }
}
