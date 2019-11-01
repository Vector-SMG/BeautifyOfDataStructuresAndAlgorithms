package com.curcopia.array;

import com.cornucopia.array.ArrayList;
import org.junit.Test;

/**
 * @author cornucopia
 * @version 1.0
 * @since 2019-10-21
 */
public class ArrayTest {


    @Test
    public void testFind(){
        ArrayList<Integer> arrayList=new ArrayList<Integer>(2);
        arrayList.add(12);
        arrayList.add(13);
        arrayList.add(14);
        arrayList.add(15);
        arrayList.add(16);


        System.out.println(arrayList.getElementData().length);

    }

}
