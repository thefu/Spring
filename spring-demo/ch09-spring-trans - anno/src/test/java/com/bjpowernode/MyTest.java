package com.bjpowernode;

import com.bjpowernode.service.BuyGoodsService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class  MyTest {

    @Test
    public void test01(){
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext ( config );
        //从容器中获取Service
        BuyGoodsService service = (BuyGoodsService) ctx.getBean ( "buyService" );

        //调用方法
        service.buy ( 1002,10 );
    }
}
