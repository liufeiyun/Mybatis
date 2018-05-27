package mapperInterface;

import model.User;

public interface UserMapperInterface {

	//���� id ��ѯ user ������
    public User selectUserById(String id) throws Exception;
 
    //�� user �����һ������
    public void insertUser(User user) throws Exception;
     
    //���� id �޸� user ������
    public void updateUserById(User user) throws Exception;
     
    //���� id ɾ�� user ������
    public void deleteUserById(String id) throws Exception;
}
