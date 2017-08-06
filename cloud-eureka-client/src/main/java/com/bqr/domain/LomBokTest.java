package com.bqr.domain;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LomBokTest
{
    
    public void nonNullExample(@NonNull Person person)
    {
        log.debug(person.toString());
//        System.out.println(person);
        System.out.println(person.getPersonName());
    }
    
    public static void main(String[] args) throws Exception
    {
        LomBokTest t = new LomBokTest();
        Person p  = new Person();
        p.setPersonAge("1");
        p.setPersonName("bqr123");
        t.nonNullExample(p);
       
//        Employee e = new Employee(1, "1","1", "1");
//        
//        Employee.builder().build();
        
//        @Cleanup InputStream in = new FileInputStream(args[0]);
//        @Cleanup OutputStream out = new FileOutputStream(args[1]);
//        byte[] b = new byte[10000];
//        while (true) {
//          int r = in.read(b);
//          if (r == -1) break;
//          out.write(b, 0, r);
//        }
    }
}
