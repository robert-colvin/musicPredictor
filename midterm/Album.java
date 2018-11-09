public class Album 
{
	int albumID;
	String title;
	int year;
	int numReviews = 0;
	double reviewSum = 0;

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
	public double getAvgReview()
	{
		if (getNumReviews() == 0)
		{
			//System.out.println("no reviews for album " + getAlbumID());
			return 0;
		}
		return (double) reviewSum/numReviews; 
	}
	public void addAlbumReview(double score)
	{
		numReviews++;
		reviewSum += score;
	}
}
