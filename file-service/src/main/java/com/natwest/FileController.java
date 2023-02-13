package com.natwest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("files")
@CrossOrigin
public class FileController {

	@Autowired
	private FileStorageService fileStorageService;
	private static final String FILE_UPLOAD_BASE_DIR = "c:\\upload\\";

	@PostMapping("upload")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file,
			@RequestParam("username") String username) throws Exception {
		createDirIfNotExists(FILE_UPLOAD_BASE_DIR);
		String fileName = file.getOriginalFilename();
		String fileUploadPath = FILE_UPLOAD_BASE_DIR + username;
		createDirIfNotExists(fileUploadPath);
		if (Files.exists(Paths.get(fileUploadPath + "\\" + fileName))) {
			return new ResponseEntity<>("File alreday exists", HttpStatus.OK);
		}
		file.transferTo(new File(fileUploadPath + "\\" + fileName));
		return new ResponseEntity<>("File has been uploaded successfully", HttpStatus.OK);
	}

	private void createDirIfNotExists(String dir) throws Exception {
		if (Files.notExists(Paths.get(dir))) {
			Files.createDirectories(Paths.get(dir));
		}
	}

	@GetMapping("download/{username}")
	public ResponseEntity<Object> downloadFile(@PathVariable("username") String username,
			HttpServletRequest request) {
		String fileDownloadBaseDir = FILE_UPLOAD_BASE_DIR + username;
		Path fileDownloadPath = Paths.get(fileDownloadBaseDir);
		try {
			Resource resource = fileStorageService.loadFileAsResource(fileDownloadPath);
			String contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
			if (contentType == null) {
				contentType = "application/octet-stream";
			}
			return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType)).body(resource);
		} catch (Exception ex) {
			return ResponseEntity.internalServerError().body("File not found at location "+ex.getMessage());
		}
	}
}