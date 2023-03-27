import java.util.*;

public class Passenger
{
	private String First_Name_;
	private String Surname_;
	private int Expenses_;

	private static final Scanner input = new Scanner(System.in);
	public Passenger ()
	{
		this.First_Name_="Not reserved";
		this.Surname_="Not reserved";
		this.Expenses_=0;
	}
	//First name
	protected void set_Firstname(int cabin_num,int x)
	{
		System.out.print("Enter cabin "+(cabin_num)+" Passenger "+ (x+1) +" first name :");
		this.First_Name_=input.next();
	}
	//sur name
	protected void set_Surname(int cabin_num,int x)
	{
		System.out.print("Enter cabin "+(cabin_num)+" Passenger "+ (x+1) +" Surname :");
		this.Surname_=input.next();
	}

	protected void Set_Expenses(int cabin_num,int x)
	{
		while (true)
		{
			System.out.print("Enter cabin "+(cabin_num)+" Passenger "+ (x+1) +" Expenses :");
			if (input.hasNextInt())
			{
				this.Expenses_=input.nextInt();
				break;
			}
			else
			{
				System.out.println("Wrong input");
				input.next();
			}
		}
	}

	protected String get_Firstname()//back to First name
	{
		return this.First_Name_;
	}

	protected String get_Surname()//back to surname
	{
		return this.Surname_;
	}

	protected int get_Expenses()//return expenses
	{
		return this.Expenses_;
	}

	protected void clear_passenger()//Reset the data
	{
		this.Expenses_=0;
		this.First_Name_="Not reserved";
		this.Surname_="Not reserved";
	}
}