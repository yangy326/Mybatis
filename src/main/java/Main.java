import Util.MySqlSessionFactory;

public class Main {

    public static void main(String[] args){
        MySqlSessionFactory mySqlSessionFactory= new MySqlSessionFactory();
        mySqlSessionFactory.openSession();
    }
}
