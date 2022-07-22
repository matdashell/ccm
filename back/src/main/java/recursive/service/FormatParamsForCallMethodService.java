package recursive.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FormatParamsForCallMethodService {

    private static final CallMethodService callMethodService = new CallMethodService();

    public void format(List<Map<String, List<String>>> methodsToExecute, Map<String, List<String>> examplesToExecute, int numberOfExamples) {
        if(numberOfExamples == -1) numberOfExamples = 1;
        for (int i = 0; i < numberOfExamples; i++) {
            int countI = i;
            methodsToExecute.forEach(methodMap -> {
                List<String> params = new ArrayList<>();
                String currentMethod = new ArrayList<>(methodMap.keySet()).get(0);
                List<String> actualParams = methodMap.get(currentMethod);

                actualParams.forEach(acParam -> {
                    boolean containsExample = examplesToExecute.containsKey(acParam);
                    if (containsExample) {
                        params.add(examplesToExecute.get(acParam).get(countI));
                    } else {
                        params.add(acParam);
                    }
                });

                try {
                    callMethodService.using(currentMethod, params);
                } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }
}
