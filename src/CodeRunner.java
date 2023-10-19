import contacts.ContactManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class CodeRunner
    {
        public static void main(String[] args) throws IOException
        {


            String directory = "src/contacts/";
            String filename = "contacts.txt";

            Path dataDirectory = Paths.get(directory);
            Path dataFile = Paths.get(directory, filename);

            if (Files.notExists(dataDirectory))
                {
                    Files.createDirectories(dataDirectory);
                }

            if (!Files.exists(dataFile))
                {
                    Files.createFile(dataFile);
                }


            ContactManager myContactManager = new ContactManager();

            myContactManager.inputValidation();



        }


    }
