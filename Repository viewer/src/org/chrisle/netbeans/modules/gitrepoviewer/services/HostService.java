package org.chrisle.netbeans.modules.gitrepoviewer.services;

import java.util.ArrayList;
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
public class HostService<T> implements IHostService<IHost> {
    public HostService(User user) {
    }

    @Override
    public List<IRepository> getRepositories(String userName) {
        // TODO: Will be overwritten.
        return null;
    }

    @Override
    public List<RepositoryBranch> getBranches(IRepositoryIdProvider repositoryId) {
        // TODO: Will be overwritten.
        return null;
    }

    @Override
    public List<String> getTags() {
        // TODO: Will be overwritten.
        return null;
    }

    @Override
    public List<IHost> getHostsFromFile() {
        return new ArrayList<>();
    }


//    @Override
//    public void saveRepository(Object repository) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void saveBranch(String repositoryId) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void saveTag(String repositoryId) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

//    @Override
//    public void setUserCredentials() {
//        // TODO: Will be overriden.
//    }

    @Override
    public void saveHost(IHost host) {
        
    }
}