package FileIO;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import org.testng.annotations.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class CsvManage {


    @Test
    public void testCsv() {

        String filePath = "/Users/anurag/Desktop/Workspace/JAVA/JavaLearning/src/main/resources/CSVFiles/TestCSV.csv";

        EditCsvGeneric(filePath, 1, 1, "Testdata");


    }


    public void test1() throws IOException, CsvValidationException {

        String filePath = "/Users/anurag/Desktop/Workspace/JAVA/JavaLearning/src/main/resources/CSVFiles/TestCSV.csv";





    }


    public void EditCsvGeneric(String fileLoc, int rowValueToUpdate, int colValueToUpdate, String data) {

        try {

            /*Path pathToFile = Paths.get(fileLoc);
            BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII);*/

            File file = new File(fileLoc);
            BufferedReader br = new BufferedReader(new FileReader(file));

            String line = br.readLine();
            FileWriter writer = new FileWriter(fileLoc);
            //CSVWriter csvWriter = new CSVWriter(writer)
            CSVWriter csvWriter = new CSVWriter(writer, ',', CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.NO_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);

            int i = 0;
            while (line != null) {
                //String[] attributes = line.split("\\|"); // split using delimeter
                String[] attributes = line.split(",");
                if (i == rowValueToUpdate) {
                    attributes[colValueToUpdate] = data;
                }
                line = br.readLine();
                csvWriter.writeNext(attributes);
                i++;
            }

            writer.close();

        } catch (IOException io) {
            System.out.println(io.getMessage());
        }


    }




}