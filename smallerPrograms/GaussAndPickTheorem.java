package smallerPrograms;

import java.util.List;
import java.util.Map;

public class GaussAndPickTheorem {
    public static void main(String[] args) {

    }
    public static long area(List<long[]> cords, long wallPoints) {
        long area =0;
        long result;
        for (int i = 1; i < cords.size()-1; i++) {
            area += cords.get(i)[0] * (cords.get(i+1)[1] - cords.get(i-1)[1]);
        }
        area += cords.get(1)[0] *(cords.get(2)[1]-cords.get(cords.size()-1)[1]);
        area += cords.get(cords.size()-1)[0] * (cords.get(1)[1]-cords.get(cords.size()-2)[1]);
        area /= 2;

        result = Math.abs(area) - (wallPoints/2) +1;

        return result;
    }
}
