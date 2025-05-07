package org.decorator.decorators;

import java.util.Base64;

public class EncryptionDecorator extends DataSourceDecorator {

    public EncryptionDecorator(DataSource source) {
        super(source);
    }

    @Override
    public void writeData(String data) {
        super.writeData(encode(data));
    }

    @Override
    public String readData() {
        return decode(super.readData());
    }

    private String encode(String data) {
        if (data == null || data.isEmpty()) {
            return "";
        }
        byte[] result = data.getBytes();
        byte key = (byte) 0xAB;
        for (int i = 0; i < result.length; i++) {
            result[i] = (byte) (result[i] ^ key);
        }
        return Base64.getEncoder().encodeToString(result);
    }

    private String decode(String data) {
        if (data == null || data.isEmpty()) {
            return "";
        }
        byte[] result;
        try {
            result = Base64.getDecoder().decode(data);
        } catch (IllegalArgumentException e) {
            System.out.println("Error decoding Base64 string: " + e.getMessage());
            return "";
        }
        
        byte key = (byte) 0xAB;
        for (int i = 0; i < result.length; i++) {
            result[i] = (byte) (result[i] ^ key);
        }
        return new String(result);
    }
}