import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class test {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("D:\\java\\IntelliJ\\Website\\siteinfo");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            BufferedWriter outputWriter1 = null;
            outputWriter1 = new BufferedWriter(new FileWriter("sizes"));

            String site;
            String[] arr;
            while ((site = bufferedReader.readLine()) != null){
                arr=site.split(",");
                outputWriter1.write(arr[1]);
                outputWriter1.newLine();
                outputWriter1.flush();
            }
            outputWriter1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
