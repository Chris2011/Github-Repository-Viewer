package org.chrisle.netbeans.modules.gitrepoviewer.components;

import javax.swing.Icon;

/**
 *
 * @author chrl
 */
class IconData {

    protected Icon _icon;
    protected Icon _openIcon;
    protected Object _data;

    public IconData(Icon icon, Object data) {
        _icon = icon;
        _openIcon = null;
        _data = data;
    }

    public IconData(Icon icon, Icon openIcon, Object data) {
        _icon = icon;
        _openIcon = openIcon;
        _data = data;
    }

    public Icon getIcon() {
        return _icon;
    }

    public Icon getOpenIcon() {
        return _openIcon != null ? _openIcon : _icon;
    }

    public Object getObject() {
        return _data;
    }

    public String toString() {
        return _data.toString();
    }
}