package com.github.nenomm.im.oxm;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.annotation.Resource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;

public class SettingsConsumer {
	private static final String FILE_NAME = "someSettings.xml";
	private static final String FILE_LOCATION = SettingsConsumer.class.getResource(".").getPath() + FILE_NAME;
	private SomeSettings settings = new SomeSettings();

	@Resource(name = "castorMarshaller")
	private Marshaller marshaller;

	@Resource(name = "castorMarshaller")
	private Unmarshaller unmarshaller;

	public void setMarshaller(Marshaller marshaller) {
		this.marshaller = marshaller;
	}

	public void setUnmarshaller(Unmarshaller unmarshaller) {
		this.unmarshaller = unmarshaller;
	}

	public void saveSettings() throws IOException {
		FileOutputStream os = null;

		try {
			os = new FileOutputStream(FILE_LOCATION);
			this.marshaller.marshal(settings, new StreamResult(os));
		}
		finally {
			if (os != null) {
				os.close();
			}
		}
	}

	public void loadSettings() throws IOException {
		FileInputStream is = null;
		try {
			is = new FileInputStream(FILE_LOCATION);
			this.settings = (SomeSettings) this.unmarshaller.unmarshal(new StreamSource(is));
		}
		finally {
			if (is != null) {
				is.close();
			}
		}
	}

}
