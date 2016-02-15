package com.bigdata;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TextFileSplit {

	public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Invalid Input!");
        }

        //first argument is the file path
        File file = new File(args[0]);

        //second argument is the number of lines per chunk
        //In particular the smaller files will have numLinesPerChunk lines
        int numLinesPerChunk = Integer.parseInt(args[1]);

        BufferedReader reader = null;
        PrintWriter writer = null;
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String line;        

        long start = System.currentTimeMillis();

        try {
            line = reader.readLine();
            for (int i = 1; line != null; i++) {
                writer = new PrintWriter(new FileWriter(args[0] + "_part" + i + ".txt"));
                for (int j = 0; j < numLinesPerChunk && line != null; j++) {
                    writer.println(line);
                    line = reader.readLine();
                }
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        writer.close();

        long end = System.currentTimeMillis();

        System.out.println("Taken time[sec]:");
        System.out.println((end - start) / 1000);

    }

}
