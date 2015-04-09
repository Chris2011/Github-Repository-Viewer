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
public interface IHost {
    public String getHostName();
    public void setHostName(String hostName);

    public List<IRepository> getRepositories();
    public void setRepositories(List<IRepository> repositories);

    public List<RepositoryBranch> getBranches();
    public void setBranches(List<RepositoryBranch> branches);

    public List<RepositoryTag> getTags();
    public void setTags(List<RepositoryTag> tags);

    public String getIcon();
    public void setIcon(String icon);
}