package panelEstudianteJuntoATable.vistas;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.filechooser.FileFilter;

import panelEstudianteJuntoATable.controllers.ControladorSexo;
import panelEstudianteJuntoATable.model.Sexo;

import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.awt.event.ActionEvent;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;

public class PanelDatosPersonales extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfId;
	private JTextField jtfNombre;
	private JLabel lblTitulo;
	private Runnable runnableMostrarPrimerRegistro;
	private Runnable runnableMostrarAnterior;
	private Runnable runnableMostrarSiguiente;
	private Runnable runnableMostrarUltimoRegistro;
	private Runnable runnableNuevo;
	private Runnable runnableGuardar;
	private Runnable runnableEliminar;
	private JTextField jtfApellido1;
	private JTextField jtfApellido2;
	private JTextField jtfDNI;
	private JTextField jtfDireccion;
	private JTextField jtfEmail;
	private JTextField jtfTelefono;
	private JComboBox<Sexo> jcbSexo;
	private JScrollPane scrollPane;
	byte[] imagenEnArrayDeBytes;
	JFileChooser jfileChooser;
	JColorChooser jColorChooser;
	private JTextField jtfColor;
	JPanel panel;

	/**
	 * Create the panel.
	 */
	public PanelDatosPersonales() {
		setLayout(new BorderLayout(0, 0));

		panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 266, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		lblTitulo = new JLabel("Titulo Del Componente");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 17));
		GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
		gbc_lblTitulo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitulo.gridx = 1;
		gbc_lblTitulo.gridy = 0;
		panel.add(lblTitulo, gbc_lblTitulo);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		jtfId = new JTextField();
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.insets = new Insets(0, 0, 5, 5);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 1;
		panel.add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);

		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 5);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 2;
		panel.add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollpane = new GridBagConstraints();
		gbc_scrollpane.gridheight = 4;
		gbc_scrollpane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollpane.fill = GridBagConstraints.BOTH;
		gbc_scrollpane.gridx = 2;
		gbc_scrollpane.gridy = 1;
		panel.add(scrollPane, gbc_scrollpane);

		JLabel lblNewLabel = new JLabel("Apellido 1:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 3;
		panel.add(lblNewLabel, gbc_lblNewLabel);

		jtfApellido1 = new JTextField();
		GridBagConstraints gbc_jtfApellido1 = new GridBagConstraints();
		gbc_jtfApellido1.insets = new Insets(0, 0, 5, 5);
		gbc_jtfApellido1.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfApellido1.gridx = 1;
		gbc_jtfApellido1.gridy = 3;
		panel.add(jtfApellido1, gbc_jtfApellido1);
		jtfApellido1.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Apellido 2:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 4;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);

		jtfApellido2 = new JTextField();
		GridBagConstraints gbc_jtfApellido2 = new GridBagConstraints();
		gbc_jtfApellido2.insets = new Insets(0, 0, 5, 5);
		gbc_jtfApellido2.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfApellido2.gridx = 1;
		gbc_jtfApellido2.gridy = 4;
		panel.add(jtfApellido2, gbc_jtfApellido2);
		jtfApellido2.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("DNI:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 5;
		panel.add(lblNewLabel_4, gbc_lblNewLabel_4);

		jtfDNI = new JTextField();
		GridBagConstraints gbc_jtfDNI = new GridBagConstraints();
		gbc_jtfDNI.insets = new Insets(0, 0, 5, 5);
		gbc_jtfDNI.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDNI.gridx = 1;
		gbc_jtfDNI.gridy = 5;
		panel.add(jtfDNI, gbc_jtfDNI);
		jtfDNI.setColumns(10);

		JButton jbtnImagen = new JButton("Cambiar Imagen");
		jbtnImagen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionaImagen();
			}
		});
		GridBagConstraints gbc_jbtnImagen = new GridBagConstraints();
		gbc_jbtnImagen.insets = new Insets(0, 0, 5, 0);
		gbc_jbtnImagen.gridx = 2;
		gbc_jbtnImagen.gridy = 5;
		panel.add(jbtnImagen, gbc_jbtnImagen);

		JLabel lblNewLabel_8 = new JLabel("Sexo:");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 6;
		panel.add(lblNewLabel_8, gbc_lblNewLabel_8);

		jcbSexo = new JComboBox<Sexo>();
		GridBagConstraints gbc_jcbSexo = new GridBagConstraints();
		gbc_jcbSexo.insets = new Insets(0, 0, 5, 5);
		gbc_jcbSexo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbSexo.gridx = 1;
		gbc_jcbSexo.gridy = 6;
		panel.add(jcbSexo, gbc_jcbSexo);

		JLabel lblNewLabel_5 = new JLabel("Dirección:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 7;
		panel.add(lblNewLabel_5, gbc_lblNewLabel_5);

		jtfDireccion = new JTextField();
		GridBagConstraints gbc_jtfDireccion = new GridBagConstraints();
		gbc_jtfDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_jtfDireccion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDireccion.gridx = 1;
		gbc_jtfDireccion.gridy = 7;
		panel.add(jtfDireccion, gbc_jtfDireccion);
		jtfDireccion.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Email:");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 8;
		panel.add(lblNewLabel_6, gbc_lblNewLabel_6);

		jtfEmail = new JTextField();
		GridBagConstraints gbc_jtfEmail = new GridBagConstraints();
		gbc_jtfEmail.insets = new Insets(0, 0, 5, 5);
		gbc_jtfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfEmail.gridx = 1;
		gbc_jtfEmail.gridy = 8;
		panel.add(jtfEmail, gbc_jtfEmail);
		jtfEmail.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Teléfono:");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 9;
		panel.add(lblNewLabel_7, gbc_lblNewLabel_7);

		jtfTelefono = new JTextField();
		GridBagConstraints gbc_jtfTelefono = new GridBagConstraints();
		gbc_jtfTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_jtfTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfTelefono.gridx = 1;
		gbc_jtfTelefono.gridy = 9;
		panel.add(jtfTelefono, gbc_jtfTelefono);
		jtfTelefono.setColumns(10);

		JLabel lblNewLabel_9 = new JLabel("Color Preferido");
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9.gridx = 0;
		gbc_lblNewLabel_9.gridy = 10;
		panel.add(lblNewLabel_9, gbc_lblNewLabel_9);

		jtfColor = new JTextField();
		jtfColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarColorFondoByJtfColor();
			}
		});
		GridBagConstraints gbc_jtfColor = new GridBagConstraints();
		gbc_jtfColor.insets = new Insets(0, 0, 5, 5);
		gbc_jtfColor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfColor.gridx = 1;
		gbc_jtfColor.gridy = 10;
		panel.add(jtfColor, gbc_jtfColor);
		jtfColor.setColumns(10);

		JButton btnNewButton = new JButton("Cambiar Color");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionaColor();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 10;
		panel.add(btnNewButton, gbc_btnNewButton);

		cargarTodosSexos();

	}

	@SuppressWarnings("unchecked")
	public void cargarTodosSexos() {
		List<Sexo> l = (List<Sexo>) ControladorSexo.getInstance().findAll();

		for (Sexo o : l) {
			this.jcbSexo.addItem(o);
		}
	}

	/**
	 * 
	 * @return
	 */
	public JPopupMenu getPopUpMenu() {
		JPopupMenu menu = new JPopupMenu();
		JMenuItem dimensiones;
		ImageIcon icono = null;
		if (imagenEnArrayDeBytes != null) {
			icono = new ImageIcon(imagenEnArrayDeBytes);

		}

		dimensiones = new JMenuItem("Dimensiones: " + ((icono != null) ? icono.getIconWidth() : 0) + " x "
				+ ((icono != null) ? icono.getIconHeight() : 0) + " pixeles");

		menu.add(dimensiones);
		menu.addSeparator();

		JMenuItem item = new JMenuItem("Cambiar Imagen");
		item.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				seleccionaImagen();
			}
		});
		menu.add(item);

		return menu;
	}

	private void seleccionaColor() {
		Color color = JColorChooser.showDialog(null, "Seleccione un Color", Color.gray);
		// Si el usuario pulsa sobre aceptar, el color elegido no será nulo
		if (color != null) {
			String strColor = "#" + Integer.toHexString(color.getRGB()).substring(2);
			this.jtfColor.setText(strColor);
			this.panel.setBackground(color);
		}

	}

	private void seleccionaImagen() {
		jfileChooser = new JFileChooser();

		// Configurando el componente

		// Tipo de selección que se hace en el diálogo
		jfileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); // Sólo selecciona ficheros

		// Filtro del tipo de ficheros que puede abrir
		jfileChooser.setFileFilter(new FileFilter() {

			@Override
			public String getDescription() {
				return "Archivos de imagen *.jpg *.png *.gif";
			}

			@Override
			public boolean accept(File f) {
				if (f.isDirectory() || (f.isFile() && (f.getAbsolutePath().toLowerCase().endsWith(".jpg")
						|| f.getAbsolutePath().toLowerCase().endsWith(".jpeg")
						|| f.getAbsolutePath().toLowerCase().endsWith(".png")
						|| f.getAbsolutePath().toLowerCase().endsWith(".gif"))))
					return true;
				return false;
			}
		});

		// Abro el diálogo para la elección del usuario
		int seleccionUsuario = jfileChooser.showOpenDialog(null);

		if (seleccionUsuario == JFileChooser.APPROVE_OPTION) {
			File fichero = jfileChooser.getSelectedFile();

			if (fichero.isFile()) {
				try {
					if (anchoImagen(fichero) <= 100 && altoImagen(fichero) <= 100) {
						this.imagenEnArrayDeBytes = Files.readAllBytes(fichero.toPath());
						setImagen(imagenEnArrayDeBytes);
					} else {
						JOptionPane.showMessageDialog(null, "La imagen tiene que tener menos de 100px x 100px");
						setImagen(null);
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}

	private void mostrarImagen() {
		if (imagenEnArrayDeBytes != null && imagenEnArrayDeBytes.length > 0) {
			ImageIcon icono = new ImageIcon(imagenEnArrayDeBytes);
			JLabel lblIcono = new JLabel(icono);
			scrollPane.setViewportView(lblIcono);
		} else {
			JLabel lblIcono = new JLabel("Sin imagen");
			scrollPane.setViewportView(lblIcono);
		}
		
		mostrarDialogo();

	}

	public void mostrarDialogo() {
		// Inicializo el menú de popup
		JPopupMenu popup = getPopUpMenu();

		// Evento para mostrar el men� en las coordenadas que correspondan
		scrollPane.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				showPopup(e);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				showPopup(e);
			}

			/**
			 * M�todo llamado cuando se detecta el evento de rat�n, mostrar� el men�
			 * 
			 * @param e
			 */
			private void showPopup(MouseEvent e) {
				if (e.isPopupTrigger()) {
					popup.show(e.getComponent(), e.getX(), e.getY());
				}
			}
		});
	}

	private void cambiarColorFondoByJtfColor() {
		if (jtfColor.getText().length() == 7 && jtfColor.getText() != null) {
			Color color = Color.decode(jtfColor.getText());
			this.panel.setBackground(color);
		}
	}

	private int anchoImagen(File f) throws IOException {
		BufferedImage img = ImageIO.read(f);
		return img.getWidth();
	}

	private int altoImagen(File f) throws IOException {
		BufferedImage img = ImageIO.read(f);
		return img.getHeight();
	}

	public void setImagen(byte[] img) {
		if (img != null && img.length > 0) {
			this.imagenEnArrayDeBytes = img;
			mostrarImagen();
		} else {
			this.imagenEnArrayDeBytes = null;
			JLabel lblIcono = new JLabel("Sin imagen");
			scrollPane.setViewportView(lblIcono);
		}
	}

	public Color getColorPanel() {
		return panel.getBackground();
	}

	public void setColorPanel(Color color) {
		this.panel.setBackground(color);
	}

	public JTextField getJtfColor() {
		return jtfColor;
	}

	public void setJtfColor(JTextField jtfColor) {
		this.jtfColor = jtfColor;
	}

	public String getColor() {
		return jtfColor.getText();
	}

	public void setColor(String Color) {
		this.jtfColor.setText(Color);
	}

	public byte[] getImagen() {
		return imagenEnArrayDeBytes;
	}

	public void setTitulo(String nuevoTitulo) {
		this.lblTitulo.setText(nuevoTitulo);
	}

	public void setNombre(String s) {
		this.jtfNombre.setText(s);
	}

	public void setApellido1(String s) {
		this.jtfApellido1.setText(s);
	}

	public void setApellido2(String s) {
		this.jtfApellido2.setText(s);
	}

	public void setDNI(String s) {
		this.jtfDNI.setText(s);
	}

	public void setDireccion(String s) {
		this.jtfDireccion.setText(s);
	}

	public void setEmail(String s) {
		this.jtfEmail.setText(s);
	}

	public void setTelefono(String s) {
		this.jtfTelefono.setText(s);
	}

	public void setId(int id) {
		this.jtfId.setText("" + id);
	}

	public int getId() {
		return Integer.parseInt(this.jtfId.getText());
	}

	public JComboBox<Sexo> getJcbSexo() {
		return jcbSexo;
	}

	public void setJcbSexo(JComboBox<Sexo> jcbSexo) {
		this.jcbSexo = jcbSexo;
	}

	public Runnable getRunnableMostrarPrimerRegistro() {
		return runnableMostrarPrimerRegistro;
	}

	public void setRunnableMostrarPrimerRegistro(Runnable runnableMostrarPrimerRegistro) {
		this.runnableMostrarPrimerRegistro = runnableMostrarPrimerRegistro;
	}

	public Runnable getRunnableMostrarAnterior() {
		return runnableMostrarAnterior;
	}

	public void setRunnableMostrarAnterior(Runnable runnableMostrarAnterior) {
		this.runnableMostrarAnterior = runnableMostrarAnterior;
	}

	public Runnable getRunnableMostrarSiguiente() {
		return runnableMostrarSiguiente;
	}

	public void setRunnableMostrarSiguiente(Runnable runnableMostrarSiguiente) {
		this.runnableMostrarSiguiente = runnableMostrarSiguiente;
	}

	public Runnable getRunnableMostrarUltimoRegistro() {
		return runnableMostrarUltimoRegistro;
	}

	public void setRunnableMostrarUltimoRegistro(Runnable runnableMostrarUltimoRegistro) {
		this.runnableMostrarUltimoRegistro = runnableMostrarUltimoRegistro;
	}

	public Runnable getRunnableNuevo() {
		return runnableNuevo;
	}

	public void setRunnableNuevo(Runnable runnableNuevo) {
		this.runnableNuevo = runnableNuevo;
	}

	public Runnable getRunnableGuardar() {
		return runnableGuardar;
	}

	public void setRunnableGuardar(Runnable runnableGuardar) {
		this.runnableGuardar = runnableGuardar;
	}

	public Runnable getRunnableEliminar() {
		return runnableEliminar;
	}

	public void setRunnableEliminar(Runnable runnableEliminar) {
		this.runnableEliminar = runnableEliminar;
	}

	public JTextField getJtfId() {
		return jtfId;
	}

	public void setJtfId(JTextField jtfId) {
		this.jtfId = jtfId;
	}

	public JTextField getJtfNombre() {
		return jtfNombre;
	}

	public void setJtfNombre(JTextField jtfNombre) {
		this.jtfNombre = jtfNombre;
	}

	public JLabel getLblTitulo() {
		return lblTitulo;
	}

	public void setLblTitulo(JLabel lblTitulo) {
		this.lblTitulo = lblTitulo;
	}

	public JTextField getJtfApellido1() {
		return jtfApellido1;
	}

	public void setJtfApellido1(JTextField jtfApellido1) {
		this.jtfApellido1 = jtfApellido1;
	}

	public JTextField getJtfApellido2() {
		return jtfApellido2;
	}

	public void setJtfApellido2(JTextField jtfApellido2) {
		this.jtfApellido2 = jtfApellido2;
	}

	public JTextField getJtfDNI() {
		return jtfDNI;
	}

	public void setJtfDNI(JTextField jtfDNI) {
		this.jtfDNI = jtfDNI;
	}

	public JTextField getJtfDireccion() {
		return jtfDireccion;
	}

	public void setJtfDireccion(JTextField jtfDireccion) {
		this.jtfDireccion = jtfDireccion;
	}

	public JTextField getJtfEmail() {
		return jtfEmail;
	}

	public void setJtfEmail(JTextField jtfEmail) {
		this.jtfEmail = jtfEmail;
	}

	public JTextField getJtfTelefono() {
		return jtfTelefono;
	}

	public void setJtfTelefono(JTextField jtfTelefono) {
		this.jtfTelefono = jtfTelefono;
	}

}
