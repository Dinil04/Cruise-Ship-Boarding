import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Date;

public class Task_2
{
	private static final Scanner input = new Scanner(System.in);
	public static void main(String[] args)//Main metthod
	{
		Cabin[] main_cabin = new Cabin[12];//create an array for cabins to store customer name
		for (int x=0;x<12;x++)
		{
			main_cabin[x]=new Cabin();
		}
		initialise(main_cabin);

		while (true)
		{
			String selection;
			String main_loop_input;

			while (true)
			{
				System.out.println("\n***********************************  Welcome to Cruise Ship Boarding  *********************************************\n\n");//menu
		System.out.println("+---------------------------------------------------------------------------------------------------+\n");
	    System.out.println("+                                      Select an option                                             +\n");
		System.out.println("+---------------------------------------------------------------------------------------------------+\n");
	    //System.out.println("----------------------------------------------------------------------------------------------------------------------");
        System.out.println("|   Enter A : to add customer-                                                                      |\n");
        System.out.println("|   Enter V : to View cabins-                                                                       |\n");
        System.out.println("|   Enter E : to Display Empty cabins-                                                              |\n");
        System.out.println("|   Enter D : to Delete customer cabins-                                                            |\n");
        System.out.println("|   Enter F : to Find cabins from customer name-                                                    |\n");
        System.out.println("|   Enter S : to Store program data into file-                                                      |\n");
        System.out.println("|   Enter L : to Load program data from file-                                                       |\n");
        System.out.println("|   Enter O : to View passengers Ordered alphabetically by name-                                    |\n");
        System.out.println("+---------------------------------------------------------------------------------------------------+");
				
				
				
				System.out.print("Your selection : ");
				selection = input.next();
				if ((selection.equals("V")| (selection.equals("v")) |(selection.equals("A")| (selection.equals("a"))|(selection.equals("E")| (selection.equals("e"))|(selection.equals("D")| (selection.equals("d"))|(selection.equals("F") | (selection.equals("f"))|(selection.equals("S")| (selection.equals("s"))|(selection.equals("L")|(selection.equals("l"))|(selection.equals("O")|(selection.equals("o"))|(selection.equals("T")|(selection.equals("t"))|(selection.equals("Q")|(selection.equals("q")))))))))))))	
						
				
				{
					break;
				}
				else
				{
					System.out.println("Sorry! Invalid input");
				}
			}

			//menu parts
			if ((selection.equals("V"))| (selection.equals("v")))
			{
				viewallCabins(main_cabin);
			}
			else if ((selection.equals("A"))| (selection.equals("a")))
			{
				add_custemors_tocabin(main_cabin);
			}
			else if ((selection.equals("E"))| (selection.equals("e")))
			{
				Empty_cabins(main_cabin);
			}
			else if ((selection.equals("D"))| (selection.equals("d")))
			{
				Delete_customer_from_cabin(main_cabin);
			}
			else if ((selection.equals("F"))| (selection.equals("f")))
			{
				Find_cabin_from_customer_name(main_cabin);
			}
			else if ((selection.equals("S"))| (selection.equals("s")))
			{
				Store_data(main_cabin);
			}
			else if ((selection.equals("L"))| (selection.equals("l")))
			{
				Load_data();
			}
			else if ((selection.equals("O"))| (selection.equals("o")))
			{
				ordered_alphabetically_name(main_cabin);
			}
			else if ((selection.equals("T"))| (selection.equals("t")))
			{
				expenses_print(main_cabin);
			}
			else if ((selection.equals("Q"))| (selection.equals("q")))
			{
				System.exit(0);
			}
			System.out.println();

			//looping
			while (true)
			{
				System.out.print("Would you want anothor services?[Yes/No] " );
				main_loop_input = input.next().toUpperCase();
				if (main_loop_input.equals("YES") )
				{
					break;
				}
				else if (main_loop_input.equals("NO"))
				{
					System.exit(0);
				}
				else
				{
					System.out.println("Sorry! Invalid input");
				}
			}
		}
	}
	private static void initialise( Cabin Cabin_Temp[] )
	{
		for (int x = 0; x < 12; x++ )
		{
			Cabin_Temp[x].set_Name("not booked") ;
			Cabin_Temp[x].set_cabin_index(x);
		}
		System.out.println( "initilise Done ");
	}

	// Make the View cabins
	private static void viewallCabins(Cabin[] Cabin_Temp)
	{
		String option;
		int choose_num;

		for (int x = 0; x < 12; x++ )
		{
			System.out.println("cabin " + x +" "+ Cabin_Temp[x].get_Name());
		}

		while (true)
		{
			System.out.println();
			System.out.println("Would you want to see passangers ?[Yes/No] ");
			option=input.next().toUpperCase();
			if (option.equals("YES") )
			{
				while (true)
				{
					System.out.print("Enter cabin number (0-11) or 12 to all passengers: " );
					if (input.hasNextInt())
					{
						choose_num = input.nextInt();
						if ((choose_num>=0) & (choose_num<=12))
						{
							break;
						}
						else
						{
							System.out.println("Sorry! out of range cablin numbers");
						}
					}
					else
					{
						System.out.println("Invalid input");
						input.next();
					}
				}
				System.out.println("--------------------------------------------------------------------------------------");
				if (choose_num==12)
				{
					for (int x = 0; x < 12; x++ )
					{
						System.out.println();
						Cabin_Temp[x].Passenger_detils();
						System.out.println("--------------------------------------------------------------------------------------");
					}
				}
				else
				{
					Cabin_Temp[choose_num].Passenger_detils();
					System.out.println("--------------------------------------------------------------------------------------");
				}
				break;
			}
			else if (option.equals("NO"))
			{
				break;
			}else
			{
				System.out.println("Sorry! Invalid input");
			}
		}
	}

	// Make the add a new customer
	private static void add_custemors_tocabin(Cabin[] Cabin_Temp)
	{
		int roomNum = 0;

		System.out.println() ;
		System.out.println("Would you like to book a cabin ?" ) ;

		int empty_cabins = 0;
		for (int x = 0;x < 12; x++){
			if ((Cabin_Temp[x].get_Name().equals("not booked")))
			{
				empty_cabins++;
			}
		}

		while (roomNum <empty_cabins )
		{
			while (true)
			{
				System.out.println("Enter cabin number (0-11) or 12 to stop:");
				if (input.hasNextInt())
				{
					roomNum = input.nextInt();
					if ((roomNum>=0) & (roomNum<12))
					{
						if ((Cabin_Temp[roomNum].get_Name().equals("not booked"))) {
							break;
						}
						else {
							System.out.println("Sorry! This cabin is already booked ");
						}
					}
					else if (roomNum==12)
					{
						break;
					}
					else
					{
						System.out.println("Sorry! cabin number is out of range");
					}
				}
				else
				{
					System.out.println("Invalid input");
					input.next();
				}
			}

			if (roomNum!=12)
			{
				Cabin_Temp[roomNum].cabin_booking(roomNum);
				Cabin_Temp[roomNum].set_passenger();
				System.out.println("--------------------------------------------------------------------------------------");
				Cabin_Temp[roomNum].Passenger_detils();
				System.out.println("--------------------------------------------------------------------------------------");

				System.out.println("Successfully added!" ) ;
			}
			else
			{
				break;
			}
			empty_cabins=0;
			for (int x=0;x<12;x++){
				if ((Cabin_Temp[x].get_Name().equals("not booked")))
				{
					empty_cabins++;
				}
			}
		}
	}

	// Make the Empty Cabins
	private static void Empty_cabins(Cabin[] Cabin_Temp)
	{
		System.out.println("Display Empty cabins are:");
		System.out.println("--------------------------------------------------------------------------------------");
		for (int x = 0; x < 12; x++ )
		{
			if (Cabin_Temp[x].get_Name().equals("not booked"))
			{
				System.out.println("cabin " + x + " is not booked ");
			}
		}
		System.out.println("--------------------------------------------------------------------------------------");
	}

	// Make the Delete customer Cabins
	private static void Delete_customer_from_cabin(Cabin[] Cabin_Temp)
	{
		int remove_cus;
		int remove_pass;
		String option;

		while (true)
		{
			System.out.print("Enter[C] to clear cabin, Enter [P] to clear Passenger ");
			option=input.next().toUpperCase();
			if (option.equals("P")|option.equals("C"))
			{
				break;
			}else
			{
				System.out.println("Sorry! Invalid option");
			}
		}

		if (option.equals("C"))
		{
			while (true)
			{
				System.out.print("What cabin number want to clear? ");
				if (input.hasNextInt())
				{
					remove_cus = input.nextInt();
					if ((remove_cus >= 0) & (remove_cus <= 12))
					{
						if (Cabin_Temp[remove_cus].get_Name().equals("not booked"))
						{
							System.out.println("Sorry! Already empty ");
							break;
						}
						else
						{
							Cabin_Temp[remove_cus].clear_cabin();
							System.out.println("Updated");
							break;
						}
					}
				}
				else
				{
					System.out.println("Invalid input");
					input.next();
				}
			}
		} else
		{
			while (true)
			{
				System.out.println("Enter Passenger's cabin number " );
				if (input.hasNextInt())
				{
					remove_cus = input.nextInt();
					if ((remove_cus>=0) & (remove_cus<=12))
					{
						break;
					}
					else
					{
						System.out.println("Sorry! out of range cablin numbers");
					}
				}
				else
				{
					System.out.println("Invalid input");
					input.next();
				}
			}
			Cabin_Temp[remove_cus].Passenger_detils();

			while (true)
			{
				System.out.print("Enter Passenger's cabin number: " );
				System.out.println("--------------------------------------------------------------------------------------");
				if (input.hasNextInt())
				{
					remove_pass = input.nextInt();
					if ((remove_pass>0) & ( remove_pass<=(Cabin_Temp[remove_cus].get_guests() )))
					{
						Cabin_Temp[remove_cus].remove_pass((remove_pass-1));
						System.out.println("Sucessfully removed passenger "+remove_pass);
						break;
					}
					else
					{
						System.out.println("Sorry! out of range Passenger numbers");
					}
				}
				else
				{
					System.out.println("Invalid input");
					input.next();
				}
				System.out.println("--------------------------------------------------------------------------------------");
			}
		}
		System.out.println();
	}

	// Make the Find Cabins
	private static void Find_cabin_from_customer_name(Cabin[] Cabin_Temp)
	{
		String find_name;
		int find_results=0;

		System.out.print("What name wish you like to find? ");
		find_name = input.next();
		System.out.println("--------------------------------------------------------------------------------------");
		for (int x = 0; x < 12; x++ )
		{
			if (Cabin_Temp[x].get_Name().contains(find_name))
			{
				System.out.println("cabin " + x + " name");
				find_results+=1;
			}

			find_results= Cabin_Temp[x].return_find_names(find_name,find_results);
		}
		if (find_results==0)
		{
			System.out.println("No results found");
		}else
		{
			System.out.println(find_results + " results found");
		}
		System.out.println("--------------------------------------------------------------------------------------");
	}

	// Make the Data Store Cabin
	public static void Store_data(Cabin[] Cabin_Temp )
	{
		Date date = new Date();

		try
		{
			FileWriter myWriter = new FileWriter("data_store.txt");
			myWriter.write("---------------Cabin Details----------------"+"\n");
			myWriter.write(String.format("Logs updated Date/Time : %tc", date )+"\n");

			for (int x = 0; x < 12; x++ )
			{
				Cabin_Temp[x].data_store(myWriter);
			}
			myWriter.write("---------------------------------------------------------------------------\n");
			myWriter.close();
			System.out.println("Successfully stored to the file.");
		}
		catch (IOException e)
		{
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	//Make the load the program
	public static void Load_data()
	{
		try
		{
			File myObj = new File("data_store.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine())
			{
				String data = myReader.nextLine();
				System.out.println(data);
			}
			myReader.close();
		}
		catch (FileNotFoundException e)
		{
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	//Create a alphabetically Ordered
	public static void ordered_alphabetically_name(Cabin[] Cabin_Temp )
	{
		boolean isordered;

		List<String> temp_list=new ArrayList<String>();
		List<String> namelist=new ArrayList<String>();

		for (int x = 0; x < 12; x++ )
		{
			temp_list=Cabin_Temp[x].name_list();
			for (String element: temp_list)
			{
				namelist.add(element);
			}
		}
		int elements=namelist.size();

		for(int i=0;i<(elements-1);i++)
		{
			isordered=false;
			for(int j=0;j<(elements-1);j++)
			{
				if ((namelist.get(j).compareTo(namelist.get(j+1))) > 0)
				{
					String temp_=namelist.get(j);
					namelist.set(j,namelist.get(j+1));
					namelist.set((j+1),temp_);
					isordered=true;
				}
			}
			if (isordered==false)
			{
				break;
			}
		}

		for (String element: namelist)
		{
			System.out.println(element);
		}
		if(elements==0)
		{
			System.out.println( "0 results found!");
		}
	}

	// expenses of customer
	public static void expenses_print(Cabin[] Cabin_Temp )
	{
		int expenses_total=0;
		for (int x = 0; x < 12; x++ )
		{
			expenses_total += Cabin_Temp[x].total_expenses();
		}
		System.out.println("Total expenses of all passengers - "+ expenses_total);
	}
}