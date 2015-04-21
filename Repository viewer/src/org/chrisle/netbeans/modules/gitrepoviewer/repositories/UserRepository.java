package org.chrisle.netbeans.modules.gitrepoviewer.repositories;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import org.chrisle.netbeans.modules.gitrepoviewer.beans.User;

/**
 *
 * @author chrl
 */
public class UserRepository {
    private String _selectedHost;
    private final Gson _gsonProvider;
    private final String _dirName;
    private final String _filePrefix;

    public UserRepository() {
        _gsonProvider = new Gson();
        _dirName = System.getProperty("user.home") + "\\.GitRepoViewer\\";
        _filePrefix = "User.json";
    }

    public void setSelectedHost(String host) {
        this._selectedHost = host;
    }

    public User getUser() throws FileNotFoundException {
        try {
            return this._gsonProvider.fromJson(new FileReader(this._dirName + this._selectedHost + this._filePrefix), User.class);
        } catch (FileNotFoundException ex) {
            throw new FileNotFoundException(ex.getMessage());
        }
    }

    public void saveUser(User user) throws Exception {
        String userJson = this._gsonProvider.toJson(user);

        try {
            File dir = new File(_dirName);
            dir.mkdir();

            File file = new File(dir, this._selectedHost + this._filePrefix);
            FileWriter fileWriter = new FileWriter(file);

            fileWriter.write(userJson);
            fileWriter.close();
        } catch(Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}