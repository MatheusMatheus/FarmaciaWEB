package br.com.farmacia.controller.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;

public class SubidorImagens {
	public static void uploadImagem(HttpServletRequest request, String subpasta) throws ServletException, IOException{

		// Pega o caminho absoluto da aplicação
		String appPath = request.getServletContext().getRealPath("");
		String fullURL = appPath.concat("imgs/farmacias/").concat(subpasta);

		// Create path components to save the file
		Part filePart = request.getPart("logoPath");
		
		String destino = fullURL + File.separator;
		String fileName = getFileName(filePart);
		
		if(!Files.exists(Paths.get(destino))) {
			Files.createDirectories(Paths.get(destino));
		}
		
		File arquivo = new File(destino + File.separator + fileName); 	
		
		try (OutputStream out = new FileOutputStream(arquivo); 
				InputStream filecontent = filePart.getInputStream()){
			
	
			int read = 0;
			final byte[] bytes = new byte[1024];

			while ((read = filecontent.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			
			uploadDropbox(arquivo, fileName, subpasta);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	private static void uploadDropbox(File arquivo, String nomeArq, String subpasta) {
		StringBuilder surl = new StringBuilder();
		surl.append("/Farmacias/Imagens/");
		surl.append(subpasta);
		
		String url = surl.toString();
		
		try (InputStream in = new FileInputStream(arquivo))  {
			ResourceBundle subidor = ResourceBundle.getBundle("br.com.farmacia.controller.subidor-imagens");
			String ACCESS_TOKEN = subidor.getString("ACCESS_TOKEN");
			DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
			DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);
			
			client.files().createFolderV2(url);
			client.files()
				  .uploadBuilder(url + "/" + nomeArq)
				  .uploadAndFinish(in);
			
		} catch (DbxException | IOException e) {
			e.printStackTrace();
		}
	}


	/**
	 * Extracts file name from HTTP header content-disposition
	 */
	private static String getFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return "";
	}
}
