package com.bjpowernode.service.impl;

import com.bjpowernode.dao.GoodsDao;
import com.bjpowernode.dao.SaleDao;
import com.bjpowernode.domain.Goods;
import com.bjpowernode.domain.Sale;
import com.bjpowernode.excep.NotEnoughException;
import com.bjpowernode.service.BuyGoodsService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


public class BuyGoodsServiceImpl implements BuyGoodsService {

    private SaleDao saleDao;
    private GoodsDao goodsDao;

    /**
     * rollbackFor:表示发生指定的异常一定回滚
     *  处理逻辑是：
     *      1）spring框架会首先检查方法抛出的异常是不是在rollbackFor的属性值中
     *        如果异常在rollbackFor列表中，不管是什么类型，一定回滚
     *      2）如果你抛出的异常不再rollbackFor列表中，spring会判断异常是不是RuntimeException，
     *        如果是一定回滚
     *
     */
//    @Transactional(
//            propagation = Propagation.REQUIRED,
//            isolation = Isolation.DEFAULT,
//            readOnly = false,
//            rollbackFor = {
//                    NullPointerException.class,NotEnoughException.class
//            }
//    )
    //使用的是事务控制的默认值，默认的传播行为是REQUIRED,默认的隔离级别就是DEFAULT
    //默认抛出运行时异常时，回滚事务
    @Transactional
    @Override
    public void buy(Integer goodsId, Integer nums) {
        System.out.println("====buy方法的开始===");
        //记录销售的信息，向sale表添加记录
        Sale sale = new Sale (  );
        sale.setGid ( goodsId );
        sale.setNums ( nums );
        saleDao.insertSale ( sale );

        //更新库存
        Goods goods = goodsDao.selectGoods ( goodsId );
        if(goods == null){
            //商品不存在
            throw new NullPointerException ( "编号是："+ goodsId + "商品不存在");
        }else if(goods.getAmount ()<nums){
            //商品库存不足
            throw new NotEnoughException ( "编号是：" + goodsId + "商品库存不足" );
        }
        //修改库存了
        Goods buyGoods =new Goods();
        buyGoods.setId ( goodsId );
        buyGoods.setAmount ( nums );
        goodsDao.updateGoods ( buyGoods );

        System.out.println("====buy方法的完成===");

    }

    public void setSaleDao(SaleDao saleDao) {
        this.saleDao = saleDao;
    }

    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }


}
