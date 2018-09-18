package com.joizhang.diveintojvm;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeHelper {

    private static final Unsafe unsafe = createUnsafe();

    private static Unsafe createUnsafe() {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        } catch (Exception e) {
            throw new RuntimeException("Can't use unsafe", e);
        }
    }

    public static Unsafe getUnsafe() {
        return unsafe;
    }

    /**
     * Returns the address the object is located at
     *
     * <p>WARNING: This does not return a pointer, so be warned pointer arithmetic will not work.
     *
     * @param obj The object
     * @return the address of the object
     */
    public static long toAddress(Object obj) {
        Object[] array = new Object[] {obj};
        long baseOffset = unsafe.arrayBaseOffset(Object[].class);
        return normalize(unsafe.getInt(array, baseOffset));
    }

    /**
     * Returns the object located at the address.
     *
     * @param address The address
     * @return the object at this address
     */
    public static Object fromAddress(long address) {
        Object[] array = new Object[] {null};
        long baseOffset = unsafe.arrayBaseOffset(Object[].class);
        unsafe.putLong(array, baseOffset, address);
        return array[0];
    }

    private static long normalize(int value) {
        if (value >= 0) {
            return value;
        }
        return (~0L >>> 32) & value;
    }

}
