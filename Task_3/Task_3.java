import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
public class Task_3{
	
private static final Object[] Cabin = null;
static int roomNum;
static String[]Cabins=new String[12];//create an array for cabins to store customer name
static String[]que=new String[12];//create an array for que to waiting list for customer
static String roomName;
private static String empty;


public static void main(String[]args) throws Exception{
        menuDisplay();

}
public static void menuDisplay() throws Exception{
	    System.out.println("\n***********************************  Welcome to Cruise Ship Boarding  *********************************************\n\n");//menu
		System.out.println("+---------------------------------------------------------------------------------------------------+\n");
	    System.out.println("+                                      Select an option                                             +\n");
	    System.out.println("----------------------------------------------------------------------------------------------------+\n");
        System.out.println("|   Enter A : to add customer-                                                                      |\n");
        System.out.println("|   Enter V : to View cabins-                                                                       |\n");
        System.out.println("|   Enter E : to Display Empty cabins-                                                              |\n");
        System.out.println("|   Enter D : to Delete customer cabins-                                                            |\n");
        System.out.println("|   Enter F : to Find cabins from customer name-                                                    |\n");
        System.out.println("|   Enter S : to Store program data into file-                                                      |\n");
        System.out.println("|   Enter L : to Load program data from file-                                                       |\n");
        System.out.println("|   Enter O : to View passengers Ordered alphabetically by name-                                    |\n");
        System.out.println("+---------------------------------------------------------------------------------------------------+");
        Scanner task=new Scanner(System.in);
        System.out.println("-Please Enter your option :");
        String option=task.nextLine();
        //System.out.println("option is " +option);
        switch (option){
         case "A":
		 case "a":
		      Add_cabins();  
            break;
        case "V":
		case "v":
		      View_cabins();
            break;
        case "E":
		case "e":
		      Empty_cabins();
            break;
        case "D":
		case "d":
		      Delete_Customer_cabins();
            break;
        case "F":
		case "f":
		      Find_Cabin();
            break;
        case "S":
        case "s":		
		      Data_store();
            break;
        case "L":
		case "l":
		      L_data_store();
            break;
        case "O":
		case "o":
		      Ordered_alphabetically();
            break;
}
}
//Add a new customer
public static void Add_cabins() throws Exception
{   //
	//try { 
    Scanner input = new Scanner (System.in);
    for (int x=0;x<Cabins.length;x++) {
    	if(Cabins[x]=="zempty") {
    	System.out.println("Enter customer name for cabin No:"+(x+1));
    	roomName = input.next();
    	roomNum=x;
    	Cabins[roomNum]=roomName;
    	menuDisplay();
    	}
    	else {
    		continue;
    	}
    }
    System.out.println("Cabins are full--move with waiting que");
    for (int y=0;y<que.length;y++) {
    	if(que[y]=="zempty") {
    	System.out.println("Enter customer name for waiting que No:"+(y+1));
    	roomName = input.next();
    	que[y]=roomName;
    	menuDisplay();
    	}
    	else {
    		continue;
    	}
    }
	}
	
//View Cabins
public static void View_cabins() throws Exception
{
    System.out.println("View customer cabins");
    while(roomNum<12)
    {
    	for(int x=0; x<12; x = x + 1)
    		if(Cabins[x]!=null && que[x]!=null)
    			System.out.println("Cabin No :"+ (x+1) +" is Taken By "+ Cabins[x]);
    		else
    		{
    			Cabins[x]="zempty";
    			que[x]="zempty";
    			System.out.println("Cabin No:"+ (x+1) +" is available for bookings");
    		}
    	menuDisplay();
    }
}

//Empty Cabins
public static void Empty_cabins() throws Exception
{
	System.out.println("View Empty cabins");
	while (roomNum<12)
	{
		for (int x = 0; x<12; x = x + 1)
			if(Cabins[x]=="zempty")
				System.out.println("Cabin No:"+ (x+1) +" is available for bookings");
				
			else
				continue;
		menuDisplay();
	}
}

//Delete Cabins
public static void Delete_Customer_cabins() throws Exception
{
	System.out.println("Delete customer from cabin");
	Scanner input=new Scanner (System.in);
	int x;
	System.out.println("Enter cabin number to be deleted:");
	x=input.nextInt();
	Cabins[x-1]="zempty";
	for (int i=0; i<que.length; i++) {
		
		if(que[i]!="zempty") {
		Cabins[x-1]=que[i];
		que[i]="zempty";
		menuDisplay();
		}
	else {
		Cabins[x-1]="zempty";
		continue;
	}
}
}

//Find Cabins
public static void Find_Cabin() throws Exception
{
	System.out.println("Find Cabin by Customer Name");
	Scanner input = new Scanner(System.in);
	String Input_Name;
	System.out.print("Enter the Passenger Name to search the cabins :");
	Input_Name = input.next();
	List<String> Cabinlist = new ArrayList<>(Arrays.asList(Cabins));

	if (Cabinlist.contains(Input_Name)){
		System.out.println("Cabin No:" + (Cabinlist.indexOf(Input_Name)) + " is occupied by " + Input_Name);
	}
	else
	{
		System.out.println("No result found");
		Scanner uinput = new Scanner(System.in);
		String User;
		System.out.println("Do you want try it again / press Y to continue , N to exits");
		User = uinput.next();
		
		if(User!="Y") {
			
			
			Find_Cabin();
		}
		else {
			menuDisplay();

		}	
	}

	menuDisplay();
}

//Data Store Cabins
public static void Data_store() throws Exception
{
	System.out.println("Save program data into a file");
	try {
		FileWriter myWriter = new FileWriter("data_store.txt");
		for (int i = 0; i < Cabins.length; i++) {
			myWriter.write(Cabins[i] + "- Cabin No." + (i + 1) + "\n");
		}
		myWriter.close();
		System.out.println("Data storing process is completed");
		menuDisplay();

	}
	catch(IOException e){
		System.out.println("An error occurred.");
		menuDisplay();
	}
}

//Load the program
public static void L_data_store() throws Exception
{
	System.out.println("Load details");
	try{
		File myObj = new File("data_store.txt");
		Scanner input = new Scanner(myObj);
		while (input.hasNextLine()){
			String task = input.nextLine();
			System.out.println(task);
		}
		input.close();
		menuDisplay();
	}
	catch (FileNotFoundException e){
		System.out.println("An error occurred.");
		menuDisplay();
	}
}

//Create a alphabetically Ordered
public static void Ordered_alphabetically() throws Exception
{
	System.out.println("Enter O to View passengers Ordered alphabetically by name");
	String temp;
	for(int j=0; j<Cabins.length; j++)
	{
	for (int i = j+1; i < Cabins.length; i++)
	{
		if(Cabins[i].compareTo(Cabins[j])<0)
		{
			temp = Cabins[j];
			Cabins[j] = Cabins[i];
			Cabins[i] = temp;
		}
	}
	System.out.println(Cabins[j]);
}
	menuDisplay();
}
private static void menu() {
	// TODO Auto-generated method stub
}
}


