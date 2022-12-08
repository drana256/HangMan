import java.util.ArrayList;

public class Check
{
    private static ArrayList<String> _toCheck = new ArrayList<String>();
    static String guiDash = "";

    public Check(ArrayList<String> word)        //constructor to set teh contents of the file into an arraylist
    {
        _toCheck = word;
    }    

    public static void checking(int _wordNumber, int chances)  //method to run the game
    {
        int _lives = chances;
        String selectedWord = _toCheck.get(_wordNumber);        //getting the word from the arraylist
        char[] dash = new char[selectedWord.length()];
        String afterGuessing = new String();

        for (int i=0; i<selectedWord.length(); i++)         //method to dash the selected word from the file
            {
                dash[i]= 95;
                guiDash = guiDash + " " + dash[i];
            }    

        GUI.set_dash(guiDash);          //displays the dashed word into the gui text area, _dash

        while(_lives!= 0)
        {
            char _userInput = GUI.returnIput();
            boolean attempt=false;
            int wordCounter = 0;

            for(int i=0; i<selectedWord.length(); i++)      //Checks if the word contains the input letter or not
            {
                if (selectedWord.charAt(i)==_userInput)
                {
                        dash[i] = _userInput;
                        attempt=true;
                }
            }
            afterGuessing = "";         //clearing the string to that it would not repeat the contents 
            for(int i=0; i<selectedWord.length(); i++)      //changing the displayed dashes with the dashes with correct input other wise printing just the dashes
            {
                    afterGuessing = afterGuessing+ " " + dash[i];
            }
            GUI.set_dash("");               //clearing the _dash text area
            GUI.set_dash(afterGuessing);    //displaying the String after guess into the _dash text area

            for(int i=0; i<selectedWord.length(); i++)      //checks if there are any empty dash left or not
            {
                if(dash[i]!=95)
                {
                    wordCounter++;
                }      
                if(wordCounter==selectedWord.length())
                {
                    _lives=0;
                }
            }
            if (attempt==false)         //if there is a worng entry a message diagolue box is displayed
            {
                GUI.failedAttempt();
                _lives--;
            }    
        }
        GUI.set_dash("");       //resetting the _dash text area
    }
}
