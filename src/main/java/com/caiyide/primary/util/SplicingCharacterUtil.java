package com.caiyide.primary.util;

import org.apache.poi.ss.formula.functions.T;

import java.util.List;

/**
 * @outhor liusiyu
 * @create 2019-02-22-14:24
 */
public class SplicingCharacterUtil {
    public  static  String  SplicingCharacter(List<String> list){
        StringBuilder str=new StringBuilder();
        for(int i=0;i<list.size();i++)
        {
            if(i==list.size()-1)//当循环到最后一个的时候 就不添加逗号,
            {
                str.append(list.get(i));
            }
            else {
                str.append(list.get(i));
                str.append(",");
            }

        }
        String results =String.valueOf( str );
         return  results;
    }
}
