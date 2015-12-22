package org.chrisle.netbeans.modules.gitrepoviewer.repositories;

import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.FileReader;
import org.chrisle.netbeans.modules.gitrepoviewer.beans.User;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 *
 * @author chrl
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({
//    FileReader.class,
    Gson.class
})
//public class UserRepositoryTest extends PowerMockTestCase {
public class UserRepositoryTest {
    private UserRepository _userRepo;
    private final Gson _gsonProvider = PowerMockito.mock(Gson.class);

    @Mock
    private FileReader _fileReader;
    private String _selectedHost;
    private String _dirName;
    private String _filePrefix;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this._selectedHost = "Github";
        this._dirName = System.getProperty("user.home") + "\\.GitRepoViewer\\";
        this._filePrefix = "User.json";
    }

    /**
     * Test of getUser method, of class UserRepository.
     * @throws java.lang.Exception
     */
    @Test
    @Ignore
    public void testGetUser() throws Exception {
        System.out.println("getUser");
        //        _userRepo.setSelectedHost(host);
        String expResult = "ChrisLE";
        this._userRepo = new UserRepository(this._gsonProvider);

        PowerMockito.when(this._gsonProvider.fromJson(new FileReader(this._dirName + this._selectedHost + this._filePrefix), User.class)).thenReturn(new User("ChrisLE", "MyToken"));
        User result = this._userRepo.getUser();
        
        assertEquals(expResult, result.getUserName());
    }
    
    /**
     * Test of getUser method, of class UserRepository.
     * @throws java.lang.Exception
     */
    @Test(expected = FileNotFoundException.class)
    public void testGetUserFileNotFound() throws Exception {
        System.out.println("getUserFileNotFound");
        //        _userRepo.setSelectedHost(host);
        String expResult = "ChrisLE";
        this._userRepo = new UserRepository(this._gsonProvider);

        PowerMockito.when(this._gsonProvider.fromJson(new FileReader(this._dirName + this._selectedHost + this._filePrefix), User.class)).thenReturn(new User("ChrisLE", "MyToken"));
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
