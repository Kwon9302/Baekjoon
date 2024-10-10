public class Test {
    public static void main(String[] args) {

        int i=2;
        int ii=i;
        String I = Integer.toString(i);
        for (int j = 0; j < I.length(); j++) {
            ii += I.charAt(j) - '0';
        }
        System.out.println(ii);
    }
}
