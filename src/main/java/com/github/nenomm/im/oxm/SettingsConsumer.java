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
	private static final String FILE_PATH = SettingsConsumer.class.getResource(".").getPath();
	private SomeSettings settings = new SomeSettings();
	private String fileName;

	@Resource(name = "marshaller")
	private Marshaller marshaller;

	@Resource(name = "marshaller")
	private Unmarshaller unmarshaller;

	public void setMarshaller(Marshaller marshaller) {
		this.marshaller = marshaller;
	}

	public void setUnmarshaller(Unmarshaller unmarshaller) {
		this.unmarshaller = unmarshaller;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void saveSettings() throws IOException {
		FileOutputStream os = null;

		try {
			os = new FileOutputStream(FILE_PATH + fileName);
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
			is = new FileInputStream(FILE_PATH + fileName);
			this.settings = (SomeSettings) this.unmarshaller.unmarshal(new StreamSource(is));
		}
		finally {
			if (is != null) {
				is.close();
			}
		}
	}

}
