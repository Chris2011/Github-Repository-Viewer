package org.chrisle.netbeans.modules.gitrepoviewer.hosts;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.egit.github.core.IRepositoryIdProvider;
import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.RepositoryBranch;

/**
 *
 * @author Chris
 */
public abstract class HostBase implements IHost {
    @Override
    public List<Repository> getRepositories(String userName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public String getHostName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getHostIcon() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<HostBase> getHosts() {
        return new ArrayList<>();
    }

    @Override
    public void saveUserCredentials(String userName, String authToken) {
        User user = new User(userName, authToken);
        Gson gson = new Gson();

        String userJson = gson.toJson(user);

        try {
            FileWriter writer = new FileWriter(System.getProperty("user.home") + this.getHostName() + "User.json");
            writer.write(userJson);
            writer.close();
        } catch(IOException e) {
            
        }
    }

    @Override
    public void saveHost(HostBase host) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveRepository(Object repository) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveBranch(String repositoryId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveTag(String repositoryId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public abstract void setUserCredentials(String userName, String authToken);
}