package spring.service;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import spring.dao.GoodsDao;
import spring.dao.SaleDao;
import spring.domain.Goods;
import spring.domain.Sale;
import spring.exception.NotEnoughException;

public class BuyGoodsServiceImpl implements BuyGoodsService {

    private SaleDao saleDao;
    private GoodsDao goodsDao;

    public void setSaleDao(SaleDao saleDao) {
        this.saleDao = saleDao;
    }

    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }

    @Transactional(
            propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT,
            readOnly = false,
            rollbackFor = {
                    NullPointerException.class,
                    NotEnoughException.class
            }
    )
    @Override
    public void buy(Integer goodsId, Integer nums) {
        System.out.println("方法的开始");
        Sale sale = new Sale();
        sale.setGid(goodsId);
        sale.setNums(nums);
        saleDao.insertSale(sale);

        Goods goods = goodsDao.selectGoods(goodsId);
        if (goods == null){
            throw new NullPointerException("编号是：" + goodsId + "的商品不存在");
        }
        else if (goods.getAmount() < nums){
            throw new NotEnoughException("编号是：" + goodsId + "的商品库存不足");
        }

        Goods goods1 = new Goods();
        goods1.setId(goodsId);
        goods1.setAmount(nums);
        goodsDao.updateGoods(goods1);
        System.out.println("方法的结束");
    }
}
