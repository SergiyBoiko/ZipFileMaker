import java.io.IOException;


import zip.AudioZip;
import zip.ImageZip;
import zip.VideoZip;

public class Main {

	public static void main(String[] args) throws IOException {
		new AudioZip().doZip();
		new VideoZip().doZip();
		new ImageZip().doZip();
	}

}
