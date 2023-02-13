package com.natwest;

import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

@Service
public class FileStorageService {

	public Resource loadFileAsResource(Path path) throws Exception {
		String fileName = Files.list(path).findFirst().get().toFile().getName();
		Path filePath = path.resolve(fileName).normalize();
		try {
			Resource resource = new UrlResource(filePath.toUri());
			if (resource.exists()) {
				return resource;
			} else {
				throw new MyFileNotFoundException("File not found " + fileName);
			}
		} catch (MalformedURLException ex) {
			throw new MyFileNotFoundException("File not found " + fileName);
		}
	}
}