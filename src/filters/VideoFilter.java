package filters;

import config.Config;

public class VideoFilter extends Filter {
	@Override
	public String[] fileExtensions() {
		return Config.videoFormat;
	}
}
