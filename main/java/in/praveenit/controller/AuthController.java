package in.praveenit.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.praveenit.security.JwtUtil;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping("/login")
	public String login(@RequestBody Map<String, String> user) {
		if (user.get("username").equals("admin") && user.get("password").equals("admin")) {
			return jwtUtil.generateToken(user.get("username"));
		}
		throw new RuntimeException("Invalid login");
	}
}
