package sample;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ItemsTest {

    private Items items;

    @org.junit.Before
    public void setUp() throws Exception {
        items = new Items("House");
    }

    @Test
    public void getItem() {
        Assert.assertEquals(items.getItem(),"House");
    }
}