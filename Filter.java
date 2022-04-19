package Singleton;

import java.util.ArrayList;
import java.util.List;

public class Filter {
    protected int threshold;

    public Filter(int threshold) {
        this.threshold = threshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < source.size(); i++) {
            if (source.get(i) > threshold) {
                result.add(source.get(i));
                logger.log("Элемент " + source.get(i) + " проходит");
            } else {
                logger.log("Элемент " + source.get(i) + " не проходит");
            }
        }

        return result;
    }

}
