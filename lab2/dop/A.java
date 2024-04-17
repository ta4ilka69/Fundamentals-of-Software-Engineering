import java.io.*;

public class BigJavaFile {
  public static void main(String[] args) {
    try {
      // Input file
      File inputFile = new File("input.txt");
      FileReader fileReader = new FileReader(inputFile);
      BufferedReader bufferedReader = new BufferedReader(fileReader);
      // Output file
      FileWriter fileWriter = new FileWriter(outputFile);
      BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

      // Read from input file and write to output file
      String line;
      while ((line = bufferedReader.readLine())
          != null) { // Process each line (Here, we're just writing it to the output file)
        bufferedWriter.write(line);
        bufferedWriter.newLine(); // Add a new line
      }
      // Close resources
      bufferedReader.close();
      bufferedWriter.close();
      System.out.println("File copied successfully.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}
