package org.decorator.client;

import org.decorator.decorators.CompressionDecorator;
import org.decorator.decorators.DataSource;
import org.decorator.decorators.EncryptionDecorator;
import org.decorator.decorators.FileDataSource;

public class Demo {
    public static void main(String[] args) {
        String salaryRecords = "Name,Salary\nJohn Smith,100000\nSteven Jobs,912000";
        String outputFilePath = ".\\Decorator\\OutputDemo.txt";

        DataSource plainSource = new FileDataSource(outputFilePath);
        System.out.println("--- Writing plain data to " + outputFilePath + " ---");
        plainSource.writeData(salaryRecords);
        System.out.println("Plain data written.");
        System.out.println("--- Reading plain data from " + outputFilePath + " ---");
        System.out.println(plainSource.readData());
        System.out.println("----------------------------------------\n");

        DataSource encryptedSource = new EncryptionDecorator(new FileDataSource(outputFilePath));
        System.out.println("--- Writing encrypted data to " + outputFilePath + " ---");
        encryptedSource.writeData(salaryRecords);
        System.out.println("Encrypted data written.");
        System.out.println("--- Reading raw (encrypted) data from " + outputFilePath + " ---");
        System.out.println(plainSource.readData()); 
        System.out.println("--- Reading and decrypting data via decorator ---");
        System.out.println(encryptedSource.readData());
        System.out.println("----------------------------------------\n");

        DataSource compressedSource = new CompressionDecorator(new FileDataSource(outputFilePath));
        System.out.println("--- Writing compressed data to " + outputFilePath + " ---");
        compressedSource.writeData(salaryRecords);
        System.out.println("Compressed data written.");
        System.out.println("--- Reading raw (compressed) data from " + outputFilePath + " ---");
        System.out.println(plainSource.readData());
        System.out.println("--- Reading and decompressing data via decorator ---");
        System.out.println(compressedSource.readData());
        System.out.println("----------------------------------------\n");

        DataSource compressedAndEncryptedSource = new EncryptionDecorator(
                                                    new CompressionDecorator(
                                                        new FileDataSource(outputFilePath)));
        System.out.println("--- Writing compressed then encrypted data to " + outputFilePath + " ---");
        compressedAndEncryptedSource.writeData(salaryRecords);
        System.out.println("Compressed and Encrypted data written.");
        System.out.println("--- Reading raw (compressed and encrypted) data from " + outputFilePath + " ---");
        System.out.println(plainSource.readData());
        System.out.println("--- Reading, decrypting, and decompressing data via stacked decorators ---");
        System.out.println(compressedAndEncryptedSource.readData());
        System.out.println("----------------------------------------\n");

        DataSource encryptedAndCompressedSource = new CompressionDecorator(
                                                    new EncryptionDecorator(
                                                        new FileDataSource(outputFilePath)));
        System.out.println("--- Writing encrypted then compressed data to " + outputFilePath + " ---");
        encryptedAndCompressedSource.writeData(salaryRecords);
        System.out.println("Encrypted and Compressed data written.");
        System.out.println("--- Reading raw (encrypted and compressed) data from " + outputFilePath + " ---");
        System.out.println(plainSource.readData());
        System.out.println("--- Reading, decompressing, and decrypting data via stacked decorators (reverse order) ---");
        System.out.println(encryptedAndCompressedSource.readData());
        System.out.println("----------------------------------------");

    }
} 