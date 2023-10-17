import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CodeRunner {


    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        String directory = "src/contacts/";
        String filename = "contacts.txt";

        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);

        if (Files.notExists(dataDirectory)) {
            Files.createDirectories(dataDirectory);
        }

        if (!Files.exists(dataFile)) {
            Files.createFile(dataFile);
        }

        // contains contacts
        List<String> fileInfo = Files.readAllLines(dataFile);

        // loop variable
        boolean flag = true;

        do {
            System.out.println();
            System.out.println("Hello, welcome to the phone company. Please select a option below.");

            System.out.println(
                    "1. View all contacts.\n" +
                            "2. Add a new contact.\n" +
                            "3. Search a contact by name.\n" +
                            "4. Delete an existing contact.\n" +
                            "5. Exit.\n" +
                            "Enter an option (1, 2, 3, 4 or 5):\n");

            // scanner
            String input1 = scanner.nextLine();

            // input validation
            if(Integer.valueOf(input1)< 1 || Integer.valueOf(input1)>5){

                System.out.println("INVALID INPUT TYPE!");
                System.out.println("PLEASE ENTER A NUMBER BETWEEN 1 AND 5.");

            } else if (input1.equals("1")) {


                System.out.println("     Name       | Phone Number      |");
                System.out.println("     ---------- | ---------------   |");


                int count = 0;
                for (String oneLine : fileInfo) {
                    count++;
                    String[] data = oneLine.split(", ");
                    String number = data[1].replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1)-$2-$3");   //(123) 456-7890

                    System.out.printf("%15d | %15s | %14s    |\n",count, data[0],number);
                }

            } else if (input1.equals("2")) {

                System.out.println("Enter name and number separated by a comma \",  \" followed by a \"space\"");

                input1 = scanner.nextLine().toLowerCase();

                //log to visualize input remove when fixed
                System.out.println(input1.split(", ")[0]);

                if(!input1.contains(", ")){

                    System.out.println("\nInvalid Entry, please separate name and phone number with a \"comma\" -> \", \"");
                    //todo BONUS
                    //todo need to fix
                } else if(fileInfo.contains(input1.split(" ")[0])){

                    System.out.println("There's already a contact named Jane Doe. Do you want to overwrite it? (Yes/No)\n");

                    String input2 = scanner.nextLine();

                    if(input2.equals("y")){

                        //todo BONUS
                        //todo need to finish
                        fileInfo.set(fileInfo.indexOf(input1),input1);
                    }


                } else {

                    Files.write(
                            Paths.get(directory, filename),
                            Arrays.asList(input1),// list with one item
                            StandardOpenOption.APPEND
                    );
                }
            } else if (input1.equals("3")) {

                System.out.println("Enter name");

                input1 = scanner.nextLine().toLowerCase();

                String finalInput = input1;

                for (String oneLine : fileInfo) {
                    //When using bar character \\ is needed to escape its normal function
                    String[] data = oneLine.split(", ");

                    if (finalInput.equals(data[0].toLowerCase())) {
                        System.out.println("     Name       | Phone Number      |");
                        System.out.println("     ---------- | ---------------   |");

                        String number = data[1].replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1)-$2-$3");   //(123) 456-7890

                        System.out.printf("%15s | %14s    |\n",data[0], number );

                    } else {

                        //todo no mention of this feature in the exercise requirements, just good UX
                        //todo need to refactor to sout not found message only once.
                        //System.out.println("Not found");
                    }
                }

            } else if (input1.equals("4")) {

                System.out.println("Who's number would you like to delete?");

                System.out.println("     Name       | Phone Number      |");
                System.out.println("     ---------- | ---------------   |");

                // loop to display contacts
                for (String oneLine : fileInfo) {
                    String[] data = oneLine.split(", ");

                    String number = data[1].replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1)-$2-$3");   //(123) 456-7890

                    System.out.printf("%15s | %14s    |\n",data[0],number );
                }

                //todo need to finish delete feature, need to figure out how to select a specific contact to delete
                System.out.println("Please select the number that corresponds with the person you wish to delete?\n");
                input1 = scanner.nextLine();
                System.out.println("Contact successfully deleted");

                // removes contact
                String newStr = String.valueOf(fileInfo.remove(Integer.parseInt(input1) - 1));
                Files.write(
                        Paths.get("src", "contacts.txt"),
                        fileInfo);

                // exits out of the loop
            } else if (input1.equals("5")) {

                System.out.println("Thank you for using our services. Have a nice day.");
                flag = false;
            }
        } while (flag);

    }






}
