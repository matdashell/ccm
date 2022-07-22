package recursive.service;

import java.util.*;

public class FormatMethodNameService {

    private static final RemoveComp removeComp = new RemoveComp();
    private static final ToCamelCase toCamelCase = new ToCamelCase();

    public Map<String, List<String>> format(String line, String startWithMath) {
        String methodWithoutPrefix = line.replaceFirst(startWithMath, "").trim();
        List<String> methodWithoutParams = Arrays.asList(methodWithoutPrefix.split("\""));
        List<String> paramsOfMethod = new ArrayList<>();
        StringBuilder realMethodName = new StringBuilder();

        for (int i = 0; i < methodWithoutParams.size(); i++) {
            boolean isOdd = i % 2 <= 0;
            if (isOdd) {
                realMethodName.append(methodWithoutParams.get(i));
            } else {
                paramsOfMethod.add(removeComp.removeFrom(methodWithoutParams.get(i)));
            }
        }

        Map<String, List<String>> methodsAndParams = new HashMap<>();
        methodsAndParams.put(toCamelCase.from(realMethodName.toString()), paramsOfMethod);

        return methodsAndParams;
    }
}
