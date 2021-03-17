package escrever.json.rev1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class EscreverJSON {

	public static void main(String[] args) throws IOException {
		Path config2 = Paths.get("C:\\Users\\Acer\\Google Drive\\Classroom\\Senai\\Programação Web Back-End\\MeuPrograma\\teste.json");
		//Path caminho = Paths.get("F:\\Users\\Acer\\Documents\\GitHub\\Projeto-Jogo-Memoria\\version2\\img\\marvel-dc\\");
		
		
		BufferedWriter bw = null;
		bw = Files.newBufferedWriter(config2, StandardCharsets.UTF_8);
		
		File arquivos = new File("F:\\Users\\Acer\\Documents\\GitHub\\Projeto-Jogo-Memoria\\version2\\img\\marvel-dc");
			File[] file = arquivos.listFiles();
					
					for (int i = 0; i < file.length; i++) {
						File f = file[i];
						
							bw.write("{" + "\"Id\":"+ "\"" + i + "\"" + ",\r\n" + "    \"Url\": \"./img/marvel-dc/" + f.getName() + "\"\r\n" + "},");
					}
					
				System.out.println("Fim !");
				bw.flush();
				bw.close();
	}
}
