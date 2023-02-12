package com.m3.clinica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Jvmspbootm3ClinicaApplication{
	/*
	@Autowired
	private BCryptPasswordEncoder passEncoder;
	*/

	public static void main(String[] args) {
		SpringApplication.run(Jvmspbootm3ClinicaApplication.class, args);
	}
/*
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		String password = "123";
		for(int i =0; i<4;i++) {
			String passwordBcrypt = passEncoder.encode(password);
			System.out.println(passwordBcrypt);
		}
	}
*/
}
