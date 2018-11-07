import java.net.*;
import java.io.*;

public class DataFormatter 
{
	//format data by creating data structure from all relevant dataset info and writing it to file for future reference
	public static void main(String[] args) 
	{
		try 
		{
	        	File file = new File("allBandData.txt");
		        file.createNewFile();
		        FileWriter writer = new FileWriter(file); 
			
					
			writer.write("Band ID, Band name, Formed in, Country, List of Album IDs, List of Album Names, List of Album Years, List of Album Reviews\n");
			

		       	writer.close();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 

	}
/*	
	public static void getConferenceInfo(String content, FileWriter writer) throws IOException
	{
	
	
		int startIndex = content.indexOf("Where");//skip a bunch of stuff to get to the top of the important bits
		int endIndex = content.indexOf("Where");

		for(int j=0;j<10;j++)//getting the acronym of the first entry (special case)
		{
			startIndex = content.indexOf(">", startIndex+1);//count > char until we get to text of first entry
			endIndex = content.indexOf("<", endIndex+1);
			if(content.substring(startIndex+1, startIndex+13).equals("Expired CFPs"))
				j-=4;
		}
		//slide indices down string apprpriately and store substring	
		startIndex++;
		endIndex = content.indexOf("<", endIndex+1);
		String confAcronym = content.substring(startIndex, endIndex);
		
		//do that over and over for sequential fields
		for(int j=0;j<3;j++)
		{
			startIndex = content.indexOf(">", startIndex+1);
			endIndex = content.indexOf("<", endIndex+1);
		}
		startIndex++;
		String confName = content.substring(startIndex, endIndex);
				
		for(int j=0;j<9;j++)
		{
			startIndex = content.indexOf(">", startIndex+1);
			endIndex = content.indexOf("<", endIndex+1);
		}
		startIndex++;
		String confLocation = content.substring(startIndex, endIndex);
		
		//append that stuff to file
	       	writer.append(confAcronym + ",");
		writer.append(confName + ",");
		writer.append(confLocation + ",\n");

		for(int k=0;k<19;k++)//do the same junk for the remaining 19 entries on page
		{
			for(int j=0;j<7;j++)
			{
				startIndex = content.indexOf(">", startIndex+1);//count > char until we get to text of next entry
				endIndex = content.indexOf("<", endIndex+1);
				if(content.substring(startIndex+1, startIndex+13).equals("Expired CFPs"))
					j-=4;
			}	
			startIndex++;
			confAcronym = content.substring(startIndex, endIndex).trim();
					
			for(int j=0;j<3;j++)
			{
				startIndex = content.indexOf(">", startIndex+1);
				endIndex = content.indexOf("<", endIndex+1);
				if(content.substring(endIndex+1, endIndex+4).trim().equals("img"))
				{
					j--;
				}
			}
			startIndex++;
			confName = content.substring(startIndex, endIndex).trim();
				
			for(int j=0;j<9;j++)
			{
				startIndex = content.indexOf(">", startIndex+1);
				endIndex = content.indexOf("<", endIndex+1);
			}
			startIndex++;
			confLocation = content.substring(startIndex, endIndex).trim();
	
		       	writer.append(confAcronym + ",");
			writer.append(confName + ",");
			writer.append(confLocation + ",\n");
		}
		writer.flush();

	}
*/	
}


