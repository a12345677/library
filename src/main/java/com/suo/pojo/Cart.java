package com.suo.pojo;

import java.math.BigDecimal;
import java.util.*;

public class Cart {
  private  static   int totalCount ;
  private   static BigDecimal  totalPrice ;
  /*map集合所装载的是购物车内每个商品和id的映射关系*/
  private   Map<Integer,CartItem> items =   new LinkedHashMap<>();

/**添加商品*/
  public  void addItem(CartItem cartItem){
      /*根据商品的id获取商品的信息*/
      int id = cartItem.getId();
      CartItem item = items.get(id);
      /*购物车里没有的话*/
   if(item==null){
       items.put(id,cartItem);
   }
   else {
       /*有的话*/
       item.setCount(item.getCount() + 1);
       item.setPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
       items.put(id, cartItem);
   }
  }
/**删除商品*/
  public  void deleteItem(int id){
      items.remove(id);

  }
  /**清空购物车*/
  public  void clear(){
      items.clear();
  }
  /**修改商品数量*/
 public  void updateCount(int id , int count){
     CartItem item = items.get(id);
     /*如果商品存在*/
     if(item!=null){
         item.setCount(count);
         item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
         items.put(id,item);
     }


 }
 /**获取总数量*/
    public int getTotalCount() {
        totalCount = 0  ;
        Set<Map.Entry<Integer, CartItem>> entrySet = items.entrySet();
        for( Map.Entry<Integer, CartItem> item : entrySet){
            item.getValue().setCount(totalCount+item.getValue().getCount());
        }
        return totalCount;
    }
/**获取总价格*/
    public BigDecimal getTotalPrice() {
       totalPrice = new BigDecimal(0);
        Set<Map.Entry<Integer, CartItem>> entrySet = items.entrySet();
        for( Map.Entry<Integer, CartItem> item : entrySet){
           item.getValue().getTotalPrice().add(item.getValue().getTotalPrice());
        }
        return totalPrice;
    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }
    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + totalCount +
                ", totalPrice=" + totalPrice +
                ", items=" + items +
                '}';
    }
}
