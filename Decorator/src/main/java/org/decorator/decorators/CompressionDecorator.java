package org.decorator.decorators;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

public class CompressionDecorator extends DataSourceDecorator {
    private int compLevel = Deflater.DEFAULT_COMPRESSION;

    public CompressionDecorator(DataSource source) {
        super(source);
    }

    public int getCompressionLevel() {
        return compLevel;
    }

    public void setCompressionLevel(int value) {
        if (value >= Deflater.NO_COMPRESSION && value <= Deflater.BEST_COMPRESSION) {
            this.compLevel = value;
        } else if (value == Deflater.DEFAULT_COMPRESSION) {
            this.compLevel = value;
        } else {
            System.out.println("Warning: Invalid compression level " + value + ". Using default.");
            this.compLevel = Deflater.DEFAULT_COMPRESSION;
        }
    }

    @Override
    public void writeData(String data) {
        super.writeData(compress(data));
    }

    @Override
    public String readData() {
        return decompress(super.readData());
    }

    private String compress(String stringData) {
        if (stringData == null || stringData.isEmpty()) {
            return "";
        }
        byte[] data = stringData.getBytes();
        try {
            ByteArrayOutputStream bout = new ByteArrayOutputStream(512);
            DeflaterOutputStream dos = new DeflaterOutputStream(bout, new Deflater(compLevel));
            dos.write(data);
            dos.close();
            return Base64.getEncoder().encodeToString(bout.toByteArray());
        } catch (IOException ex) {
            System.out.println("Error during compression: " + ex.getMessage());
            return "";
        }
    }

    private String decompress(String stringData) {
        if (stringData == null || stringData.isEmpty()) {
            return "";
        }
        byte[] data;
        try {
            data = Base64.getDecoder().decode(stringData);
        } catch (IllegalArgumentException e) {
            System.out.println("Error decoding Base64 string for decompression: " + e.getMessage());
            return "";
        }
        
        try {
            InputStream in = new ByteArrayInputStream(data);
            InflaterInputStream iin = new InflaterInputStream(in);
            ByteArrayOutputStream bout = new ByteArrayOutputStream(512);
            int b;
            while ((b = iin.read()) != -1) {
                bout.write(b);
            }
            iin.close();
            in.close(); 
            return new String(bout.toByteArray());
        } catch (IOException ex) {
            System.out.println("Error during decompression: " + ex.getMessage());
            return "";
        }
    }
} 