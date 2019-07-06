package cn.myfreecloud.shop.generator;

/**
 * @author: zhangyang
 * @date: 2019/7/6 19:28
 * @description:
 */
public class MysqlGeneratorTest {


    public static void main(String[] args) {
        MysqlGenerator mysqlGenerator = new MysqlGenerator();
        mysqlGenerator.generator("user");
    }
}
