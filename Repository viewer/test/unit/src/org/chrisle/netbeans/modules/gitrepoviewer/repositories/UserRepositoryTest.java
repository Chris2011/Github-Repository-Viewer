package org.chrisle.netbeans.modules.gitrepoviewer.repositories;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import org.chrisle.netbeans.modules.gitrepoviewer.beans.User;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import static org.junit.Assert.assertEquals;

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
    
    public Reader _fileReader;

    @Before
    public void setUp() throws Exception {
//        MockitoAnnotations.initMocks(this);
        this._selectedHost = "Github";
        this._filePrefix = "User.json";
        
        File tempFile = testFolder.newFile(this._selectedHost + this._filePrefix);
        
        this._fileReader = new FileReader(testFolder.getRoot().getPath() + "\\" + tempFile.getName());
        this._userRepo = new UserRepository(this._gsonProvider, this._fileReader);

    }

    /**
     * Test of getUser method, of class UserRepository.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        
        String expResult = "ChrisLE";

        Mockito.when(this._gsonProvider.fromJson(_fileReader, User.class)).thenReturn(new User("ChrisLE", "MyToken"));
        User result = this._userRepo.getUser();
        
        assertEquals(expResult, result.getUserName());
    }
    
    /**
     * Test of getUser method, of class UserRepository.
     * @throws java.io.FileNotFoundException
     */
//    @Ignore
    @Test(expected = FileNotFoundException.class)
    public void testGetUserFileNotFound() throws FileNotFoundException {
        System.out.println("getUserFileNotFound");
        
        Mockito.when(this._gsonProvider.fromJson(new FileReader("Foooooooooooooooo.json"), User.class)).thenReturn(new User("ChrisLE", "MyToken"));
        User result = this._userRepo.getUser();
    }

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