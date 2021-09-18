package fileIO;

import org.testng.annotations.Test;

import java.io.*;
import java.util.Scanner;

public class TextFileManage {


    @Test
    public void testText() {

        String filePath = "/Users/anurag/Desktop/Workspace/JAVA/JavaLearning/src/main/resources/CSVFiles/TestTextFile.txt";

        textUsingBufferReader(filePath);
        textUsingFileReader(filePath);
        textUsingScannerWithoutLoop(filePath);

    }


    public void textUsingBufferReader(String filePath) {
        try {
            File file = new File(filePath);

            BufferedReader br = null;

            br = new BufferedReader(new FileReader(file));

            String st;
            while ((st = br.readLine()) != null)
                System.out.println(st);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void textUsingFileReader(String filePath) {
        try {

            FileReader fr = new FileReader(filePath);

            int i;
            while ((i=fr.read()) != -1)
                System.out.print((char) i);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void textUsingScannerWithoutLoop(String filePath) {
        try {

            File file = new File(filePath);
            Scanner sc = new Scanner(file);

            // we just need to use \\Z as delimiter
            sc.useDelimiter("\\Z");

            System.out.println(sc.next());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }




}


