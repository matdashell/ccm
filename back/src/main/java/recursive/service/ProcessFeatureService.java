package recursive.service;

import java.util.*;

public class ProcessFeatureService {

    private static final FormatParamsForCallMethodService formatParamsForCallMethodService = new FormatParamsForCallMethodService();
    private static final ProcessMethodService processMethodService = new ProcessMethodService();
    private static final ProcessExampleService processExampleService = new ProcessExampleService();

    public void fromScanner(Scanner featureScanner) {
        boolean isNotExample = true;
        int numberOfExamples = -1;
        List<Map<String, List<String>>> methodsToExecute = new ArrayList<>();
        Map<String, List<String>> examplesToExecute = new HashMap<>();
        StringBuilder examplesBuilder = new StringBuilder();
        while (featureScanner.hasNext()) {
            String line = featureScanner.nextLine().trim();

            if (isNotExample) {
                Optional<Map<String, List<String>>> result = Optional.ofNullable(processMethodService.from(line));
                result.ifPresent(methodsToExecute::add);
            } else {
                examplesBuilder.append(line).append("\n");
                numberOfExamples++;
            }

            if (line.equals("Exemplos:")) {
                isNotExample = false;
            }
        }

        if (!examplesBuilder.toString().isBlank()) {
            examplesToExecute = processExampleService.from(examplesBuilder.toString());
        }

        formatParamsForCallMethodService.format(methodsToExecute, examplesToExecute, numberOfExamples);
    }
}
