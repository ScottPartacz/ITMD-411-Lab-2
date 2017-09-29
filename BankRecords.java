import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BankRecords {

	static BankRecords robjs[] = new BankRecords[600]; 
	
	static ArrayList<List<String>> array = new ArrayList<>();
	
	String id; // string
	int age;  // numeric
	String sex; // male, female
	String region; // Inner_City,Town,Rural,Suburban
	double income; // numeric
	String married; // No,Yes
	String children; // 0,1,2,3
	String car; // No, Yes
	String save_act; // No, Yes
	String current_act; // No, Yes
	String mortgage; // No, Yes
	String pep; // No, Yes
	
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * @return the region
	 */
	public String getRegion() {
		return region;
	}
	/**
	 * @param region the region to set
	 */
	public void setRegion(String region) {
		this.region = region;
	}
	/**
	 * @return the income
	 */
	public double getIncome() {
		return income;
	}
	/**
	 * @param income the income to set
	 */
	public void setIncome(double income) {
		this.income = income;
	}
	/**
	 * @return the married
	 */
	public String getMarried() {
		return married;
	}
	/**
	 * @param married the married to set
	 */
	public void setMarried(String married) {
		this.married = married;
	}
	/**
	 * @return the children
	 */
	public String getChildren() {
		return children;
	}
	/**
	 * @param children the children to set
	 */
	public void setChildren(String children) {
		this.children = children;
	}
	/**
	 * @return the car
	 */
	public String getCar() {
		return car;
	}
	/**
	 * @param car the car to set
	 */
	public void setCar(String car) {
		this.car = car;
	}
	/**
	 * @return the save_act
	 */
	public String getSave_act() {
		return save_act;
	}
	/**
	 * @param save_act the save_act to set
	 */
	public void setSave_act(String save_act) {
		this.save_act = save_act;
	}
	/**
	 * @return the current_act
	 */
	public String getCurrent_act() {
		return current_act;
	}
	/**
	 * @param current_act the current_act to set
	 */
	public void setCurrent_act(String current_act) {
		this.current_act = current_act;
	}
	/**
	 * @return the mortgage
	 */
	public String getMortgage() {
		return mortgage;
	}
	/**
	 * @param mortgage the mortgage to set
	 */
	public void setMortgage(String mortgage) {
		this.mortgage = mortgage;
	}
	/**
	 * @return the pep
	 */
	public String getPep() {
		return pep;
	}
	/**
	 * @param pep the pep to set
	 */
	public void setPep(String pep) {
		this.pep = pep;
	}
	/**
	 * This method reads the CSV file and put all of the rows in an Arraylist
	 */
	public static void readData()
	{
		BufferedReader br;
		String line;

	     //initialize reader object and set file path to root of project
	     	try {
				br = new BufferedReader(new FileReader(new File("bank-Detail.csv")));
				while ((line = br.readLine()) != null) {
		             //parse each record in csv file by a comma ( , )
		             //into a list stored in the arraylist-> Arrays
						array.add(Arrays.asList(line.split(",")));
					}
				br.close();
			} catch (FileNotFoundException e) {
				System.out.println("File not found");
			} catch (IOException e) {
				e.printStackTrace();
			}
	            
	     processData();  //call function for processing record data

	}
	/**
	 * This method adds each row of the arraylist into BankRecords objects that are then stored in robjs array of BankRecord objects
	 */
	public static void processData()
	{
		//create index for array while iterating thru arraylist
		 int idx=0;

			    //create for each loop to cycle thru arraylist of values 
			    //and PASS that data into your record objects' setters 
			    for (List<String> rowData: array) {
			      //initialize array of objects
			    	robjs[idx] = new BankRecords();
			    	//call setters below and populate them, item by item
			    	robjs[idx].setId(rowData.get(0)); //get 1st column
			    	robjs[idx].setAge(Integer.parseInt(rowData.get(1))); //get 2nd column
			    	robjs[idx].setSex(rowData.get(2));
			    	robjs[idx].setRegion(rowData.get(3));
			    	robjs[idx].setIncome(Double.parseDouble(rowData.get(4)));
			    	robjs[idx].setMarried(rowData.get(5));
			        robjs[idx].setChildren(rowData.get(6));
			    	robjs[idx].setCar(rowData.get(7));
			    	robjs[idx].setSave_act(rowData.get(8));
			    	robjs[idx].setCurrent_act(rowData.get(9));
			    	robjs[idx].setMortgage(rowData.get(10));
			    	robjs[idx].setPep(rowData.get(11));

	          /*continue processing arraylist item values into each array object->
	           robjs[] by index*/
	                 idx++;
			    }
			  printData();
	}
	/**
	 * This method formats and prints the data from robjs
	 */
	public static void printData()
	{
		int temp = 0;
	    int Number_of_Records = 25;
		System.out.println("\n                                BANK RECORDS\n");
		System.out.println("+-------------------------------------------------------------------------+");
		System.out.println("|     ID    |  AGE  |    SEX    |     REGION     |   INCOME  |  MORTGAGE  |");
		System.out.println("+-------------------------------------------------------------------------+");
		for(BankRecords Data: robjs)
		{
			temp++; // temp value to know how many times the loop as gone through
			
			if(temp > Number_of_Records) // checks to see if the number of loops and sees if it is over the amount of records you want
			{
				break;
			}
			
			/*
			 * All of the following if statements are used to format the displayed table
			 */
			System.out.print("|  "+Data.getId()+"  |  "+Data.getAge()+"   |  ");
			
			if(Data.getSex().equals("FEMALE"))
			{
				System.out.print(Data.getSex()+"   |  ");
			}
			else
			{
				System.out.print(Data.getSex()+"     |  ");
			}
			
			if(Data.getRegion().equals("TOWN"))
			{
				System.out.print(Data.getRegion()+"          |  ");
			}
			else if(Data.getRegion().equals("INNER_CITY"))
			{
				System.out.print(Data.getRegion()+"    |  ");
			}
			else if(Data.getRegion().equals("RURAL"))
			{
				System.out.print(Data.getRegion()+"         |  ");
			}
			else
			{
				System.out.print(Data.getRegion()+"      |  ");
			}
			
			if(Data.getIncome() >= 100000)
			{
				System.out.print(Data.getIncome()+"  |  ");
			}
			else
			{
				System.out.print(Data.getIncome()+"   |  ");
			}
	
			if(Data.getMortgage().equals("YES"))
			{
				System.out.print(Data.getMortgage()+"      |  \n");
			}
			else
			{
				System.out.print(Data.getMortgage()+"       |  \n");
			}
			
		}
		
		System.out.println("+-------------------------------------------------------------------------+");
		
	}
}
