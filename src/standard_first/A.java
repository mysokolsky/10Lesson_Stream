package standard_first;

public class A implements Cleaner {
    @Override
    public int clean(String user){
        return user.length();
    }
}
