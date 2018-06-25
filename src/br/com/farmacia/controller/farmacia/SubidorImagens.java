package br.com.farmacia.controller.farmacia;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

public class SubidorImagens {
	public static void uploadImagem(HttpServletRequest request) {

		OutputStream out = null;
		InputStream filecontent = null;

		try {
			// Pega o caminho absoluto da aplicação
			String appPath = request.getServletContext().getRealPath("");
			String razaoSocial = request.getParameter("razaoSocial");
			String fullURL = appPath.concat("imgs/farmacias/").concat(razaoSocial).concat("/logo");

			// Create path components to save the file
			final Part filePart = request.getPart("logoPath");
			String destino = fullURL + File.separator;
			final String fileName = getFileName(filePart);
			
			if(!Files.exists(Paths.get(destino))) {
				Files.createDirectories(Paths.get(destino));
			}

			out = new FileOutputStream(new File(destino + File.separator + fileName));
			filecontent = filePart.getInputStream();

			int read = 0;
			final byte[] bytes = new byte[1024];

			while ((read = filecontent.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
		} catch (IOException | ServletException fne) {
			fne.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (filecontent != null) {
				try {
					filecontent.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
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
