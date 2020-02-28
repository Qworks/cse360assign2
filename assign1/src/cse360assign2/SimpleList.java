/**
 * @author Benjamin Hay
 * Class ID: 321
 * Assignment Number:1
 * Description: This Class makes a simple list in an array
 * where integers can be added and removed.
 */
package cse360assign2;

public class SimpleList 
{
	private int count;
	private int[] list;
	public SimpleList() 
	/**
	 * constructor that creates an array and sets count to 0
	 */
	{
	list = new int[10];
	count = 0;
	}
	public void add(int num)
	/** 
	 * adds a number to the list and moves all previous numbers
	 * to the right one and cuts off any extra numbers
	 * @param num number to be added
	 */
	{
		for(int index = count; index > 0; index--)
		{
			if(index==10)//cuts off the number at the end of the list
			{
				index--;
			}
			list[index] = list[index-1];
		}
		list[0] = num;
		if(count != 10)
		{
			count++;
		}
	}
	public void remove(int num)
	/**
	 * removes a number from the list and
	 * moves the numbers to the left to fill the gap
	 * @param num number to be removed
	 */
	{
		int index = search(num);
		if(index != -1)
		{
			for(int index1 = index; index1 < count-1; index1++)
			{
				list[index1]=list[index1 + 1];
			}
			list[count-1]=0;
			count--;
		}
	}
	public int count()
	/**
	 * returns the number of elements in the list
	 * @param none
	 * @return count count of elements
	 */
	{
		return count;
	}
	public String toString()
	/**
	 * converts the list into a string
	 * @param none
	 * @return str String of list
	 */
	{
		String str = "";

		for(int index = 0;index < count;index++)
		{
			if(index == count-1)
			{
				str = str + Integer.toString(list[index]);
			}
			else {
				str = str + Integer.toString(list[index]) + " ";
			}
		}
		return str;
	}
	public int search(int num)
	/**
	 * searches through the list for the number and
	 * returns the index of the number. If it doesn't find it it returns -1
	 * @param num number to be found
	 * @return index index of number found or -1
	 */
	{
		for(int index = 0;index < count;index++)
		{
			if(num == list[index])
			{
				return index;
			}
		}
		return -1;
	}
}
