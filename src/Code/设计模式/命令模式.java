package Code.设计模式;

import java.util.Arrays;

/**
 * 命令模式：当不确定方法要执行的行为时，可以创建一个接口，接口实现类可以作为行为参数传入方法
 */
public class 命令模式 {
    public static void main(String[] args) {
        int[] nums = {2,1,3,4};
        Process process = new Process();
        process.process(nums,new Sc());
        process.process(nums,new Bl());
    }
}

interface Command{
    public void process(int[] nums);
}

class Sc implements Command{

    @Override
    public void process(int[] nums) {
        System.out.println(nums[0]);
    }
}

class Bl implements Command{

    @Override
    public void process(int[] nums) {
        Arrays.sort(nums);
        for(int i : nums){
            System.out.print(i+" ");
        }
    }
}

class Process{
    public void process(int[] nums,Command cmd){
        cmd.process(nums);
    }
}
