package com.caiyide.primary.common.util;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * Ftp上传
 * @author chenshunhua
 * @date 2018/8/17
 */
public class FtpUtil {

    // ftp服务器ip地址
    private static String FTP_ADDRESS;
    // 端口号
    private static int FTP_PORT;
    // 用户名
    private static String FTP_USERNAME;
    // 密码
    private static String FTP_PASSWORD;
    // 图片路径
    private static String FTP_BASEPATH;

    private static final Logger logger = LoggerFactory.getLogger(FtpUtil.class);

    private static boolean uploadFile(String originFileName, InputStream input) {
        logger.info("originFileName:[{}]",originFileName);
        logger.info("FTP_ADDRESS:[{}]",FTP_ADDRESS);
        logger.info("FTP_PORT:[{}]",FTP_PORT);
        logger.info("FTP_USERNAME:[{}]",FTP_USERNAME);
        logger.info("FTP_BASEPATH:[{}]",FTP_BASEPATH);

        boolean success = false;
        FTPClient ftp = new FTPClient();
        ftp.setControlEncoding("UTF-8");
        try {
            int reply;
            ftp.connect(FTP_ADDRESS, FTP_PORT);// 连接FTP服务器
            ftp.login(FTP_USERNAME, FTP_PASSWORD);// 登录
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return success;
            }
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftp.makeDirectory(FTP_BASEPATH);
            ftp.changeWorkingDirectory(FTP_BASEPATH);
            ftp.storeFile(originFileName, input);
            input.close();
            ftp.logout();
            success = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
        return success;
    }

    public static Boolean uploadFile(String path, InputStream inputStream, String ftpAddress, int ftpPort,
                                     String ftpName, String ftpPassWord, String ftpBasePath) {
        FTP_ADDRESS = ftpAddress;
        FTP_PORT = ftpPort;
        FTP_USERNAME = ftpName;
        FTP_PASSWORD = ftpPassWord;
        FTP_BASEPATH = ftpBasePath;
        uploadFile(path,inputStream);
        return true;
    }

}
