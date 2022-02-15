package com.sparta.spartatraineesimulator.view;

import com.sparta.spartatraineesimulator.model.TrainingCentre;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.HashMap;

public class FileWriterClass {
    //a demo class responsible to store the output in a file:  "spartaSimulationOutputFile.txt"

    private HashMap<TrainingCentre, int[]> trainingCentres; //have to modify them based on the type of training centres we got
    // private HashMap<CourseTypeClass, int[]> trainees; //have to modify them based on the type of training courses we got in the course type class.

    private static final String OUTPUT_FILE_LOCATION = "spartaSimulationOutputFile.txt";

    public FileWriterClass() {
    }

    private boolean fileExists() {
        File file = new File(OUTPUT_FILE_LOCATION);
        return file.isFile();
    }

    private String formatResults(int unformattedNumber) {
        return NumberFormat.getInstance().format((double) unformattedNumber);
    }

    public void outputToFile() {
        try {
            if (!fileExists()) {
                File file = new File(OUTPUT_FILE_LOCATION);
                file.createNewFile();
            }
            //can add buffered writer if needed
            FileWriter writer = new FileWriter(OUTPUT_FILE_LOCATION);
            writer.write(createOutput());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void outputToConsole() {
        PrintClass.printString(createOutput());
    }

    public String createOutput() {

        // int[] typeOfTrainingCentre = trainingCentres.get(TypeOfTrainingCentre.class); //can add as many as needed

        // int[] courseTypeClass = trainees.get(CourseTypeClass.COURSE_NAME); //can add as many as needed

        return null ; // will update this later on
    }
}
