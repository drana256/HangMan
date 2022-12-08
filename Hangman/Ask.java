/*
This class asks the user for a value and returs the user input.
*/
import java.util.Scanner;
public class Ask 
{
    public static char user()
    {
        Scanner user = new Scanner(System.in);
        try
        {
            System.out.print("Guess a Letter: ");
            char letter = user.next().charAt(0);
            return letter;
        }
        finally
        {
            user.close();       //closing the scanner class
        }
    }
}

