
public class A{
    public static void main(String[] args) {
		B b= new B(10);
		System.out.println(b.i);
	}
}
class B extends C{
	public B(int i) {
	     this.i=i;
	}
}

class C {
	public int i=1;
}