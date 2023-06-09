package com.bjpowernode.service.impl;

import com.bjpowernode.dao.GoodsDao;
import com.bjpowernode.dao.SaleDao;
import com.bjpowernode.domain.Goods;
import com.bjpowernode.domain.Sale;
import com.bjpowernode.excep.NotEnoughException;
import com.bjpowernode.service.BuyGoodsService;


public class BuyGoodsServiceImpl implements BuyGoodsService {

    private SaleDao saleDao;
    private GoodsDao goodsDao;

    public void addSale(){}
    public void addGoods(){}

    public void modifyGoods(){}
    public void modifySale(){}

    public void removeGoods(){}
    public void removeSale(){}

    public void queryGoods(){}
    public void searchSale(){}

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
