package com.github.nenomm.im.oxm;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.castor.CastorMarshaller;

@Configuration
public class OxmConfig {

	@Bean
	public SettingsConsumer settingsConsumer() {
		SettingsConsumer settingsConsumer = new SettingsConsumer();
		settingsConsumer.setFileName("defaultWay.xml");
		return settingsConsumer;
	}

	@Bean
	public CastorMarshaller marshaller() {
		CastorMarshaller castorMarshaller = new CastorMarshaller();
		castorMarshaller.setTargetClass(SomeSettings.class);
		castorMarshaller.setUseXSITypeAtRoot(true);

		return castorMarshaller;
	}
}
