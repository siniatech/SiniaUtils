package com.siniatech.siniautils.file;

import static java.nio.file.Files.createFile;
import static java.nio.file.Files.exists;
import static java.nio.file.Files.newBufferedReader;
import static java.nio.file.Files.newBufferedWriter;
import static java.nio.file.Files.newInputStream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PathHelper {

	static public Path createFileWithContents(String pathString, String contents)
			throws IOException {
		Path path = FileSystems.getDefault().getPath(pathString);
		if (exists(path)) {
			throw new IOException("File " + pathString + " already exists.");
		} else {
			createFile(path);
		}
		BufferedWriter out = newBufferedWriter(path, Charset.defaultCharset());
		out.write(contents);
		out.close();
		return path;
	}

	static public String getFileContents(Path file) throws IOException {
		StringBuffer sb = new StringBuffer();
		BufferedReader in = newBufferedReader(file, Charset.defaultCharset());
		String line;
		while ((line = in.readLine()) != null) {
			sb.append(line);
		}
		in.close();
		return sb.toString();
	}

	static public String sha1(Path path) throws IOException,
			NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA1");
		InputStream is = newInputStream(path);
		byte[] dataBytes = new byte[1024];
		int nread = 0;
		while ((nread = is.read()) != -1) {
			md.update(dataBytes, 0, nread);
		}
		byte[] mdbytes = md.digest();
		StringBuffer sb = new StringBuffer("");
		for (int i = 0; i < mdbytes.length; i++) {
			sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16)
					.substring(1));
		}

		return sb.toString();
	}
}
