package com.aurora.springcloud.mapper;

import com.aurora.springcloud.payment.Payment;
import org.apache.ibatis.annotations.*;

/**
 * @author zbsilent
 * @date 2021年06月09日 2:33 上午
 */
@Mapper
public interface PaymentDao {

  /**
   * 创建
   *
   * @param payment 付款实体
   * @return int
   */
  @Options(useGeneratedKeys = true, keyProperty = "id")
  @Insert("insert into payment(id,serial) values (#{id},#{serial})")
  public int create(Payment payment);

  /**
   * 查询
   *
   * @param id primary key
   * @return Payment
   */
  @Select("SELECT * FROM payment WHERE id =#{id}")
  @Results(
      value = {
        @Result(id = true, column = "id", property = "id"),
        @Result(column = "serial", property = "serial")
      })
  public Payment retrieve(@Param("id") long id);

  /**
   * 更新
   *
   * @param payment 付款实体
   */
  @Update("UPDATE payment SET serial =#{serial} WHERE id =#{id}")
  public void update(Payment payment);

  /**
   *
   * 删除
   * @InsertProvider(type = TestSqlProvider.class, method = "insertSql")
   * @param userId primary key
   *
   * @Result(property="studentList",javaType=List.class,column="gid",many=@Many
   *       (select="cn.easytop.lesson03.resultMap.anno.StudentMapper.queryAllStudent"))*
   * 根据@Select("select * from grade where gid=#{0}")查询出来的gid与数据库中学生列表名映射（一致自动映射）
   * 把gid传递到 "cn.easytop.lesson03.resultMap.anno.StudentMapper.queryAllStudent" 此方法中
   * 查询出来的结果与Grade中的 studentList映射   并指定类型 javaType=List.class
   *
   */



  @Delete("DELETE FROM payment WHERE id =#{id}")
  public void delete(@Param("id") long userId);
}
