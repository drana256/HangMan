/*
This class asks the user for a value and returs the user input.
*/
import java.util.Scanner;
public class Ask 
{
    public static char user()
    {
        Scanner sc = new Scanner(System.in);
        char letter = sc.next().charAt(0);
        return letter;
    }
}

