package com.itsalexnguyen.contactssimple.network;

/**
 * A collection of endpoints used through of the app.
 */
final class RestEndpoints {
    static final String BASE_URL = "https://randomuser.me";

    static final String RANDOM_USER = "/api/";

    static String randomUsersWithCount(int count) {
        return String.format("%s%s%d", RANDOM_USER, "?results=", count);
    }

    private RestEndpoints() {
        // Do not allow clients to instantiate.
    }
}
