import java.util.Scanner;
import java.io.File;
import java.io.IOException;
public class dfa_4700 
{
	public static void main(String[] args) throws IOException 
	{
		String fileName = "DFA1.txt";
		File inputFileName = new File(fileName);
		Scanner readFile = new Scanner(inputFileName);
		String alphabet = readFile.next();
		readFile.nextLine();
		int num_Of_State = readFile.nextInt();
		readFile.nextLine();		
		Data []obj = new Data[num_Of_State];
		
		for(int i = 0; i < num_Of_State ; i++)
		{
			String check_for_semicolon = "";
			while(!check_for_semicolon.equals(";"))
			{
				int a = readFile.nextInt();
				int b = readFile.nextInt();
				obj[i] = new Data(a,b);
				
				check_for_semicolon = readFile.next();
			}// while loop
			
			readFile.nextLine();
		}// for loop
		
		int accept_State = readFile.nextInt();		
		boolean isStop = false;
		
		while(isStop == false)
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("Please Enter a string: " );
			String string = sc.next();
			int currentState = 0; // start state
			
			for( int i = 0 ; i < string.length() ; i++)
			{
				System.out.println("Current state = "+ currentState +" and Current input char = " +string.charAt(i));
				currentState = NextState(string.charAt(i), currentState, obj);
				
				if(currentState == -1)
				{
					System.out.println("Invalid input, only include a or b in the string. " );
					i = string.length();
				}//if
				
			}// for loop
			
			if(currentState == accept_State)
			{
				System.out.println("String " + string + " is accepted.");
			}//if
			else
			{
				System.out.println("String " + string + " is rejected.");
			}//else
			
			System.out.println("\nDo you want to continue?Press 1 to continue. " );
			String input = sc.next();
			
			if(!input.equals("1"))
			{
				isStop = true;
				System.out.print("You decided to end the Program.");	
			}//if
			sc.close();
		}//while loop	

		readFile.close();
	}// main

	private static int NextState(char charAt, int currentState, Data[] obj) 
	{
		int num = 0;
		
		if(charAt == 'a' || charAt == 'A')
		{
			num = obj[currentState].getA();
		}
		else if(charAt == 'b' || charAt == 'B')
		{
			num = obj[currentState].getB();
		}
		else
		{
			num = -1;
		}
		
		return num;
	}// NextState
}// dfa_4700

class Data
{
	private int a, b;
	
	public Data(int a, int b)
	{
		this.a = a;
		this.b = b;
	}
	public int getA()
	{
		return a;
	}
	public int getB()
	{
		return b;
	}
}// class data
