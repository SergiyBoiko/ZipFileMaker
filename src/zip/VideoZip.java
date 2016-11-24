package zip;

import java.io.FileFilter;

import config.Config;
import filters.VideoFilter;


public class VideoZip extends Zip {
	@Override
	public String outPathDirectorie() {
		return Config.videoZip;
	}

	@Override
	public FileFilter fileFilter() {
		return new VideoFilter();
	}
}
