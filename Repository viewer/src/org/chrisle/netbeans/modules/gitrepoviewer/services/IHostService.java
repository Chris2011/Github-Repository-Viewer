package org.chrisle.netbeans.modules.gitrepoviewer.services;

import java.util.List;
import org.chrisle.netbeans.modules.gitrepoviewer.beans.IHost;
import org.chrisle.netbeans.modules.gitrepoviewer.beans.User;
import org.chrisle.netbeans.modules.gitrepoviewer.nodes.IRepository;
import org.eclipse.egit.github.core.IRepositoryIdProvider;
import org.eclipse.egit.github.core.RepositoryBranch;

/**
 *
 * @author Chris
 */
public interface IHostService<T extends IHost> {
//    public void setUserCredentials();
//    public void saveUser(T host);

    public List<IRepository> getRepositories(String userName);
//    public void saveRepository(Object repository);

    public List<RepositoryBranch> getBranches(IRepositoryIdProvider repositoryId);
//    public void saveBranch(String repositoryId);

    public List<String> getTags();
//    public void saveTag(String repositoryId);

//    public String getHostName();
//
//    public String getHostIcon();

    /**
     * Get all saved hosts, with all other information (Repositories, Branches, Tags, etc.).
     * @return List of HostBase objects.
     */
    public List<T> getHostsFromFile();

//    public User getUser();

    /**
     * Saves a host to a file with all information (Repositories, Branches, Tags, etc.).
     * @param host A host, which will be saved.
     */
    public void saveHost(T host);
}