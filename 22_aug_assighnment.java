class Singleton {
    static Singleton obj=null;
    private Singleton(){};
    public  void fun(String s)
    {
        System.out.println(s);
    }
    public static Singleton sin()
    {
        if(obj==null)
            obj=new Singleton();
        return obj;
    }
}
public class singleton12
{
    public static void main(String[] args) {

        Singleton s= Singleton.sin();
        Singleton s1=Singleton.sin();
        System.out.println(s.hashCode()+"  "+s1.hashCode());
        s.fun("Hello!");
        s1.fun("Hi");

    }
}
