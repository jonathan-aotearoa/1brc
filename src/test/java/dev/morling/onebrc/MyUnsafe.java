package dev.morling.onebrc;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

class MyUnsafe {

    static final Unsafe UNSAFE;

    static {
        try {
            final Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            UNSAFE = (Unsafe) theUnsafe.get(null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(STR."Error getting instance of \{Unsafe.class.getName()}", e);
        }
    }

    private MyUnsafe() {}
}
