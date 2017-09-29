import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BankRecordsTest {

	public static void main(String[] args)  {
		
		BankRecords.readData(); // Starts the process to read,process, and print the data
		
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
		System.out.println("Cur dt=" + timeStamp + "\nProgrammed by Scott Partacz \n");


	}

}
