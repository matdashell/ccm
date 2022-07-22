package recursive.service;

import java.io.File;
import java.io.FileNotFoundException;

public class ReadFeatureService {

    public File read(String featureName) throws FileNotFoundException {
        String url = "src/main/resources/feature/" + featureName + ".feature";
        return new File(url);
    }
}
