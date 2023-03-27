import java.util.*;
import java.io.FileWriter;   
import java.io.IOException;  

public class Cabin {

	private String cabin_name;
	private int cabin_passengers=0;
	private int C_index;
	Passenger[]  p_array = new Passenger[3];

	
	private static final Scanner input = new Scanner(System.in);
	protected Cabin()
	{
		for (int x=0;x<3;x++)
		{
			this.p_array[x]=new Passenger();
		}
	}
	protected void cabin_booking(int cabin_number)// cabin name, number and cabin size
	{
		this.C_index = cabin_number;
		System.out.println("Enter customer name for cabin " + this.C_index+ " :");
		this. cabin_name = input.next();
		while (true)
		{
			System.out.println("Enter how many Passenger in the cabin " + this.C_index + "[maximum 3 passenger] :");
			if (input.hasNextInt())
			{
				this.cabin_passengers = input.nextInt();
				if ((this.cabin_passengers > 0) & (this.cabin_passengers < 4))
				{
					break;
				}
				else
				{
					System.out.println("Sorry! Maxmium 3 Passenger only");
				}
			}
			else
			{
				System.out.println("Enter a valid input");
				input.next();
			}
		}
	}
	protected void set_Name(String mainName)// update cabin name
	{
		this.cabin_name=mainName;
	}
	protected void set_cabin_index(int cabin_num)
	{
		this.C_index=cabin_num;
	}
	protected void set_passenger()//Passenger
	{
		for (int x=0;x<(this.cabin_passengers);x++)
		{
			System.out.println("---------------------------------------------------------------------------");
			System.out.println("Passenger " +(x+1));
			this.p_array[x].set_Firstname(this.C_index,x);
			this.p_array[x].set_Surname(this.C_index,x);
			this.p_array[x].Set_Expenses(this.C_index,x);
		}
	}
	protected String get_Name()// back to cabin name
	{
		return this.cabin_name;
	}
	protected int get_guests()// back to cabin count
	{
		return this.cabin_passengers;
	}
	protected void Passenger_detils()//when user input all the data vewing
	{
		System.out.println();

		if (this.cabin_name.equals("not booked"))
		{
			System.out.println("----cabin No." + this.C_index + " - " + this.cabin_name+"----");
		} else {
			System.out.println("----cabin No." + this.C_index + " - " + this.cabin_name + "'s cabin"+"----");
		}
		for (int x=0;x<this.cabin_passengers;x++)
		{
			System.out.println("Passenger "+(x+1)+" details");
			System.out.println("First name : "+this.p_array[x].get_Firstname());
			System.out.println("Surname    : "+this.p_array[x].get_Surname());
			System.out.println("Expenses   : "+this.p_array[x].get_Expenses());
			System.out.println();
		}
	}
	protected void clear_cabin()//clear babin
	{
		for (int x=0;x<(this.cabin_passengers);x++)
		{
			this.p_array[x].clear_passenger();
		}
		cabin_name = "not booked";
		cabin_passengers = 0;
	}
	protected int return_find_names(String find_name,int find_results)//Find customer cabin
	{
		for (int x=0;x<(this.cabin_passengers);x++)
		{
			if ((this.p_array[x].get_Surname()+" "+this.p_array[x].get_Firstname()).contains(find_name))
			{
				System.out.println("cabin " + this.C_index + " Passenger "+(x+1)+" name "+(this.p_array[x].get_Surname()+" "+this.p_array[x].get_Firstname()));
				find_results+=1;
			}
		}
		return find_results;
	}
	protected void data_store(FileWriter myWriter)//Store the data
	{
		try
		{
			myWriter.write("\n");
			if (this.cabin_name.equals("not booked"))
			{
				myWriter.write("----cabin No." + this.C_index + " - " + this.cabin_name+"----"+"\n");
			}
			else
			{
				myWriter.write("----cabin No." + this.C_index + " - " + this.cabin_name + "'s cabin"+"----"+"\n");
			}
			for (int x=0;x<this.cabin_passengers;x++)
			{
				myWriter.write("Passenger "+(x+1)+" details"+"\n");
				myWriter.write("First name : "+this.p_array[x].get_Firstname()+"\n");
				myWriter.write("Surname    : "+this.p_array[x].get_Surname()+"\n");
				myWriter.write("Expenses   : "+this.p_array[x].get_Expenses()+"\n");
				myWriter.write("\n");
			}
		}
		catch (IOException e)
		{
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
	protected  List<String> name_list()// getting passegers names to list
	{
		List<String> arr=new ArrayList<String>();
		for (int x=0;x<(this.cabin_passengers);x++)
		{
			if (!(this.cabin_name.equals("not booked")))
			{
				arr.add((this.p_array[x].get_Firstname()+" "+this.p_array[x].get_Surname())+" cabin number "+this.C_index);
			}
		}
		return arr;
	}
	protected int total_expenses()// calculate passegnger expenses
	{
		int cabin_total=0;
		for (int x=0;x<(this.cabin_passengers);x++)
		{
			if (!(this.cabin_name.equals("not booked")))
			{
				System.out.println(this.p_array[x].get_Firstname()+" - " + this.p_array[x].get_Expenses());
				cabin_total+=this.p_array[x].get_Expenses();
			}
		}
		return cabin_total;
	}
	protected void remove_pass(int remove_pass)//remove the passenger
	{
		this.p_array[remove_pass].clear_passenger();
	}
}