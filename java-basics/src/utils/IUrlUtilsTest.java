package utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class IUrlUtilsTest {


    @Test
    public void extraDomain() {
        System.out.println(        IUrlUtils.extraDomain("https://www.cnblogs.com/DreamDrive/p/7594305.html"));
    }

    @Test
    public void extraUrlSchema() {
        System.out.println(        IUrlUtils.extraUrlSchema("https://www.cnblogs.com/DreamDrive/p/7594305.html"));
    }

    @Test
    public void extraSchema() {
    }
}