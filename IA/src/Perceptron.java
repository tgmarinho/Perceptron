
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Perceptron extends JFrame {

	private static final long serialVersionUID = 1L;

	public static JComboBox d0 = new JComboBox(new String[] { "0", "1" });
	public static JComboBox d1 = new JComboBox(new String[] { "0", "1" });
	public static JComboBox d2 = new JComboBox(new String[] { "0", "1" });
	public static JComboBox d3 = new JComboBox(new String[] { "0", "1" });
	public static JComboBox d4 = new JComboBox(new String[] { "0", "1" });
	public static JComboBox d5 = new JComboBox(new String[] { "0", "1" });
	public static JComboBox d6 = new JComboBox(new String[] { "0", "1" });
	public static JComboBox d7 = new JComboBox(new String[] { "0", "1" });
	
	public static JCheckBox d0verifica = new JCheckBox();
	public static JCheckBox d1verifica = new JCheckBox();
	public static JCheckBox d2verifica = new JCheckBox();
	public static JCheckBox d3verifica = new JCheckBox();
	public static JCheckBox d4verifica = new JCheckBox();
	public static JCheckBox d5verifica = new JCheckBox();
	public static JCheckBox d6verifica = new JCheckBox();
	public static JCheckBox d7verifica = new JCheckBox();
	
	public static JTextArea saidaCampo = new JTextArea();

	public static JTextField cw1 = new JTextField();
	public static JTextField cw2 = new JTextField();
	public static JTextField cw3 = new JTextField();
	public static JTextField cwb = new JTextField();
	public static JTextField cn = new JTextField();
	public static JButton aprender = new JButton("Aprender!");
	public static JButton limpar = new JButton("Limpar");
	public static JButton salvar = new JButton("Salvar (.txt)");
	public static JButton creditos = new JButton("Créditos");
	public static JButton sair = new JButton("Sair");

	public static float w1, w2, w3;
	public static float y, n, wb;

	public Perceptron() {
		super();
	}
	
	
	public static void main(String[] a) {
		montaJanela();
	}

	/**
	 * Função que Monta os itens da janela principal
	 */
	public static void montaJanela() {
		JFrame janela = new JFrame("Perceptron");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = janela.getContentPane();
		c.setLayout(new GridLayout(2, 3));

		c.add(tabela());
		c.add(valores());
		c.add(displaySaida());
		c.add(botoes());

		// janela.pack();
		janela.setBounds(350, 200, 600, 480);
		janela.setResizable(false);
		janela.setVisible(true);
	}

	/**
	 * Campo de texto de saída com borda xD
	 * 
	 * @return Campo de saída
	 */
	private static Component displaySaida() {
		JPanel p = new JPanel(new GridLayout(1, 1));
		p.setBorder(BorderFactory.createTitledBorder("Saída"));

		saidaCampo.setRows(5);
		p.add(saidaCampo);
		return p;
	}

	/**
	 * inicializa botões de controle
	 * 
	 * @return botões
	 */
	private static Component botoes() {
		JPanel p = new JPanel(new GridLayout(5, 5));
		p.setBorder(BorderFactory.createTitledBorder("Botões de Controle"));

		aprender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btaprender();
			}
		});
		p.add(aprender);
		limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btlimpar();
			}
		});
		p.add(limpar);
		salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btsalvar();
			}
		});
		p.add(salvar);
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btsair();
			}
		});
		
		p.add(creditos);
		creditos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				creditos();
			}
		});
		p.add(creditos);

		p.add(sair);
		return p;
	}

	/**
	 * Cria labels e campos para os valores que serão utilizados nos calculos
	 * 
	 * @return panel
	 */
	private static Component valores() {
		JPanel p = new JPanel(new GridLayout(5, 2));
		p.setBorder(BorderFactory.createTitledBorder("Valores para Cálculo"));
		
		p.add(new JLabel("                           W1:"));
		p.add(cw1);

		p.add(new JLabel("                           W2:"));
		p.add(cw2);
		
		p.add(new JLabel("                           W3:"));// SwingConstants.RIGHT
		p.add(cw3);
		
		p.add(new JLabel("                           WB:"));
		p.add(cwb);
	
		p.add(new JLabel("                             N:"));
		p.add(cn);

		return p;
	}

	/**
	 * Monta a tabela dos campos de bits
	 * 
	 * @return tabela
	 */
	private static Component tabela() {
		JPanel p = new JPanel(new GridLayout(9, 4));
		p.setBorder(BorderFactory.createTitledBorder("Conjunto de Entradas"));
		// Labels...
		p.add(new JLabel("X3"));
		p.add(new JLabel("X2"));
		p.add(new JLabel("X1"));
		p.add(new JLabel("D"));
		p.add(new JLabel("Teste"));
		
		// Campos...

		p.add(zero());
		p.add(zero());
		p.add(zero());
		p.add(d0);
		p.add(d0verifica);
		//if(d0verifica.isSelected()) { 

		//}
		
		p.add(zero());
		p.add(zero());
		p.add(um());
		p.add(d1);
		p.add(d1verifica);
		
		p.add(zero());
		p.add(um());
		p.add(zero());
		p.add(d2);
		p.add(d2verifica);
		
		p.add(zero());
		p.add(um());
		p.add(um());
		p.add(d3);
		p.add(d3verifica);

		p.add(um());
		p.add(zero());
		p.add(zero());
		p.add(d4);
		p.add(d4verifica);

		p.add(um());
		p.add(zero());
		p.add(um());
		p.add(d5);
		p.add(d5verifica);

		p.add(um());
		p.add(um());
		p.add(zero());
		p.add(d6);
		p.add(d6verifica);

		p.add(um());
		p.add(um());
		p.add(um());
		p.add(d7);
		p.add(d7verifica);
		

		return p;
	}

	/**
	 * Disable textfield = zero
	 * 
	 * @return textfield
	 */
	public static JTextField zero() {
		JTextField zero = new JTextField("0");
		zero.setEnabled(false);
		return zero;
	}

	/**
	 * Disable textfield = um
	 * 
	 * @return textfield
	 */
	public static JTextField um() {
		JTextField um = new JTextField("1");
		um.setEnabled(false);
		return um;
	}

	// ////////////////////////////////
	/**
	 * Botão aprender
	 */
	public static void btaprender() {

		if( cw1.getText().equals("") || cw2.getText().equals("") || cw3.getText().equals("") ||
				cwb.getText().equals("") || cwb.getText().equals("") || cn.getText().equals("") ) {
			
			JOptionPane.showMessageDialog(null, "Todos os campos devem estar preenchidos");
			
		} else {

			int vet[] = new int[8];
			vet[0] = Integer.parseInt((String) d0.getSelectedItem());
			vet[1] = Integer.parseInt((String) d1.getSelectedItem());
			vet[2] = Integer.parseInt((String) d2.getSelectedItem());
			vet[3] = Integer.parseInt((String) d3.getSelectedItem());
			vet[4] = Integer.parseInt((String) d4.getSelectedItem());
			vet[5] = Integer.parseInt((String) d5.getSelectedItem());
			vet[6] = Integer.parseInt((String) d6.getSelectedItem());
			vet[7] = Integer.parseInt((String) d7.getSelectedItem());
			// Valores no dos D's no vetor
			calcular(vet);
			
		}
	}

	public static void calcular(int[] d) {

		boolean aprendeu = true;
		int epoca = 0;
		w1 = Float.parseFloat(cw1.getText());
		w2 = Float.parseFloat(cw2.getText());
		w3 = Float.parseFloat(cw3.getText());
		wb = Float.parseFloat(cwb.getText());
		n = Float.parseFloat(cn.getText());
		saidaCampo.setText("");
		

		do {
			System.out.print("\n--- ÉPOCA:" + (epoca + 1));
			saidaCampo.setText(saidaCampo.getText() + "\n----------------\n"
					+ (epoca + 1) + "------------ª EPOCA:\n--------------\n");
			aprendeu = true;
			
			if(!d0verifica.isSelected()) {
			
				// x1 = 0, x2 = 0 e x3 = 0 -> A SAIDA AQUI EU ARRUMEI, TEM Q DEIXAR IGUAL PARA OS OUTROS
				saidaCampo.setText(saidaCampo.getText()
						+ "\n1ª Entrada (0-0-0):\nw1:" + w1 + ", w2:" + w2 + ", w3:"
						+ w3 + "\n" + "y = (0 * " + w1 + ") + (0 * " + w2
						+ ") + (0 * " + w3 + ")\n");
				
				//CONTA 0
				y = (0 * w1) +  (0 * w2) + (0 * w3);
				y = verifica(y, wb);
				aprendeu = verifica2(d[0], y, n, aprendeu, 0);
			}
			
			if(!d1verifica.isSelected()) {

				// 001
				saidaCampo.setText(saidaCampo.getText() + "\n2ª Entrada(001):\nw1:"
						+ w2 + ", w2:" + w2 + ", w3:" + w3 + "\n" + "y = (0 * "
						+ w1 + ") + (0 * " + w2 + ") + (1 * " + w3 + ")\n");
			
				//CONTA 1
				y = (0 * w1) + (0 * w2) + (1 * w3);
				y = verifica(y, wb);
				aprendeu = verifica2(d[1], y, n, aprendeu, 1);
			}
			
			if(!d2verifica.isSelected()) {
				// 010
				saidaCampo.setText(saidaCampo.getText() + "\n3ª Entrada(010):\nw1:"
						+ w1 + ", w2:" + w2 + ", w3:" + w3 + "\n" + "y = (0 * "
						+ w3 + ") + (1 * " + w2 + ") + (0 * " + w3 + ")\n");
				
				//CONTA 2
				y = (0 * w1) + (1 * w2) + (0 * w3);
				y = verifica(y, wb);
				aprendeu = verifica2(d[2], y, n, aprendeu, 2);
			}
			
			if(!d3verifica.isSelected()) {
				// 011
				saidaCampo.setText(saidaCampo.getText() + "\n4ª Entrada(011):\nw1:"
						+ w1 + ", w2:" + w2 + ", w3:" + w3 + "\n" + "y = (0 * "
						+ w1 + ") + (1 * " + w2 + ") + (1 * " + w3 + ")\n");
				
				// CONTA 3
				y =  (0 * w1) + (1 * w2) + (1 * w3);
				y = verifica(y, wb);
				aprendeu = verifica2(d[3], y, n, aprendeu, 3);
			}
			
			if(!d4verifica.isSelected()) {
				// 100
				saidaCampo.setText(saidaCampo.getText() + "\n5ª Entrada(100):\nw1:"
						+ w1 + ", w2:" + w2 + ", w3:" + w3 + "\n" + "y = (1 * "
						+ w1 + ") + (0 * " + w2 + ") + (0 * " + w3 + ")\n");
				
				//CONTA 4
				y = (1 * w1) + (0 * w2) + (0 * w3);
				y = verifica(y, wb);
				aprendeu = verifica2(d[4], y, n, aprendeu, 4);
			}
			
			if(!d5verifica.isSelected()) {
				// 101
				saidaCampo.setText(saidaCampo.getText() + "\n6ª Entrada(101):\nw1:"
						+ w1 + ", w2:" + w2 + ", w3:" + w3 + "\n" + "y = (1 * "
						+ w1 + ") + (0 * " + w2 + ") + (1 * " + w3 + ")\n");
				
				// CONTA 5
				y = (1 * w1) + (0 * w2)  + (1 * w3);
				y = verifica(y, wb);
				aprendeu = verifica2(d[5], y, n, aprendeu, 5);
			}
			
			if(!d6verifica.isSelected()) {
				// 110
				saidaCampo.setText(saidaCampo.getText() + "\n7ª Entrada(110):\nw1:"
						+ w1 + ", w2:" + w2 + ", w3:" + w3 + "\n" + "y = (1 * "
						+ w1 + ") + (1 * " + w2 + ") + (0 * " + w3 + ")\n");
				
				//CONTA 6
				y = (1 * w1) + (1 * w2) + (0 * w3) ;
				y = verifica(y, wb);
				aprendeu = verifica2(d[6], y, n, aprendeu, 6);
			}
			
			if(!d7verifica.isSelected()) {
					// 111
				saidaCampo.setText(saidaCampo.getText() + "\n8ª Entrada(111):\nw1:"
						+ w1 + ", w2:" + w2 + ", w3:" + w3 + "\n" + "y = (1 * "
						+ w1 + ") + (1 * " + w2 + ") + (1 * " + w3 + ")\n");
				
				//CONTA 7
				y = (1 * w1) + (1 * w2) + (1 * w3);
				y = verifica(y, wb);
				aprendeu = verifica2(d[7], y, n, aprendeu, 7);
			}
			
			epoca = epoca + 1;
		
		} while (epoca < 20 && aprendeu == false);

		executaTeste(d);
		
		if (aprendeu == true) {
			saidaCampo.setText(saidaCampo.getText()
					+ "\n-----------> Perceptron aprendeu na " + (epoca + 1)
					+ "ª Época");
			System.out.print("\n-----------> Perceptron aprendeu na "
					+ (epoca + 1) + "ª Época");
		} else {
			saidaCampo.setText(saidaCampo.getText()
					+ "\n-----------> Não foi possivel aprender.");
			System.out.print("\n-----------> Não foi possivel aprender.");
		}
		System.out.print("\n\nDone!");
	}

	
	
	/** TODO: AQUI É SÓ TESTEEEEEEEEEEEEEEEEEEEEEEEEEEEEE QUEZIA TEM Q ARRUMAR OS SYSOS" */
	
	private static void executaTeste(int[] d) {

		boolean aprendeu = true;

			// AGORA FAÇO ESSA GAMBIARRA PARA RODAR APENAS OS VOLORES DE TESTE QUE NAO TINHA SIDO RODADOS
			if(d0verifica.isSelected()) {
				saidaCampo.setText(saidaCampo.getText() + "\n-------TESTE ---------\n");
				// x1 = 0, x2 = 0 e x3 = 0 -> A SAIDA AQUI EU ARRUMEI, TEM Q DEIXAR IGUAL PARA OS OUTROS
				saidaCampo.setText(saidaCampo.getText()
						+ "\n1ª Entrada (0-0-0):\nw1:" + w1 + ", w2:" + w2 + ", w3:"
						+ w3 + "\n" + "y = (0 * " + w1 + ") + (0 * " + w2
						+ ") + (0 * " + w3 + ")\n");

				//CONTA 0
				y = (0 * (w1)) +  (0 * (w2)) + (0 * (w3));
				y = verifica(y, wb);
				aprendeu = verifica2(d[0], y, n, aprendeu, 0);
			}

			if(d1verifica.isSelected()) {
				saidaCampo.setText(saidaCampo.getText() + "\n-------TESTE ---------\n");
				// 001
				saidaCampo.setText(saidaCampo.getText() + "\n2ª Entrada(001):\nw3:"
						+ w3 + ", w2:" + w2 + ", w1:" + w1 + "\n" + "y = (0 * "
						+ w3 + ") + (0 * " + w2 + ") + (1 * " + w1 + ")\n");

				//CONTA 1
				y = (0 * w1) + (0 * w2) + (1 * w3);
				y = verifica(y, wb);
				aprendeu = verifica2(d[1], y, n, aprendeu, 1);
			}

			if(d2verifica.isSelected()) {
				// 010
				saidaCampo.setText(saidaCampo.getText() + "\n3ª Entrada(010):\nw3:"
						+ w3 + ", w2:" + w2 + ", w1:" + w1 + "\n" + "y = (0 * "
						+ w3 + ") + (1 * " + w2 + ") + (0 * " + w1 + ")\n");

				//CONTA 2
				y = (0 * w1) + (1 * w2) + (0 * w3);
				y = verifica(y, wb);
				aprendeu = verifica2(d[2], y, n, aprendeu, 2);
			}

			if(d3verifica.isSelected()) {
				saidaCampo.setText(saidaCampo.getText() + "\n-------TESTE ---------\n");
				// 011
				saidaCampo.setText(saidaCampo.getText() + "\n4ª Entrada(011):\nw3:"
						+ w3 + ", w2:" + w2 + ", w1:" + w1 + "\n" + "y = (0 * "
						+ w3 + ") + (1 * " + w2 + ") + (1 * " + w1 + ")\n");

				// CONTA 3
				y =  (0 * w1) + (1 * w2) + (1 * w3);
				y = verifica(y, wb);
				aprendeu = verifica2(d[3], y, n, aprendeu, 3);
			}

			if(d4verifica.isSelected()) {
				saidaCampo.setText(saidaCampo.getText() + "\n-------TESTE ---------\n");
				// 100
				saidaCampo.setText(saidaCampo.getText() + "\n5ª Entrada(100):\nw3:"
						+ w3 + ", w2:" + w2 + ", w1:" + w1 + "\n" + "y = (1 * "
						+ w3 + ") + (0 * " + w2 + ") + (0 * " + w1 + ")\n");

				//CONTA 4
				y = (1 * w1) + (0 * w2) + (0 * w3);
				y = verifica(y, wb);
				aprendeu = verifica2(d[4], y, n, aprendeu, 4);
			}

			if(d5verifica.isSelected()) {
				saidaCampo.setText(saidaCampo.getText() + "\n-------TESTE ---------\n");
				// 101
				saidaCampo.setText(saidaCampo.getText() + "\n6ª Entrada(101):\nw3:"
						+ w3 + ", w2:" + w2 + ", w1:" + w1 + "\n" + "y = (1 * "
						+ w3 + ") + (0 * " + w2 + ") + (1 * " + w1 + ")\n");

				// CONTA 5
				y = (1 * w1) + (0 * w2)  + (1 * w3);
				y = verifica(y, wb);
				aprendeu = verifica2(d[5], y, n, aprendeu, 5);
			}

			if(d6verifica.isSelected()) {
				saidaCampo.setText(saidaCampo.getText() + "\n-------TESTE ---------\n");
				// 110
				saidaCampo.setText(saidaCampo.getText() + "\n7ª Entrada(110):\nw3:"
						+ w3 + ", w2:" + w2 + ", w1:" + w1 + "\n" + "y = (1 * "
						+ w3 + ") + (1 * " + w2 + ") + (0 * " + w1 + ")\n");

				//CONTA 6
				y = (0 * w1) + (1 * w2) + (1 * w3) ;
				y = verifica(y, wb);
				aprendeu = verifica2(d[6], y, n, aprendeu, 6);
			}

			if(d7verifica.isSelected()) {
				saidaCampo.setText(saidaCampo.getText() + "\n-------TESTE ---------\n");
				// 111
				saidaCampo.setText(saidaCampo.getText() + "\n8ª Entrada(111):\nw3:"
						+ w3 + ", w2:" + w2 + ", w1:" + w1 + "\n" + "y = (1 * "
						+ w3 + ") + (1 * " + w2 + ") + (1 * " + w1 + ")\n");

				//CONTA 7
				y = (1 * w1) + (1 * w2) + (1 * w3);
				y = verifica(y, wb);
				aprendeu = verifica2(d[7], y, n, aprendeu, 7);
			}
	}

	/**
	 * @param d
	 * @param w1
	 * @param w2
	 * @param w3
	 * @param y
	 * @param n
	 * @param aprendeu
	 * @param i OBS: recebe o valor da entrada
	 * @return
	 */
	private static boolean verifica2(int d, float y, float n, boolean aprendeu, int i) {
		aprendeu = comparayd(y, d, n, aprendeu, i);
		return aprendeu;
	}

	public static boolean comparayd(float y, int d, float n, boolean aprendeu, int i) {
		if (y != d) {
			aprendeu = false;
			saidaCampo.setText(saidaCampo.getText() + "\ny:" + y + " e d:" + d
					+ ", Atualização nos W's\n--------------\n");
			System.out.print("\nNew w's: ");
			
			// o valor i preenche a entrada[x]
			int[][] entrada = new int[8][3];
			entrada[0][0] = 0;
			entrada[0][1] = 0;
			entrada[0][2] = 0;
			
			entrada[1][0] = 0;
			entrada[1][1] = 0;
			entrada[1][2] = 1;
			
			entrada[2][0] = 0;
			entrada[2][1] = 1;
			entrada[2][2] = 0;
			
			entrada[3][0] = 0;
			entrada[3][1] = 1;
			entrada[3][2] = 1;
			
			entrada[4][0] = 1;
			entrada[4][1] = 0;
			entrada[4][2] = 0;
			
			entrada[5][0] = 1;
			entrada[5][1] = 0;
			entrada[5][2] = 1;
			
			entrada[6][0] = 1;
			entrada[6][1] = 1;
			entrada[6][2] = 0;
			
			entrada[7][0] = 1;
			entrada[7][1] = 1;
			entrada[7][2] = 1;
			
			// o valor  de i preenche a entrada[i]
			w1 = incw(w1, d, y, n, entrada[i][0]);
			w2 = incw(w2, d, y, n, entrada[i][1]);
			w3 = incw(w3, d, y, n, entrada[i][2]);
			
			saidaCampo.setText(saidaCampo.getText() + "w1:" + w1 + ", w2:" + w2
					+ ", w3:" + w3 + "\n");
			System.out.print("w1:" + w1 + ", w2:" + w2 + ", w3:" + w3);

		} else {
			saidaCampo.setText(saidaCampo.getText() + "\ny:" + y + " e d:" + d
					+ ", Sem atualização\n--------------\n");
		}

		return aprendeu;
	}

	private static float incw(float w, int d, float y, float n, int entrada) {
		float dw = n * (d - y) * entrada;
		w = w + dw;
		return w;
	}

	private static float verifica(float y, float wb) {
		if (y <= wb) {
			y = 0;
			saidaCampo.setText(saidaCampo.getText() + "y <= wb .: y=0\n");
		} else {
			y = 1;
			saidaCampo.setText(saidaCampo.getText() + "y > wb .: y=1\n");
		}
		return y;
	}

	/**
	 * Botão limpar
	 */
	public static void btlimpar() {
		cw1.setText("");
		cw2.setText("");
		cw3.setText("");
		cwb.setText("");
		cn.setText("");
		saidaCampo.setText("");

		d0.setSelectedIndex(0);
		d1.setSelectedIndex(0);
		d2.setSelectedIndex(0);
		d3.setSelectedIndex(0);
		d4.setSelectedIndex(0);
		d5.setSelectedIndex(0);
		d6.setSelectedIndex(0);
		d7.setSelectedIndex(0);
		
		d0verifica.setSelected(false);
		d1verifica.setSelected(false);
		d2verifica.setSelected(false);
		d3verifica.setSelected(false);
		d4verifica.setSelected(false);
		d5verifica.setSelected(false);
		d6verifica.setSelected(false);
		d7verifica.setSelected(false);
	}

	/**
	 * Botão salvar
	 */
	public static void btsalvar() {
		File arq = new File("src/Saidas/");
		arq.mkdirs();
		try {
			String nome = JOptionPane
					.showInputDialog("Digite o nome do Arquivo: ");
			FileWriter arquivo = new FileWriter("src/Saidas/" + nome + ".txt");
			arquivo.write(saidaCampo.getText());
			arquivo.close();
			JOptionPane.showMessageDialog(null, "Arquivo Salvo Com Sucesso",
					"Info", JOptionPane.INFORMATION_MESSAGE);

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,
					"Não Foi Possível salvar o arquivo.", "Info",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	/**
	 * Botão sair
	 */
	public static void btsair() {
		Object[] options = { "Sim", "Cancelar" };
		if ((JOptionPane.showOptionDialog(null, "Realmente deseja Sair?",
				"Aviso", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, options[0])) == JOptionPane.OK_OPTION) {
			System.exit(0);
		}

	}
	
	public static void creditos() {
		
		JOptionPane.showMessageDialog(null, "Trabalho de Inteligência Artificial / RNA (Perceptron)\n" +
											"Quezia Jesuino - RA 3333333333\n" +
											"Thiago Marinho - RA 3006105339\n" +
											"Adaptamos o código fonte do site: www.queziacoloca.site.aqui.br\n" +
											"Ciência da Computação - D80 - AI");

	}
	
	
	
}
