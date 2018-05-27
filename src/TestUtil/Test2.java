package TestUtil;

import java.io.IOException;
import java.io.InputStream;

import mapperInterface.UserMapperInterface;
import model.User;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test2 {

	public static void main(String[] args) throws IOException {
        //mybatis的配置文件
        String resource = "conf.xml";
        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream is = Test2.class.getClassLoader().getResourceAsStream(resource);
        //构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        //使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
        //Reader reader = Resources.getResourceAsReader(resource); 
        //构建sqlSession的工厂
        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //创建能执行映射文件中sql的sqlSession
        SqlSession session = sessionFactory.openSession();
        
        UserMapperInterface userMapperInterface = session.getMapper(UserMapperInterface.class);
		try {
			//使用接口方式配置查询方法，执行查询数据测试
			long startTime=System.currentTimeMillis();
			User user = userMapperInterface.selectUserById("AB5E1C5E41CA44DC958601D639051CFB");
			long endTime=System.currentTimeMillis();
			System.out.println("query cost:"+(endTime-startTime)+"ms");
	        System.out.println(user);
	        //向数据库中插入一条数据
	        user.setName("张三");
	        user.setAge(20);
	        startTime=System.currentTimeMillis();
			userMapperInterface.insertUser(user);
			session.commit();
			endTime=System.currentTimeMillis();
			System.out.println("inster cost:"+(endTime-startTime)+"ms");
		} catch (Exception e) {
			e.printStackTrace();
		}
        session.close();
    }
}
