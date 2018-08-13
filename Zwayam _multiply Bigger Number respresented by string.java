package mulitplyString;

import java.util.Arrays;

class GfG
{
    public String multiply(String a,String b)
    {

    	int neg = 0;
       if(a.length() == 0 || b.length() == 0)
       {
           return "";
       }
       if(a.equals("0") || b.equals("0"))
       {
           return "";
       }
        if(a.charAt(0) == '-')
        {
        	neg++;
        	StringBuilder bb = new StringBuilder(a);
        	bb.deleteCharAt(0);
        	a = bb.toString();
        }
        if(b.charAt(0) == '-')
        {
        	neg++;
        	StringBuilder bbb = new StringBuilder(b);
        	bbb.deleteCharAt(0);
        	b = bbb.toString();
        }
        char[] c1 = new StringBuilder(a).toString().toCharArray();
        char[] c2 = new StringBuilder(b).toString().toCharArray();
        char[] c = new char[c1.length + c2.length];
        Arrays.fill(c, '0');

        int iter = c1.length-1;

        while(iter >= 0)
        {
            int carry = 0;
            int jter = c2.length-1;
            while(jter >= 0)
            {
                int temp = (c1[iter] - '0') * (c2[jter]-'0') + carry + (c[iter+jter+1] - '0');

                c[iter+jter+1] = (char)(temp%10 + '0');

                carry = temp/10;
                jter--;
            }
            c[iter] =  (char)(c[iter] +carry);

            iter--;
        }

        StringBuilder str = new StringBuilder(new String(c));

        if(neg == 0 || neg == 2)
        {
        	String s = new StringBuilder(new String(str)).toString();
        	int pos = 0;
            while(s.charAt(pos) == '0' && pos < s.length())
            {
                pos++;
            }
        	return s.substring(pos);
        }


        String s = new StringBuilder(new String(str)).toString();
    	int pos = 0;
        while(s.charAt(pos) == '0' && pos < s.length())
        {
            pos++;
        }
    	return '-'+s.substring(pos);

    }
}
