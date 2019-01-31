import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class Website1 {
    public static void main(String[] args) {
        FileReader fileReader = null;
        int count=0;
        try {
            fileReader = new FileReader("D:\\Studies\\IntelliJ\\Website\\src\\output1");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String site="";
            BufferedWriter outputWriter1 = null;
            outputWriter1 = new BufferedWriter(new FileWriter("errors1"));

            while ((site = bufferedReader.readLine()) != null) {
                try {
                    String url = "https://www." + site;
                    URL urlName = new URL(url);
                    URLConnection yc = urlName.openConnection();
                    BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
                    String inputLine;
                    StringBuilder a = new StringBuilder();
                    while ((inputLine = in.readLine()) != null)
                        a.append(inputLine);
                    in.close();

                    BufferedWriter outputWriter = null;
                    String name = site + ".html";
                    String path = "D:\\Studies\\IntelliJ\\Website\\html\\" + name;
                    File file = new File(path);
                    outputWriter = new BufferedWriter(new FileWriter(file));
                    outputWriter.write(a.toString());
                    outputWriter.flush();
                    outputWriter.close();
                    System.out.println("here"+count);
                    count++;
                    long kb=file.length()/1024;
                    if(kb<2){
                        System.out.println("fake");

                    }

                } catch(IOException e){
                    System.out.println("error"+count);
                    count++;
                    outputWriter1.write(site);
                    outputWriter1.newLine();
                    outputWriter1.flush();
                    continue;
                }
            }
            outputWriter1.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

