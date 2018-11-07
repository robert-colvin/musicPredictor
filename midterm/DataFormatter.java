import java.net.*;
import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class DataFormatter 
{

	//format data by creating data structure from all relevant dataset info and writing it to file for future reference
	public static void main(String[] args) 
	{
		try 
		{
			HashMap<Integer, Band> bandHash = new HashMap<>();
	        	File file = new File("allBandData.csv");
		        file.createNewFile();
		        FileWriter writer = new FileWriter(file); 
			File bandsFile  = new File("./datasets/bands.csv");
			File albumsFile  = new File("./datasets/albums.csv");
			File reviewsFile  = new File("./datasets/reviews.csv");

			
			getBands(bandsFile, bandHash);
			getAlbums(albumsFile, bandHash);
			getReviews(reviewsFile, bandHash);

			writeData(writer, bandHash);

		       	writer.close();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		} 

	}
	
	public static void getBands(File bandsFile, HashMap<Integer, Band> bandHash) throws IOException
	{
		FileReader fr = new FileReader(bandsFile);
		BufferedReader br = new BufferedReader(fr);
		
		String line = br.readLine();
		line = br.readLine();//twice to skip over header line
		while(line != null)
		{
			StringTokenizer st = new StringTokenizer(line, ",");

			int bandID = Integer.parseInt(st.nextToken());
			String bandName = st.nextToken();
			String country = st.nextToken();
			st.nextToken();//skips the status field; I'd like to factor in this attribute in the model but it is not a crucial one - like a cherry on top
			String formedString = st.nextToken();
			int formedIn = -1;
			if(!formedString.equals("N/A"))
				formedIn = Integer.parseInt(formedString);
			st.nextToken();//skips active field for same reason as status

			Band b = new Band(bandID, bandName, formedIn, country);
			bandHash.put(bandID, b);

			line = br.readLine();
		}
	}
	public static void getAlbums(File albumsFile, HashMap<Integer, Band> bandHash) throws IOException
	{
		FileReader fr = new FileReader(albumsFile);
		BufferedReader br = new BufferedReader(fr);
		
		String line = br.readLine();
		line = br.readLine();//twice to skip over header line
		while(line != null)
		{
			StringTokenizer st = new StringTokenizer(line, ",");

			int albumID = Integer.parseInt(st.nextToken());
			int bandID = Integer.parseInt(st.nextToken());
			String albumTitle = st.nextToken();
			int albumYear = Integer.parseInt(st.nextToken());

			Album a = new Album(albumID, albumTitle, albumYear);
			bandHash.get(bandID).addAlbum(albumID, a);

			line = br.readLine();
		}
	}
	public static void getReviews(File reviewsFile, HashMap<Integer, Band> bandHash) throws IOException
	{
		FileReader fr = new FileReader(reviewsFile);
		BufferedReader br = new BufferedReader(fr);
		
		String line = br.readLine();
		line = br.readLine();//twice to skip over header line
		while(line != null)
		{
			StringTokenizer st = new StringTokenizer(line, ",");

			int reviewID = Integer.parseInt(st.nextToken());
			int albumID = Integer.parseInt(st.nextToken());
			int reviewScore = Integer.parseInt(st.nextToken());

			bandHash.get(bandID).addAlbum(albumID, a);

			line = br.readLine();
		}

	}
	public static void writeData(FileWriter writer, HashMap<Integer, Band> bandHash) throws IOException
	{
		//writer.write("Band ID, Band name, Formed in, Country, List of Album IDs, List of Album Names, List of Album Years, List of Album Reviews\n");
	}
	
}


