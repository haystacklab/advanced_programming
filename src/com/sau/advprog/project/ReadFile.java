package com.sau.advprog.project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFile {
    protected List<String> readFile(String fileLocation) throws FileNotFoundException {
        List<String> lines = new ArrayList();
        Scanner scanner = new Scanner(new File(fileLocation));
        scanner.useDelimiter("\n");
        while (scanner.hasNext()) {
            lines.add(scanner.next());
        }
        scanner.close();
        return lines;
    }
}
