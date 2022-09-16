package com.nexton.cloudapp.qa.constants;

import com.nexton.cloudapp.qa.enums.ConfigProperties;
import com.nexton.cloudapp.qa.utils.ReaderPropertyFile;

public class FrameworkConstants {
    private final static  String SYSTEM_PATH =System.getProperty("user.dir");
    private final static String CONFIG_PATH = SYSTEM_PATH +"/src/test/java/com/nexton/cloudapp/qa/testResources/config.properties";
    private final static String EXCEL_PATH = SYSTEM_PATH +"/src/test/java/com/nexton/cloudapp/qa/testResources/datatest.xlsx";


    private final static long PAGELOAD = 10;
    private final static int EXPLICITWAIT = 10;
    private static final String EXTENTREPORT_PATH = System.getProperty("user.dir") + "/extent-test-output";

    public static long getPageload() {
        return PAGELOAD;
    }

    public static String getExcelpath() {
        return EXCEL_PATH;
    }

    public static String getExtentreportpath() throws Exception {

        if (ReaderPropertyFile.getValue(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("yes")) {
            return EXTENTREPORT_PATH + "/" + "index.html";
        } else {
            return EXTENTREPORT_PATH + "/" + "index.html";
        }

    }

    public static int getExplicitwait() {
        return EXPLICITWAIT;
    }
    public static String getSystemPath() {
        return SYSTEM_PATH;
    }

    public static String getConfigPath() {

        System.out.println(CONFIG_PATH);
        return CONFIG_PATH;
    }
}
