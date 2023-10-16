
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Contacts {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        String directory = "src";
        String filename = "contacts.txt";

        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);

        if (Files.notExists(dataDirectory)) {
            Files.createDirectories(dataDirectory);
        }

        if (! Files.exists(dataFile)) {
            Files.createFile(dataFile);
        }

//        List<String> stooges = Arrays.asList("Larry : 1","Curly : 2","Moe : 3");
//
//        Files.write(dataFile, stooges);
//
//        List<String> myData = Arrays.asList("Clifford : 4", "Fenny : 5", "Javascript : 6", "Happy : 7");
//
//        Files.write(dataFile, myData, StandardOpenOption.APPEND);


//        Files.write(
//                Paths.get("src", "contacts.txt"),
//                Arrays.asList("sad : 8"), // list with one item
//                StandardOpenOption.APPEND
//        );

        List<String> fileInfo = Files.readAllLines(dataFile);

//        for (String oneLine : fileInfo) {
//            //When using bar character \\ is needed to escape its normal function
//            String[] data = oneLine.split(" : ");
//            System.out.println(data[0]);
//            System.out.println(data[1]);
////            System.out.println(data);
//
//        }

        System.out.println("Hello, welcome to the phone company. Please select a option below.");

        System.out.println(
                "1. View src.contacts.\n" +
                "2. Add a new contact.\n" +
                "3. Search a contact by name.\n" +
                "4. Delete an existing contact.\n" +
                "5. Exit.\n" +
                "Enter an option (1, 2, 3, 4 or 5):\n");

        String input1 = scanner.nextLine();

        if ( input1.equals("1")) {
            for (String oneLine : fileInfo) {
                //When using bar character \\ is needed to escape its normal function
                String[] data = oneLine.split(" : ");
                System.out.println(data[0]);
                System.out.println(data[1]);
                ;
            }
        } else if (input1.equals("2")){
            System.out.println("What is their name and number?");
            input1 = scanner.nextLine();

            Files.write(
                    Paths.get("src", "contacts.txt"),
                    Arrays.asList(input1),// list with one item
                   StandardOpenOption.APPEND
            );
        } else if (input1.equals("3")){
            System.out.println("Who would you like to search?");
            input1 = scanner.nextLine();
        } else if (input1.equals("4")){
            System.out.println("Who's number would you like to delete?");
            input1 = scanner.nextLine();
            String newStr = fileInfo.replace(input1, "");
        }



        };

    }


