package cn.xxct.oa_element.utils;/*
package cn.xxct.oa_element.utils;

import cn.xxct.oa_element.domain.Productt;
import cn.xxct.oa_element.domain.Sell;
import cn.xxct.oa_element.domain.SellDetail;
import cn.xxct.oa_element.domain.Stock;
import cn.xxct.oa_element.utilsvo.OrderInRebackVo;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class SellUtils {
    public static<T> void product(OrderInRebackVo orderInRebackVo, float money, int num , Map<String,Object> map) {

        List<T> list=new ArrayList<>();
        for (Productt productt : orderInRebackVo.getOr()) {
            sellDetail.setProductName(productt.getName());
            sellDetail.setProductNum(productt.getProductNum());
            sellDetail.setPrice(productt.getPrice());
            sellDetail.setMoney(sellDetail.getPrice() * sellDetail.getProductNum());
            orderInRebackVo.getSell().getSellDetailList().add(sellDetail);
            money += sellDetail.getMoney();
            num += sellDetail.getProductNum();
            Stock stock = new Stock();
            stock.setProductId(productt.getId());
            stock.setProductNum(sellDetail.getProductNum());
            stock.setCreateTime(new Date());
            orderInRebackVo.getSell().getStocks().add(stock);
        }

        orderInRebackVo.getSell().setMoney(money);
        orderInRebackVo.getSell().setProductNum(num);
        orderInRebackVo.getSell().setOperator(SessionUtils.getCurrentUser().getUser_name());
        orderInRebackVo.getSell().setCreateTime(new Date());
    }
}
*/
