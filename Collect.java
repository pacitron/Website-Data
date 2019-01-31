import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Collect {
    public static void main(String[] args) {
        try {
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter Path");
            String src=sc.nextLine();
            File folder = new File(src);
            File[] listOfFiles = folder.listFiles();
            BufferedWriter outputWriter1 = null;
            outputWriter1 = new BufferedWriter(new FileWriter("siteinfo"));
            int count=0;

            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile()) {
                    outputWriter1.write(String.valueOf(listOfFiles[i].length()));
                    outputWriter1.newLine();
                    outputWriter1.flush();
                    System.out.println(count);
                    count++;
                    //System.out.println("File " + listOfFiles[i].getName()+"\tSize "+listOfFiles[i].length());
                }
            }
            outputWriter1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
