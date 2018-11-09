import java.util.HashMap;

public class Band
{
	int ID;
	String name;
	String genre;
	int formedIn;
	String country;
	HashMap<Integer, Album> albums = new HashMap<>();

	public Band(int id, String name, String genre, int formedIn, String country)
	{
		this.ID = id;
		this.name = name;
		this.genre = genre;
		this.formedIn = formedIn;
		this.country = country;

	}
	public int getBandID()
	{
		return this.ID;
	}
	public String getBandName()
	{
		return this.name;
	}
	public String getGenre()
	{
		return this.genre;
	}
	public int getYearFormed()
	{
		return this.formedIn;
	}
	public String getCountry()
	{
		return this.country;
	}
	public Album getAlbum(int albumID)
	{
		return this.albums.get(albumID);
	}
	public void printAlbums()
	{
		int i = 1;
		System.out.println("Band #" + getBandID() + ": " + getBandName() + " from " + getCountry() + " has the following albums:");
		for (int albumID : albums.keySet())
		{
			Album album = albums.get(albumID);
			System.out.println(i + ". " + album.getAlbumTitle() + ", " + album.getAlbumYear() + " with avg review score: " + album.getAvgReview());
			i++;
		}
		System.out.println();
	}
			
	public void addAlbum(int albumId, Album album)
	{
		this.albums.put(albumId, album);
	}
	public void addReview(int albumId, double score)
	{
		this.albums.get(albumId).addAlbumReview(score);
	}

}
