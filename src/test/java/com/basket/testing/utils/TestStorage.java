package com.basket.testing.utils;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public final class TestStorage {

    private final ConcurrentHashMap<String,Object> storage;

    private TestStorage() {
        this.storage = new ConcurrentHashMap<>() ;
    }

    private static class TestStorageHolder {
        private static final TestStorage INSTANCE = new TestStorage();
    }

    private ConcurrentHashMap getStorage() { return this.storage; }
    private static TestStorage getInstance() { return TestStorageHolder.INSTANCE; }

    public static Object getKeyValue(String key) {
        return getInstance().getStorage().getOrDefault(key,"test");
    }

    public static Object setKeyValue(String key,Object value) {
        return getInstance().getStorage().put(key,value);
    }
}
