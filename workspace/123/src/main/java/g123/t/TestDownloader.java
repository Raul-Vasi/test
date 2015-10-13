package g123.t;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

/**
 * @author raul
 *
 */
public class TestDownloader {
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Count c = new Count("");
		String imageUrl = "https://www.jvrb.org/past-issues/11.2014/4075/fulltext/fedoraxml_body";
		String destinationFile = "/home/raul/test/tmp/image.html";

		saveImage(imageUrl, destinationFile);
	}

	public static void saveImage(String imageUrl, String destinationFile) throws IOException {
		URL url = new URL(imageUrl);
		InputStream is = url.openStream();
		OutputStream os = new FileOutputStream(destinationFile);

		byte[] b = new byte[2048];
		int length;

		while ((length = is.read(b)) != -1) {
			os.write(b, 0, length);
		}

		is.close();
		os.close();

	}

}
