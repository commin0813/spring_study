package kr.co.fastcampus.cli.di;

public class B {
    boolean value = false;

    public B(boolean value) {
        this.value = value;
    }
    public void cal(){
        System.out.println(value);
    }
}
