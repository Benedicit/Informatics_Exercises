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
        int currentLine =0;
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
            strLine = strLine.replaceAll("[|-]","");
            if(strLine.isEmpty()) {
                continue;
            }
            int cacheSetCount = 8;
            strLine = strLine.trim();
            if(currentLine < cacheSetCount) {
                String[] counts = strLine.split("0x");
                List<String> list = new ArrayList<>();
                for (String s: counts) {
                    if(!s.isEmpty()) {
                        s = s.trim();
                        if(s.length() < 8) {
                            s = "0x" + s + " ".repeat(7-s.length());
                        }
                        list.add(s);
                    }
                }
                caches.put(currentLine,list);

            } else {

                strLine = strLine.substring(2);
                int whole = HexFormat.fromHexDigits(strLine);
                int blockNumber = whole / 8;
                int index = blockNumber % 8;
                int tag = whole >> 6;
                String hexTag = Integer.toHexString(tag).toUpperCase().trim();
                if (!caches.containsKey(index)) {
                    List<String> l = new ArrayList<>();
                    l.add(hexTag);
                    caches.put(index, l);

                } else {
                    var temp2 = caches.get(index);

                    if(hexTag.length() < 8) {
                        hexTag = "0x" + hexTag + " ".repeat(7-hexTag.length());
                    }
                    temp2.add(0, hexTag);
                }
            }
            currentLine++;
        }
        //int i =0;

        for (var t : caches.keySet()) {
            var list = caches.get(t);
            while (list.size() < 4) {
                list.add(" ".repeat(9));
            }
            System.out.println(" ".repeat(9) + "|-----------|-----------|-----------|-----------|");
            System.out.println("Zeile "  + t + ": | " + list.stream().limit(4).collect(Collectors.joining(" | ")) + " |");
        }
        System.out.println(" ".repeat(9) + "|-----------|-----------|-----------|-----------|");
    }
}
