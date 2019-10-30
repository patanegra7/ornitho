package cat.dme.ornitho.server.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TODO: Review
 *
 */
public class FileUtil {

	private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);

	private static final Charset CHARSET_UTF8 = StandardCharsets.UTF_8;

	public static void writeStrToFile(final String pathFile, final String content) {

		FileOutputStream fos = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;

		try {
			final File file = new File(pathFile);

			if (!file.exists()) {
				// make sure folders exists
				file.getParentFile().mkdirs();
				file.createNewFile();
			}

			fos = new FileOutputStream(file);
			osw = new OutputStreamWriter(fos, FileUtil.CHARSET_UTF8);
			bw = new BufferedWriter(osw);
			bw.write(content);

		} catch (final IOException e) {
			FileUtil.logger.error("writeStrToFile: Error writing content", e);
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
				if (osw != null) {
					osw.close();
				}
				if (fos != null) {
					fos.close();
				}
			} catch (final IOException e) {
				FileUtil.logger.error("writeStrToFile: Error closing file", e);
			}
		}
	}

	public static String readStrFromFile(final String pathFile) {

		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		StringBuilder sb = null;

		try {
			String sCurrentLine;

			fis = new FileInputStream(pathFile);
			isr = new InputStreamReader(fis, FileUtil.CHARSET_UTF8);
			br = new BufferedReader(isr);
			sb = new StringBuilder();

			while ((sCurrentLine = br.readLine()) != null) {
				sb.append(sCurrentLine);
			}

		} catch (final IOException e) {
			FileUtil.logger.error("readStrFromFile: Error reading content", e);
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (isr != null) {
					isr.close();
				}
				if (fis != null) {
					fis.close();
				}
			} catch (final IOException e) {
				FileUtil.logger.error("readStrFromFile: Error closing file", e);
			}
		}

		return sb.toString();
	}

	public static String readStrFromJsonResourceFile(final String pathResourceFile) {

		StringBuilder sb = null;
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;

		try {
			sb = new StringBuilder();
			is = Thread.currentThread().getContextClassLoader().getResourceAsStream(pathResourceFile);
			if (is == null)
				return null;
			isr = new InputStreamReader(is, FileUtil.CHARSET_UTF8);
			br = new BufferedReader(isr);

			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
		} catch (final IOException e) {
			FileUtil.logger.error("readStrFromJsonResourceFile: Error reading content", e);
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (isr != null) {
					isr.close();
				}
				if (is != null) {
					is.close();
				}
			} catch (final IOException e) {
				FileUtil.logger.error("readStrFromJsonResourceFile: Error closing file", e);
			}
		}

		return sb.toString();
	}
}
