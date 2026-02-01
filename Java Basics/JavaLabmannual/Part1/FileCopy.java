import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) throws IOException {
        
        // Create source file
        File sourceFile = new File("source.txt");
        if (sourceFile.createNewFile()) {
            System.out.println("Source file created: " + sourceFile.getName());
            // Write some data to source file
            FileWriter writer = new FileWriter(sourceFile);
            writer.write("This is the source file.\n");
            writer.write("Content will be copied to destination file.");
            writer.close();
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

        // Copy data from source to destination
        FileReader fr = new FileReader(sourceFile);
        FileWriter fw = new FileWriter(destFile);

        int ch;
        while ((ch = fr.read()) != -1) {
            fw.write(ch);
        }

        fr.close();
        fw.close();

        System.out.println("Data copied successfully.");
    }
}
