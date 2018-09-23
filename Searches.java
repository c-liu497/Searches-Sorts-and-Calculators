/*
Name: Caroline Liu
Name of Program: Searches
Date: April 10th, 2016
Teacher:Ms. Dyke
Purpose: The purpose of this program is to display a menu that allows
you to show a series of searches using graphics. Choosing 1 
shows you a sequential search, and choosing 2 shows you a binary
search. Both searches will display a randomly generated array of
values. Both searches then display some graphics, before displaying 
the index of the number. Choosing 3 exits the program.
*/
import java.awt.*;
import hsa.*;
import java.util.Random;
public class Searches
{
    int a[] = new int [20];
    Console c;
    Random r = new Random ();
    int searchKey;
    String choice;
    private void title ()
    {
	c.clear ();
	c.print (' ', 35);
	c.println ("Searches!");
	c.println ();
    }


    private void pauseProgram ()
    {
	c.print ("Press any key to continue: ");
	c.getChar ();
    }


    public void menu ()
    {
	title ();
	c.println ("MENU:");
	c.println ("1.Sequential");
	c.println ("2.Binary");
	c.println ("3.Quit");
	c.println ();
	c.println ("Please enter either 1,2, or 3:");
	choice = c.readLine ();
	if (!choice.equals ("1") && !choice.equals ("2") && !choice.equals ("3"))
	{
	    c.setCursor (20, 1);
	    c.println (" ERROR! Please enter only 1, 2, 3!");
	    menu ();
	}
    }


    public void makeArray ()
    {
	for (int i = 0 ; i < 20 ; i++)
	{
	    a [i] = r.nextInt (100) + 1;
	}
    }


    private void printArray ()
    {
	c.setColor (Color.black);
	int counter = 0;
	Font f = new Font ("TimesRoman", Font.PLAIN, 15);
	for (int i = 0 ; i < 20 ; i++)
	{
	    c.drawString (Integer.toString (a [i]), 10 + counter, 250);
	    counter = counter + 30;
	}
    }


    public void askPrompt ()
    {
	while (true)
	{
	    c.setCursor (7, 1);
	    c.println ();
	    c.setCursor (5, 1);
	    c.println ("Please enter the integer value that you would like to search for in the array \nof values below: ");
	    try
	    {
		searchKey = Integer.parseInt (c.readLine ());
		break;
	    }
	    catch (NumberFormatException e)
	    {
		new Message ("Please only  enter an integer!", "ERROR!");
	    }
	}
    }


    private void delay ()
    {
	try
	{
	    Thread.sleep (700);
	}
	catch (Exception e)
	{
	}
    }


    public void sequential (int[] a)
    {
	title ();
	int index = -1;
	printArray ();
	askPrompt ();
	for (int i = 0 ; i < 20 ; i++)
	{
	    delay ();
	    c.setColor (Color.green);
	    c.fillRect (10 + i * 30, 235, 15, 15);
	    c.setColor (Color.white);
	    c.fillRect (10 + (i - 1) * 30, 235, 15, 15);
	    printArray ();
	    if (searchKey == a [i])
	    {
		index = i;
		break;
	    }
	}
	if (index==-1)
	{
	c.setColor(Color.white);
	c.fillRect (10 + 19 * 30, 235, 15, 15);
	printArray();
	}
	c.setCursor (20, 1);
	c.println ("The index of the value you searched for is: " + index);
	pauseProgram ();
    }


    private void insertionSort ()
    {
	for (int i = 1 ; i < a.length ; i++)
	{
	    int current = a [i];
	    int x;
	    for (x = i - 1 ; x >= 0 && current < a [x] ; x--)
	    {
		a [x + 1] = a [x];
	    }
	    a [x + 1] = current;
	}
	c.print ("Sorted List: ");
	for (int y = 0 ; y < a.length ; y++)
	{
	    c.print (a [y] + " ");
	}
    }


    public int binarySearch (int num)
    {
	int end = a.length - 1;
	int start = 0;
	c.println ();
	c.print ("LOW", 20);
	c.print ("MID", 20);
	c.println ("HIGH");
	while (end >= start)
	{
	    delay ();
	    int mid = (start + end) / 2;

	    c.print (start, 1);
	    c.print (mid, 20);
	    c.println (end, 22);
	    if (a [mid] == num)
	    {
		c.println ();
		return mid;
	    }
	    if (a [mid] > num)
		end = mid - 1;
	    if (a [mid] < num)
		start = mid + 1;
	}
	c.println ();
	return -1;
    }


    public void display ()
    {
	title ();
	insertionSort ();
	askPrompt ();
	c.println ("The number you have searched was first found at the index: [" + binarySearch (searchKey) + "].");
	pauseProgram ();
    }


    public Searches ()
    {
	c = new Console ();
    }


    public void goodbye ()
    {
	title ();
	c.println ("Thanks for using my program! Bye!");
	c.println ();
	c.println ("Program by Caroline Liu");
	pauseProgram ();
	c.close ();
    }


    public static void main (String[] args)
    {
	Searches s = new Searches ();
	while (true)
	{
	    s.menu ();
	    if (s.choice.equals ("3"))
	    {
		break;
	    }
	    else
	    {
		s.makeArray ();
		if (s.choice.equals ("1"))
		{
		    s.sequential (s.a);
		}
		else
		{
		    s.display ();
		}
	    }
	}
	s.goodbye ();
    } // main method
} // Searches class


