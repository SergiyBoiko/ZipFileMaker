package filters;

import java.io.File;
import java.io.FileFilter;

public class Filter implements FileFilter {

	public String[] fileExtensions()
	{
		return new String[] {};
	}

	@Override
	public boolean accept(File file) {
		for (String extension : fileExtensions())
		{
			if (file.getName().toLowerCase().endsWith(extension))
			{
				return true;
			}
		}
		return false;
	}
}

