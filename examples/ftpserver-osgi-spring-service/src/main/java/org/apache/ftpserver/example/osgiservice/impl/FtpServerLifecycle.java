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


package org.apache.ftpserver.example.osgiservice.impl;

import org.apache.ftpserver.FtpServer;

/**
 * An OSGi life cycle management class
 *
 * @author <a href="http://mina.apache.org">Apache MINA Project</a>
 */
public class FtpServerLifecycle {
    /** The server to manage */
    private FtpServer server;

    /**
     * A default constructor
     */
    public FtpServerLifecycle() {
        // Do nothing
    }

    /**
     * Get the FtpServer instance
     *
     * @return The FtpServer instance
     */
    public FtpServer getServer() {
        return server;
    }

    /**
     * Set the FtpServer instance
     *
     * @param server The FtpServer instance
     */
    public void setServer(FtpServer server) {
        this.server = server;
    }

    /**
     * Initialize the FtpServer
     *
     * @throws Exception If the server can't be started
     */
    public void init() throws Exception {
        server.start();
        System.out.println("Server started");
    }

    /**
     * Stop the server
     *
     * @throws Exception If the server can't be stopped
     */
    public void destroy() throws Exception {
        server.stop();
        System.out.println("Server stopped");
    }

}
