
package Indexador;

import java.io.File;
import java.util.Vector;
import Tela.Tela;

public class Indexador {
	
	
  private Indexador() {}

	     
public static void indexarDocumento(){
	 System.out.println("Arquivos encontrado :");
}

public static File[] listDir(File dir) 
{
	Vector enc = new Vector();
	File[] files = dir.listFiles();
	for (int i = 0; i < files.length; i++) {
		if (files[i].isDirectory()) {
			//Adiciona no Vector os arquivos encontrados dentro de 'files[i]':
			File[] recFiles = listDir(files[i]);
			for (int j = 0; j < recFiles.length; j++) {
				enc.addElement(recFiles[j]);
			}
		} else {
			//Adiciona no Vector o arquivo encontrado dentro de 'dir':
			enc.addElement(files[i]);
		}
	}
	//Transforma um Vector em um File[]:
	File[] encontrados = new File[enc.size()];
	for (int i = 0; i < enc.size(); i++) {
		encontrados[i] = (File)enc.elementAt(i);
	}
	return encontrados;
}

public static void Indexar(File arquivo) {
	 System.out.println("Arquivos encontrado :");
	  //File diretorio = new File(arquivos);
	  File[] encontrados = listDir(arquivo);
	  for(int i = 0; i < encontrados.length; i++)
	  {
		  System.out.println("Arquivos encontrado :" + encontrados[i]);
	  }
	
}

}
















































