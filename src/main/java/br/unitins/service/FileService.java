package br.unitins.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;

@ApplicationScoped
public class FileService {
    
    public void salvarImagemUsuario(byte[] imagem, String nomeImagem) {
        // String path = "C:/Users/usuarios/Documents/imagem_usuario/" + nomeImagem;
         String path = "/Users/janio/Documents/imagens_usuario/" + nomeImagem;
       
         // salvando o arquivo
         try {
            File file = new File(path);
            if (!file.exists())
                file.createNewFile();

            FileOutputStream fos = new FileOutputStream(file);
            // salvando no hd
            fos.write(imagem);
            // garantindo o envio do ultimo lote de bytes
            fos.flush();
            fos.close();

         } catch (IOException e) {
            e.printStackTrace();
         }

    }

}
