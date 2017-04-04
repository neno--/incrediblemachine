package com.github.nenomm.im.another;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	@Bean(name = "strange")
	Object strangeOne() {
		return 42;
	}
}
