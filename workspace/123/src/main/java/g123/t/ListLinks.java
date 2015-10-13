package g123.t;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ListLinks {
	public static void main(String[] args) throws IOException {

		String url = "https://alkyoneus.hbz-nrw.de/dev/jahrgang-2015/ausgabe-1/2295/fulltext/fedoraxml_body";
		// print("Fetching %s...", url);

		Document doc = Jsoup.connect(url).get();

		Elements links = doc.select("a[href]");
		Elements media = doc.select("[src]");
		Elements imports = doc.select("link[href]");
		Elements img = doc.getElementsByTag("img");

		ByteArrayInputStream bs = new ByteArrayInputStream(doc.outerHtml().getBytes("UTF-8"));
		IOUtils.copy(bs, new FileOutputStream("/home/raul/test/tmp/test.html"));

		for (Element el : img) {
			String src1 = el.absUrl("src");
			System.out.println(img.get(0).toString());
			System.out.println("src attribute is : " + src1);

			Response resultImageResponse = Jsoup.connect(src1).ignoreContentType(true).execute();
			FileOutputStream out = (new FileOutputStream("/home/raul/test/tmp/test.html" + img.get(0).toString()));
			out.write(resultImageResponse.bodyAsBytes());
			out.close();

		}
		// print("\nMedia: (%d)", media.size());
		// for (Element src : media) {
		// if (src.tagName().equals("img"))
		// print(" * %s: <%s> %sx%s (%s)", src.tagName(), src.attr("abs:src"),
		// src.attr("width"),
		// src.attr("height"), trim(src.attr("alt"), 20));
		// else
		// print(" * %s: <%s>", src.tagName(), src.attr("abs:src"));
		// }

		// print("\nImports: (%d)", imports.size());
		// for (Element link : imports) {
		// print(" * %s <%s> (%s)", link.tagName(), link.attr("abs:href"),
		// link.attr("rel"));
		// }
		//
		// print("\nLinks: (%d)", links.size());
		// for (Element link : links) {
		// print(" * a: <%s> (%s)", link.attr("abs:href"), trim(link.text(),
		// 35));
		// }
	}

	// static void getImages(String src) throws IOException {
	//
	// String folder = null;
	//
	// // Exctract the name of the image from the src attribute
	//
	// int indexname = src.lastIndexOf("/");
	// System.out.println(indexname);
	// System.out.println(src.length());
	//
	// if (indexname == src.length()) {
	//
	// src = src.substring(1, indexname);
	//
	// }
	//
	// indexname = src.lastIndexOf("/");
	//
	// String name = src.substring(indexname, src.length());
	//
	// System.out.println(name);
	//
	// // Open a URL Stream
	//
	// URL url = new URL(src);
	//
	// InputStream in = url.openStream();
	//
	// OutputStream out = new BufferedOutputStream(new
	// FileOutputStream("/home/raul/test/tmp/" + name));
	//
	// for (int b; (b = in.read()) != -1;) {
	//
	// out.write(b);
	//
	// }
	//
	// out.close();
	//
	// in.close();
	//
	// }

	private static void print(String msg, Object... args) {
		System.out.println(String.format(msg, args));
	}

	private static String trim(String s, int width) {
		if (s.length() > width)
			return s.substring(0, width - 1) + ".";
		else
			return s;
	}
}
