package recursive.service;

import java.util.*;

public class ProcessExampleService {

    private static final FormatParamExamplService formatParamExamplService = new FormatParamExamplService();

    public Map<String, List<String>> from(String line) {
        Scanner scanner = new Scanner(line);
        List<String> headers = new ArrayList<>();
        List<List<String>> values = new ArrayList<>();

        boolean first = true;
        while (scanner.hasNext()) {
            if (first) {
                headers = formatParamExamplService.format(scanner.nextLine());
                first = false;
            } else {
                values.add(formatParamExamplService.format(scanner.nextLine()));
            }
        }

        Map<String, List<String>> mapOfExamples = new HashMap<>();

        for (List<String> value : values) {
            for (int j = 0; j < headers.size(); j++) {
                List<String> previus = mapOfExamples.get(headers.get(j));
                if (previus == null) {
                    previus = new ArrayList<>();
                }
                previus.add(value.get(j));
                mapOfExamples.put(headers.get(j), previus);
            }
        }

        return mapOfExamples;
    }
}
