/*Name: Caroline Liu
Name of Program: Sorts
Date of Creation: April 7,2016
Sorts To Person: Selection Sort: Samantha Unger
Insertion Sort: Esther Yoo
Merge Sort: Caroline Liu
Purpose: The purpose of this program is to display a menu that allows
you to see a type of sort represented with colour graphics. The
user can choose to see a selection sort, an insertion sort, and
a merge sort.
*/
import java.awt.*;
import hsa.*;
import java.util.Random;

public class Sorts
{
    Console c;
    String choice;
    int[] a = new int [10];
    int counter1 = 0;
    int counter = 40;

    ;
    public void drawTitle ()
    {
	c.clear ();
	c.print (" ", 37);
	c.println ("Sorts!");
	c.println ();
    }


    public void pauseProgram ()
    {
	c.setCursor (23, 1);
	c.print ("Press any key to continue: ");
	c.getChar ();
    }


    public void menu ()
    {
	drawTitle ();
	c.println ("Menu:");
	c.println ("1. Selection Sort");
	c.println ("2. Insertion Sort");
	c.println ("3. Merge Sort");
	c.println ("4. Quit");
	c.println ();
	c.println ("Please choose either 1,2,3,or 4:");
	choice = c.readLine ();
	if (!choice.equals ("1") && !choice.equals ("2") && !choice.equals ("3") && !choice.equals ("4"))
	{
	    c.setCursor (20, 1);
	    c.println ("ERROR!Please enter only 1, 2, 3 or 4!");
	    pauseProgram ();
	    menu ();
	}
    }


    public void mergeSort (int a[], int left, int right)
    {
	if (left < right)
	{
	    int middle = (left + right) / 2;
	    //splits array into sections from left
	    mergeSort (a, left, middle);
	    //splits array into sections from right
	    mergeSort (a, middle + 1, right);
	    c.setColor (Color.green);
	    c.fillRect (30, 110 + (counter1) * 30, 600, 20);
	    c.setColor (Color.black);
	    c.fillRect (30 + (left) * 60, 110 + (counter1) * 30, 2, 20);
	    c.fillRect (30 + (middle + 1) * 60, 110 + (counter1) * 30, 2, 20);
	    c.fillRect (30 + (right + 1) * 60, 110 + (counter1) * 30, 2, 20);
	    printArray (a, a.length, counter1);
	    merge (a, left, middle, right);
	    delay ();
	    c.setColor (Color.green);
	    c.fillRect (30, 110 + (counter1) * 30, 600, 20);
	    c.setColor (Color.black);
	    c.fillRect (30 + (left) * 60, 110 + (counter1) * 30, 2, 20);
	    c.fillRect (30 + (right + 1) * 60, 110 + (counter1) * 30, 2, 20);

	    printArray (a, a.length, counter1++);
	    delay ();
	}

    }


    public void merge (int a[], int left, int middle, int right)
    {
	int d, e, f;
	//array holding left half
	int[] b = new int [5];
	//array holding right half
	int[] c = new int [5];
	//left half length
	int leftL = middle - left + 1;
	//right half length
	int rightL = right - middle;

	//copies number into arrays
	for (d = 0 ; d < leftL ; d++)
	{
	    b [d] = a [left + d];
	}
	//copies numbers into right array
	for (e = 0 ; e < rightL ; e++)
	{
	    c [e] = a [middle + 1 + e];
	}
	d = 0;
	e = 0;
	f = left;
	//
	while (d < leftL && e < rightL)
	{
	    if (b [d] <= c [e])
	    {
		a [f] = b [d];
		d++;
	    }
	    else
	    {
		a [f] = c [e];
		e++;
	    }
	    f++;
	}

	while (d < leftL)
	{
	    a [f] = b [d];
	    d++;
	    f++;
	}
	while (e < rightL)
	{
	    a [f] = c [e];
	    e++;
	    f++;
	}
    }


    public void makeArray ()
    {
	Random r = new Random ();
	for (int i = 0 ; i < 10 ; i++)
	{
	    a [i] = (r.nextInt (100) + 1);
	}
	c.println ("Unsorted List:");
	printArray (a, a.length, -2);
    }


    public void delay ()
    {
	try
	{
	    Thread.sleep (800);
	}
	catch (Exception e)
	{
	}
    }


    public Sorts ()
    {
	c = new Console ();
    }


    public void printArray (int a[], int size, int ySpace)
    {
	int i;
	int counter2 = 0;
	c.setColor (Color.black);
	Font f = new Font ("TimesRoman", Font.PLAIN, 15);
	for (i = 0 ; i < size ; i++)
	{
	    c.setFont (f);
	    c.drawString (Integer.toString (a [i]), 40 + counter2, 130 + (ySpace * 30));
	    counter2 = counter2 + 60;
	}
    }


    public void selectionSort (int[] demoArray)
    {
	drawTitle ();
	makeArray ();
	int lowestIndex;
	int spaceCounter;
	int counter;
	int num;
	for (int x = 0 ; x < 10 ; x++)
	{
	    lowestIndex = x;
	    for (int y = x + 1 ; y < 10 ; y++)
	    {
		if (demoArray [y] < demoArray [lowestIndex])
		{
		    lowestIndex = y;
		}
	    }
	    spaceCounter = x;
	    counter = 60;
	    while (spaceCounter < 10)
	    {
		c.setColor (Color.red);
		c.fillRect (40 + x * 60, 110 + (x * 30), 20, 20);
		c.setColor (Color.green);
		c.fillRect (40 + x * 60 + counter, 110 + (x * 30), 20, 20);
		if (spaceCounter != x)
		{
		    c.setColor (Color.white);
		    c.fillRect (40 + (x) * 60 + (counter - 60), 110 + (x * 30), 20, 20);
		}
		counter = counter + 60;
		printArray (demoArray, demoArray.length, x);
		spaceCounter++;
		delay ();
	    }
	    c.setColor (Color.pink);
	    c.fillRect (40 + lowestIndex * 60, 110 + (x * 30), 20, 20);
	    c.setColor (Color.red);
	    c.fillRect (40 + x * 60, 110 + (x * 30), 20, 20);
	    printArray (demoArray, demoArray.length, x);
	    delay ();
	    if (lowestIndex != x)
	    {
		num = demoArray [x];
		demoArray [x] = demoArray [lowestIndex];
		demoArray [lowestIndex] = num;
	    }
	}
	pauseProgram ();
    }


    private void insertG (int[] array, int sortingNum, int y)
    {
	c.setColor (Color.green);
	c.fillRect (40 + sortingNum * 60, 110 + y * 30, 20, 20);
	c.fillRect (40 + (sortingNum - 1) * 60, 110 + y * 30, 20, 20);
	c.setColor (Color.white);
	c.fillRect (40 + (sortingNum + 1) * 60, 110 + y * 30, 20, 20);
	printArray (array, array.length, y);
	delay ();
    }


    public void insertionSort (int[] array)
    {
	drawTitle ();
	makeArray ();
	int temp;
	int y = 0;
	int currentNum = 1;
	int sortingNum = 1;
	while (true)
	{
	    sortingNum = currentNum;
	    while (array [sortingNum] < array [sortingNum - 1])
	    {
		temp = array [sortingNum];
		insertG (array, sortingNum, y);
		array [sortingNum] = array [sortingNum - 1];
		array [sortingNum - 1] = temp;
		c.setColor (Color.white);
		c.fillRect (40, 110 + y * 30, 600, 290);
		printArray (array, array.length, y);
		insertG (array, sortingNum, y);
		if (sortingNum != 1)
		{
		    sortingNum--;
		}
	    }
	    printArray (array, array.length, y);
	    currentNum++;
	    y++;
	    if (currentNum == 10)
		break;
	}
	pauseProgram ();
	return;

    }


    public void goodbye ()
    {
	drawTitle ();
	c.println ("Thanks for using my program! By:Caroline Liu");
	pauseProgram ();
	c.close ();
    }


    public static void main (String[] args)
    {
	Sorts s = new Sorts ();
	while (true)
	{
	    s.menu ();
	    if (s.choice.equals ("4"))
	    {
		break;
	    }
	    else
	    {
		if (s.choice.equals ("1"))
		{
		    s.selectionSort (s.a);
		}
		else if (s.choice.equals ("2"))
		{
		    s.insertionSort (s.a);
		    s.printArray (s.a, s.a.length, 9);
		}
		else
		{
		    s.drawTitle ();
		    s.makeArray ();
		    s.counter1 = 0;
		    s.mergeSort (s.a, 0, 9);
		    s.printArray (s.a, s.a.length, 9);
		    s.pauseProgram ();
		}
	    }
	}
	s.goodbye ();
    } // main method
} // Sorts5 class
