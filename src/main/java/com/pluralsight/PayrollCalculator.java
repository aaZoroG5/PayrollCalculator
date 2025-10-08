package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PayrollCalculator {

    public static void main(String[] args) {
        //create a try statement that catches I/O exception
        try {
            //create a file reader object connected to the file
            FileReader payRollReader = new FileReader("employees.csv");
            //create a buffer reader to manage input stream
            BufferedReader bufferedReader = new BufferedReader(payRollReader);
            //can also write this in one line
            //BufferReader bufferreader = new BufferedReader(new FileReader("poem.csv"))

            String input;
            //create a loop that reads each line in the csv file
            while ((input = bufferedReader.readLine()) != null) {
                //TEST//System.out.println(input);
                String [] firstSplit = input.split("\\|");

                //parse the strings into double
                firstSplit[0] = Double.parseDouble(firstSplit[0]);
                firstSplit[2] = Double.parseDouble(firstSplit[2]);
                firstSplit[3] = Double.parseDouble(firstSplit[3]);
            }
            bufferedReader.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }

    }

}
