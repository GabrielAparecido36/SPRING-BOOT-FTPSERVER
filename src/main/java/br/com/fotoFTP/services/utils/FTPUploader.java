package br.com.fotoFTP.services.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.web.multipart.MultipartFile;

public class FTPUploader extends FTP {

	public List<String> Upar(MultipartFile [] fl) throws IOException, URISyntaxException {
		
		List<File> files = new ArrayList<>();
		List<String> urlFotos = new ArrayList<>();
		
		for(int i = 0; i < fl.length; i++) {
			File file = new File(fl[i].getOriginalFilename());
			file.createNewFile();
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(fl[i].getBytes());
			fos.close();
			files.add(file);
		}


		FTPClient ftp = new FTPClient();
		try {
			int reply;
			String server = "ftp.camassonequinha.com.br";
			ftp.connect(server);
			ftp.login("testes@camassonequinha.com.br", "senha321");
			reply = ftp.getReplyCode();

			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
			}
			ftp.setFileType(FTP.BINARY_FILE_TYPE);
			for(int i = 0; i < files.size(); i++) {
				InputStream inputStream = new FileInputStream(files.get(i));
				ftp.storeFile(files.get(i).getName(), inputStream);
				inputStream.close();
				urlFotos.add("img/" + files.get(i).getName());
			}
			ftp.logout();
			return urlFotos;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException ioe) {

				}
			}
		}
		return null;

	}

}
