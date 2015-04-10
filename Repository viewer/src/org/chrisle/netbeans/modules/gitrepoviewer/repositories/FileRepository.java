package org.chrisle.netbeans.modules.gitrepoviewer.repositories;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 *
 * @author chrl
 */
public class FileRepository {
    private String _selectedHost;

    public int getHostsLength() {
        getHostsLength();

        return 0;
    }

    public void getHosts() {
        try {
            FileReader hosts = new FileReader(System.getProperty("user.home") + "\\.GitRepoViewer\\" + _selectedHost + "Hosts.json");
        } catch (FileNotFoundException ex) {
        }
    }
}