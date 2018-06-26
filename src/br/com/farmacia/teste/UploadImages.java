package br.com.farmacia.teste;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.users.FullAccount;

public class UploadImages
{
	 private static final String ACCESS_TOKEN = "rR-a_dxX65AAAAAAAAAABl48CHYl92TBHPCiDlHUjzAcpyRdgCfgorUdpBXPW6_s";

	    public static void main(String args[]) throws DbxException, FileNotFoundException, IOException {
	        // Create Dropbox client
	        DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
	        DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);
	    
	        FullAccount account = client.users().getCurrentAccount();
	        System.out.println(account.getName().getDisplayName());
	        System.out.println(account.getEmail());
	        
	        String url = "/home/matheus/Imagens/batman.jpg";
	        File file = new File(url);
	        try (InputStream in = new FileInputStream(file)) {
	        	
	            FileMetadata metadata = client.files().uploadBuilder("/Eu sou foda/batman.jpg")
	                .uploadAndFinish(in);
	        }
	    }
}
