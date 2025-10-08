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
                if(firstSplit[0].equals("id")){ //I MADE THIS IF STATEMENT TO SKIP OVER THE FIRST LINE OF THE CSV FILE, IT WAS PREVENTING ME FROM PARSING STRINGS TO DOUBLES
                    continue;
                }
                //TEST for split //System.out.println(firstSplit[0]);

                //created a double array to convert string values into double, note we are only parsing 3 indexes because the fourth is already a string
                double[] stringToDouble = new double[3];
                //parse the strings into double
                stringToDouble[0] = Double.parseDouble(firstSplit[0]);
                stringToDouble[1] = Double.parseDouble(firstSplit[2]);
                stringToDouble[2] = Double.parseDouble(firstSplit[3]);
                //TEST for parse //System.out.println(stringToDouble[0]);

                //initialize the variable to the corresponding arrays
                double employeeId = stringToDouble[0];
                String name = firstSplit[1];
                double hoursWorked = stringToDouble[1];
                double payRate = stringToDouble[2];

                //create a new instance of the employee class
                Employee employee = new Employee(employeeId, name, hoursWorked, payRate);

                //save the input by using setter methods
                employee.setEmployeeId(employeeId);
                employee.setName(name);
                employee.setHoursWorked(hoursWorked);
                employee.setPayRate(payRate);

                //format and print the new instance by using getter methods
                System.out.printf("Employee ID: %.0f Name: %s GrossPay: $%.2f", employee.getEmployeeId(), employee.getName(), employee.getGrossPay());
                System.out.println();
                System.out.println("--------------------------------------------------------------");
            }
            bufferedReader.close();

        }
        catch(IOException e) {
            e.printStackTrace();
        }

    }

}
