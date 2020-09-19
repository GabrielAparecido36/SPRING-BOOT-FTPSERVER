package br.com.fotoFTP.dependencies;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.web.multipart.MultipartFile;

public class FTPUploader extends FTP {

	public void Upar(MultipartFile fl) throws IOException {
		File file = new File(fl.getOriginalFilename());
		file.createNewFile();
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(fl.getBytes());
		fos.close();


		FTPClient ftp = new FTPClient();
		boolean error = false;
		try {
			int reply;
			String server = "***";
			ftp.connect(server);
			ftp.login("***", "***");
			reply = ftp.getReplyCode();

			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
			}
			ftp.setFileType(FTP.BINARY_FILE_TYPE);
			String firstRemoteFile = "BK.jpg";
			InputStream inputStream = new FileInputStream(file);
			boolean done = ftp.storeFile(firstRemoteFile, inputStream);
			inputStream.close();
			ftp.logout();
		} catch (IOException e) {
			error = true;
			e.printStackTrace();
		} finally {
			if (ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException ioe) {

				}
			}
		}

	}

}
