
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
public class FileHandlingQuestion5
{
    public static void SearchByTerm(String termChoice) throws IOException {
        FileReader fr = new FileReader("Terms.txt");
        BufferedReader br = new BufferedReader(fr);

        String lineOne;
        String lineTwo;
        int total = 0;
        while ((lineOne = br.readLine()) != null) {
            if (lineOne.equals(termChoice)) {
                System.out.println("FOUND... " + (lineTwo = br.readLine()));
                total += 1;
            }
        }

        if (total == 0) {
            System.out.println("TERM NOT FOUND");
        }
    }

    public static void SearchDescriptionsForKeyword(String keyWord) throws IOException {
        FileReader fr = new FileReader("Terms.txt");
        BufferedReader br = new BufferedReader(fr);

        String lineOne;
        String lineTwo;
        int total = 0;
        while ((lineOne = br.readLine()) != null) {
            if ((lineTwo = br.readLine()).contains(keyWord)) {
                System.out.println("FOUND for " + lineOne);
                System.out.println(lineTwo);
                total += 1;
            }
        }

        if (total == 0) {
            System.out.println("NO DESCRIPTIONS FOUND containing this keyword");
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int choice;
        String cont = "yes";
        do {
            System.out.println("1. Search for a term.");
            System.out.println("2. Search for a keyword in the descriptions.");
            System.out.println("3. End");
            System.out.println("Key in choice");
            do {
                choice = input.nextInt();
            } while(choice<1 || choice>3);

            if (choice == 1) {
                System.out.print("Term...? ");
                String termChoiceFirst = input.nextLine();
                termChoiceFirst = input.nextLine();
                String termChoice = termChoiceFirst.toLowerCase();
                SearchByTerm(termChoice);
            }
            else if (choice == 2) {
                System.out.print("Key Word...? ");
                String keyWordFirst = input.nextLine();
                keyWordFirst = input.nextLine();
                String keyWord = keyWordFirst.toLowerCase();
                SearchDescriptionsForKeyword(keyWord);
            }
            else {
                System.exit(0);
            }

            System.out.println("Do you wish to continue, yes or no?");
            String cont1 = input.nextLine();
            cont = cont1.toLowerCase();
        } while (cont.equals("yes"));

    }

}
