package dev.morling.onebrc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.ByteBuffer;

import static jonathan.aotearoa.MyUnsafe.UNSAFE;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class LongToBytesTest {
    
    private byte[] expected;
    private long l;
    
    @BeforeEach
    void setUp() {
        expected = new byte[] {1,2,3,4,5,6,7,8};
        l = ByteBuffer.wrap(expected).getLong();
    }

    @Test
    void byteBuffer() {
        final byte[] actual = ByteBuffer.allocate(Long.BYTES)
                .putLong(l)
                .array();
        assertArrayEquals(expected, actual);
    }

    @Test
    void unsafePutLong() {
        final byte[] actual = new byte[Long.BYTES];
        UNSAFE.putLong(actual, UNSAFE.arrayBaseOffset(actual.getClass()), Long.reverseBytes(l));
        assertArrayEquals(expected, actual);
    }

    @Test
    void forLoopShift() {
        // When
        final byte[] actual = new byte[Long.BYTES];
        for (int i = 7; i >= 0; i--) {
            actual[i] = (byte) (l);
            l >>= Byte.SIZE;
        }
        // Then
        assertArrayEquals(expected, actual);
    }

    @Test
    void shifts() {
        // When
        final byte[] actual = new byte[Long.BYTES];
        actual[7] = (byte) l;
        actual[6] = (byte) (l >> 8);
        actual[5] = (byte) (l >> 16);
        actual[4] = (byte) (l >> 24);
        actual[3] = (byte) (l >> 32);
        actual[2] = (byte) (l >> 40);
        actual[1] = (byte) (l >> 48);
        actual[0] = (byte) (l >> 56);
        // Then
        assertArrayEquals(expected, actual);
    }
}
