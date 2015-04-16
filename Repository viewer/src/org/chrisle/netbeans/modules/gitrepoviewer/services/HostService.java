package org.chrisle.netbeans.modules.gitrepoviewer.services;

import java.util.ArrayList;
import java.util.List;
import org.chrisle.netbeans.modules.gitrepoviewer.beans.IHost;
import org.chrisle.netbeans.modules.gitrepoviewer.beans.User;
import org.chrisle.netbeans.modules.gitrepoviewer.nodes.IRepository;
import org.chrisle.netbeans.modules.gitrepoviewer.repositories.UserRepository;
import org.eclipse.egit.github.core.IRepositoryIdProvider;
import org.eclipse.egit.github.core.RepositoryBranch;
import org.openide.util.Exceptions;

/**
 *
 * @author Chris
 */
public class HostService<T> implements IHostService<IHost> {
    private final User _user;
    private final UserRepository _userRepo;

    public HostService(User user) {
        _userRepo = new UserRepository();
        _user = user;
    }

    @Override
    public List<IRepository> getRepositories(String userName) {
        // TODO: Will be overwritten.
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
    public List<IHost> getHostsFromFile() {
        return new ArrayList<>();
    }

    @Override
    public User getUser() {
        return this._userRepo.getUser();
    }

    

    @Override
    public void saveUserCredentials(IHost host) {
        this._userRepo.setSelectedHost(host.getHostName());

        try {
            this._userRepo.saveUser(this._user);
        } catch (Exception ex) {
            Exceptions.printStackTrace(ex);
        }
    }

    @Override
    public void saveHost(IHost host) {
        
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
}