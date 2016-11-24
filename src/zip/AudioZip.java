package zip;

import java.io.FileFilter;

import config.Config;
import filters.AudioFilter;

public class AudioZip extends Zip {
	@Override
	public String outPathDirectorie() {
		return Config.audioZip;
	}

	@Override
	public FileFilter fileFilter() {
		return new AudioFilter();
	}
}
