package cn.yihua.nacostest.socket;

public class TestBob {
    public static void main(String[] args) {
        int a =978945;
        int b = a>>16;
        System.out.println(b);
        int c = a - (b<<16);
        int d = c>>8;
        System.out.println(d);
        int e = c-(d<<8);
        System.out.println(e);
        int f = (b<<16)+(d<<8)+e;
        System.out.println(f);
    }
}
