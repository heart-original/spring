package spring.dao;

import spring.domain.Goods;

public interface GoodsDao {
    int updateGoods(Goods goods);
    Goods selectGoods(Integer goodsId);
}
