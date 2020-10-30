package huffcodes;

import huffcodes.Compresor;
import huffcodes.Diccionario;
import huffcodes.Tree;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

/**
 * La clase MainApp lanza la aplicaciÃ³n.
 * 
 */
public class MainApp
{
	/**
	 * MÃ©todo que crea la interfaz grÃ¡fica del Ã¡rrbol.
	 * 
	 * @param tree arbol a partir del que crear al interfaz grafica.
	 * @return     Ventana con la interfaz grafica del arbol.
	 */
	private static JFrame createTreeGUI(Tree tree)
	{
		// Ventana a retornar.
		JFrame frame=new JFrame("arbol de Huffman");

		// DimensiÑn de la ventana.
		Dimension size=Toolkit.getDefaultToolkit().getScreenSize();
		size=new Dimension(
				(int)(size.getWidth()*0.9),
				(int)(size.getHeight()*0.9));

		// Se aÑade el Ñrbol.
		frame.getContentPane().add(
				new JTreePanel(
						tree,
						size),
						BorderLayout.CENTER);

		frame.pack();

		// Opciones finales de la ventana.
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(size);
		frame.setLocationRelativeTo(null);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		frame.setIconImage(new ImageIcon(
				MainApp.class.getResource("/images/Arbol.png")).getImage());

		return frame;
	}
	
	/**
	 * Metodo que crea un cuadro de diaogo con un area de texto.
	 * 
	 * @param owner Ventana principal de la aplicacion.
	 * @param text  Texto a insertar en el area de texto.
	 * @param title Titulo del cuadro de diaogo.
	 * @return      La ventana con el area de texto.
	 */
	private static JDialog createTextArea(
			JFrame owner, String text, String title)
	{
		// DiÑlogo a retornar.
		JDialog dialog=new JDialog(owner,text,true);
		dialog.setTitle(title);
		dialog.setResizable(false);
		
		// Se inserta el Ñrea de texto.
		JTextArea textArea=new JTextArea(text);
		textArea.setEditable(false);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		
		JScrollPane areaScrollPane = new JScrollPane(textArea);
		areaScrollPane.setHorizontalScrollBarPolicy(
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		areaScrollPane.setPreferredSize(new Dimension(800,600));
		
		dialog.add(areaScrollPane);
		dialog.pack();
		dialog.setLocationRelativeTo(null);
		
		return dialog;
	}
	
	/**
	 * MÑtodo que crea los botones de la interfaz grÑfica de
	 * usuario.
	 * 
	 * @param owner Ventana principal de la aplicaciÑn.
	 * @param tree  Ñrbol a partir del que crear al interfaz grÑfica.
	 * @param dicc  Diccionario.
	 * @param texto Texto sin comprimir.
	 * @param compr Texto comprimido.
	 * @return     Los botones de la interfaz grÑfica de usuario.
	 */
	private static JButton[] createButtons(
			final JFrame owner,
			final Tree tree, final Diccionario dicc,
			final String texto, final Vector<Boolean> compr)
	{
		// BOTÑN: ÑRBOL DE HUFFMAN.
		JButton bArbol=new JButton("Ñrbol de Huffman");
		bArbol.setIcon(new ImageIcon(
				MainApp.class.getResource("/images/Arbol.png")));
		bArbol.setHorizontalTextPosition(SwingConstants.CENTER);
		bArbol.setVerticalTextPosition(SwingConstants.BOTTOM);
		
		bArbol.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent evt)
			{
				createTreeGUI(tree).setVisible(true);
			}
		});
		
		// BOTÑN: ALFABETO.
		JButton bAlfabeto=new JButton("Alfabeto");
		bAlfabeto.setIcon(new ImageIcon(
				MainApp.class.getResource("/images/Alfabeto.png")));
		bAlfabeto.setHorizontalTextPosition(SwingConstants.CENTER);
		bAlfabeto.setVerticalTextPosition(SwingConstants.BOTTOM);
		
		bAlfabeto.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent evt)
			{
				String text=dicc.toString();
				createTextArea(owner,text,"Alfabeto").setVisible(true);
			}
		});
		
		// BOTÑN: COMPARATIVA.
		JButton bComparativa=new JButton("Comparativa de compresiÑn");
		bComparativa.setIcon(new ImageIcon(
				MainApp.class.getResource("/images/Comparativa.png")));
		bComparativa.setHorizontalTextPosition(SwingConstants.CENTER);
		bComparativa.setVerticalTextPosition(SwingConstants.BOTTOM);
		
		bComparativa.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent evt)
			{
				// Texto completo.
				String text="";
				
				// Se aÑade el texto sin compresiÑn de Huffman.
				text="TEXTO ORIGINAL CODIFICADO:\n";
				String textoOriginalCod=
					Compresor.codificacionTextoEnBinario(texto);
				
				text+="\n"+textoOriginalCod;
				text+="\n\nTAMAÑO: "+textoOriginalCod.length();
				
				// Se aÑade el texto con compresiÑn de Huffman.
				text+="\n\n\nTEXTO COMPRIMIDO CODIFICADO:\n\n";
				
				for (int i=0; i<compr.size(); i++)
					text+=(compr.get(i) ? "1" : "0");
				
				text+="\n\nTAMAÑO: "+compr.size();

				// Se aÑade el ratio de compresiÑn.
				double ratio=100.0-compr.size()*100.0/textoOriginalCod.length();
				text+=String.format("\n\n\nRATIO DE COMPRESIÑN: %6.2f",ratio);
				text+="%";
				
				createTextArea(owner,text,"Comparativa").setVisible(true);
			}
		});
		
		return new JButton[] {
				bArbol, bAlfabeto, bComparativa
		};
	}

	/**
	 * MÑtodo que crea la interfaz grÑfica de la aplicaciÑn..
	 * 
	 * @param tree Ñrbol a partir del que crear al interfaz grÑfica.
	 * @param dicc Diccionario.
	 * @param text Texto sin comprimir.
	 * @param comp Texto comprimido.
	 * @return     Ventana con la interfaz grÑfica de la aplicaciÑn.
	 */
	private static JFrame createGUI(
			Tree tree, Diccionario dicc, String text, Vector<Boolean> comp)
	{
		// Ventana a retornar.
		JFrame frame=new JFrame("CÑdigos de Huffman");

		// Paneles de opciones.
		JPanel panel=new JPanel(new GridLayout(1,0));
		JPanel flowP;

		// Se aÑaden los botones.
		JButton[] botones=createButtons(frame,tree,dicc,text,comp);
		
		for (JButton b : botones)
		{
			flowP=new JPanel(new FlowLayout());
			flowP.add(b);
			panel.add(flowP);
		}
		
		// Opciones finales de la ventana.
		frame.add(panel,BorderLayout.CENTER);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		frame.setIconImage(new ImageIcon(
				MainApp.class.getResource("/images/Icon.png")).getImage());
		
		return frame;
	}

	/**
	 * MÑtodo principal que lanza la aplicaciÑn.
	 * 
	 * @param args ParÑmetros de cabecera de la aplicaciÑn.
	 */
	public static void main(String[] args)
	{
		// Se establece el Look & Feel.
		try {
			UIManager.setLookAndFeel(
					UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Se pide el texto al usuario.
		String texto=JOptionPane.showInputDialog(
				null,
				"Introduzca el texto a codificar:",
				"CÑdigos de Huffman",
				JOptionPane.QUESTION_MESSAGE);
		
		if (texto==null)
			System.exit(0);
		
		// Se obtienen las frecuencias de las letras.
		Vector<Tree> vector=
			Compresor.obtenerComponentes(texto);

		vector=Compresor.ordenarMenorAMayorComponentes(vector);
		Tree huffman=Compresor.crearArbolDeCodigos(vector);

		// Se construye el diccionario.
		Diccionario dicc=
			Compresor.construirDiccionarioDesdeArbol(
					Compresor.obtenerAlfabeto(texto),
					huffman);

		// Se comprime el texto.
		Vector<Boolean> compr=
			Compresor.comprime(texto,dicc);

		// Se muestra toda la informaciÑn.
		JFrame mainGUI=createGUI(huffman,dicc,texto,compr);
		mainGUI.setVisible(true);
	}
}
