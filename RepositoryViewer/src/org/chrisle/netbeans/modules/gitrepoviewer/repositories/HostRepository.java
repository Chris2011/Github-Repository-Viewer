package org.chrisle.netbeans.modules.gitrepoviewer.repositories;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 *
 * @author chrl
 */
public class HostRepository {
    private String _selectedHost;

    public int getHostsLength() {
        return 0;
    }

    public void getHosts() {
        try {
            FileReader hosts = new FileReader(System.getProperty("user.home") + "\\.GitRepoViewer\\" + _selectedHost + "Hosts.json");
        } catch (FileNotFoundException ex) {
        }
    }

    public void saveHost() {
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