import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Sales
{
    public static void main(String[] args) throws IOException
    {
        // Declare variables
        int choice;         // One of the four options (should be 1, 2, 3 or 4)
        double saleAmount;  // Amount of sale; entered by user
        double sale;        // The sale from the file that will be printed
        double sum;         // The total of all the sales

        // Continuously ask uer for choice
        do
        {
            // Prompt the user for a choice
            System.out.println("Please enter choice - 1:  Add sale, 2: print out sales from file , 3: Print total of all sales, 4: quit program: ");

            Scanner input = new Scanner(System.in);
            choice = input.nextInt();

            // Create options
            // Option 1
            if (choice == 1)
            {
                // Create FileWriter and PrintWriter objects
                FileWriter fwriter = new FileWriter("sales.txt", true);
                PrintWriter outputFile = new PrintWriter(fwriter);

                // Prompt user for the amount of the sale
                System.out.print("Enter the individual sale amount: ");
                saleAmount = input.nextDouble();
                outputFile.println(saleAmount);

                outputFile.close();
            }
            // Option 2: Print out all sales in the file
            else if (choice == 2)
            {
                // Load file
                File myFile = new File("sales.txt");
                Scanner inputFile = new Scanner(myFile);

                // Read in all the data from the file
                while (inputFile.hasNext())
                {
                    sale = inputFile.nextDouble();
                    System.out.printf("%.2f\n", sale);
                }
                inputFile.close();
            }
            // Option 3: Print the total of all the sales
            else if (choice == 3)
            {
                // Load file
                File myFile = new File("sales.txt");
                Scanner inputFile = new Scanner(myFile);

                // Initialize sum variable
                sum = 0;

                // Sum up all the data
                while (inputFile.hasNext())
                {
                    sum += inputFile.nextDouble();
                }
                inputFile.close();


                System.out.printf("The total is %f.\n", sum);
            }

            else if (choice == 0)
            {
                // Load file
                File myFile = new File("sales.txt");
                Scanner inputFile = new Scanner(myFile);

                // find the largest value
                double largest = 0;
                while (inputFile.hasNext())
                {
                    double value = inputFile.nextDouble();
                    if (value > largest)
                    {
                        largest = value;
                    }
                }

                System.out.printf("Largest value: %f\n", largest);
            }
        } while (choice != 4);  // terminates program

    }
}
