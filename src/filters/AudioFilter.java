package filters;
import config.Config;;

public class AudioFilter extends Filter {
	@Override
	public String[] fileExtensions() {
		return Config.audioFormat;
	}
}
