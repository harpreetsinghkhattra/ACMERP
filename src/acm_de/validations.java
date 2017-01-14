package acm_de;

public class validations {
	public static boolean isempty(String value)
	{
		if(value.replace(" ", "").length()==0)
{
	return false;
}
return true;
	}
	
	public static boolean compare(String string1, String string2)
	{
		if(string1.equals(string2))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public static boolean emailvalid()
	{
		return false;
	}
	public static boolean phonevalid(String phone)
	{
		if(phone.length()>=10 && phone.length()>=13)
		{
			return true;
		}
		return false;
	}

}
