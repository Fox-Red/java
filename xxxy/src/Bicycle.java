public class Bicycle {
    private String color = "black";
    private double fastest = 80.0;
    public int nowSpeed;



    public void setColor(String coloe) {
        this.color = color;
    }
    public String getColor() {
        return color;
    }
    public int addSpeed(int a, int nowSpeed, int t) {
        this.nowSpeed = nowSpeed;
        for (int j=0; j<=t; j++) {
            int time = 0;
            time++;
            nowSpeed += a;
            if (nowSpeed > (int)fastest) {
                System.out.println("经过了"+time+"秒，自行车的速度是"+nowSpeed);
            }else {
                System.out.println("自行车太快啦");
                return nowSpeed;
            }
        }
        return nowSpeed;
    }
    public int subSpeed(int a, int nowSpeed,int t) {
        this.nowSpeed = nowSpeed;
        for (int j=0; j<=t; j++) {
            int time = 0;
            time++;
            nowSpeed -= a;
            if (nowSpeed > 0) {
                System.out.println("经过了"+time+"秒，自行车的速度是"+nowSpeed);
            }else {
                System.out.println("自行车太慢啦，你咋这么low");
                return nowSpeed;
            }
        }
        return nowSpeed;
    }
}
