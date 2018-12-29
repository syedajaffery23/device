//MP2, Syeda Jaffery, CIS 340, online

import java.util.ArrayList;
import java.util.Scanner;

public class DeviceManagementSystem {
	
	//declare class variables
	public String name;
	public String sku;
	public int input;
	
	//create an object d of type Devices
	Devices d;
	
	//create an arraylist of type Devices
	ArrayList <Devices> deviceList = new ArrayList<>();
	
	Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) 
	{
		DeviceManagementSystem dms = new DeviceManagementSystem();
		dms.loadDMS();
	}//end main
	
//*********displays menu, asks user for choice and returns it*************
	private int displayMenu()
	{
		System.out.println("\n\n\t\tLibrary Device Checkout System");
		System.out.println("\n1. List Devices by Title\n2. Add New Devices"
				+ "\n3. Edit Device Information\n4. Search by Device name"
				+ "\n5. Check Out Devices\n6. Check In Devices\n7. Exit");
		
		//try block to catch invalid inputs
		try {
		//save user choice in input
		System.out.print("\n\nSelect menu options 1-7: ");
		input = Integer.parseInt(scanner.nextLine());
		}
	
		//executes if invalid entry
		catch(Exception e )
		{
			System.out.println("\nInvalid input");
		}
		scanner.nextLine();
		
		//return user input
		return input;	
	}
	
//******loads pre existing devices in array list*************
	public void loadSampleDevices()
	{
		Devices d1, d2, d3, d4, d5;
		d1 = new Devices("6757A", "Apple 9.7-inch iPad Pro");
		d2 = new Devices("93P51B", "Amazon Kindle Fire Kids Edition");
		d3 = new Devices("10N8C", "LeapFrog Epic Learning Tablet");
		d4 = new Devices("85U2O", "Amazon Kindle Fire HD 8", false); //availability of this device is "checked out"
		d5 = new Devices("91H2D", "HP Envy 8 Note");
		
		deviceList.add(d1);
		deviceList.add(d2);
		deviceList.add(d3);
		deviceList.add(d4);
		deviceList.add(d5);	
	}
	
//******load the device management system***********
	public void loadDMS()
	{
		//call method to prefill array
		loadSampleDevices();
		
		
		do {
			//call user choice from displayMenu method
			input = displayMenu(); 
			System.out.println("\n\n\n"); //create white space
			
			//switch on input and call appropriate methods for each 
			switch (input)
			{
			case 1: 
				printDeviceList();
				System.out.printf("\n\nPress enter to continue... \n\n\n");
				scanner.nextLine();
				break;
			case 2: 
				addNewDevice();
				break;
			case 3: 
				editDevice();
				break;
			case 4: 
				searchAndReturn();
				break;
			case 5: 
				checkOut();
				break;
			case 6: 
				checkIn();
				break;
			case 7: 
				exit();
				break;
			default:
				break;	
			}
		}while (input != 7);
	}
	
	
//************CASE 1: LIST DEVICE BY TITLE**************
//***********goes through the device arraylist and prints out each device information*********
	private void printDeviceList()
	{
		int index = 0;
		System.out.println("\n\n\t\tLibrary Device Checkout System - List");
		System.out.printf("\n\n\n%-3s %-10s %-35s", "#", "SKU","Name");
		
		//for each device device print out its sku, name and availability status
		for(Devices device: deviceList)
		{
			System.out.printf("\n%-3d %-10s %-35s %10s", 
					index+1, device.SKU, device.name, device.availability());
			index++;
		}
	}
	
//************CASE 2: ADD NEW DEVICE **************
//*********adds new device to the list************
	private void addNewDevice()
	{
		System.out.println("\n\n\t\tLibrary Device Checkout System - Add new Device");
		
		System.out.print("SKU: ");
		sku = scanner.nextLine().toUpperCase(); //convert sku to upper case
		System.out.print("Name: ");
		name = scanner.nextLine();
		
		//calls constructor from device class to create a new object
		d = new Devices(sku, name);
		
		//adds device to array list
		deviceList.add(d);
	}

//************CASE 3: EDIT DEVICE INFORMATION **************
//*********edits device name and sku by asking user***********
	private void editDevice()
	{
		int input;
		
		System.out.println("\n\n\t\tLibrary Device Checkout System - Edit Devices");
		
		//show user the current devices in the system
		printDeviceList();
		
		//checks if the user input is valid
		try {
		System.out.printf("\n\nEnter Device number to edit (1 - %d): ", deviceList.size() );
		input = Integer.parseInt(scanner.nextLine());
		
		d = deviceList.get(input-1); //input -1 to get the right index number
		
		System.out.print("SKU: ");
		sku = scanner.nextLine().toUpperCase();
		System.out.print("Name: ");
		name = scanner.nextLine();
		
		//call setters from device class to edit attributes
		d.setName(name);
		d.setSKU(sku);
		
		System.out.println("\nDevice information updated.");
		}
		
		//executes for invalid entry
		catch(IndexOutOfBoundsException e)
		{
			System.out.println("\nInvalid number");
		}
		catch(Exception e )
		{
			System.out.println("\nInvalid input");
		}
		
		scanner.nextLine();
	}
	
//************CASE 4: SEARCH BY DEVICE NAME **************
//*********searches the arraylist and prints name matches
	private void searchAndReturn()
	{
		int index = 0;
		
		System.out.println("\n\n\t\tLibrary Device Checkout System - Search Devices");
		
		//ask user for device name and save it in variable input
		System.out.print("Enter Device to search for: ");
		String input = scanner.nextLine().toLowerCase();
		
		System.out.printf("\nListings for '%s'", input);
		
		//for each device tmpdevice, search it with user input
		for(Devices tmpDevice: deviceList)
		{
			////get name and convert to lower case
			String name = tmpDevice.getName().toLowerCase(); 
			
			//if name matches user input, print its information
			if (name.contains(input))
			{
				System.out.printf("\n%-3s %-10s %-35s", 
						index+1, tmpDevice.SKU, tmpDevice.name);
			}
			index++; //increment index to display the index number correctly
		}
	}
	
//************CASE 5: CHECK OUT DEVICES **************
//
	public void checkOut()
	{
		//declare local variables
		int index = 0;
		int deviceNumber;
		
		//print heading
		System.out.println("\n\n\t\tLibrary Device Checkout System - Check Out Devices");
		System.out.print("\nAvailable Devices\n");
		System.out.printf("\n%-3s %-10s %-35s","#","SKU","Name");
		
		//for each device in array list, check available status
		for(Devices device: deviceList)
		{
			if (device.isAvailable()) //call isAvailable method from Device class
			{
				System.out.printf("\n%-3d %-10s %-35s ", 
						index+1, device.SKU, device.name);
			}
			index++; //increment index to display the index number correctly
		}
		
		//try this block to catch exceptions
		//checks if the user input is valid
		try {
		System.out.printf("\n\nEnter Device number: ");
		deviceNumber = Integer.parseInt(scanner.nextLine());
		
		//get index number and save device in temporary device d
		d = deviceList.get(deviceNumber-1);
		
		//if device is not available, tell user its already checked out
		if (d.available == false)
		{
			System.out.printf("%s is already %s", d.name, d.availability());
		}
		
		//change the availability status of device
		//tell user device name is now checked out
		else 
		{
		d.setAvailable(false);
		System.out.printf("You checked out %s", d.name);}
		}
		
		//execute the catch blocks if user input is incorrect
		catch(IndexOutOfBoundsException e)
		{
			System.out.println("\nInvalid number");
		}
		catch(Exception e )
		{
			System.out.println("\nInvalid input");
		}
		
		scanner.nextLine();
		
	}
	
//************CASE 6: CHECK IN DEVICES **************
//
	public void checkIn()
	{
		//declare local variables
		int index = 0;
		int input;
		
		//print heading
		System.out.println("\n\n\t\tLibrary Device Checkout System - Check In Devices");
		System.out.print("\nChecked Out Devices\n");
		System.out.printf("\n%-3s %-10s %-35s","#","SKU","Name");
		
		//for each device in array list, check available status
		for(Devices device: deviceList)
		{
			//call isAvailable method from Device class
			//print name if device is not available
			if (! device.isAvailable())
			{
				System.out.printf("\n%-3d %-10s %-35s ", 
					index+1, device.SKU, device.name);
			}
			index++; //increment index to display the index number correctly
		}
		
		//try block checks if the user input is valid
		try {
		System.out.printf("\n\nEnter Device number: ");
		input = Integer.parseInt(scanner.nextLine());
		
		//get index number and save device in temporary device d
		d = deviceList.get(input-1);
		
		//if device is available, tell user its not checked out
		if (d.available == true)
		{
			System.out.printf("%s is not checked out", d.name);
		}
		
		//change the availability status of device
		//tell user device name is now checked in
		else 
		{
			d.setAvailable(true);
			System.out.printf("You checked in %s", d.name);}
		}
		
		//execute the catch blocks if user input is incorrect
		catch(IndexOutOfBoundsException e)
		{
			System.out.println("\nInvalid number");
		}
		
		catch(Exception e )
		{
			System.out.println("\nInvalid input");
		}
		
		scanner.nextLine();
		
	}
	
//************CASE 7: EXIT **************
//*********displays exit message and exits the system cleanly*******
	private void exit()
	{
		System.out.println("Good Bye!");
		System.exit(0);
	}
}
