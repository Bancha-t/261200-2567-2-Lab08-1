import java.util.Random;

public class Main{
    public static void main(String[] args) {
        Thread i1 = new Thread(new ExecOne());
        Thread i2 = new Thread(new ExecTwo());
        Thread i3 = new Thread(new ExecThree());
         
        i1.start();
        i2.start();
        i3.start(); 
    }
}

class ExecOne implements Runnable {
    public void run() {
        Random rand = new Random();
        int n = rand.nextInt(5000);
        for (int i = 1; i < 51; i++) {
            try {Thread.sleep(n);}
            catch (InterruptedException e) {throw new RuntimeException();}  
            System.out.println("thread #<1> : " +i);
        }
    }
}

class ExecTwo implements Runnable{
    public void run(){
        Random rand = new Random();
        int n = rand.nextInt(5000);
        for (int i = 1; i < 51; i++) {
            try {Thread.sleep(5);}
            catch (InterruptedException e) {throw new RuntimeException();}  
            System.out.println("thread #<2> : " +i);
        }
    }
}

class ExecThree implements Runnable{
    public void run(){
        Random rand = new Random();
        int n = rand.nextInt(5000);
        for (int i = 1; i < 51; i++) {
            try {Thread.sleep(n);}
            catch (InterruptedException e) {throw new RuntimeException();}  
            System.out.println("thread #<3> : " +i);
        }
    }
}

/*
1.ก่อนใช้ Thread.sleep() พบว่าการพิมพ์ตัวเลขออกมาไม่เป็นระเบียบ เนื่องจากเธรดถูกสลับการทำงานแบบไม่แน่นอน
2.หลังจากใช้ Thread.sleep(1000) พบว่าการพิมพ์ตัวเลขเป็นระเบียบมากขึ้น โดยค่าจะเปลี่ยนทุก 3 เลข **แต่เมื่อเพิ่ม random เข้ามา พบว่าเธรดมักเลือกทำงานกับค่าที่มี sleep น้อยกว่าก่อน
3.Multithreading ใน Java คือการทำงานพร้อมกันของหลายเธรด ซึ่งการสลับการทำงานของเธรดขึ้นอยู่กับ Thread Scheduler ของระบบปฏิบัติการ ทำให้ลำดับการพิมพ์ผลลัพธ์ไม่แน่นอนและเปลี่ยนแปลงในแต่ละครั้งที่รันโปรแกรม
*/