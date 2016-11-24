package zip;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import config.Config;

public class GenerateDirectorie {
	List<String> list = new ArrayList<>();
    
	public List<String> generateFilesList(File file) {
        if (file.isFile()) {
            list.add(generateZipEntry(file.getAbsolutePath()));
        }
        if (file.isDirectory()) {
            String dir = file.getAbsoluteFile().toString();
            if(!dir.equalsIgnoreCase(Config.workingDirectory)) {
                list.add(dir.substring(Config.workingDirectory.length() + 1)
                        + File.separator);
            }
            for (String nextFile : file.list()) {
                generateFilesList(new File(file, nextFile));
            }
        }
		return list;
    }
    private String generateZipEntry(final String filename) {
        return filename.substring(Config.workingDirectory.length() + 1);
    }

}
