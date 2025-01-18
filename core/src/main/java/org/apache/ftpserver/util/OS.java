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

package org.apache.ftpserver.util;

import java.util.Locale;

/**
 * <strong>Internal class, do not use directly.</strong>
 *
 * Condition that tests the OS type.
 *
 * @author <a href="http://mina.apache.org">Apache MINA Project</a>
 */
public final class OS {
    /** OS/400 */
    private static final String FAMILY_OS_400 = "os/400";

    /** Z/OS */
    private static final String FAMILY_Z_OS = "z/os";

    /** WIN9x */
    private static final String FAMILY_WIN9X = "win9x";

    /** OpenVMS */
    private static final String FAMILY_OPENVMS = "openvms";

    /** Unix */
    private static final String FAMILY_UNIX = "unix";

    /** Tandem */
    private static final String FAMILY_TANDEM = "tandem";

    /** MAC */
    private static final String FAMILY_MAC = "mac";

    /** MS/DOS */
    private static final String FAMILY_DOS = "dos";

    /** NetWare */
    private static final String FAMILY_NETWARE = "netware";

    /** OS/2 */
    private static final String FAMILY_OS_2 = "os/2";

    /** Windows */
    private static final String FAMILY_WINDOWS = "windows";

    /** The OS name */
    private static final String OS_NAME = System.getProperty("os.name").toLowerCase(Locale.US);

    /** The OS architecture */
    private static final String OS_ARCH = System.getProperty("os.arch").toLowerCase(Locale.US);

    /** The OS version */
    private static final String OS_VERSION = System.getProperty("os.version").toLowerCase(Locale.US);

    /** The OS path separator */
    private static final String PATH_SEP = System.getProperty("path.separator");

    /**
     * Default constructor
     */
    private OS() {
    }

    /**
     * Determines if the OS on which Ant is executing matches the given OS
     * family. * Possible values:<br />
     * <ul>
     * <li>dos</li>
     * <li>mac</li>
     * <li>netware</li>
     * <li>os/2</li>
     * <li>tandem</li>
     * <li>unix</li>
     * <li>windows</li>
     * <li>win9x</li>
     * <li>z/os</li>
     * <li>os/400</li>
     * </ul>
     *
     * @param family the family to check for
     * @return <code>true</code> if the OS matches
     */
    private static boolean isFamily(final String family) {
        return isOs(family, null, null, null);
    }

    /**
     * Tells if the underlaying OS is MS/DOS
     *
     * @return <code>true</code> if the underlaying OS is MS/DOS
     */
    public static boolean isFamilyDOS() {
        return isFamily(FAMILY_DOS);
    }

    /**
     * Tells if the underlaying OS is MAC
     *
     * @return <code>true</code> if the underlaying OS is MAC
     */
    public static boolean isFamilyMac() {
        return isFamily(FAMILY_MAC);
    }

    /**
     * Tells if the underlaying OS is NetWare
     *
     * @return <code>true</code> if the underlaying OS is NetWare
     */
    public static boolean isFamilyNetware() {
        return isFamily(FAMILY_NETWARE);
    }

    /**
     * Tells if the underlaying OS is OS/2
     *
     * @return <code>true</code> if the underlaying OS is OS/2
     */
    public static boolean isFamilyOS2() {
        return isFamily(FAMILY_OS_2);
    }

    /**
     * Tells if the underlaying OS is Tandem
     *
     * @return <code>true</code> if the underlaying OS is Tandem
     */
    public static boolean isFamilyTandem() {
        return isFamily(FAMILY_TANDEM);
    }

    /**
     * Tells if the underlaying OS is Unix
     *
     * @return <code>true</code> if the underlaying OS is Unix
     */
    public static boolean isFamilyUnix() {
        return isFamily(FAMILY_UNIX);
    }

    /**
     * Tells if the underlaying OS is Windows
     *
     * @return <code>true</code> if the underlaying OS is Windows
     */
    public static boolean isFamilyWindows() {
        return isFamily(FAMILY_WINDOWS);
    }

    /**
     * Tells if the underlaying OS is Win9x
     *
     * @return <code>true</code> if the underlaying OS is Win9x
     */
    public static boolean isFamilyWin9x() {
        return isFamily(FAMILY_WIN9X);
    }

    /**
     * Tells if the underlaying OS is Z/OS
     *
     * @return <code>true</code> if the underlaying OS is Z/OS
     */
    public static boolean isFamilyZOS() {
        return isFamily(FAMILY_Z_OS);
    }

    /**
     * Tells if the underlaying OS is OS/400
     *
     * @return <code>true</code> if the underlaying OS is OS/400
     */
    public static boolean isFamilyOS400() {
        return isFamily(FAMILY_OS_400);
    }

    /**
     * Tells if the underlaying OS is OpenVMS
     *
     * @return <code>true</code> if the underlaying OS is OpenVMS
     */
    public static boolean isFamilyOpenVms() {
        return isFamily(FAMILY_OPENVMS);
    }

    /**
     * Determines if the OS on which Ant is executing matches the given OS name.
     *
     * @param name the OS name to check for
     * @return <code>true</code> if the OS matches
     */
    public static boolean isName(final String name) {
        return isOs(null, name, null, null);
    }

    /**
     * Determines if the OS on which Ant is executing matches the given OS
     * architecture.
     *
     * @param arch the OS architecture to check for
     * @return <code>true</code> if the OS matches
     */
    public static boolean isArch(final String arch) {
        return isOs(null, null, arch, null);
    }

    /**
     * Determines if the OS on which Ant is executing matches the given OS
     * version.
     *
     * @param version the OS version to check for
     * @return <code>true</code> if the OS matches
     */
    public static boolean isVersion(final String version) {
        return isOs(null, null, null, version);
    }

    /**
     * Determines if the OS on which Ant is executing matches the given OS
     * family, name, architecture and version
     *
     * @param family The OS family
     * @param name The OS name
     * @param arch The OS architecture
     * @param version The OS version
     * @return <code>true</code> if the OS matches
     */
    public static boolean isOs(final String family, final String name, final String arch, final String version) {
        boolean retValue = false;

        if (family != null || name != null || arch != null || version != null) {

            boolean isFamily = true;
            boolean isName = true;
            boolean isArch = true;
            boolean isVersion = true;

            if (family != null) {
                switch (family) {
                    case FAMILY_WINDOWS:
                        isFamily = OS_NAME.indexOf(FAMILY_WINDOWS) > -1;
                        break;

                    case FAMILY_OS_2:
                        isFamily = OS_NAME.indexOf(FAMILY_OS_2) > -1;
                        break;

                    case FAMILY_NETWARE:
                        isFamily = OS_NAME.indexOf(FAMILY_NETWARE) > -1;
                        break;

                    case FAMILY_DOS:
                        isFamily = PATH_SEP.equals(";") && !isFamily(FAMILY_NETWARE);
                        break;

                    case FAMILY_MAC:
                        isFamily = OS_NAME.indexOf(FAMILY_MAC) > -1;
                        break;

                    case FAMILY_TANDEM:
                        isFamily = OS_NAME.indexOf("nonstop_kernel") > -1;
                        break;

                    case FAMILY_UNIX:
                        isFamily = PATH_SEP.equals(":")
                            && !isFamily(FAMILY_OPENVMS)
                            && (!isFamily(FAMILY_MAC) || OS_NAME.endsWith("x"));
                        break;

                    case FAMILY_WIN9X:
                        isFamily = isFamily(FAMILY_WINDOWS)
                            && (OS_NAME.indexOf("95") >= 0
                                    || OS_NAME.indexOf("98") >= 0
                                    || OS_NAME.indexOf("me") >= 0 || OS_NAME
                                    .indexOf("ce") >= 0);
                        break;

                    case FAMILY_Z_OS:
                        isFamily = OS_NAME.indexOf(FAMILY_Z_OS) > -1 || OS_NAME.indexOf("os/390") > -1;
                        break;

                    case FAMILY_OS_400:
                        isFamily = OS_NAME.indexOf(FAMILY_OS_400) > -1;
                        break;

                    case FAMILY_OPENVMS:
                        isFamily = OS_NAME.indexOf(FAMILY_OPENVMS) > -1;
                        break;

                    default:
                        throw new IllegalArgumentException("Don\'t know how to detect os family \"" + family + "\"");
                }
            }

            if (name != null) {
                isName = name.equals(OS_NAME);
            }

            if (arch != null) {
                isArch = arch.equals(OS_ARCH);
            }

            if (version != null) {
                isVersion = version.equals(OS_VERSION);
            }

            retValue = isFamily && isName && isArch && isVersion;
        }

        return retValue;
    }
}
