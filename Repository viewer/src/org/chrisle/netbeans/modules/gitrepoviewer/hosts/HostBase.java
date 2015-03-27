package org.chrisle.netbeans.modules.gitrepoviewer.hosts;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import org.chrisle.netbeans.modules.gitrepoviewer.components.ErrorDialog;
import org.eclipse.egit.github.core.IRepositoryIdProvider;
import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.RepositoryBranch;

/**
 *
 * @author Chris
 */
public class HostBase implements IHost {
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
            File dir = new File(System.getProperty("user.home") + "\\.GitRepoViewer");
            dir.mkdir();

            File file = new File(dir,  this.getHostName() + "User.json");
            FileWriter fileWriter = new FileWriter(file);

            fileWriter.write(userJson);
            fileWriter.close();
        } catch(Exception e) {
            ErrorDialog test = new ErrorDialog(null, true);
            test.setErrorMessage(e.getMessage());
            test.setVisible(true);
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
    public void setUserCredentials(String userName, String authToken) {
        // TODO: Will be overriden.
    }
}