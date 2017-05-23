package util;

import org.neo4j.driver.v1.Value;

public class Wrapper 
{
	
	public static Integer getInt(Value v)
	{
		if(!v.isNull()) 
			return v.asInt();
		return null;
	}
	
	public static Double getDouble(Value v)
	{
		if(!v.isNull()) 
			return v.asDouble();
		return null;
	}
	
	
	
	
}
