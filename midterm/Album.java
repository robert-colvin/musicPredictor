public class Album 
{
	int albumID;
	String title;
	int year;
	int numReviews = 0;
	int reviewSum = 0;

	public Album(int id, String title, int year)
	{
		this.albumID = id;
		this.title = title;
		this.year = year;
	}

	public int getAlbumID()
	{
		return this.albumID;
	}
	public String getAlbumTitle()
	{	
		return this.title;
	}
	public int getAlbumYear()
	{
		return this.year;
	}
	public int getNumReviews()
	{
		return this.numReviews;
	}
	public int getAvgReview()
	{
		if (getNumReviews() == 0)
		{
			System.out.println("no reviews for album " + getAlbumID());
			return 0;
		}
		return reviewSum/numReviews; 
	}
	public void addAlbumReview(int score)
	{
		numReviews++;
		reviewSum += score;
	}
}
