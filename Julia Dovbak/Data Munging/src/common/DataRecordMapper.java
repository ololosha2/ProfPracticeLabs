package common;

public interface DataRecordMapper<T extends DataRecord>
{
	T map(String[] lineParts);
}
