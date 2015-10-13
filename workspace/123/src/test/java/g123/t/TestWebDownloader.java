package g123.t;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

public class TestWebDownloader {

	@Test
	public void DownTest() {
		try {
			String urlSeite = "https://www.jvrb.org/past-issues/11.2014/4075/fulltext/fedoraxml_body";
			String destinationFile = "/home/raul/test/tmp/image.html";
			saveImage(urlSeite, destinationFile);
			Document doc = Jsoup.parse(urlSeite);

			createResourceFolder(urlSeite, destinationFile);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private void createResourceFolder(String urlSeite, String destinationFile) {
		FileReader fr;
		try {
			fr = new FileReader(urlSeite);
			BufferedReader br = new BufferedReader(fr);

			String zeile = br.readLine();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void createResourceFolder() {

	}

	private void saveImage(String urlSeite, String destinationFile) throws IOException {
		URL url = new URL(urlSeite);
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
