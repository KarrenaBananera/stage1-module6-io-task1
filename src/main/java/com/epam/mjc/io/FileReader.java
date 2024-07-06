package com.epam.mjc.io;

import java.io.File;
import java.io.*;

public class FileReader {

    public Profile getDataFromFile(File file) {
        try(java.io.FileReader reader = new java.io.FileReader(file))
        {
            int symbol;
            StringBuilder profile = new StringBuilder();
            while ((symbol = reader.read()) != -1)
            {
                profile.append((char) symbol);
            }
            profile = new StringBuilder(profile.toString().replaceAll(".*: ", ""));
            String[] data = profile.toString().split("\n");
             return new Profile(data[0],Integer.valueOf(data[1]),data[2],Long.valueOf(data[3]));
        }
        catch (IOException exception)
        {
            exception.printStackTrace();
            return new Profile();
        }
    }

}
