package config;
public class Config {
	public static String [] audioFormat = new String[]{"mp3", "wav", "wma"};
	public static String [] videoFormat = new String[]{"avi", "mp4", "flv"};
	public static String [] imageFormat = new String[]{"jpeg", "jpg", "gif", "png"};

	public static String workingDirectory = "D:\\Work\\worksKepler\\ZipFileMaker\\testZip";

	public static String imageZip;
	public static String audioZip;
	public static String videoZip;

	static  {
		imageZip = "images.zip";
		audioZip = "audios.zip";
		videoZip = "videos.zip";
	}
}