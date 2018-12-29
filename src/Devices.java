import java.util.Scanner;

//MP2, Syeda Jaffery, CIS 340, online

public class Devices {
	
	//declare class variables
	String name;
	String SKU;
	boolean available = true;
	
	//no-arg constructor
	public Devices()
	{
		this.name = "";
		this.SKU = "";
		this.available = true;
	}
	
//******constructor with arguments
	public Devices(String sKU, String name) 
	{
		this.name = name;
		SKU = sKU;
		this.available = true;
	}
	public Devices(String sKU, String name, boolean available) 
	{
		this.name = name;
		SKU = sKU;
		this.available = available;
	}

//******getters and setters for Device attributes
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public String getSKU() 
	{
		return SKU;
	}
	public void setSKU(String sKU) 
	{
		SKU = sKU;
	}
	
	public boolean isAvailable() 
	{
		return available;
	}
	public void setAvailable(boolean available) 
	{
		this.available = available;
	}

	//changes the availability status and prints out a string 
	public String availability()
	{
		String availability;
		if (available == true)
			availability = "Available";
		else 
			availability = "Checked Out";
		return availability;
			
	}
	
} // end class
