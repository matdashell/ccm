package recursive.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ProcessMethodService {

    private static final FormatMethodNameService formatMethodNameService = new FormatMethodNameService();

    public Map<String, List<String>> from(String line) {
        List<String> maths = Arrays.asList("E", "Entao", "Dado", "Dada", "Quando", "Dados", "Dadas", "Mas", "*");
        String firsElementOfLine = line.split(" ")[0];

        String startWithMath = maths.stream()
                .reduce("", (accumulator, math) -> {
                    if (line.startsWith(math) && firsElementOfLine.length() == math.length()) {
                        accumulator = math;
                    }
                    return accumulator;
                });

        if (startWithMath.isBlank()) {
            return null;
        }
        return formatMethodNameService.format(line, startWithMath);
    }
}
