package org.chrisle.netbeans.modules.gitrepoviewer.nodes;

/**
 *
 * @author Chris
 */
public class Repository implements IRepository {
    private String _repoName;

    @Override
    public String getRepositoryName() {
        return this._repoName;
    }

    @Override
    public void setRepositoryName(String repoName) {
        this._repoName = repoName;
    }
}