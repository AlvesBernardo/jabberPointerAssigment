package com.softwarequality.jabberpoint;

import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Constants {
    private JSONObject constants;

    public Constants(String filePath) {
        try {
            InputStream is = getClass().getClassLoader().getResourceAsStream(filePath);
            if (is == null) {
                throw new IllegalArgumentException("File " + filePath + " not found!");
            } else {
                BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
                String line;
                StringBuilder contentBuilder = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    contentBuilder.append(line).append("\n");
                }

                reader.close();

                this.constants = new JSONObject(contentBuilder.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getValue(String key) {
        return this.constants.getString(key);
    }
}
