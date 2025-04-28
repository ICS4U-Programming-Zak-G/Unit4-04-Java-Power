// Import libraries
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
* This program uses recursion to calculate the power of a number.
*
* @author  Zak Goneau
* @version 1.0
* @since   2025-04-28
*/

// Creating class
public final class RecPow {

    /**
     * This is a private constructor used to satisfy the style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private RecPow() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the main method.
     *
     * @param args Unused.
     * @throws Exception - Input/Output exception
     */

    public static void main(final String[] args) throws Exception {

        // Initialize output string
        String outputStr = "";

        // Open file writer to write to output file
        final FileWriter myWriter = new FileWriter("output.txt");

        // Introduce program to user
        System.out.println("This program uses recursion to "
                + "calculate the power of a number. "
                + "The output will be in a file.");

        // Open input file and prepare to read
        final File file = new File("./input.txt");
        final Scanner scanner = new Scanner(file);

        // Loop while there's another line in the file
        while (scanner.hasNextLine()) {

            // Get current line from file
            final String line = scanner.nextLine();

            // Split line into parts by space
            final String[] lineArray = line.split(" ");

            // Check if array has two values
            if (lineArray.length != 2) {
                // Add to output string that array does not have two values
                outputStr += "Please enter two integers only.\n";

            // Otherwise array has two values
            } else {
                // Try to convert first value to integer
                try {
                    // Cast first value to integer for base
                    final int base = Integer.parseInt(lineArray[0]);

                    // Try to convert second value to integer
                    try {
                        // Cast second value to integer for exponent
                        final int exponent = Integer.parseInt(lineArray[1]);

                        // Check if exponent is positive
                        if (exponent < 0) {
                            // Add to output string if exponent is negative
                            outputStr += exponent + " cannot be a negative "
                                + "exponent.\n";

                        // Otherwise exponent is valid
                        } else {
                            // Call function to calculate power
                            final int result = recPow(base, exponent);

                            // Add result to output string
                            outputStr += base + " ^ " + exponent
                                + " = " + result + "\n";
                        }

                    // Catch invalid exponent value and add to output string
                    } catch (NumberFormatException error) {
                        outputStr += lineArray[1]
                             + " is not a positive integer.\n";
                    }

                // Catch invalid base value and add to output string
                } catch (NumberFormatException error) {
                    outputStr += lineArray[0] + " is not an integer.\n";
                }
            }
        }

        // Write to output file
        myWriter.write(outputStr);

        // Display success message
        System.out.println("Success, the result "
                + "is printed in the output file.");

        // Close scanner
        scanner.close();

        // Close writer
        myWriter.close();
    }

    /**
    * This function calculates the power of a number.
    *
    * @param base The base value to raise to the power
    * @param exponent The power to raise the number to
    * @return The value of the number raised to the power
    */

    // Define function to calculate power
    public static int recPow(final int base, final int exponent) {
        // Set base case
        if (exponent == 0) {
            // Return number if exponent equals 0
            return 1;

        // Otherwise perform recursion
        } else {
            // Call function and return value
            return base * recPow(base, exponent - 1);
        }
    }
}
