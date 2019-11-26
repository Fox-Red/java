import java.util.Scanner;

public class Time {
    private int hour = 0;
    private int minter = 0;
    private int scend = 0;
    Time() {};
    Time(int hour, int minter, int scend) {
       if (hour > 23 || hour < 0) {
           System.out.println("输入的时间异常");
           return;
       }
        if (minter < 0 || minter > 59) {
            System.out.println("输入的时间异常");
            return;
        }
        if (scend > 59 || scend < 0) {
            System.out.println("输入的时间异常");
            return;
        }
        this.hour = hour;
        this.minter = minter;
        this.scend = scend;
    }
    public int getScend() {
        return this.scend;
    }
    //增加时间
    public void addTime(int scend) {
        if (scend < 0) {
            return;
        }
        this.scend += scend;
        while (this.scend > 59) {
            minter++;
            this.scend -= 60;
            if (minter > 59) {
                hour++;
                minter = 0;
                if (hour > 23) {
                    hour = 0;
                }
            }
        }
    }
    //减少时间
    public void subTime(int scend) {
        if (scend > 0) {
            return;
        }
        this.scend += scend;
        while (this.scend < 0) {
            minter--;
            this.scend += 60;
            if (minter < 0) {
                hour--;
                minter = 59;
                if (hour < 0) {
                    hour = 23;
                }
            }
        }
    }
    //选择12小时还是24小时制显示
    public void disPlay(int choose) {
        if (choose == 12) {
            this.hour = this.hour - 12;
        }else if (choose != 24) {
            System.out.println("输入错误按24小时制输出");
        }
    }
    public static void main(String[] args) {
        boolean stop = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入小时");
        int hour = scanner.nextInt();
        System.out.println("请输入分钟");
        int minter = scanner.nextInt();
        System.out.println("请输入秒");
        int second = scanner.nextInt();
        Time tempTime = new Time(hour,minter,second);
        while (stop) {
            System.out.println("请选择12小时制还是24小时制显示输入12或24");
            int timeChoose = scanner.nextInt();
            System.out.println("请输入要增加或要减少的时间，增加为正，减少为负");
            int seconds = scanner.nextInt();
            if (seconds > 0) {
                tempTime.addTime(seconds);
            }else {
                tempTime.subTime(seconds);
            }
            tempTime.disPlay(timeChoose);
            System.out.println(tempTime.hour+":"+tempTime.minter+":"+tempTime.scend);
            System.out.println("Do you what to end the loop?");
            String chooseStop = scanner.next();
            if (chooseStop.equals("yes")) {
                stop = false;
            }
        }
    }
}
