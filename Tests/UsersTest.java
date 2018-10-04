package sample;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class UsersTest {

    private Users users1;

    @org.junit.Before
    public void setUp() throws Exception {
        users1 = new Users("micheal","hidden");
    }

    @Test
    public void getName() {
        Assert.assertEquals(users1.getName(),"micheal");
    }

    @Test
    public void getPassword() {
        Assert.assertEquals(users1.getPassword(),"hidden");
    }
}