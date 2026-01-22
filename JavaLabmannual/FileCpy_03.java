////Q.3 : A java program to create file using File Class and copy data from on file to other file.

// package JavaLabmannual;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCpy_03 {
    public static void main(String[] args) throws IOException {
        
        // Create source file
        File sourceFile = new File("source.txt");
        if (sourceFile.createNewFile()) {
            System.out.println("Source file created: " + sourceFile.getName());
            try ( // Write some data to source file
                    FileWriter writer = new FileWriter(sourceFile)) {
                writer.write("This is the source file.\n");
                writer.write("Content will be copied to destination file.");
            }
        } else {
            System.out.println("Source file already exists.");
        }

        // Create destination file
        File destFile = new File("destination.txt");
        if (destFile.createNewFile()) {
            System.out.println("Destination file created: " + destFile.getName());
        } else {
            System.out.println("Destination file already exists. Data will be overwritten.");
        }

        FileWriter fw;
        try ( // Copy data from source to destination
                FileReader fr = new FileReader(sourceFile)) {
            fw = new FileWriter(destFile);
            int ch;
            while ((ch = fr.read()) != -1) {
                fw.write(ch);
            }
        }
        fw.close();

        System.out.println("Data copied successfully.");
    }
}

