import java.io.*;
import java.util.*;

public class SortTitles {

    public static LinkedHashMap<String, Integer> sortHashMapByValues(HashMap<String, Integer> passedMap) {
        List<String> mapKeys = new ArrayList<>(passedMap.keySet());
        List<Integer> mapValues = new ArrayList<>(passedMap.values());
        Collections.sort(mapValues);
        Collections.sort(mapKeys);

        LinkedHashMap<String, Integer> sortedMap =
                new LinkedHashMap<>();

        Iterator<Integer> valueIt = mapValues.iterator();
        while (valueIt.hasNext()) {
            int val = valueIt.next();
            Iterator<String> keyIt = mapKeys.iterator();

            while (keyIt.hasNext()) {
                String key = keyIt.next();
                int comp1 = passedMap.get(key);
                int comp2 = val;

                if (comp1==comp2) {
                    keyIt.remove();
                    sortedMap.put(key, val);
                    break;
                }
            }
        }
        return sortedMap;
    }

    public static void main(String[] args) {
        try {
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter Path");
            String src=sc.nextLine();
            FileReader fileReader = new FileReader("D:\\java\\IntelliJ\\Website\\titleinfo");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            HashMap<String, Integer> frequency = new HashMap<>();

            String scanner=bufferedReader.readLine();
                while (scanner!=null) {
                    String temp = scanner;
                    if(frequency.containsKey(temp)) {
                        Integer count = frequency.get(temp);
                        frequency.put(temp, Integer.sum(count, 1));
                    } else {
                        frequency.put(temp, 1);
                    }
                    scanner=bufferedReader.readLine();
                }

            BufferedWriter outputWriter1 = null;
            outputWriter1 = new BufferedWriter(new FileWriter("titlesMine"));
            LinkedHashMap<String, Integer> frequency1 =sortHashMapByValues(frequency);
            for (String name: frequency1.keySet()){
                String key =name.toString();
                String value = frequency1.get(name).toString();
                outputWriter1.write(key+","+value);
                outputWriter1.newLine();
                outputWriter1.flush();
            }
            outputWriter1.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
