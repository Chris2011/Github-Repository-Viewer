/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.chrisle.githubrepoviewer;

import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
        dtd = "-//org.chrisle.githubrepoviewer//GithubRepoViewer//EN",
        autostore = false
)
@TopComponent.Description(
        preferredID = "GithubRepoViewerTopComponent",
        iconBase = "org/chrisle/githubrepoviewer/github-cat.png",
        persistenceType = TopComponent.PERSISTENCE_ALWAYS
)
@TopComponent.Registration(mode = "explorer", openAtStartup = false)
@ActionID(category = "Window", id = "org.chrisle.githubrepoviewer.GithubRepoViewerTopComponent")
@ActionReferences({
    @ActionReference(path = "Menu/Window" /*, position = 333 */),
    @ActionReference(path = "Shortcuts", name = "DO-G DO-R")
})
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_GithubRepoViewerAction",
        preferredID = "GithubRepoViewerTopComponent"
)
@Messages({
    "CTL_GithubRepoViewerAction=Github Repository Viewer",
    "CTL_GithubRepoViewerTopComponent=Repositories",
    "HINT_GithubRepoViewerTopComponent=This is a Repository Viewer"
})
public final class GithubRepoViewerTopComponent extends TopComponent {

    public GithubRepoViewerTopComponent() {
        initComponents();
        setName(Bundle.CTL_GithubRepoViewerTopComponent());
        setToolTipText(Bundle.HINT_GithubRepoViewerTopComponent());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    @Override
    public void componentOpened() {
        // TODO add custom code on component opening
    }

    @Override
    public void componentClosed() {
        // TODO add custom code on component closing
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    void readProperties(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }
}
