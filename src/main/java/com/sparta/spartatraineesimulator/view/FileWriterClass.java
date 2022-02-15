package com.sparta.spartatraineesimulator.view;

import com.sparta.spartatraineesimulator.controller.Controller;
import com.sparta.spartatraineesimulator.model.TrainingCentre;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class FileWriterClass {
    //a demo class responsible to store the output in a file:  "spartaSimulationOutputFile.txt"

    private static final String OUTPUT_FILE_LOCATION = "spartaSimulationOutputFile.csv";

    public FileWriterClass() {
    }

    private boolean fileExists() {
        File file = new File(OUTPUT_FILE_LOCATION);
        return file.isFile();
    }

    private String formatResults(int unformattedNumber) {
        return NumberFormat.getInstance().format((double) unformattedNumber);
    }

    public void outputToFile(ArrayList<TrainingCentre> centres) {
        try {
            if (!fileExists()) {
                File file = new File(OUTPUT_FILE_LOCATION);
                file.createNewFile();
            }
            //can add buffered writer if needed
            FileWriter writer = new FileWriter(OUTPUT_FILE_LOCATION);
            writer.write(createOutput(centres));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String createOutput(ArrayList<TrainingCentre> centres) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < centres.size(); i++){
            result.append(centres.get(i));
        }
        return result.toString();
    }
}
