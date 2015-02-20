package org.chrisle.gitrepoviewer.components;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellRenderer;

/**
 *
 * @author chrl
 */
class IconCellRenderer extends JLabel implements TreeCellRenderer {
    protected Color _textSelectionColor;
    protected Color _textNonSelectionColor;
    protected Color _bkSelectionColor;
    protected Color _bkNonSelectionColor;
    protected Color _borderSelectionColor;

    protected boolean m_selected;

    public IconCellRenderer() {
        super();
        _textSelectionColor = UIManager.getColor("Tree.selectionForeground");
        _textNonSelectionColor = UIManager.getColor("Tree.textForeground");
        _bkSelectionColor = UIManager.getColor("Tree.selectionBackground");
        _bkNonSelectionColor = UIManager.getColor("Tree.textBackground");
        _borderSelectionColor = UIManager.getColor("Tree.selectionBorderColor");
        setOpaque(false);
    }

    public Component getTreeCellRendererComponent(JTree tree,
            Object value, boolean sel, boolean expanded, boolean leaf,
            int row, boolean hasFocus) {
        DefaultMutableTreeNode node
                = (DefaultMutableTreeNode) value;
        Object obj = node.getUserObject();
        setText(obj.toString());
        if (obj instanceof IconData) {
            IconData idata = (IconData) obj;
            if (expanded) {
                setIcon(idata.getOpenIcon());
            } else {
                setIcon(idata.getIcon());
            }
        } else {
            setIcon(null);
        }

        setFont(tree.getFont());
        setForeground(sel ? _textSelectionColor : _textNonSelectionColor);
        setBackground(sel ? _bkSelectionColor : _bkNonSelectionColor);
        m_selected = sel;
        return this;
    }

    public void paint(Graphics g) {
        Color bColor = getBackground();
        Icon icon = getIcon();

        g.setColor(bColor);
        int offset = 0;
        if (icon != null && getText() != null) {
            offset = (icon.getIconWidth() + getIconTextGap());
        }
        g.fillRect(offset, 0, getWidth() - 1 - offset,
                getHeight() - 1);

        if (m_selected) {
            g.setColor(_borderSelectionColor);
            g.drawRect(offset, 0, getWidth() - 1 - offset, getHeight() - 1);
        }

        super.paint(g);
    }
}
