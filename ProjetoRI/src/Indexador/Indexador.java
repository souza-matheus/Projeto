
package Indexador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Vector;
import Tela.Tela;

public class Indexador
{

private Indexador() {
}

public static void indexarDocumento()
{

}

public static File[] listDir(File dir)
{
	Vector enc = new Vector();
	File[] files = dir.listFiles();
	for (int i = 0; i < files.length; i++)
	{
		if (files[i].isDirectory())
		{
			// Adiciona no Vector os arquivos encontrados dentro de
			// 'files[i]':
			File[] recFiles = listDir(files[i]);
			for (int j = 0; j < recFiles.length; j++)
			{
				enc.addElement(recFiles[j]);
			}
		} else
		{
			// Adiciona no Vector o arquivo encontrado dentro de 'dir':
			enc.addElement(files[i]);
		}
	}
	// Transforma um Vector em um File[]:
	File[] encontrados = new File[enc.size()];
	for (int i = 0; i < enc.size(); i++)
	{
		encontrados[i] = (File) enc.elementAt(i);
	}
	return encontrados;
}

public static void Indexar(File arquivo)
{

	// File diretorio = new File(arquivos);
	File[] encontrados = listDir(arquivo);

	TreeMap<String, Integer> frequencia = new TreeMap<String, Integer>();
	Map[] mapa = new Map[5];
	mapa[0] = new HashMap<String, Integer>();

	lerArquivo(frequencia, encontrados);
	salvarDados(frequencia);

}

public static void lerArquivo(TreeMap<String, Integer> frequencia, File[] encontrados)
{
	long total = 0;
	Scanner arquivo;
	String palavra; // Pega palavra
	Integer cont; // Ocorrencia de determinada palavra
	long contador = 0;
	int docs = 0;

	for (int x = 0; x < encontrados.length; x++)
	{

		try
		{
			arquivo = new Scanner(new FileReader(encontrados[x]));
		} catch (FileNotFoundException e)
		{
			System.err.println(e);
			return;
		}
		System.out.println("Lendo arquivo: " + encontrados[x]);
		while (arquivo.hasNext())
		{
			palavra = arquivo.next();// Leitura da proxima palavra
			palavra = palavra.toLowerCase(); // Passa tudo para minúsculo
			palavra = palavra.replaceAll("[^a-zA-Z0-9\\s]", ""); // remove caracteres inuteis																	
			cont = getCont(palavra, frequencia) + 1;// Pega o cont da palavra e adiciona 1
			frequencia.put(palavra, cont);
			total = total + cont;
			contador++;
			docs = x + 1;

		}
	}
	// End of for loop *]
	System.out.println("Há " + total + " palavras na coleção.");
	System.out.println("Há " + contador + " palavras únicas na coleção.");
	System.out.println("Há " + docs + " documentos na coleção.");

}

public static int getCont(String word, TreeMap<String, Integer> frequencyData)
{
	if (frequencyData.containsKey(word))
	{ // Se a palavra ja ocorreu
		return frequencyData.get(word); // Retorna tamanho
	} else
	{
		return 0;// palavra não ocorreu
	}
}

private static String diretorio = System.getProperty("user.home") + "/Desktop/";

public static void salvarDados(TreeMap<String, Integer> frequencia)
{
	File file = new File(diretorio + "//indexado.txt");
	try
	{
		if (!file.exists())
		{
			file.createNewFile();
		}
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
	} catch (Exception e)
	{
	}
	try
	{
		FileWriter escrever = new FileWriter(new File(diretorio + "indexado.txt"));
		for (String word : frequencia.keySet())
		{
			// escrever.write(String.format("%15d %s\n",
			// frequencia.get(word), word));
			escrever.write(String.format(frequencia.get(word) + "," + word));
			escrever.write(System.lineSeparator());
		}
		escrever.close();
	} catch (IOException e)
	{
		e.printStackTrace();
	}

}

}
