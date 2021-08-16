package Arquivo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Form extends JFrame implements ActionListener {

	
	private static final long serialVersionUID = 1L;
	private static LeituraEEscrita ler, save;
	private JPanel painel;
	private JButton BTleitura, BTsalvar, BTbackupSalvar, BTbackupLer,BTmaiusculas,BTchar,BTline;
	private JTextArea ATexto;
	private JTextField CTexto,LTexto;
	
	Form(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Textualizador-O-Matic® © Ryan, Isael & Vitor");
		setSize(980, 485);
		painel = new JPanel();
		setContentPane(painel);
		painel.setBackground(new Color(30, 30, 30));
		setLocationRelativeTo(null);
		setLayout(null);
		
		BTleitura = new JButton("Ler arquivo");
		BTleitura.setForeground(Color.white);
		BTleitura.setBounds(10,10,150,30);
		BTleitura.setBackground(new Color(207, 75, 0));
		painel.add(BTleitura);
		
		BTsalvar = new JButton("Salvar arquivo");
		BTsalvar.setBounds(170,10,150,30);
		BTsalvar.setForeground(Color.white);
		BTsalvar.setBackground(new Color(207, 75, 0));
		painel.add(BTsalvar);
		
		BTbackupSalvar = new JButton("Salvar backup");
		BTbackupSalvar.setBounds(330,10,150,30);
		BTbackupSalvar.setForeground(Color.white);
		BTbackupSalvar.setBackground(new Color(207, 75, 0));
		painel.add(BTbackupSalvar);
		
		BTbackupLer = new JButton("Ler backup");
		BTbackupLer.setBounds(490,10,150,30);
		BTbackupLer.setForeground(Color.white);
		BTbackupLer.setBackground(new Color(207, 75, 0));
		painel.add(BTbackupLer);
		
		BTmaiusculas = new JButton("Salvar maiúsculas");
		BTmaiusculas.setBounds(650,10,150,30);
		BTmaiusculas.setForeground(Color.white);
		BTmaiusculas.setBackground(new Color(207, 75, 0));
		painel.add(BTmaiusculas);
		
		BTchar = new JButton("Atualizar caractéres");
		BTchar.setBounds(810,10,150,30);
		BTchar.setForeground(Color.white);
		BTchar.setBackground(new Color(207, 75, 0));
		painel.add(BTchar);
		
		CTexto = new JTextField("Caractéres: 0");
		CTexto.setBounds(810,50,150,30);
		CTexto.setBackground(new Color(45, 45, 45));
		CTexto.setForeground(Color.white);
		CTexto.setEditable(false);
		painel.add(CTexto);
		
		BTline = new JButton("Atualizar linhas");
		BTline.setBounds(810,90,150,30);
		BTline.setForeground(Color.white);
		BTline.setBackground(new Color(207, 75, 0));
		painel.add(BTline);
		
		LTexto = new JTextField("Linhas: 0");
		LTexto.setBounds(810,130,150,30);
		LTexto.setBackground(new Color(45, 45, 45));
		LTexto.setForeground(Color.white);
		LTexto.setEditable(false);
		painel.add(LTexto);
		
		ATexto = new JTextArea("");
		ATexto.setBounds(10,50,790,400);
		ATexto.setBackground(new Color(45, 45, 45));
		ATexto.setForeground(Color.white);
		painel.add(ATexto);
		
		BTleitura.addActionListener(this);
		BTsalvar.addActionListener(this);
		BTbackupSalvar.addActionListener(this);
		BTbackupLer.addActionListener(this);
		BTmaiusculas.addActionListener(this);
		BTchar.addActionListener(this);
		BTline.addActionListener(this);
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == BTleitura) {
			ATexto.setText(ler.open());		
			
		}else if(e.getSource() == BTsalvar) {
			ler.salvar(ATexto.getText());
			
		}else if(e.getSource() == BTbackupSalvar) {
			save.salvarBackup(ATexto.getText());
			
		}else if(e.getSource() == BTbackupLer) {
			ATexto.setText(save.openBackup());
			
		}else if(e.getSource() == BTmaiusculas) {
			ler.salvarUpper(ATexto.getText());
			ATexto.setText(ler.open());
		}else if(e.getSource() == BTline) {
			LTexto.setText(ler.getLines(ATexto.getText()));
		}else if(e.getSource() == BTchar) {
			CTexto.setText(ler.getChars(ATexto.getText()));
		}
	}
	
	public static void main(String[] args) {
		save = new LeituraEEscrita();
		ler = new LeituraEEscrita();
		new Form().setVisible(true);
			
	}
	
}
/*ler = new LeituraEEscrita();
String texto = "Banana melancia\r\n";
//ler.salvar(texto);
System.out.println(ler.open());
*/