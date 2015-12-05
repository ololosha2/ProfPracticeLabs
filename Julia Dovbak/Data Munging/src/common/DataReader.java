package common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataReader
{
	public DataReader()
	{
		
	}
	
	public <T extends DataRecord> List<T> read(String filename, DataRecordMapper<T> mapper) throws IOException
	{
		List<T> data = new ArrayList<>();
		
		Scanner scanner = new Scanner(new FileInputStream(filename));
		while(scanner.hasNextLine())
		{
			String line = scanner.nextLine().trim().replace("*", "").replace("-", "");
			if(line.length() > 0 && Character.isDigit(line.charAt(0)))
			{
				String[] parts = line.split(" +");
				T map = mapper.map(parts);
				data.add(map);
			}
		}
		scanner.close();
		
		return data;
	}
}
