package com.xiangpeng.shsearch.tools;


import java.io.File;

public class RecursionUtils {

    /***
     递归文件夹
     */
    public static void recursionFolder(File f,UtilHandler u) throws Exception {
        if(f.isDirectory()){
            File[] files = f.listFiles();
            for (int i = 0 ; i < files.length;i++){
                File file = files[i];
                recursionFolder(file,u);
            }
        }else {
            u.doHadnle(new Object[]{f});
        }

    }

}
