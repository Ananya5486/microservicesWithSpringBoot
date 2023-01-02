package com.udemy.in28minutes.rest.webservices.restfulwebservices;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

@RestController
public class Download {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/print")
	public void download() {
		String filePath = "E:\\backup\\Desktop\\Documents\\PAN.pdf";
		logger.info("file path->>>>>" + filePath);
		File file = new File(filePath);
		StreamingResponseBody body = outputStream -> {
			InputStream inputStream = new FileInputStream(file);
			inputStream.transferTo(outputStream);
			logger.info("Downloaded");
		};
	}
}
