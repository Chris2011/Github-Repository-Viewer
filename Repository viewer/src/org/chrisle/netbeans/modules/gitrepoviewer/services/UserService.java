package org.chrisle.netbeans.modules.gitrepoviewer.services;

import java.io.FileNotFoundException;
import org.chrisle.netbeans.modules.gitrepoviewer.beans.IHost;
import org.chrisle.netbeans.modules.gitrepoviewer.beans.User;
import org.chrisle.netbeans.modules.gitrepoviewer.repositories.UserRepository;
import org.openide.util.Exceptions;

/**
 *
 * @author chrl
 */
public class UserService {
    protected final User _user;
    protected final UserRepository _userRepo;

    public UserService(User user, UserRepository userRepo) {
        this._userRepo = userRepo;
        this._user = user;
    }

    public User getUser() {
        try {
            return this._userRepo.getUser();
        } catch (FileNotFoundException ex) {
            Exceptions.printStackTrace(ex);
            return null;
        }
    }

    public void saveUser(IHost host) {
        this._userRepo.setSelectedHost(host.getHostName());
        try {
            this._userRepo.saveUser(this._user);
        } catch (Exception ex) {
            Exceptions.printStackTrace(ex);
        }
    }   
}