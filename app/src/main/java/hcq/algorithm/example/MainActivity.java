package hcq.algorithm.example;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StackQueque queque = new StackQueque();
        queque.offer(1);
        queque.offer(2);
        queque.offer(3);
        queque.offer(4);

        System.out.println("queque:" + queque.peek());

        int size = queque.size();
        for (int i = 0; i < size; i++) {
            System.out.println("queque:" + queque.poll());
        }

    }


}
