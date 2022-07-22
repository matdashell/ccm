package mapper;

import io.cucumber.java.*;
import steps.MyStepdefs;

import java.io.*;
import java.util.Scanner;

public class PathMapper {

    public static final String DEFAULT_MAPPER_PATH = "src/main/java/mapper/mapper.csv";
    private static boolean NEW_INSERTS = false;

    @AfterAll
    public static void resetCSV() {
        try {
            FileWriter fileWriter = new FileWriter(DEFAULT_MAPPER_PATH);
            fileWriter.write("");
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Before
    public void loadCSV() {
        try {
            NEW_INSERTS = true;
            File file = new File(DEFAULT_MAPPER_PATH);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String[] content = scanner.nextLine().split(";");
                MyStepdefs.xPath.put(content[0], content[1]);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void insertOnCSV(String key, String value) {
        if(NEW_INSERTS) {
            resetCSV();
            NEW_INSERTS = false;
        }
        try {
            FileWriter fileWriter = new FileWriter(DEFAULT_MAPPER_PATH, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(String.format("%s;%s", key, value));
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
