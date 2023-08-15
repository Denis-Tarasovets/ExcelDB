package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.model.StudInfo;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JsonWriter {

    private static final Logger logger = Logger.getLogger(JsonWriter.class.getName());

    public JsonWriter() {
    }

    public static void exportJSON(StudInfo studInfo, String filePath) {

        logger.log(Level.INFO, "JSON export started");

        try {
            OutputStream fileOut = new FileOutputStream(filePath);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            fileOut.write(gson.toJson(studInfo).getBytes(StandardCharsets.UTF_8));

        } catch (Exception e) {
            logger.log(Level.SEVERE, "JSON export error", e);
            return;
        }

        logger.log(Level.INFO, "JSON export ended");
    }
}
