package org.decorator.decorators;

import java.io.*;

public class FileDataSource implements DataSource {
    private String name;

    public FileDataSource(String name) {
        this.name = name;
    }

    @Override
    public void writeData(String data) {
        final File file = new File(name);
        final File parentDir = file.getParentFile();
        if (parentDir != null && !parentDir.exists()) {
            if (!parentDir.mkdirs()) {
                System.out.println("Error: Could not create directory " + parentDir);
                return;
            }
        }
        try (OutputStream fos = new FileOutputStream(file)) {
            fos.write(data.getBytes(), 0, data.length());
        } catch (IOException ex) {
            System.out.println("Error writing to file " + name + ": " + ex.getMessage());
        }
    }

    @Override
    public String readData() {
        char[] buffer = null;
        final File file = new File(name);
        if (!file.exists()) {
            System.out.println("Error: File not found " + name);
            return "";
        }
        try (FileReader reader = new FileReader(file)) {
            buffer = new char[(int) file.length()];
            reader.read(buffer);
        } catch (IOException ex) {
            System.out.println("Error reading from file " + name + ": " + ex.getMessage());
            return "";
        }
        return new String(buffer);
    }
} 