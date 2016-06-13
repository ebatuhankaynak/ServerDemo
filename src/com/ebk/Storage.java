package com.ebk;

import com.ebk.controllers.PrivateChatController;

/**
 * Created by E.Batuhan Kaynak on 6.6.2016.
 */
public class Storage {
    private static String username;
    private static PrivateChatController privateChatController;

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        Storage.username = username;
    }

    public static PrivateChatController getPrivateChatController() {
        return privateChatController;
    }

    public static void setPrivateChatController(PrivateChatController privateChatController) {
        Storage.privateChatController = privateChatController;
    }
}
