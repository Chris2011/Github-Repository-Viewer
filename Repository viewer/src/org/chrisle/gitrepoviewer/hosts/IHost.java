package org.chrisle.gitrepoviewer.hosts;

import java.util.List;
import org.eclipse.egit.github.core.IRepositoryIdProvider;
import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.RepositoryBranch;

/**
 *
 * @author chrl
 */
public interface IHost {
    public void setUserCredentials(String userName, String password);
    public List<Repository> getRepositories(String userName);
    public List<RepositoryBranch> getBranches(IRepositoryIdProvider repositoryId);
    public List<String> getTags();
    public String getHostName();
    public String getHostIcon();
}