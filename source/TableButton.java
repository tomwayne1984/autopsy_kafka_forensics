/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forensic;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.AbstractCellEditor;

import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableCellEditor;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 * TableButton
 * Class to create buttons within a table view.
 */
public class TableButton extends AbstractCellEditor implements
TableCellEditor, TableCellRenderer, ActionListener, MouseListener {
	private final JTable ownerTable;
	private final Action onClickAction;
	private final Border isNotFocusedBorder;
	private final Border isfocusedBorder;
	private final JButton showButton;
	private final JButton editButton;
	private boolean isEditingCell;
	private Object captionObj;

	public TableButton(JTable table, Action action, int column) {
		ownerTable = table;
		onClickAction = action;
		showButton = new JButton();
		editButton = new JButton();
		isNotFocusedBorder = editButton.getBorder();
		isfocusedBorder = new LineBorder(Color.BLACK);
		editButton.setFocusPainted(false);
		editButton.addActionListener(this);
		table.getColumnModel().getColumn(column).setCellRenderer(this);
		table.getColumnModel().getColumn(column).setCellEditor(this);
		table.addMouseListener(this);
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		if (isSelected) {
			showButton.setBackground(table.getSelectionBackground());
			showButton.setForeground(table.getSelectionForeground());
		} else {
			showButton.setBackground(UIManager.getColor("Button.background"));
			showButton.setForeground(table.getForeground());
		}
		if (hasFocus) {
			showButton.setBorder(isfocusedBorder);
		} else {
			showButton.setBorder(isNotFocusedBorder);
		}
		showButton.setText(value.toString());
		return showButton;
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean isSelected, int row, int column) {
		editButton.setText(value.toString());
		captionObj = value;
		return editButton;
	}

	@Override
	public Object getCellEditorValue() {
		return captionObj;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		fireEditingStopped();
		ActionEvent event = new ActionEvent(ownerTable,
				ActionEvent.ACTION_PERFORMED,
				Integer.toString(
						ownerTable.convertRowIndexToModel(
								ownerTable.getEditingRow()
								)
						)
				);
		onClickAction.actionPerformed(event);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (ownerTable.isEditing() && ownerTable.getCellEditor() == this) {
			isEditingCell = true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (ownerTable.isEditing() && isEditingCell) {
			ownerTable.getCellEditor().stopCellEditing();
		}
		isEditingCell = false;
	}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

}
