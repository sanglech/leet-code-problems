package Stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
    Create your own FIFO queue. WIll be given a list of commands and
    a max queue size. You will return the an array of the results for command The three commands:
    1. "SIZE" calcualte size of queue.
    2. "OFFER XXXXX": add XXXXX to queue (if its not full).
       Should add if true or false if it can be added to queue.
    3. TAKE: POP the first value off the queue and put it in result queue (if there is a value, if not put false).
 */

public class MyFIFO {
    public static String[] FIFO(String[] cmds, int maxQueue){
        List<String> results = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        int i =0;
        while(i<cmds.length){
            String cmd = cmds[i];

            if(cmd.contains("SIZE")){
                results.add(String.valueOf(q.size()));
            }

            else if(cmd.contains("OFFER")){
                String value = cmd.split(" ")[1];

                if(q.size()<maxQueue){
                    results.add("true");
                    q.add(Integer.valueOf(value));
                }
                else {
                    results.add("false");
                }
            }
            else if(cmd.contains("POP")){
                if(q.size()<=0){
                    results.add("false");
                }
                else {
                    results.add(String.valueOf(q.remove()));
                }
            }
            else {
                results.add("fail");
            }

            i++;
        }

        return results.toArray(String[]::new);
    }
}
