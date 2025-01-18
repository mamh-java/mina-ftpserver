/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.ftpserver.usermanager.impl;

import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.ftplet.UserManager;
import org.apache.ftpserver.usermanager.Md5PasswordEncryptor;
import org.apache.ftpserver.usermanager.PasswordEncryptor;

/**
 * <strong>Internal class, do not use directly.</strong>
 * <p>
 * Abstract common base type for {@link UserManager} implementations
 *
 * @author <a href="http://mina.apache.org">Apache MINA Project</a>
 */
public abstract class AbstractUserManager implements UserManager {
    /** 'userid' key for the variable to be injected into SQL prepared statement*/
    public static final String ATTR_LOGIN = "userid";

    /** 'userpassword' key for the variable to be injected into SQL prepared statement*/
    public static final String ATTR_PASSWORD = "userpassword";

    /** 'homedirectory' key for the variable to be injected into SQL prepared statement*/
    public static final String ATTR_HOME = "homedirectory";

    /** 'writepermission' key for the variable to be injected into SQL prepared statement*/
    public static final String ATTR_WRITE_PERM = "writepermission";

    /** 'enableflag' key for the variable to be injected into SQL prepared statement*/
    public static final String ATTR_ENABLE = "enableflag";

    /** 'idletime' key for the variable to be injected into SQL prepared statement*/
    public static final String ATTR_MAX_IDLE_TIME = "idletime";

    /** 'uploadrate' key for the variable to be injected into SQL prepared statement*/
    public static final String ATTR_MAX_UPLOAD_RATE = "uploadrate";

    /** 'downloadrate' key for the variable to be injected into SQL prepared statement*/
    public static final String ATTR_MAX_DOWNLOAD_RATE = "downloadrate";

    /** 'maxloginnumber' key for the variable to be injected into SQL prepared statement*/
    public static final String ATTR_MAX_LOGIN_NUMBER = "maxloginnumber";

    /** 'maxloginperip' key for the variable to be injected into SQL prepared statement*/
    public static final String ATTR_MAX_LOGIN_PER_IP = "maxloginperip";

    private final String adminName;

    private final PasswordEncryptor passwordEncryptor;

    /**
     * An AbstractUserManager constructor. The default password encryptor is using MD5
     */
    public AbstractUserManager() {
        this(null,  new Md5PasswordEncryptor());
    }

    /**
     * Internal constructor, do not use directly
     *
     * @param adminName The administrator name
     * @param passwordEncryptor The password encryption method
     */
    public AbstractUserManager(String adminName, PasswordEncryptor passwordEncryptor) {
        this.adminName = adminName;
        this.passwordEncryptor = passwordEncryptor;
    }

    /**
     * Get the admin name.
     *
     * {@inheritDoc}
     */
    public String getAdminName() {
        return adminName;
    }

    /**
     * {@inheritDoc}
     */
    public boolean isAdmin(String login) throws FtpException {
        return adminName.equals(login);
    }

    /**
     * Retrieve the password encryptor used for this user manager
     *
     * @return The password encryptor. Default to {@link Md5PasswordEncryptor}
     *  if no other has been provided
     */
    public PasswordEncryptor getPasswordEncryptor() {
        return passwordEncryptor;
    }
}
