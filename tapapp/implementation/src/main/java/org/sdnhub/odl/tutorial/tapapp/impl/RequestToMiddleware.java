package org.sdnhub.odl.tutorial.tapapp.impl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestToMiddleware {
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	public String middlewareUrl;
	public Properties properties;

	public void sendRequest(Object input) {
		try {
			initProperties();
			middlewareUrl = properties.getProperty("middleWareUrl");
			URL url = new URL(middlewareUrl);
			// String auth = "admin:admin";
			// String encoding = Base64.encode(auth.getBytes());

			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			// connection.setRequestProperty("Authorization","Basic " +
			// encoding);
			connection.setRequestProperty("Content-Type", "application/json");

			// String input = "{\"input\": {\n" +
			// "    \"src-ip-address\": \"10.0.0.1/32\",\n" +
			// "    \"dst-ip-address\": \"10.0.0.10/32\",\n" +
			// "    \"switches-in-old-path\": [6, 4, 1, 9, 11],\n" +
			// "    \"switches-in-new-path\": [6, 4, 1, 8, 10, 9, 11],\n" +
			// "    \"flow-priority\": 300\n" +
			// "  }\n" +
			// "}";

			// String input = "{\"input\": {\n" +
			// "    \"src-ip-address\": \"10.0.0.1/32\",\n" +
			// "    \"dst-ip-address\": \"10.0.0.10/32\",\n" +
			// "    \"switches-in-path\": [6, 4, 1, 9, 11],\n" +
			// "    \"flow-priority\": 300\n" +
			// "  }\n" +
			// "}";
			
			
			LOG.debug("==============---------------=================----------------------");
			LOG.debug("     Sending request to: {}, with input: {}", middlewareUrl, (String)input);
			LOG.debug("==============---------------=================----------------------");
			
			OutputStream stream = connection.getOutputStream();
			stream.write(((String) input).getBytes());
			stream.flush();

			// if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
			// throw new RuntimeException("Failed: HTTP error code: "
			// + connection.getResponseCode());
			// }

			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(connection.getInputStream()));

			String output;
//			System.out.println("Server response: ");
			while ((output = bufferedReader.readLine()) != null) {
//				System.out.println(output);
				LOG.debug("==============---------------=================----------------------");
				LOG.debug("     Server response: {}", output);
				LOG.debug("==============---------------=================----------------------");
			}

			connection.disconnect();

		} catch (Exception e) {

			LOG.debug("==============---------------=================----------------------");
			LOG.debug("     Exception occured on sending request to MiddleWare: {}", e.getMessage());
			LOG.debug("==============---------------=================----------------------");
		}
	}
	
	/**
	 * Initialize the configuration file
	 */
	private void initProperties() {
		properties = new Properties();
        
		final String dir = System.getProperty("user.dir");
//        System.out.println("current dir = " + dir);

        String key = "distribution";
        String[] parts = dir.split(key);
        String resources = "tapapp/implementation/src/main/resources/ddos-config.properties";
        String resourcesPath = parts[0] + resources;

//        System.out.println("Final path: " + resourcesPath);
        try {
			properties.load(new FileInputStream(resourcesPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
