package com.itsalexnguyen.contactssimple;


import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public final class TestUtils {

    private TestUtils() {
        // Do not allow instances of this class
    }

    /**
     * Retrieve the content of the file as a string
     *
     * @param path Path to the file
     * @return String
     * Return file content
     **/
    public static String readFileAsString(String path) {
        String contents = null;
        InputStream stream = null;
        InputStreamReader streamReader = null;
        BufferedReader buffer = null;

        try {
            stream = TestUtils.class.getClassLoader().getResourceAsStream(path);
            streamReader = new InputStreamReader(stream, "utf-8");
            buffer = new BufferedReader(streamReader);
            StringBuffer strBuffer = new StringBuffer();
            String s;
            while ((s = buffer.readLine()) != null) {
                strBuffer.append(s);
            }

            contents = strBuffer.toString();
        } catch (Exception e) {
            contents = null;
        } finally {
            try {
                if (stream != null) {
                    stream.close();
                }
                if (streamReader != null) {
                    streamReader.close();
                }
                if (buffer != null) {
                    buffer.close();
                }
            } catch (IOException e) {
                contents = null;
            }
        }

        return contents;
    }
}