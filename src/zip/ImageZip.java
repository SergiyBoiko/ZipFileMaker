package zip;

import java.io.FileFilter;

import config.Config;
import filters.ImageFilter;

public class ImageZip extends Zip {
	@Override
	public String outPathDirectorie() {
		return Config.imageZip;
	}

	@Override
	public FileFilter fileFilter() {
		return new ImageFilter();
	}
}
