package LOL;

import java.io.*;

/**
 * @outhor liusiyu
 * IO读取文件中的数据并 查分存储
 * @create 2019-04-15-16:29
 */
public class IOduqu {

public static void main(String[] args) throws Exception {
    String filePath = "C:/Users/Hello/Desktop/test.txt";
      Object OBJ= readTxt(filePath);
    System.out.println(OBJ);
}

    //	读取文件
    public static Object readTxt(String path) throws Exception {

        StringBuilder strb = new StringBuilder( "" );

        InputStream is = new FileInputStream( new File( path ) );
        InputStreamReader isr = new InputStreamReader( is, getCode( path ) );
        BufferedReader br = new BufferedReader( isr );

        Product PD = new Product();
        String str = "";
        String result[] = new String[0];
        Product pd = new Product();
        while (null != (str = br.readLine())) {
            // 注意要加\\,要不出不来,yeah

            String[] names = str.split( "\\ " );
              result=new String[names.length];
            for (int i = 0; i < names.length; i++) {
                result[i]=names[i];
            }
            pd.setName( result[0] );
            pd.setPrice( Integer.parseInt(result[1]) );
            pd.setLevel( result[2]);
            pd.setAmout( Integer.parseInt(result[3] ) );

        }

        br.close();
        return pd.toString();
        }
    // 获取编码格式 gb2312,UTF-16,UTF-8,Unicode,UTF-8
    public static String getCode(String path) throws Exception {
        InputStream inputStream = new FileInputStream(path);
        byte[] head = new byte[3];
        inputStream.read(head);
        String code = "gb2312"; // 或GBK
        if (head[0] == -1 && head[1] == -2)
            code = "UTF-16";
        else if (head[0] == -2 && head[1] == -1)
            code = "Unicode";
        else if (head[0] == -17 && head[1] == -69 && head[2] == -65)
            code = "UTF-8";
        inputStream.close();

        return code;
    }

//    public static void main(String[] args) {
//        String value = "192.168.128.33";
//        // 注意要加\\,要不出不来,yeah
//        String[] names = value.split("\\.");
//        for (int i = 0; i < names.length; i++) {
//            System.out.println(names[i]);
//        }
//    }

}

