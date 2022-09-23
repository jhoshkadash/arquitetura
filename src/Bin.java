//translate String number to binary string

public class Bin {
  public static String toBin(String number, int size) {
    int num = Integer.parseInt(number);
    String bin = Integer.toBinaryString(num);    
    int len = bin.length();
    if (len < size) {
      for (int i = 0; i < size - len; i++) {
        bin = "0" + bin;
      }
    }
    return bin;
  }
}
