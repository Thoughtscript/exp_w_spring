package io.thoughtscript.springexps.helpers;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JvmHeapHelper {
    public static void printHeap() throws InterruptedException {
        long heapSize = Runtime.getRuntime().totalMemory();
        long heapMaxSize = Runtime.getRuntime().maxMemory();
        long heapFreeSize = Runtime.getRuntime().freeMemory();

        log.info("heapSize: {} heapMaxSize: {} heapFreeSize: {}", heapSize, heapMaxSize, heapFreeSize);

        log.info("Garbage collecting...");
        System.gc();

        log.info("Sleeping for 5s...");
        Thread.sleep(5000);
    }
}
