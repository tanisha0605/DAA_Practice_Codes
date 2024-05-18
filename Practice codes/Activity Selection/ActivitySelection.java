import java.util.Scanner;
class Activity {
    int no;
    int start;
    int finish;
}
class ActivitySelection{
    static void selection(Activity[] act,int n){
        int i,j;

        for(i=0; i<n-1; i++){
            for (j=0; j<n-i-1; j++){
                if(act[j].finish > act[j+1].finish){
                    Activity temp = act[j];
                    act[j]=act[j+1];
                    act[j+1] = temp;
                }
            }
        }
        int[] soln=new int[n];
        soln[0]=act[0].no;
        int prevAct=0;
        int actSelected=1;
        for(i=0;i<n;i++){
            if(act[i].start >= act[prevAct].finish){
                soln[actSelected]=act[i].no;
                actSelected++;
                prevAct=i;
            }
        }
       System.out.println("The selected activities are:");
        for (int k = 0; k < n; k++) {
            if (soln[k] != 0)
                System.out.print(soln[k] + "\t");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of activities: ");
        int n = scanner.nextInt();
        Activity[] act = new Activity[n];
        System.out.println("Enter start time and finish time:");
        for (int i = 0; i < n; i++) {
            System.out.print("Activity " + (i + 1) + ": ");
            act[i] = new Activity();
            act[i].start = scanner.nextInt();
            act[i].finish = scanner.nextInt();
            act[i].no = i + 1;
        }
        selection(act, n);
        scanner.close();
    }
}
