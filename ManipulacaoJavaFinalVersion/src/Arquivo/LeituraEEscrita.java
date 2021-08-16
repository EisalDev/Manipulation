package Arquivo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class LeituraEEscrita {
	
	BufferedReader reader;
	BufferedWriter writer; 
	String arquivo = "./BD/arquivo.txt";
	String backup = "./BD/backup.txt";
	
	void salvar(String content) {
		try {
			writer = new BufferedWriter(new FileWriter(arquivo, false));
			writer.write(content);
			writer.close();
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar arquivo: " + e);
		}
	}
	void salvarUpper(String content) {
		try {
			writer = new BufferedWriter(new FileWriter(arquivo, false));
			writer.write(content.toUpperCase());
			writer.close();
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar arquivo: " + e);
		}
	}
	
	void salvarBackup(String content) {
		try {
			writer = new BufferedWriter(new FileWriter(backup, false));
			writer.write(content);
			writer.close();
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar arquivo: " + e);
		}
	}
	
	String open() {
		String retorno = "";
		try {
			reader = new BufferedReader(new FileReader(arquivo));
			String linha = "";
			while((linha = reader.readLine()) != null) {
				retorno += linha + "\n";
			}
			reader.close();			
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Arquivo não encontrado: " + e);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao abrir arquivo: " + e);
		}
		return retorno;
	}
	
	String openBackup() {
		String retorno = "";
		try {
			reader = new BufferedReader(new FileReader(backup));
			String linha = "";
			while((linha = reader.readLine()) != null) {
				retorno += linha + "\n";
			}
			reader.close();			
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Arquivo não encontrado: " + e);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao abrir arquivo: " + e);
		}
		return retorno;
	}
	String getLines(String txt) {
		String retorno = "Linhas: ";
		int count = 1;
		for(int i = 0; i < txt.length(); i++)
		{
			if(txt.charAt(i) == '\n') count += 1;
		}
		return retorno + count;
	}
	
	String getChars(String txt) {
		String retorno = "Caractéres: ";
		int count = 0;
		for(int i = 0; i < txt.length(); i++)
		{
			String t = (i < txt.length() - 1)? String.valueOf(txt.charAt(i)) + String.valueOf(txt.charAt(i+1)) : String.valueOf(txt.charAt(i-1)) + String.valueOf(txt.charAt(i));
			String tt = (i > 0)? String.valueOf(txt.charAt(i-1)) + String.valueOf(txt.charAt(i)) : String.valueOf(txt.charAt(i)) + String.valueOf(txt.charAt(i+1));
			if(t != "\n" && tt != "\n" && txt.charAt(i) != ' ' && txt.charAt(i) != '\n') count += 1;
		}
		return retorno + count;
	}
	

}
