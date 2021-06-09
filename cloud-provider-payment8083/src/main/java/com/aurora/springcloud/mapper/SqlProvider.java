package com.aurora.springcloud.mapper;

 import org.apache.ibatis.jdbc.SQL;



/**
 * @author zbsilent
 * @date 2021年06月09日 3:23 上午
 */
public class SqlProvider {

  public String queryAll() {

//    return new SQL().SELECT("").FROM("").INNER_JOIN("")..WHERE("sq", "st2").toString();
/*    return new SQL(){
      SELECT("g.id,g.name,g.origin,g.price,t.id AS t_id,t.type_name");
      FROM("goods g");
      INNER_JOIN("goods_type t ON g.type_id=t.id");
      WHERE("g.id=#{id}");
    }.toString(); */
      return "";
  }
}
