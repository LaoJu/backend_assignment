import java.sql.*;
import java.util.Arrays;

public class JDBCDemo {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://localhost:3306/test?useSSL=false&characterEncoding=utf8";
    private static final String USER = "root";
    private static final String PASSWORD = "chen6104!@#$";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //加载数据库驱动程序
        Class.forName(DRIVER);
        //连接数据库
        Connection con = DriverManager.getConnection(DBURL,USER,PASSWORD);
        //进行数据库的数据操作
        System.out.println("连接成功");
       Statement stmt = con.createStatement();

        //创建表 添加数据
        String sql1 = " CREATE TABLE member (id SMALLINT ,name VARCHAR(20))";
        String sql2 = "insert into member VALUES (1,'A'),(2,'B'),(3,'C')";

        //执行SQl返回更新的数据行
        int len1 = stmt.executeUpdate(sql1);
        int len2 = stmt.executeUpdate(sql2);
        System.out.println("..."+len2);

        //数据修改
        String sql3 ="UPDATE member SET name='D' WHERE id=3";
        int len3 = stmt.executeUpdate(sql3);

        //数据删除
        String sql4 = "DELETE FROM member WHERE id=2";
        int len4 = stmt.executeUpdate(sql4);

        //数据查找
        String sql5 = "SELECT * FROM member";
        ResultSet rs = stmt.executeQuery(sql5);
        while(rs.next())                         //循环取出每一行返回的数据
        {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            System.out.println("ID:"+id+"..."+"NAME:"+name);

         }


        //PreparedStatement操作
        String addname = "E";
        int addid = 233;
        String sql6 = "INSERT INTO member(id,name) VALUES (?,?)";          //使用占位符进行预处理数据
        PreparedStatement pstmt = con.prepareStatement(sql6);
        pstmt.setInt(1,addid);         //设置第一个占位符
        pstmt.setString(2,addname);    //设置第二个占位符
        int len5 = pstmt.executeUpdate();

        System.out.println("影响的行数："+len5);



        //事务处理
        con.setAutoCommit(false);        //取消自动提交
        try
        {
            stmt.addBatch("INSERT  INTO member(id,name) VALUES (55,'Y')");
            stmt.addBatch("INSERT  INTO member(id,name) VALUES (66,'Z')");
            int result[] = stmt.executeBatch();          //执行批处理
            System.out.println(Arrays.toString(result));
            con.commit();       //如果执行语句没有问题 则提交
        }catch (Exception e)
        {
            e.printStackTrace();
            con.rollback();
        }


        rs.close();
        stmt.close();
        con.close();

    }
}
