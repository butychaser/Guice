package org.gm.guicetutorial;

import com.google.inject.ImplementedBy;

@ImplementedBy(MD5HelperStandardImpl.class)
public interface MD5Helper
{

    String getMD5Hash (String input);

}