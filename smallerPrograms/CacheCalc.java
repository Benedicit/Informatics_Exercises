package smallerPrograms;



import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class CacheCalc {
    public static void main(String[] args) {
        calc();
    }

    public static void calc() {
        File file = new File("/Users/benedikt/Documents/Studium/Informatik/ERA/Zusatz/input.txt");
        BufferedReader br;
        long result = 0;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String strLine;
        List<String> line1 = new ArrayList<>();
        Map<Integer, List<String>> caches = new HashMap<>();
        while (true) {
            try {
                if ((strLine = br.readLine()) == null) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            strLine = strLine.substring(2);
            int whole = HexFormat.fromHexDigits(strLine);

            int blockNumber = whole / 8;
            int index = blockNumber % 8;
            int tag = whole >> 6;
            String hexTag = Integer.toHexString(tag).toUpperCase();
            if(!caches.containsKey(index)) {
                List<String> l = new ArrayList<>();
                l.add(hexTag);
                caches.put(index, l);

            } else {
                var temp2 = caches.get(index);
                temp2.add(0,hexTag);
            }

        }
        //int i =0;
        for (var t : caches.keySet()) {
            var list = caches.get(t);
            System.out.println("Zeile "  + t + ": | " + list.stream().limit(4).collect(Collectors.joining(" | ")) + " |");
        }
    }
}
