package com.github.nenomm.im.oxm.springway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.nenomm.im.oxm.SettingsConsumer;

@Configuration
public class SpringWayConfig {

	@Bean
	public SettingsConsumer settingsConsumerSpringWay() {
		SettingsConsumer settingsConsumer = new SettingsConsumer();
		settingsConsumer.setFileName("springWay.xml");
		return settingsConsumer;
	}
}
