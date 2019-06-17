package cz.muni.fi.pb162.hw03.impl;

import java.io.*;

public class IOoperations {
    public void translate(InputStream is, OutputStream os) throws TranslatorException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os));
        String output = readInputStreamToString(is);
        try {
            writer.write(output);
        } catch (IOException e) {
            throw new TranslatorException("output fails", e);
        }
    }

    private String readInputStreamToString(InputStream is) throws TranslatorException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String line;
        StringBuilder builder = new StringBuilder();

        try {
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");

                for (String string : parts) {
                    builder.append(this.convert(string)).append(" ");
                }
                builder.append(System.lineSeparator());
            }
            return builder.toString();
        } catch (IOException e) {
            throw new TranslatorException("file read fails", e);
        }
    }

    public void translate(File file) throws TranslatorException {
        try (InputStream in = new FileInputStream(file)) {
            String output = readInputStreamToString(in);
            System.out.print(output);
        } catch (IOException e) {
            throw new TranslatorException("file IO failed", e);
        }
    }
}
