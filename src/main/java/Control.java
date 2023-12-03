import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Control {
    static void application(Scanner scanner) {
        File inputFile = new File("countries.csv");
        Map<String, Country> countryMap = Control.convertFileIntoMap(inputFile);
        if (!inputFile.exists()) {
            System.out.println("Brak pliku countries.csv.");
        } else {
            findCountry(scanner, countryMap);
        }
    }

    static void findCountry(Scanner scanner, Map<String, Country> countryMap) {
        System.out.println("Podaj kod kraju, o którym chcesz zobaczyć informacje:");
        String requestedCountry = scanner.nextLine();
        getCountryFromMap(countryMap, requestedCountry);
    }

    static Map<String, Country> convertFileIntoMap(File inputFile) {
        String line;
        String separator = ";";
        Map<String, Country> countryMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            while ((line = br.readLine()) != null) {
                String[] country = line.split(separator);
                countryMap.put(country[0], new Country(country[1], country[0], Integer.parseInt(country[2])));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return countryMap;
    }

    static void getCountryFromMap(Map<String, Country> countryMap, String requestedCountry) {
        if (countryMap.containsKey(requestedCountry)) {
            System.out.println(countryMap.get(requestedCountry));
        } else {
            System.out.println("Kod kraju " + requestedCountry + " nie został znaleziony.");
        }
    }
}
