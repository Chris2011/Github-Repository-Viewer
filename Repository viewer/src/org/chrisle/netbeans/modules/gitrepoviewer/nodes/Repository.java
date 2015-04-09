package org.chrisle.netbeans.modules.gitrepoviewer.nodes;

/**
 *
 * @author Chris
 */
public class Repository implements IRepository {
    private String _repoName;
    private String _icon;

    @Override
    public String getName() {
        return this._repoName;
    }

    @Override
    public void setName(String repoName) {
        this._repoName = repoName;
    }

    public String getIcon() {
        return _icon;
    }

    public void setIcon(String iconName) {
        this._icon = iconName;
    }
}