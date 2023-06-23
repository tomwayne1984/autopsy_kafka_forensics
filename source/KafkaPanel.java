/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package forensic;

import java.awt.Component;
import java.awt.FileDialog;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import org.openide.nodes.Node;
import org.openide.util.lookup.ServiceProvider;
import org.sleuthkit.autopsy.corecomponentinterfaces.DataContentViewer;
import org.sleuthkit.datamodel.AbstractFile;
import org.sleuthkit.datamodel.Content;
import org.sleuthkit.datamodel.TskCoreException;

/**
 * KafkaPanel
 * The class allows to view contents of Kafka log files.
 * Key-value pairs can be inspected via a representation as UTF-8 string
 * (in case possible) and a binary hex view.
 * The timestamps of data insertion are extracted and shown together with the
 * hashed values (SHA-256).
 * Values can be exported to files for external processing and documentation.
 *
 * @author t
 */
@ServiceProvider(service = DataContentViewer.class)
public class KafkaPanel extends javax.swing.JPanel implements DataContentViewer {

	/**
	 * Creates new form KafkaPanel
	 */
	public KafkaPanel() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jSplitPane1 = new javax.swing.JSplitPane();
		jScrollPane1 = new javax.swing.JScrollPane();
		tableView = new javax.swing.JTable();
		jSplitPane5 = new javax.swing.JSplitPane();
		jSplitPane4 = new javax.swing.JSplitPane();
		jTextField2 = new javax.swing.JTextField();
		jScrollPane3 = new javax.swing.JScrollPane();
		jTextPane2 = new javax.swing.JTextPane();
		jSplitPane3 = new javax.swing.JSplitPane();
		jTextField1 = new javax.swing.JTextField();
		jScrollPane2 = new javax.swing.JScrollPane();
		jTextPane1 = new javax.swing.JTextPane();

		setLayout(new java.awt.GridLayout(1, 0));

		jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

		tableView.setModel(new javax.swing.table.DefaultTableModel(
				new Object [][] {

				},
				new String [] {
						"Timestamp", "Key", "Value", "SHA-256 Hash", "Export", "KeyAbsoluteOffset", "KeyLength", "ValueAbsoluteOffset", "ValueLength"
				}
				) {
			boolean[] canEdit = new boolean [] {
					false, false, false, false, false, false, false, false, false
			};

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit [columnIndex];
			}
		});
		tableView.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		jScrollPane1.setViewportView(tableView);
		if (tableView.getColumnModel().getColumnCount() > 0) {
			tableView.getColumnModel().getColumn(0).setHeaderValue(org.openide.util.NbBundle.getMessage(KafkaPanel.class, "KafkaPanel.tableView.columnModel.title0")); // NOI18N
			tableView.getColumnModel().getColumn(1).setHeaderValue(org.openide.util.NbBundle.getMessage(KafkaPanel.class, "KafkaPanel.tableView.columnModel.title1")); // NOI18N
			tableView.getColumnModel().getColumn(2).setHeaderValue(org.openide.util.NbBundle.getMessage(KafkaPanel.class, "KafkaPanel.tableView.columnModel.title2")); // NOI18N
			tableView.getColumnModel().getColumn(3).setHeaderValue(org.openide.util.NbBundle.getMessage(KafkaPanel.class, "KafkaPanel.tableView.columnModel.title3")); // NOI18N
			tableView.getColumnModel().getColumn(4).setHeaderValue(org.openide.util.NbBundle.getMessage(KafkaPanel.class, "KafkaPanel.tableView.columnModel.title4")); // NOI18N
			tableView.getColumnModel().getColumn(5).setHeaderValue(org.openide.util.NbBundle.getMessage(KafkaPanel.class, "KafkaPanel.tableView.columnModel.title5")); // NOI18N
			tableView.getColumnModel().getColumn(6).setHeaderValue(org.openide.util.NbBundle.getMessage(KafkaPanel.class, "KafkaPanel.tableView.columnModel.title6")); // NOI18N
			tableView.getColumnModel().getColumn(7).setHeaderValue(org.openide.util.NbBundle.getMessage(KafkaPanel.class, "KafkaPanel.tableView.columnModel.title7")); // NOI18N
			tableView.getColumnModel().getColumn(8).setHeaderValue(org.openide.util.NbBundle.getMessage(KafkaPanel.class, "KafkaPanel.tableView.columnModel.title8")); // NOI18N
		}

		jSplitPane1.setTopComponent(jScrollPane1);

		jSplitPane5.setResizeWeight(0.5);

		jSplitPane4.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

		jTextField2.setEditable(false);
		jTextField2.setText(org.openide.util.NbBundle.getMessage(KafkaPanel.class, "KafkaPanel.jTextField2.text")); // NOI18N
		jTextField2.setBorder(null);
		jSplitPane4.setTopComponent(jTextField2);

		jTextPane2.setEditable(false);
		jTextPane2.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
		jScrollPane3.setViewportView(jTextPane2);

		jSplitPane4.setBottomComponent(jScrollPane3);

		jSplitPane5.setLeftComponent(jSplitPane4);

		jSplitPane3.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

		jTextField1.setEditable(false);
		jTextField1.setText(org.openide.util.NbBundle.getMessage(KafkaPanel.class, "KafkaPanel.jTextField1.text")); // NOI18N
		jTextField1.setBorder(null);
		jSplitPane3.setLeftComponent(jTextField1);

		jTextPane1.setEditable(false);
		jTextPane1.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
		jTextPane1.setText(org.openide.util.NbBundle.getMessage(KafkaPanel.class, "KafkaPanel.jTextPane1.text")); // NOI18N
		jTextPane1.setToolTipText(org.openide.util.NbBundle.getMessage(KafkaPanel.class, "KafkaPanel.jTextPane1.toolTipText")); // NOI18N
		jScrollPane2.setViewportView(jTextPane1);

		jSplitPane3.setRightComponent(jScrollPane2);

		jSplitPane5.setRightComponent(jSplitPane3);

		jSplitPane1.setRightComponent(jSplitPane5);

		add(jSplitPane1);
	}// </editor-fold>//GEN-END:initComponents

	/**
	 * setNode
	 * This method initializes all components of the Kafka log view.
	 * @param selectedNode node where the view gets included
	 */
	@Override
	public void setNode(final Node selectedNode) {
		DefaultTableModel model = (DefaultTableModel) tableView.getModel();
		try {
			// reset
			if (selectedNode == null) return;
			Content content = selectedNode.getLookup().lookup(Content.class);
			// non-content object passed in?
			if (content == null) return;
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			AbstractFile file = selectedNode.getLookup().lookup(AbstractFile.class);
			if (file != null) {
				if (file.isFile() && file.getSize() > 100) {
					parseKafkaLogFile(file, model, md);
				}
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Exception: " + ex.getMessage());
		}
		includeExportButton(selectedNode);
		initColumns();
		includeHexView(selectedNode);
	}

	/**
	 * includeHexView
	 * Method to update the hex view on the bottom.
	 * @param selectedNode node where the view gets included
	 */
	private void includeHexView(final Node selectedNode) {
		tableView.getSelectionModel().
		addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting() && tableView.getSelectedRow() != -1) {
					long offSet = (long) ((DefaultTableModel) tableView.getModel())
							.getValueAt(tableView.getSelectedRow(), 5);
					int numBytes = (int) ((DefaultTableModel) tableView.getModel())
							.getValueAt(tableView.getSelectedRow(), 6);
					AbstractFile file = selectedNode.getLookup()
							.lookup(AbstractFile.class);
					updateHexView(file, numBytes, offSet, jTextPane2);

					offSet = (long) ((DefaultTableModel) tableView.getModel())
							.getValueAt(tableView.getSelectedRow(), 7);
					numBytes = (int) ((DefaultTableModel) tableView.getModel())
							.getValueAt(tableView.getSelectedRow(), 8);
					file = selectedNode.getLookup().lookup(AbstractFile.class);
					updateHexView(file, numBytes, offSet, jTextPane1);
				}
			}

			private void updateHexView(AbstractFile file, int numBytes,
					long offSet, JTextPane textPane) throws HeadlessException {
				if (file != null) {
					byte[] keyContentBuffer = new byte[numBytes];
					try {
						if (file.read(keyContentBuffer, offSet, numBytes)
								!= numBytes) {
							JOptionPane.showMessageDialog(null,
									"Could not read " + numBytes
									+ " bytes from " + file.getName());
						} else {
							textPane.setText(
									HexView.formatHexBytes(keyContentBuffer, 16));
						}
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null,
								"Exception: could not read " + numBytes +
								" bytes: " + ex.getMessage());
					}
				}
			}
		});
	}

	/**
	 * initColumns
	 * This method first removes the helper columns (to seek key value pairs).
	 * The information of the helper columns still remain in the data model.
	 * We further adjusts the width of visible columns.
	 */
	private void initColumns() {
		// hide last columns with file seeking information
		for (int i = 0; i < 4; i++) {
			tableView.removeColumn(tableView.getColumnModel()
					.getColumn(tableView.getColumnCount() - 1));
		}
		// Time
		tableView.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		tableView.getColumnModel().getColumn(0).setPreferredWidth(140);
		tableView.getColumnModel().getColumn(0).setMinWidth(10);
		tableView.getColumnModel().getColumn(0).setMaxWidth(140);
		// Key
		tableView.getColumnModel().getColumn(1).setPreferredWidth(200);
		tableView.getColumnModel().getColumn(1).setMinWidth(20);
		// Value
		tableView.getColumnModel().getColumn(2).setPreferredWidth(400);
		tableView.getColumnModel().getColumn(2).setMinWidth(20);
		// Hash
		tableView.getColumnModel().getColumn(3).setPreferredWidth(100);
		tableView.getColumnModel().getColumn(3).setMinWidth(70);
		tableView.getColumnModel().getColumn(3).setMaxWidth(430);
		// Export
		tableView.getColumnModel().getColumn(4).setPreferredWidth(95);
		tableView.getColumnModel().getColumn(4).setMinWidth(95);
		tableView.getColumnModel().getColumn(4).setMaxWidth(95);
	}

	/**
	 * includeExportButton
	 * Method for the functionality of the export buttons.
	 * @param selectedNode node where the buttons get included
	 */
	private void includeExportButton(final Node selectedNode) {
		Action export = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JTable table = (JTable)e.getSource();
				int modelRow = Integer.valueOf(e.getActionCommand());
				long offSet = (long) ((DefaultTableModel)table.getModel())
						.getValueAt(modelRow, 7);
				int numBytes = (int) ((DefaultTableModel)table.getModel())
						.getValueAt(modelRow, 8);
				AbstractFile file = selectedNode.getLookup()
						.lookup(AbstractFile.class);
				if (file != null) {
					byte[] valueContentBuffer = new byte[numBytes];
					try {
						if (file.read(valueContentBuffer, offSet, numBytes)
								!= numBytes) {
							JOptionPane.showMessageDialog(null,
									"Could not read " + numBytes
									+ " bytes from " + file.getName());
						} else {
							FileDialog fDialog = new FileDialog((JFrame)
									((JComponent)e.getSource()).getRootPane()
									.getParent(), "Save", FileDialog.SAVE);
							fDialog.setVisible(true);
							String path = fDialog.getDirectory() + fDialog.getFile();
							File fileOut = new File(path);
							fileOut.createNewFile();
							FileOutputStream outputStream = new FileOutputStream(fileOut);
							outputStream.write(valueContentBuffer);
							outputStream.close();
						}
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null,
								"Could not write " + numBytes
								+ " bytes: " + ex.getMessage());
					}
				}
			}
		};
		TableButton buttonColumn = new TableButton(tableView, export, 4);
	}

	/**
	 * parseKafkaLogFile
	 * Method for parsing the Kafka log files.
	 * @param file: file to be parsed
	 * @param model: model to store the parsed data
	 * @param md: message digest used for hashing
	 * @throws TskCoreException 
	 */
	private void parseKafkaLogFile(AbstractFile file, DefaultTableModel model,
			MessageDigest md) throws TskCoreException {
		boolean debug = false; // toggle debug details
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
		int buffLength = 100;
		byte[] shortBuffer = new byte[buffLength];
		int bytesRead = file.read(shortBuffer, 0, buffLength);
		if (bytesRead != buffLength) {
			throw new TskCoreException("Could not read " + buffLength
					+ " bytes from " + file.getName());
		}
		// check if file has 14 times FF at the right place, which is a
		// strong indicator for a Kafka log-file
		if ((!checkBufferAllFF(shortBuffer, 0, 42)) // not only FFs
				&& checkBufferAllFF(shortBuffer, 43, 56) // 14 times FF
				&& (!checkBufferAllFF(shortBuffer, 57, 60))) {     // not only FFs
			if (debug) model.addRow(new Object[]{"runtime","debug","file "
					+file.getName()+" hits filter for fixed position of FFs", ""});
			// Start parsing the file
			long currentFileOffset = 0;
			while (true) {
				if (debug) model.addRow(new Object[]{"runtime","debug",
						"traversing through while-loop for offset "+currentFileOffset,""});
				if (file.read(shortBuffer, currentFileOffset, buffLength) != buffLength) {
					if (debug) model.addRow(new Object[]{"runtime","debug",
							"break while loop as read not successful",""});
					break;
				}
				ByteBuffer sb = ByteBuffer.wrap(shortBuffer);
				sb.getInt(); // Initial Zeroes, not needed
				int baseOffset = sb.getInt();  // baseOffset, not needed
				int lengthOfBatch = sb.getInt() + 12;
				long createTimeFirstRecord = sb.getLong(27);
				if (debug) model.addRow(new Object[]{"runtime","debug",
						"length of batch is " + lengthOfBatch
						+ " (includes plus 12 introductory bytes)",""});
				if (debug) model.addRow(new Object[]{"runtime","debug",
						"time of first record is " + createTimeFirstRecord
						+ ", readable: "+ dateFormat.format(new Date(createTimeFirstRecord)),""});
				byte[] fullBatchBuffer = new byte[lengthOfBatch];
				if (file.read(fullBatchBuffer, currentFileOffset, lengthOfBatch) != lengthOfBatch) {
					throw new TskCoreException("Could not read " + lengthOfBatch
							+ " bytes from " + file.getName());
				}
				ByteBuffer fbb = ByteBuffer.wrap(fullBatchBuffer);
				int numberOfRecordsInBatch = fbb.getInt(57);
				byte[] skipStartBuffer = new byte[61];
				fbb.get(skipStartBuffer);
				if (debug) model.addRow(new Object[]{"runtime","debug",
						"we loop over " + numberOfRecordsInBatch
						+ " records within batch "+baseOffset,""});
				// Iterate over all records within the batch
				for (int i = 0; i < numberOfRecordsInBatch; i++) {
					int lengthOfRecord = (int) fbb.get() / 2;
					byte zeroByte = fbb.get(); // skip zero-byte after length indicator
					int timeOffset = (int) fbb.get() / 2; // read time offset
					if (timeOffset < 0) {
						fbb.get(); // skip one byte
						// timeOffset = timeOffset * -1 (int)fbb.get();
					}
					int innerBatchOffset = (int) fbb.get() / 2;
					if (innerBatchOffset < 0) {
						fbb.get(); // skip one byte
						//kafkaOffsetOfRecord = kafkaOffsetOfRecord*-1(int)fbb.get();
					}
					int keyLength = (int) fbb.get() / 2;
					byte[] bytesForKey = new byte[keyLength];
					int keyPos = fbb.position();
					fbb.get(bytesForKey);
					String key = "[Key not UTF-8 encoded]";
					try {
						key = new String(bytesForKey, StandardCharsets.UTF_8);
					} catch (Exception e) {}
					int valueLength = (int) fbb.get() / 2;
					byte[] bytesForValue = new byte[valueLength];
					int valPos = fbb.position();
					fbb.get(bytesForValue);
					String value = "[Value not UTF-8 encoded]";
					try {
						value = new String(bytesForValue, StandardCharsets.UTF_8);
					} catch (Exception e) {}
					fbb.get(); // skip zero-byte at the end
					if (debug) model.addRow(new Object[]{"runtime","debug",
							"Record "+i+": "
									+ "length "+lengthOfRecord+"; "
									+ "zeroByte "+zeroByte+"; "
									+ "timeOffset "+timeOffset+"; "
									+ "innerBatchOffset "+innerBatchOffset+"; "
									+ "BytesFor K: " + HexView.bytesToHex(bytesForKey, false)+"; "
									+ "BytesFor V: " + HexView.bytesToHex(bytesForValue, false),
									""
					});
					// Show time/key/value-pair in view
					model.addRow(new Object[]{
							dateFormat.format(new Date(createTimeFirstRecord+timeOffset)),
							key,
							value,
							HexView.bytesToHex(md.digest(bytesForValue), false),
							"Export Value",
							currentFileOffset+(long)keyPos,
							keyLength,
							currentFileOffset+(long)valPos,
							valueLength
					});
				}
				currentFileOffset = currentFileOffset + lengthOfBatch;
			}
			if (debug) model.addRow(new Object[]{"leave while loop"});
		}
	}

	/**
	 * checkBufferAllFF
	 * Method that checks a buffer whether from start to end position
	 * there is only 0xFF.
	 * Used to find pattern that indicates a Kafka log file.
	 * @param buffer
	 * @param start
	 * @param end
	 * @return true on success
	 */
	private boolean checkBufferAllFF(byte[] buffer, int start, int end) {
		for (int i = start; i <= end; i++) {
			if ( ! (buffer[i] == (byte)0xFF) ) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String getTitle() {
		return "Kafka Log Forensic v0.9";
	}

	@Override
	public String getToolTip() {
		return "Kafka Forensics";
	}

	@Override
	public DataContentViewer createInstance() {
		return new KafkaPanel();
	}

	@Override
	public Component getComponent() {
		// we can do this because this class extends JPanel
		return this;
	}

	@Override
	public void resetComponent() {
		tableView.setModel(new javax.swing.table.DefaultTableModel(
				new Object [][] { },
				new String [] {
						"Timestamp", "Key", "Value", "SHA-256 Hash", "Export",
						"KeyAbsoluteOffset", "KeyLength", "ValueAbsoluteOffset",
						"ValueLength"
				}
				));
	}

	@Override
	public boolean isSupported(Node node) {
		// get a Content datamodel object out of the node
		//        Content content = node.getLookup().lookup(Content.class);
		//        if (content == null) {
		//            return false;
		//        }
		// we only want files that are 1024 bytes or larger (for no good reason)
		//        if (content.getSize() < 1024) {
		//            return false;
		//        }
		return true;
	}

	@Override
	public int isPreferred(Node node) {
		// we return 1 since this module will operate on nearly all files
		// 5 specific, see ViewerPriority.java
		return 1;
	}


	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JSplitPane jSplitPane1;
	private javax.swing.JSplitPane jSplitPane3;
	private javax.swing.JSplitPane jSplitPane4;
	private javax.swing.JSplitPane jSplitPane5;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextPane jTextPane1;
	private javax.swing.JTextPane jTextPane2;
	private javax.swing.JTable tableView;
	// End of variables declaration//GEN-END:variables
}
