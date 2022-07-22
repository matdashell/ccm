package recursive.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FormatParamExamplService {

    public List<String> format(String arg) {
        return Arrays.stream(arg.split("\\|"))
                .map(String::trim)
                .filter(item -> !item.isBlank())
                .collect(Collectors.toList());
    }
}
