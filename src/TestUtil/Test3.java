package TestUtil;

import java.io.IOException;
import java.io.InputStream;

import mapperInterface.UserMapperInterface;
import model.User;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test3 {

	public static void main(String[] args) throws IOException {
        //mybatis�������ļ�
        String resource = "conf.xml";
        //ʹ�������������mybatis�������ļ�����Ҳ���ع�����ӳ���ļ���
        InputStream is = Test3.class.getClassLoader().getResourceAsStream(resource);
        //����sqlSession�Ĺ���
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        //ʹ��MyBatis�ṩ��Resources�����mybatis�������ļ�����Ҳ���ع�����ӳ���ļ���
        //Reader reader = Resources.getResourceAsReader(resource); 
        //����sqlSession�Ĺ���
        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //������ִ��ӳ���ļ���sql��sqlSession
        SqlSession session = sessionFactory.openSession();
        
        UserMapperInterface userMapperInterface = session.getMapper(UserMapperInterface.class);
		try {
			//ʹ�ýӿڷ�ʽ���ò�ѯ������ִ�в�ѯ���ݲ���
			long startTime=System.currentTimeMillis();
			User user = userMapperInterface.selectUserById("AB5E1C5E41CA44DC958601D639051CFB");
			long endTime=System.currentTimeMillis();
			System.out.println("query cost:"+(endTime-startTime)+"ms");
	        System.out.println(user);
	        //�����ݿ��в���һ������
	        user.setName("����");
	        user.setAge(25);
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
