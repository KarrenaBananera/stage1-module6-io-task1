package com.epam.mjc.io;

import java.io.File;
import java.io.*;

public class FileReader {

    public Profile getDataFromFile(File file) {
        try(java.io.FileReader reader = new java.io.FileReader(file))
        {
            int symbol;
            String profile = "";
            while ((symbol = reader.read()) != -1)
            {
                profile += (char)symbol;
            }
            profile = profile.replaceAll(".*: ","");
            String[] data = profile.split("\r\n");
             return new Profile(data[0],Integer.valueOf(data[1]),data[2],Long.valueOf(data[3]));
        }
        catch (IOException exception)
        {
            exception.printStackTrace();
            return new Profile();
        }
    }

}
