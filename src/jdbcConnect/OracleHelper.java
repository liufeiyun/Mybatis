package jdbcConnect;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
public class OracleHelper {
 
    static final String DB_USER="scott";
    static final String DB_PWD="scott";
    static final String ORCL_URL="jdbc:oracle:thin:@localhost:1521/orcl";
    public String getUser(String findEmpno){
     
        Connection con=null;
        PreparedStatement pre=null;
        ResultSet result=null;
        String nameInOrcl=null;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con=DriverManager.getConnection(ORCL_URL,DB_USER,DB_PWD);
            String sql="select e.ename from emp e where e.empno=?";
            pre=con.prepareStatement(sql);
            pre.setString(1,findEmpno);        
            result=pre.executeQuery(); 
                while(result.next()){  
                    nameInOrcl=result.getString("ename");
                }
             
        }catch(Exception ex){
            System.out.println("δ�ܷ��ؽ��");
        }finally{
            try {
                result.close();
            } catch (SQLException e) {
                System.out.println("�رռ�¼��ʧ��");
            }
            try {
                pre.close();
            } catch (SQLException e) {
                System.out.println("�رտ�����ʧ��");
            }
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("�ر�����ʧ��");
            }  
        }      
        return nameInOrcl;
    }
    
    public static void main(String[] args){
    	OracleHelper obj=new OracleHelper();
    	String temp=obj.getUser("7369");
    	System.out.println(temp);
    }
}