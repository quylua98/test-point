package com.quylua98;

import com.quylua98.dto.ResponseData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@SpringBootApplication
@Controller
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@PostMapping("/api/altema/pointsget_api")
	public ResponseEntity<?> getPoint(@RequestBody String suid) {
		return ResponseEntity.ok(new ResponseData(suid, 1000, 200, "success"));
	}

}
