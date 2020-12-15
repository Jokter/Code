package Code.设计模式;

public class Single {
    private static volatile Single s = null;
    private Single(){}
    public static Single getInstance(){
        if(s==null){
            synchronized(Single.class){
                if(s==null){
                    s = new Single();
                }
            }
        }
        return s;
    }
}
