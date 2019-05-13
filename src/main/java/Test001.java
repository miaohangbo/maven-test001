import java.sql.*;

/**
 * Created by 54110 on 2019-05-12.
 */
public class Test001 {
    public static void main(String[] args) {
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.连接数据库
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","root","59852369");
            //3创建语句对象
            Statement statement = connection.createStatement();
            //4,写sql语句
            String sql = "select * from user";
            //5执行sql语句
            ResultSet resultSet = statement.executeQuery(sql);
            //6.处理返回结果集
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                Date birthday = resultSet.getDate("birthday");
                System.out.println(id+"--"+username+"--"+birthday);
            }
            resultSet.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
