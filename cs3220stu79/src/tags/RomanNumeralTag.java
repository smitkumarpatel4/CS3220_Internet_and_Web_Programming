package tags;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class RomanNumeralTag extends SimpleTagSupport {

	int value;
	enum Numeral {
		I(1), IV(4), V(5), IX(9), X(10), XL(40), L(50), XC(90), C(100), CD(400), D(500), CM(900), M(1000);
		int count;

		Numeral(int count) {
			this.count = count;
		}
	};
	
	public void setValue(int value) {
		this.value = value;
	}

	public static String roman_conversion(long n) {

		if (n <= 0 && n>3999) {
			throw new IllegalArgumentException();
		}

		StringBuilder str = new StringBuilder();

		final Numeral[] values = Numeral.values();
		for (int i = values.length - 1; i >= 0; i--) {
			while (n >= values[i].count) {
				str.append(values[i]);
				n -= values[i].count;
			}
		}
		return str.toString();
	}
	
	public void doTag() throws JspException, IOException
    {
       getJspContext().getOut().print(roman_conversion(value));
        
    }	
}