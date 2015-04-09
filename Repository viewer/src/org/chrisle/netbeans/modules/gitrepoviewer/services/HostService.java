package org.chrisle.netbeans.modules.gitrepoviewer.services;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import org.chrisle.netbeans.modules.gitrepoviewer.beans.IHost;
import org.chrisle.netbeans.modules.gitrepoviewer.components.ErrorDialog;
import org.chrisle.netbeans.modules.gitrepoviewer.beans.User;
import org.chrisle.netbeans.modules.gitrepoviewer.nodes.IRepository;
import org.eclipse.egit.github.core.IRepositoryIdProvider;
import org.eclipse.egit.github.core.RepositoryBranch;

/**
 *
 * @author Chris
 */
public class HostService<T> implements IHostService<IHost> {
    private final Gson _gsonProvider;
    private final User _user;
    private final ErrorDialog _errorDialog;
    private final String _dirName;

    public HostService(User user) {
        _errorDialog = new ErrorDialog(null, true);
        _dirName = System.getProperty("user.home") + "\\.GitRepoViewer";
        _gsonProvider = new Gson();
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
    public void saveUserCredentials(IHost host) {
        String userJson = _gsonProvider.toJson(_user);

        try {
            File dir = new File(_dirName);
            dir.mkdir();

            File file = new File(dir,  host.getHostName() + "User.json");
            FileWriter fileWriter = new FileWriter(file);

            fileWriter.write(userJson);
            fileWriter.close();
        } catch(Exception e) {
            _errorDialog.setErrorMessage(e.getMessage());
            _errorDialog.setVisible(true);
        }
    }

    @Override
    public void saveHost(IHost host) {
        String hostJson = _gsonProvider.toJson(host);
        try {
            File dir = new File(_dirName);
            dir.mkdir();
            
            File file = new File(dir, host.getHostName() + "Hosts.json");
            FileWriter fileWriter = new FileWriter(file);

            fileWriter.write(hostJson);
            fileWriter.close();
        } catch(Exception e) {
            _errorDialog.setErrorMessage(e.getMessage());
            _errorDialog.setVisible(true);
        }
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