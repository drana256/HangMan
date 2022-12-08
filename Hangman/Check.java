import java.io.IOException;
import java.util.ArrayList;

public class Check 
{
    private ArrayList<String> _toCheck = new ArrayList<String>();
    
    public Check(ArrayList<String> word)
    {
        _toCheck = word;
    }    

    public void checking() 
    {
        String selectedWord = _toCheck.get(0);
        String[] dash = new String[selectedWord.length()];
        char[] finalword = new char[selectedWord.length()];
        int attempt = 0;
        for (int i=0; i<selectedWord.length(); i++)
        {
            dash[i]= " _ ";
            System.out.print(dash[i]);
        }    
        while(attempt != 5)
        {
            char _userInput = Ask.user();
            for(int i=0; i<selectedWord.length(); i++)
            {
                if (selectedWord.charAt(i)==_userInput)
                {
                   finalword[i] = _userInput;
                }
            }
            attempt++;
        }
        
        for(int i=0; i<dash.length; i++)
        {
            System.out.println(finalword[i]);
        }
        
    }
   
}
