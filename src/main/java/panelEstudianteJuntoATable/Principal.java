package panelEstudianteJuntoATable;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import panelEstudianteJuntoATable.controllers.ControladorEstudiante;
import panelEstudianteJuntoATable.controllers.DatosDeTabla;
import panelEstudianteJuntoATable.model.Estudiante;
import panelEstudianteJuntoATable.utils.CacheImagenes;
import panelEstudianteJuntoATable.vistas.PanelEstudiante;

import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private PanelEstudiante panelEstudiante;
	private DefaultTableModel dtm = null;
	private Object datosEnTabla[][] = DatosDeTabla.getDatosDeTabla();
	private String titulosEnTabla[] = DatosDeTabla.getTitulosColumnas();
	private JScrollPane scrollPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		panelEstudiante = new PanelEstudiante();
		
		dtm = getDefaultTableModelNoEditable();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		contentPane.add(splitPane, BorderLayout.CENTER);
		splitPane.setRightComponent(panelEstudiante);
		scrollPane = new JScrollPane();
		splitPane.setLeftComponent(scrollPane);
		splitPane.setResizeWeight(1);
		table = new JTable(dtm);
		scrollPane.setViewportView(table);
		this.add(getBarraHerramientas(), BorderLayout.NORTH);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				int indiceFilaSel = 0;
				
				
				
				indiceFilaSel = table.getSelectedRow();
				
				int id = (int) datosEnTabla[indiceFilaSel][0];
				panelEstudiante.mostrarEntidad(ControladorEstudiante.getInstance().find(id));
				
			}
		});
		
	}
	
	public void guardado() {
		try {
			panelEstudiante.guardar();
			
			
			int filaSeleccionada = table.getSelectedRow();
			
			Estudiante e = ControladorEstudiante.getInstance().find((Integer) datosEnTabla[table.getSelectedRow()][0]);
			
			
			datosEnTabla[filaSeleccionada][0] = e.getId();
	        datosEnTabla[filaSeleccionada][1] = e.getNombre();
	        datosEnTabla[filaSeleccionada][2] = e.getApellido1();
	        datosEnTabla[filaSeleccionada][3] = e.getApellido2();
	        datosEnTabla[filaSeleccionada][4] = e.getDni();
	        datosEnTabla[filaSeleccionada][5] = e.getDireccion();
	        datosEnTabla[filaSeleccionada][6] = e.getEmail();
	        datosEnTabla[filaSeleccionada][7] = e.getTelefono();
	        datosEnTabla[filaSeleccionada][8] = e.getSexo();
	        datosEnTabla[filaSeleccionada][9] = e.getColorPreferido();
			
			dtm.fireTableDataChanged();
			
			JOptionPane.showMessageDialog(null, "Estudiante guardado correctamente");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	
	private DefaultTableModel getDefaultTableModelNoEditable () {
		DefaultTableModel dtm = new DefaultTableModel(datosEnTabla, titulosEnTabla) {
			/**
			 * Se conocer� el dato en cada celda, es uno de los m�todos fundamentales del abstractTableModel
			 */
			@Override
			public Object getValueAt(int rowIndex, int columnIndex) {
				return datosEnTabla[rowIndex][columnIndex];
			}

			
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
				datosEnTabla[rowIndex][columnIndex] = aValue;
				fireTableCellUpdated(rowIndex, columnIndex);
			}
			
		};
		return dtm;
	}
	
	
	/**
	 * 
	 * @return
	 */
	private JToolBar getBarraHerramientas() {
		JToolBar toolBar = new JToolBar();

		// Bot�n para modificar la primera l�nea en su primera columna
		JButton jbtModificar = new JButton();
		jbtModificar.setIcon(CacheImagenes.getCacheImagenes().getIcono("guardar.png"));
		jbtModificar.setToolTipText("Modificar el valor de la primera columna de la primera fila");
		jbtModificar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				guardado();
			}
		});
		toolBar.add(jbtModificar);

		
		return toolBar;
	}
	
	

}
