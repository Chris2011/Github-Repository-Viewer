package org.chrisle.netbeans.modules.gitrepoviewer.hosts;

import java.util.List;
import org.eclipse.egit.github.core.IRepositoryIdProvider;
import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.RepositoryBranch;

/**
 *
 * @author chrl
 */
public interface IHost {
    public void saveUserCredentials(String userName, String authToken);

    public List<Repository> getRepositories(String userName);
    public void saveRepository(Object repository);

    public List<RepositoryBranch> getBranches(IRepositoryIdProvider repositoryId);
    public void saveBranch(String repositoryId);

    public List<String> getTags();
    public void saveTag(String repositoryId);

    public String getHostName();
    public String setHostName(String hostName);

    public String getHostIcon();

    /**
     * Get all saved hosts, with all other information (Repositories, Branches, Tags, etc.).
     * @return List of HostBase objects.
     */
    public List<HostBase> getHosts();

    /**
     * Saves a host to a file with all information (Repositories, Branches, Tags, etc.).
     * @param host A host, which will be saved.
     */
    public void saveHost(HostBase host);
}