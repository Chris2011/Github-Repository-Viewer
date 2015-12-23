package org.chrisle.netbeans.modules.gitrepoviewer.repositories;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileReader;
import org.chrisle.netbeans.modules.gitrepoviewer.beans.User;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 *
 * @author chrl
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({
    Gson.class
})
public class UserRepositoryTest {
    private UserRepository _userRepo;
    private final Gson _gsonProvider = PowerMockito.mock(Gson.class);

    private String _selectedHost;
    private String _dirName;
    private String _filePrefix;
    
    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();

    @Before
    public void setUp() {
//        MockitoAnnotations.initMocks(this);
        this._selectedHost = "Github";
//        this._dirName = System.getProperty("user.home") + "\\.GitRepoViewer\\";
        this._filePrefix = "User.json";
    }

    /**
     * Test of getUser method, of class UserRepository.
     * @throws java.lang.Exception
     */
//    @Ignore
    @Test
    public void testGetUser() throws Exception {
        System.out.println("getUser");
        String expResult = "ChrisLE";
        this._userRepo = new UserRepository(this._gsonProvider);
        
        File tempFile = testFolder.newFile(this._selectedHost + this._filePrefix);
//        File tempFolder = testFolder.newFile("folder");
        
        System.out.println(testFolder.getRoot().getName());

        Mockito.when(this._gsonProvider.fromJson(new FileReader(testFolder.getRoot().getPath() + "\\" + tempFile.getName()), User.class)).thenReturn(new User("ChrisLE", "MyToken"));
        User result = this._userRepo.getUser();
        
        assertEquals(expResult, result.getUserName());
    }
    
    /**
     * Test of getUser method, of class UserRepository.
     * @throws java.lang.Exception
     */
//    @Ignore
//    @Test(expected = FileNotFoundException.class)
//    public void testGetUserFileNotFound() throws Exception {
//        System.out.println("getUserFileNotFound");
//        this._userRepo = new UserRepository(this._gsonProvider);
//        
//        Mockito.when(this._gsonProvider.fromJson(new FileReader(this._dirName + this._selectedHost + this._filePrefix), User.class)).thenReturn(new User("ChrisLE", "MyToken"));
//        User result = this._userRepo.getUser();
//    }

//    /**
//     * Test of saveUser method, of class UserRepository.
//     */
//    @Test
//    public void testSaveUser() throws Exception {
//        System.out.println("saveUser");
//        User user = null;
//        UserRepository instance = new UserRepository();
//        instance.saveUser(user);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
