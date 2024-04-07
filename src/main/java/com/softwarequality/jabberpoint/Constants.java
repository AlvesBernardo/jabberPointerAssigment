package com.softwarequality.jabberpoint;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Constants {
    private final JSONObject constants;

    public Constants(String filePath) {
        String content = "";
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(filePath)) { // If your file is at the root of the resources directory
             if (is == null) {
            throw new IllegalArgumentException("File " + filePath + " not found!");
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
            String line;
            StringBuilder contentBuilder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                contentBuilder.append(line).append("\n");
            }
            content = contentBuilder.toString();
        }
    } catch(
    IOException e)

    {
        e.printStackTrace();  // Consider logging this exception or handling it in a way that's suitable for your application.
    }
        this.constants =new

    JSONObject(content);
}

public String getValue(String key) {
    return this.constants.getString(key);
}
}