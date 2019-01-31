import java.io.*;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class title {

    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Path to search files");
        String src=sc.nextLine();
        File folder = new File(src);
        File[] listOfFiles = folder.listFiles();
        BufferedWriter outputWriter1 = null;
        outputWriter1 = new BufferedWriter(new FileWriter("titleinfo"));
        int count=0;
        for (int i = 0; i < listOfFiles.length; i++) {
            InputStream is = new FileInputStream(listOfFiles[i]);
            BufferedReader buf = new BufferedReader(new InputStreamReader(is));
            String line = buf.readLine();
            StringBuilder sb = new StringBuilder();
            while(line != null) {
                sb.append(line).append("\n");
                line = buf.readLine();
            }
            //String fileAsString = sb.toString();

            String html = sb.toString();
            Document doc = Jsoup.parse(html);
            String title = doc.title();
            outputWriter1.write(title);
            outputWriter1.newLine();
            outputWriter1.flush();
            System.out.println(count);
            count++;
        }
        outputWriter1.close();
    }
}
