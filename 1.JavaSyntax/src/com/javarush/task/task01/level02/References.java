package level02;

public class References
{
  public static void main (String[] args)
  {
    int m = 5;
    int n = 6;
    System.out.println("Before");
    System.out.println("M=" +m+ " N=" + n);
    swap(m, n);
    System.out.println("After");
    System.out.println("M=" +m+ " N=" + n);

    String s1 = "Сергей";
    String s2 = "Вика";
    System.out.println("Before");
    System.out.println("s1=" +s1+ " s2=" + s2);
    swap(s1, s2);
    System.out.println("After");
    System.out.println("s1=" +s1+ " s2=" + s2);

    MyObject o1 = new MyObject(1);
    MyObject o2 = new MyObject(2);

    System.out.println("Before");
    System.out.println("o1=" +o1+ " o2=" + o2);
    swap(o1, o2);
    System.out.println("After");
    System.out.println("o1=" +o1+ " o2=" + o2);

    System.out.println("Before");
    System.out.println("o1=" +o1+ " o2=" + o2);
    swap(o1, o2, "");
    System.out.println("After");
    System.out.println("o1=" +o1+ " o2=" + o2);


  }

  private static void swap(int a, int b)
  {
    int c = a;
    a = b;
    b = c;
  }
  private static void swap(String s1, String s2)
  {
    String s = s1;
    s1 = s2;
    s2 = s;

    s1 = "Вика";
    s2 = "Сергей";
  }

  private static void swap(MyObject o1, MyObject o2)
  {
    MyObject o = o1;
    o1 = o2;
    o2 = o;
  }

  private static void swap(MyObject o1, MyObject o2, String get)
  {
    o1.setId(2);
    o2.setId(1);
  }

}