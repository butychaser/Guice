package org.gm.guicetutorial;

import java.math.BigInteger;

import com.twmacinta.util.MD5;

public class MD5HelperFastImpl implements MD5Helper
{

    public MD5HelperFastImpl ()
    {
        System.out.println("Constructing MD5HelperFastImpl.");
    }

    @Override
    public String getMD5Hash (String input)
    {

        MD5 md5 = new MD5();
        md5.Update(input);

        return new BigInteger(1, md5.Final()).toString(16);
    }

}
