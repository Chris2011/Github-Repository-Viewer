package org.chrisle.netbeans.modules.gitrepoviewer.beans;

import java.util.List;
import org.chrisle.netbeans.modules.gitrepoviewer.nodes.IRepository;
import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.RepositoryBranch;
import org.eclipse.egit.github.core.RepositoryTag;

/**
 *
 * @author Chris
 */
//public abstract class Host implements IHost {
public class Host implements IHost {
    private String _hostName;
    private List<IRepository> _repositories;
    private List<RepositoryBranch> _branches;
    private List<RepositoryTag> _tags;
    private String _icon;

    @Override
    public String getHostName() {
        return this._hostName;
    }

    @Override
    public void setHostName(String hostName) {
        this._hostName = hostName;
    }

    @Override
    public List<IRepository> getRepositories() {
        return this._repositories;
    }

    @Override
    public void setRepositories(List<IRepository> repositories) {
        this._repositories = repositories;
    }

    @Override
    public List<RepositoryBranch> getBranches() {
        return this._branches;
    }

    @Override
    public void setBranches(List<RepositoryBranch> branches) {
        this._branches = branches;
    }

    @Override
    public List<RepositoryTag> getTags() {
        return this._tags;
    }

    @Override
    public void setTags(List<RepositoryTag> tags) {
        this._tags = tags;
    }

    @Override
    public String getIcon() {
        return this._icon;
    }

    @Override
    public void setIcon(String icon) {
        this._icon = icon;
    }
}