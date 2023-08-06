public class Integrate {
    // X^3
    public interface FofX {
        double eval(double x);
    }

    static final int LEFT_POINT = 0;
    static final int MID_POINT = 1;
    static final int RIGHT_POINT = 2;

    static double integrate(FofX f, double a, double b, int interval, int point) {
        double sum=0;
        double dx=(b-a)/interval;
        for(int i=0; i<interval; i++) {
            switch(point) {
                case LEFT_POINT: sum+=f.eval(a+i*dx)*dx; break;
                case MID_POINT: sum+=f.eval(a+i*dx+dx/2)*dx; break;
                case RIGHT_POINT: sum+=f.eval(a+i*dx+dx)*dx; break;
            }
        }
        
        return sum;
    }

    static double integrate2(FofX f, double a, double b, int interval) {
        double sum = 0;
        double d = b-a;
        double xi = 0;
        double factor = interval*(interval+1)/2;
        for(int i = 0; i < interval; i++) {
            double dxi = d*(interval-i)/factor;
            sum+=f.eval(xi)*dxi;          // left point
            // sum+=f.eval(xi+dxi/2)*dxi;      // right point
            // sum+=f.eval(xi+dxi)*dxi;      // mid point
            xi+=dxi;
        }
        return sum;
    }

    public static void main(String args[]) {
        FofX f = (x) ->  x*x*x;
        // FofX f = (x) ->  x*x;
        //FofX f = (x) ->  Math.exp(x);
        int interval = 1;
        while(true){
            double s = integrate(f, 0, 1, interval, LEFT_POINT);
            // System.out.println("Error : " + Math.abs(s -  0.25));
           
            interval++;
            if(Math.abs(s - 0.25) < 0.001){
            // if(Math.abs(s - 0.33) < 0.001){
                System.out.println("Error : " + Math.abs(s -  0.25));
                // System.out.println("Error : " + Math.abs(s -  0.33));
                System.out.println(interval);
                System.out.println("S: "+s);
                break;
            }
        }
        // double s = integrate(f, 0, 1, interval, MID_POINT);
        // System.out.println("Error : " + Math.abs(s -  0.25));
        // System.out.println("S: "+s);
        interval = 1;
        while(true){
            double s2 = integrate2(f, 0, 1, interval);
            interval++;
            if(Math.abs(s2 - 0.25) < 0.001){
            // if(Math.abs(s2 - 0.33) < 0.001){
                System.out.println("S2: "+s2);
                System.out.println("Error : " + Math.abs(s2 -  0.25));
                // System.out.println("Error : " + Math.abs(s2 -  0.33));
                System.out.println(interval);
                break;
            }
        }
        double s2 = integrate2(f, 0, 1, interval);
    }
}