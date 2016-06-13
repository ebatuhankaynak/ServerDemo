package com.ebk;

/**
 * Created by E.Batuhan Kaynak on 6.6.2016.
 */
public class Storage {
    private static String username;

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        Storage.username = username;
    }
}
