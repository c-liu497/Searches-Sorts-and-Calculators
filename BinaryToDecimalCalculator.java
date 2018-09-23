/*Name:Caroline Liu
Name of Program: Binary to Decimal Calculator
Teacher:Ms.Dyke
Date: November 18th, 2015
Assignment: The purpose of this program is to convert a binary number
that the user inputs into a decimal number. The user will first see a
screen with the title and some 1's and 0's. After 5 seconds, the screen
will change and the main menu will be shown. The user can choose to either
continue, see the instructions, or exit, by choosing either 1,2, or 3. If
the user does not enter a proper option an error will appear and they will
have to re-enter their input. If they choose "2" the instructions will appear,
and they will be asked to press any key in order to return to the main menu.
If they choose "1", a line will appear asking the m for input. The user must
enter a binary number, or else an error message will appear. Once they enter
in a correct input calculations will be done, and the final value, and the
value the user inputted will be on the screen. The user must t, which will
allow the user to exit the program. A message will appear, along with the
creator's name, before the user is asked to press any key. Pressing a key
will cause the screen to close.
Instance/console variables:
Name              Type       Purpose
c             reference      refer/allows access to the Console class,
			     allowing us to use methods from the Console
			     class.
binaryInput   integer        stores the binary number that the user wants
			     to convert into a decimal number.
choice        string         stores the users' choice on whether to continue
			     with the program, see the instructions, or exit.
*/
import java.awt.*;
import hsa.*;
//import java.lang.String;

public class BinaryToDecimalCalculator
{
    Console c;
    String choice;
    int binaryInput;
    /* method drawTitle:The purpose of this method is to display the title
    ofthis program, which is "Binary to Decimal". The title is
    centred.This method also clears the screen.
    */
    private void drawTitle ()
    {
	c.clear ();
	c.print (' ', 31);
	c.println ("Binary to Decimal");
	c.println ();
    }


    /* method pauseProgram: The purpose of this method is to pause the program
       whenever necessary. It outputs a line asking the user to press any key
       to continue.
    */
    private void pauseProgram ()
    {
	c.println ();
	c.print ("Press any key to continue: ");
	c.getChar ();
    }


    /*method splashScreen: The purpose of this method is to act as a title
      screen for the program. It displays some graphics(some 1's and 0's)
      and it appears for 5 seconds. The try-catch is used to errortrap the
      delay.
      Local variables:
      Name          Type             Purpose
      oneX      integer(array)     stores the x values of the leftmost "1"
      oneY      integer(array)     stores the y values of both "1"'s
      oneX1     integer(array)     stores the x values of the rightmost "1"
    */
    public void splashScreen ()
    {
	int oneX[] = {120, 150, 150, 120, 120, 100, 80};
	int oneY[] = {200, 200, 400, 400, 240, 260, 240};
	int oneX1[] = {400, 430, 430, 400, 400, 380, 360};

	drawTitle ();
	c.setColor (Color.blue);
	c.fillOval (200, 200, 125, 200);
	c.fillOval (500, 200, 125, 200);
	c.fillPolygon (oneX, oneY, 7);
	c.fillPolygon (oneX1, oneY, 7);
	c.setColor (Color.white);
	c.fillOval (225, 225, 75, 150);
	c.fillOval (525, 225, 75, 150);

	try
	{
	    Thread.sleep (5000);
	}
	catch (Exception e)
	{
	}
    }


    /* method mainMenu: The purpose of this method is to output the options
    that the user can choose, based on what they want to do. They can either
    continue with the program(option 1), see the instructions(option 2),
    or exit the program(option 3). The if structure is used to display an
    error message if the user enters an input that is not one of the 3
    options. It also recalls mainMenu. drawTitle is called in the
    beginning to clear the screen.
    */
    public void mainMenu ()
    {
	drawTitle ();
	c.println ("1.Continue");
	c.println ("2.Instructions");
	c.println ("3.Exit");
	c.print ("Please press 1,2,or 3: ");

	choice = c.readLine ();
	if (!choice.equals ("1") && !choice.equals ("2") && !choice.equals ("3"))
	{
	    new Message ("Please enter only 1,2, or 3!", "ERROR!");
	    mainMenu ();
	}
    }


    /*method instructions:The purpose of this method is to display the
     instructions pertaining to the use of the program.The method pauseProgram
     is called as well, so the user must press a key in order to return to
     the menu. The method drawTitle is called in order to clear the screen
     and display the title.
    */
    public void instructions ()
    {
	drawTitle ();
	c.println ("This program converts binary numbers to decimal numbers.");
	c.println ("If you choose the 1st option(continue) in the main menu, you will then be asked to enter a binary number that you want to be converted.");
	c.println ("(If you enter in an incorrect number, an error window will appear, and you will then have to re-enter your input.)");
	c.println ("The screen will then display your input and your converted number.");
	c.println ("Enjoy converting numbers!");
	pauseProgram ();
    }


    /*method askData:The purpose of this method is to ask the user for the
    binary number that the user would like to be converted. This method also
    calls drawTitle.
     Local variables:
      Name          Type             Purpose
      testString     string           used to hold the user input to be tested
      emptyInt        int              used to hold user input while it's
				       being tested.
    */
    public void askData ()
    {
	String testString = "a";
	int emptyInt = 2;
	drawTitle ();
	while (true)
	{
	    try
	    {
		c.setCursor (3, 1);
		c.println ();
		c.setCursor (3, 1);
		c.print ("Please enter the binary number you'd like to convert: ");
		testString = c.readLine ();
		emptyInt = Integer.parseInt (testString, 2);
		if (emptyInt < 0)
		{
		    new Message ("Please enter a positive binary number!", "ERROR!");
		    askData ();
		}
		else
		    break;
	    }
	    catch (NumberFormatException e)
	    {
		new Message ("Please enter only a binary number!", "ERROR!");
	    }
	}
	binaryInput = Integer.parseInt (testString);
    }


    /*method binaryToDecimal:The purpose of this method is to convert the
    binary number that the user entered into a decimal number. The while
    loop is used to repeat the calculations until the binary number has
    been converted. The for loop is used to create the powers of 2 needed
    for the formula. It's start condition is 0 and it's stop condition is
    i<=counter. The first if structure is used to ensure that the for loop
    doesnt run the first time the  loop runs. The second if structure is used
    to break the loop once the number ahs been converted. This is a helper
    method that returns the integer answer decimalNum.
     Variables: Name         Type       Purpose
	      twoCount       int         stores the value of the powers of
					 2 that are needed in the binary
					 to decimal formula
	      counter        int         used to create the stop condition
					 for the for loop
	      decimalNum     int         stores the final value
	      digit          int         stores a digit of the original input
	      i              int(loop)   used to count for the for loop
	      binaryInput    int         stores a parameter needed to access
					 and use the method

    */
    private int binaryToDecimal (int binaryInput)
    {
	int twoCount = 1;
	int counter = -1;
	int decimalNum = 0;
	int digit = 0;

	while (true)
	{
	    digit = binaryInput % 10;
	    if (counter >= 0)
	    {
		twoCount = 1;
		for (int i = 0 ; i <= counter ; i++)
		{
		    twoCount = twoCount * 2;
		}
	    }

	    decimalNum = decimalNum + (twoCount * digit);
	    counter++;

	    if (binaryInput == 1)
	    {
		break;
	    }

	    binaryInput = binaryInput / 10;
	}
	return decimalNum;
    }


    /* display method: The purpose of this method is to display the
       value the user inputted, and to display the converted number(which is
       a decimal). It displays the final value by calling the helper method
       binaryToDecimal (binaryInput). It then calls pauseProgram. The
       drawTitle method is called in the beginning.
       */
    public void display ()
    {
	drawTitle ();
	c.println ("The binary number you entered was " + binaryInput + " and it becomes: " + binaryToDecimal (binaryInput));
	pauseProgram ();
    }


    /*method goodBye: The purpose of this method is to output a message and
      close the screen after the user exits the program. It also calls the
      methods drawTitle and pauseProgram, and outputs the creator of the
      program's name.
    */
    public void goodbye ()
    {
	drawTitle ();
	c.println ("Thanks for using my program! By:Caroline Liu");
	pauseProgram ();
	c.close ();
    }


    /*constructor method:This method creates/initializes the console class.
      It also allows a window title to be made.
    */
    public BinaryToDecimalCalculator ()
    {
	c = new Console ("Binary to Decimal Calculator");
    }


    /*main method: This method is used to call all the methods within the
      class BinaryToDecimalCalculator class in the right order. The while
      loop is used to loop the program in order to display the screens in
      the proper order. It also only allows the program to end when
      the user chooses the exit option. The if structure is used in
      order to display the proper screens, depending on what the user has
      chosen.
      Variables: Name         Type       Purpose
		      b       reference   refers/allows access to the
					  BinaryToDecimalCalculator
					  class, allowing us to use the methods
					  within the class.
     */
    public static void main (String[] args)
    {

	BinaryToDecimalCalculator b = new BinaryToDecimalCalculator ();
	b.splashScreen ();
	while (true)
	{
	    b.mainMenu ();
	    if (b.choice.equals ("1"))
	    {
		b.askData ();
		b.display ();
	    }
	    else if (b.choice.equals ("2"))
	    {
		b.instructions ();
	    }
	    else
	    {
		break;
	    }
	}
	b.goodbye ();
    }
}



// Place your program here.  'c' is the output console
// main method
// BinaryToDecimalCalculator class
