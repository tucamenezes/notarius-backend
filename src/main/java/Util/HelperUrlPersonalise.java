package Util;

import java.util.concurrent.atomic.AtomicLong;

public class HelperUrlPersonalise {

    //private static final int GRANDEUR_CLE_URL =10;

    private static final AtomicLong time = new AtomicLong();

    public static String genererCleUrl(Long cleBase) {

        /*Generer en Base 36*/
        return Long.toString(uniqueTemps(), Character.MAX_RADIX);
    }

    public static long uniqueTemps() {

        long now = System.currentTimeMillis();
        long value = time.get();
        long next = Math.max(now, value) + 1;
        if (time.compareAndSet(value, next))
            return next;
        return time.incrementAndGet();
    }



}
