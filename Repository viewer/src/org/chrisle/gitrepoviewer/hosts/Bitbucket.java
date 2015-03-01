package org.chrisle.gitrepoviewer.hosts;

import java.util.List;
import org.eclipse.egit.github.core.IRepositoryIdProvider;
import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.RepositoryBranch;

/**
 *
 * @author chrl
 */
public class Bitbucket implements IHost {
    private final String _hostName;

    public Bitbucket(String hostName) {
        _hostName = hostName;
    }

    @Override
    public void setUserCredentials(String userName, String password) {
        
    }

    @Override
    public List<Repository> getRepositories() {
        return null;
    }

    @Override
    public List<RepositoryBranch> getBranches(IRepositoryIdProvider repositoryId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> getTags() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean isPrivate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getHostName() {
        return _hostName;
    }

    @Override
    public String getHostIcon() {
        return "org/chrisle/gitrepoviewer/resources/bitbucket.png";
    }
}
