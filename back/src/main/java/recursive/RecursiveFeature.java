package recursive;

import recursive.service.ProcessFeatureService;
import recursive.service.ReadFeatureService;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RecursiveFeature {

    private final ReadFeatureService readFeatureService = new ReadFeatureService();
    private final ProcessFeatureService processFeatureService = new ProcessFeatureService();

    //TODO: controlar recursividades descontroladas com AspecjJ

    public void fromFeatureName(String featureName) {
        try {
            File file = readFeatureService.read(featureName);
            Scanner scanner = new Scanner(file);
            processFeatureService.fromScanner(scanner);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
