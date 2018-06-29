package br.com.farmacia.teste;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.dropbox.core.DbxDownloader;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.ListFolderErrorException;
import com.dropbox.core.v2.files.ListFolderResult;

public class Teste {
	private static final String ACCESS_TOKEN = "rR-a_dxX65AAAAAAAAAABl48CHYl92TBHPCiDlHUjzAcpyRdgCfgorUdpBXPW6_s";

	public static void main(String[] args) throws ListFolderErrorException, DbxException, IOException {
		DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
		DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);
		
		
		// Get files and folder metadata from Dropbox root directory
        ListFolderResult result = client.files().listFolder("");
        DbxDownloader<FileMetadata> imagem =  client.files().download("/Farmacias/Imagens/Teste/logo/batman.jpg");
        
		try (InputStream input = imagem.getInputStream();
				OutputStream out = new FileOutputStream("/home/matheus/Documentos/teste2");) {
			int b;
			while ((b = input.read()) != -1) {
				out.write(b);
			}
		}
        
        /*while (true) {
            for (Metadata metadata : result.getEntries()) {
                System.out.println(metadata.getPathLower());
            }

            if (!result.getHasMore()) {
                break;
            }

            result = client.files().listFolderContinue(result.getCursor());
        }*/
	}

}
