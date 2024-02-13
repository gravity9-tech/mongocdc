package com.gravity9.mongocdc.logging;

import com.gravity9.mongocdc.MongoConfig;
import org.slf4j.MDC;

import java.util.concurrent.atomic.AtomicInteger;

public final class LoggingUtil {
    private static final String MDC_KEY_NAME = "cdcContextId";
    private static final AtomicInteger managerCount = new AtomicInteger();

    private LoggingUtil() {
    }

    public static String createManagerId(MongoConfig config) {
        return "cdcm_" + config.getDatabaseName() + "_" + config.getCollectionName() + "_" + managerCount.getAndIncrement();
    }

    public static String createWorkerId(String managerId, int partition) {
        return managerId + "_partition_" + partition;
    }

    public static void setLoggingContext(String contextId) {
        MDC.put(MDC_KEY_NAME, contextId);
    }

    public static void removeLoggingContext() {
        MDC.remove(MDC_KEY_NAME);
    }
}
