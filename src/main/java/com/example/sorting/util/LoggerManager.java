package com.example.sorting.util;

 

public class LoggerManager {

    // Private constructor prevents instantiation from other classes
    private LoggerManager() {}

    // Inner static class responsible for holding the singleton instance
    private static class Holder {
        private static final LoggerManager INSTANCE = new LoggerManager();
    }

    public static LoggerManager getInstance() {
        return Holder.INSTANCE;
    }

    public void log(String message) {
        System.out.println("[LOG - SortingSystem] " + message);
    }
}
