package org.chrisle.netbeans.modules.gitrepoviewer.repositories;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileWriter;
import java.io.Reader;
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
    private final Reader _fileReader;

    public UserRepository(Gson gsonProvider, Reader fileReader) {
        this._gsonProvider = gsonProvider;
        this._dirName = System.getProperty("user.home") + "\\.GitRepoViewer\\";
        this._filePrefix = "User.json";
        this._fileReader = fileReader;
    }

    public void setSelectedHost(String host) {
        this._selectedHost = host;
    }
    
    public String getSelectedHost() {
        return _selectedHost;
    }

    public User getUser() {
        return this._gsonProvider.fromJson(this._fileReader, User.class);
    }

    public void saveUser(User user) throws Exception {
        String userJson = this._gsonProvider.toJson(user);

        try {
            File dir = new File(this._dirName);
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