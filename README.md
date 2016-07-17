
<li><h3>连接数据库</h3>
<pre><code>  public class DBUtil {
      private static final String url ="jdbc:mysql://localhost:3306/new";
      private static final String user ="root";
      private static final String password ="";
      private static Connection conn = null;
      static{
          try {
              Class.forName("com.mysql.jdbc.Driver");
              conn = DriverManager.getConnection(url, user, password);
              } catch (ClassNotFoundException e) {
                  e.printStackTrace();
              } catch (SQLException e) {
                  e.printStackTrace();
              }
           }

      public static Connection getConnection(){
          return conn;
      }    
  }</code></pre>
</li>
<li><h3>写入sql语言</h3>
<pre><code>  String sql = "insert into user (user_id,username,password)"
      +"values(?,?,?)";
  PreparedStatement ps = conn.prepareStatement(sql);
  ps.setInt(1, user.getUser_id());
  ps.setString(2,user.getUsername());
  ps.setString(3, user.getPassword());
  ps.execute();//执行sql</code></pre>
Edit By <a href="http://mahua.jser.me">MaHua</a></li>
</ul>
</body></html>