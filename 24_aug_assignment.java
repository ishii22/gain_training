public class IntegerArray {
    private Integer[] a;
    public IntegerArray(int size){
        a = new Integer[size];
    }
    public void setElement(int index, Integer element){
        if(index>=0 && index<a.length)
            a[index] = element;
        else
            throw new RuntimeException("Array Index is out of bounds");
    }
    public Integer getElement(int index){
        if(index>=0 && index<a.length)
            return a[index];
        else
            throw new RuntimeException("Array Index is out of Bounds");
    }
    public class IntegerArrayIterator{
        private int index = -1;
        private IntegerArrayIterator(){};
        public boolean hasNext(){
            return index < a.length;
        }
        public Integer next(){
            if(index==a.length)
                throw new RuntimeException("Array Index is out of Bounds");
            return a[++index];
        }
    }
    public IntegerArrayIterator getIterator(){
        return new IntegerArrayIterator();
    }
}

class newTest{
    public static void main(String[] args) {
        IntegerArray intArr = new IntegerArray(7);
        for(int i=0; i<=6; i++)
            intArr.setElement(i,(i+1)*2);
        IntegerArray.IntegerArrayIterator itr= intArr.getIterator();

        while(itr.hasNext())
            System.out.println(itr.next());
    }
}
