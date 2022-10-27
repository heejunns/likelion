package Day_10_15.Algorithm;

public class Star_4 {
    public void makeStar(int n){
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <n-i; j++){
                System.out.print(" ");
            }
            for(int k = 0; k < (i*2)+1; k++){
                System.out.print("*");
            }
            System.out.println();
        }
        for (int l = n-2; l>=0; l-- ){
            for(int j = 0; j<n-l; j++){
                System.out.print(" ");
            }
            for(int k = 0; k < (l*2)+1; k++){
                System.out.print("*");
            }
            System.out.println();

        }
    }
    public static void main(String[] args) {
        Star_4 star = new Star_4();
        star.makeStar(10);
    }
}
