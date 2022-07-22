package recursive.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileDTO {

    Map<String, String> mappers = new HashMap<>();
    List<String> values = new ArrayList<>();
    List<String> examples = new ArrayList<>();
    List<String> functions = new ArrayList<>();
    List<String> lines = new ArrayList<>();
}
