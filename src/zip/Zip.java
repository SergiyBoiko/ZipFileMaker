package zip;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import config.Config;
import filters.Filter;

public abstract class Zip {
	public String outPathDirectorie(){
		return "path";
	}

	public abstract FileFilter fileFilter();
	
	void zipAddFiles(ZipOutputStream out){
		try{
			System.out.println("Write to the archive: "+outPathDirectorie());
			for(int i = 0; i < new GenerateDirectorie().generateFilesList(new File(Config.workingDirectory)).size(); i++){
				File direc = new File(new GenerateDirectorie().generateFilesList(new File(Config.workingDirectory)).get(i)); 
				for(File file : direc.listFiles(fileFilter())){
					if(file.isDirectory())
						zipAddFiles(out);
					else{
						out.putNextEntry(new ZipEntry(file.getPath().replace(Config.workingDirectory, "")));
						write(new FileInputStream(file), out);
					}
				}
			}
			System.out.println("All files added");
		} catch (FileNotFoundException  e) {
			Logger.getLogger(Zip.class.getName())
			.log(Level.SEVERE, null, e);
		}	catch (NullPointerException  e) {
				Logger.getLogger(Zip.class.getName())
				.log(Level.SEVERE, null, e);
		} catch (IOException e) {
			Logger.getLogger(Zip.class.getName())
			.log(Level.SEVERE, null, e);
		}
	}

	private void write(InputStream inputStream, OutputStream out) throws IOException {
		byte[] buffer = new byte[2048];
		int length;
		while((length = inputStream.read(buffer)) >= 0){
			out.write(buffer, 0, length);
			inputStream.close();
		}
	}
	public void doZip() throws IOException {
		final ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(outPathDirectorie()));
		zipAddFiles(zipOut);
		zipOut.close();
	}
}
