package org.chrisle.netbeans.modules.gitrepoviewer.repositories;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import org.chrisle.netbeans.modules.gitrepoviewer.beans.User;
import org.openide.util.Exceptions;

/**
 *
 * @author chrl
 */
public class UserRepository {
    private String _selectedHost;
    private FileReader _userFile;
    private Gson _gsonProvider;
    private final String _dirName;

    public UserRepository() {
        _gsonProvider = new Gson();
        _dirName = System.getProperty("user.home") + "\\.GitRepoViewer\\";

        try {
            this._userFile = new FileReader(this._dirName + this._selectedHost + "User.json");
        } catch (FileNotFoundException ex) {
            Exceptions.printStackTrace(ex);
        }
    }

    public void setSelectedHost(String host) {
        this._selectedHost = host;
    }

    public User getUser() {
        return this._gsonProvider.fromJson(this._userFile, User.class);
    }

    public void saveUser(User user) throws Exception {
        String userJson = this._gsonProvider.toJson(user);

        try {
            File dir = new File(_dirName);
            dir.mkdir();
            
            File file = new File(dir, this._selectedHost + "Hosts.json");
            FileWriter fileWriter = new FileWriter(file);

            fileWriter.write(userJson);
            fileWriter.close();
        } catch(Exception e) {
            throw new Exception(e.getMessage());
        }
//        String hostJson = _gsonProvider.toJson(host);
//        try {
//            File dir = new File(_dirName);
//            dir.mkdir();
//            
//            File file = new File(dir, host.getHostName() + "Hosts.json");
//            FileWriter fileWriter = new FileWriter(file);
//
//            fileWriter.write(hostJson);
//            fileWriter.close();
//        } catch(Exception e) {
//            _errorDialog.setErrorMessage(e.getMessage());
//            _errorDialog.setVisible(true);
//        }
    }
}