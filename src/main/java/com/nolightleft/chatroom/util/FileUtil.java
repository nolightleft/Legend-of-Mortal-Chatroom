package com.nolightleft.chatroom.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * Title: {@link FileUtil}
 * </p>
 * <b>Description:</b>
 * <p>
 * Insert Description here
 * </p>
 *
 * @author lzu
 */
public class FileUtil {
	public static final String ROOT = "cache";
//	public static final String IMAGE_DIR = ROOT + "/pictures/";
	public static final String ICON_DIR = "/img/icons/";
	public static final String PICTURE_DIR = "/img/pictures/";
	
	/**
	 * @param imageName
	 * @param imageData
	 * @throws IOException
	 */
	public static void saveImage(String imageName, byte[] imageData) throws IOException {
		
		if (imageData != null) {
			InputStream inputStream = new ByteArrayInputStream(imageData);
			
			try {
				saveFile(ICON_DIR, imageName, inputStream);
			} catch (IOException ioe) {
				throw new IOException("Could not save image: " + imageName, ioe);
			}
		}
	}
	
	/**
	 * @param fileName
	 * @param multipartFile
	 * @throws IOException
	 */
	public static void saveFile(String fileName, MultipartFile multipartFile) throws IOException {
		try (InputStream inputStream = multipartFile.getInputStream()) {
			saveFile(ICON_DIR, fileName, inputStream);
		} catch (IOException ioe) {
			throw new IOException("Could not save file: " + fileName, ioe);
		}
	}
	
	/**
	 * @param uploadDir
	 * @param fileName
	 * @param inputStream
	 * @throws IOException
	 */
	private static void saveFile(String uploadDir, String fileName, InputStream inputStream) throws IOException {
		Path destinyDirPath = Paths.get(uploadDir);

		if (!Files.exists(destinyDirPath)) {
			Files.createDirectories(destinyDirPath);
		}

		Files.copy(inputStream, destinyDirPath.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
	}
}
