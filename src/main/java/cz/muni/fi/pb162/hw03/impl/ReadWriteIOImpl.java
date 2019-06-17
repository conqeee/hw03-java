package cz.muni.fi.pb162.hw03.impl;

import cz.muni.fi.pb162.hw03.ReadWriteIO;

import java.io.InputStream;
import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.FileOutputStream;

/**
 * class for reading and writing operations
 */
public class ReadWriteIOImpl implements ReadWriteIO {

    @Override
    public String streamToString(InputStream inputStream) throws IOException {
        StringBuilder result = new StringBuilder();
        try (Reader reader = new BufferedReader(new InputStreamReader(inputStream))){
            int i;
            while ((i=reader.read()) != -1){
                result.append((char) i);
            }
        }
        return result.toString();
    }

    @Override
    public String fileToString(File file) throws IOException {
        String result;
        try (InputStream stream = new FileInputStream(file)){
            result = streamToString(stream);
        }
        return result;
    }

    @Override
    public void stringToStream(String string, OutputStream outputStream) throws IOException {
        try (PrintWriter printWriter = new PrintWriter(outputStream)){
            printWriter.print(string);
        }
    }

    @Override
    public void stringToFile(String string, File file) throws IOException {
        try (OutputStream out = new FileOutputStream(file)){
            stringToStream(string, out);
        }
    }
}
