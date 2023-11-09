package com.nextscience.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.stereotype.Component;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

@Component
public final class SftpClient {
	private final String host;
	private final int port;
	private final String username;
	private final String password;
	private final JSch jsch;
	private ChannelSftp channel;
	private Session session;

	/**
	 * @param host     remote host
	 * @param port     remote port
	 * @param username remote username
	 */
	public SftpClient() {
		Properties properties = loadProperties("application.properties");
		host = properties.getProperty("sftp.host");
		port = Integer.parseInt(properties.getProperty("sftp.port"));
		username = properties.getProperty("sftp.username");
		password = properties.getProperty("sftp.password");
		jsch = new JSch();
	}

	/**
	 * Use default port 22
	 *
	 * @param host     remote host
	 * @param username username on host
	 */

	/**
	 * Authenticate with remote using password
	 *
	 * @param password password of remote
	 * @throws JSchException If there is problem with credentials or connection
	 */
	public void authPassword() throws JSchException {
		session = jsch.getSession(username, host, port);
		var config = new Properties();
		config.put("StrictHostKeyChecking", "no");
		session.setConfig(config);
		session.setPassword(password);
		session.connect();
		channel = (ChannelSftp) session.openChannel("sftp");
		channel.connect();
	}

	private Properties loadProperties(String fileName) {
		Properties properties = new Properties();
		try (InputStream input = getClass().getClassLoader().getResourceAsStream(fileName)) {
			if (input == null) {
				System.out.println("Sorry, unable to find " + fileName);
				return properties;
			}
			properties.load(input);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return properties;

	}

	public void uploadFile(InputStream inputStream, String remoteFileName) throws JSchException, SftpException, IOException {
	    try {
	        channel.put(inputStream, remoteFileName);
	    } finally {
	        inputStream.close();  
	    }
	}

}
