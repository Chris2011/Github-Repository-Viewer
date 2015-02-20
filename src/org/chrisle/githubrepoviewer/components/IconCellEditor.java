package org.chrisle.githubrepoviewer.components;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellEditor;
import javax.swing.tree.TreePath;

/**
 *
 * @author chrl
 */
class IconCellEditor extends JLabel implements TreeCellEditor, ActionListener {
    protected JTree m_tree = null;
    protected JTextField m_editor = null;
    protected IconData m_item = null;
    protected int m_lastRow = -1;
    protected long m_lastClick = 0;
    protected Vector m_listeners = null;

    public IconCellEditor(JTree tree) {
        super();
        m_tree = tree;
        m_listeners = new Vector();
    }

    public Component getTreeCellEditorComponent(JTree tree,
            Object value, boolean isSelected, boolean expanded,
            boolean leaf, int row) {
        if (value instanceof DefaultMutableTreeNode) {
            DefaultMutableTreeNode node
                    = (DefaultMutableTreeNode) value;
            Object obj = node.getUserObject();
            if (obj instanceof IconData) {
                IconData idata = (IconData) obj;
                m_item = idata;
                // Reserve some more space...
                setText(idata.toString() + "     ");
                setIcon(idata._icon);
                setFont(tree.getFont());
                return this;
            }
        }
        // We don't support other objects...
        return null;
    }

    public Object getCellEditorValue() {
        if (m_item != null && m_editor != null) {
            m_item._data = m_editor.getText();
        }
        return m_item;
    }

    public boolean isCellEditable(EventObject evt) {
        if (evt instanceof MouseEvent) {
            MouseEvent mEvt = (MouseEvent) evt;
            if (mEvt.getClickCount() == 1) {
                int row = m_tree.getRowForLocation(mEvt.getX(),
                        mEvt.getY());
                if (row != m_lastRow) {
                    m_lastRow = row;
                    m_lastClick = System.currentTimeMillis();
                    return false;
                } else if (System.currentTimeMillis() - m_lastClick
                        > 1000) {
                    m_lastRow = -1;
                    m_lastClick = 0;
                    prepareEditor();
                    mEvt.consume();
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    protected void prepareEditor() {
        if (m_item == null) {
            return;
        }
        String str = m_item.toString();

        m_editor = new JTextField(str);
        m_editor.addActionListener(this);
        m_editor.selectAll();
        m_editor.setFont(m_tree.getFont());

        add(m_editor);
        revalidate();

        TreePath path = m_tree.getPathForRow(m_lastRow);
        m_tree.startEditingAtPath(path);
    }

    protected void removeEditor() {
        if (m_editor != null) {
            remove(m_editor);
            m_editor.setVisible(false);
            m_editor = null;
            m_item = null;
        }
    }

    public void doLayout() {
        super.doLayout();
        if (m_editor != null) {
            int offset = getIconTextGap();
            if (getIcon() != null) {
                offset += getIcon().getIconWidth();
            }
            Dimension cSize = getSize();
            m_editor.setBounds(offset, 0, cSize.width - offset,
                    cSize.height);
        }
    }

    public boolean shouldSelectCell(EventObject evt) {
        return true;
    }

    public boolean stopCellEditing() {
        if (m_item != null) {
            m_item._data = m_editor.getText();
        }

        ChangeEvent e = new ChangeEvent(this);
        for (int k = 0; k < m_listeners.size(); k++) {
            CellEditorListener l = (CellEditorListener) m_listeners.
                    elementAt(k);
            l.editingStopped(e);
        }

        removeEditor();
        return true;
    }

    public void cancelCellEditing() {
        ChangeEvent e = new ChangeEvent(this);
        for (int k = 0; k < m_listeners.size(); k++) {
            CellEditorListener l = (CellEditorListener) m_listeners.
                    elementAt(k);
            l.editingCanceled(e);
        }

        removeEditor();
    }

    public void addCellEditorListener(CellEditorListener l) {
        m_listeners.addElement(l);
    }

    public void removeCellEditorListener(CellEditorListener l) {
        m_listeners.removeElement(l);
    }

    public void actionPerformed(ActionEvent e) {
        stopCellEditing();
        m_tree.stopEditing();
    }
}
