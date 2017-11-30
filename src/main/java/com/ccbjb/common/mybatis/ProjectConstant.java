package com.ccbjb.common.mybatis;

/**
 * 项目常量
 */
public class ProjectConstant {
    public static final String BASE_PACKAGE = "com.ccbjb";//项目基础包名称，根据自己公司的项目修改

    public static final String MODEL_PACKAGE = BASE_PACKAGE + ".common.domain;" + BASE_PACKAGE + ".model";//Model所在包
    public static final String MAPPER_PACKAGE = BASE_PACKAGE + ".common.mapper";//Mapper所在包
    public static final String SERVICE_PACKAGE = BASE_PACKAGE + ".dao";//Service所在包
    public static final String SERVICE_IMPL_PACKAGE = SERVICE_PACKAGE + ".impl";//ServiceImpl所在包
    public static final String CONTROLLER_PACKAGE = BASE_PACKAGE + ".controller";//Controller所在包

    public static final String MAPPER_INTERFACE_REFERENCE = BASE_PACKAGE + ".common.mybatis.Mapper";//Mapper插件基础接口的完全限定名
    public static final String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
    public static final String JDBC_URL = "jdbc:mysql://127.0.0.1/parkcharge?useUnicode=true&characterEncoding=utf-8";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "";
}
