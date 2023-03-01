// Custom Stack without size restrictions
// Dynamic in nature extends when full

public class DynamicStack extends CustomStack{
    public DynamicStack(){
        super();
        // it will call CustomStack()
    }
    public DynamicStack(int size){
        super(size);
        // it will call CustomStack(int size)
    }


    public boolean push(int item){
        if(this.isFull()){
            // double the array size
            int[] temp = new int[data.length * 2];
            // copy all previous items in new stack
            for (int i = 0; i < data.length; i++) temp[i] = data[i];
            data = temp;
        }
        // now we know its not full since we extended the size
        return super.push(item);
    }
}
