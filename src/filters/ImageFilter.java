package filters;

import config.Config;

public class ImageFilter extends Filter {
	@Override
	public String[] fileExtensions() {
		return Config.imageFormat;
	}
}
