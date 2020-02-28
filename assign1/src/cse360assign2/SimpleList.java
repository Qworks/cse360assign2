/**
 * @author Benjamin Hay
 * Class ID: 321
 * Assignment Number:2
 * Description: This Class makes a simple list in an array
 * where integers can be added and removed. This version 
 * increases the size of the array by 50% when adding if it
 * is full and decreases the size by 25% when removing if at least 25% of
 * the array is empty. It also includes four new functions: append, first,
 * last, and size.
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
			if(index == list.length)//increases the size if the list is full
			{
				int[] temp = new int[(int) (list.length * 1.5)]; 
				//increases the size by 50% rounded down
				for(int index2 = 0; index2 < count; index2++) 
				//copies list into a temp array
				{
					temp[index2] = list[index2]; 
				}
				list = temp; //list becomes temp
			}
			list[index] = list[index-1];
		}
		list[0] = num;
		count++;
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
			if(count/list.length < 0.75 && list.length > 1) 
			//if the list has more than 25% empty spaces
			{
				int[] temp = new int[(int) (list.length*.75)]; 
				//decreases the size by 25% rounded down
				for(int index2 = 0; index2 < count; index2++) 
				//copies list into a temp array
				{
					temp[index2] = list[index2]; 
				}
				list = temp; //list becomes temp
			}
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
	public void append(int num)
	/**
	 * appends the integer to the end of the list and increases
	 * the size of the list by 50% if it is full.
	 * @param num number to be appended
	 */
	{
		if(count == list.length)//increases the size if the list is full
		{
			int[] temp = new int[(int) (list.length * 1.5)]; 
			//increases the size by 50% rounded down
			for(int index2 = 0; index2 < count; index2++) 
			//copies list into a temp array
			{
				temp[index2] = list[index2]; 
			}
			list = temp; //list becomes temp
		}
		list[count] = num;
		count++;
	}
	public int first()
	/**
	 * Returns the first element of the list
	 * @return list[0] first element of the list
	 */
	{
		if(count == 0)// if there are no elements
		{
			return -1;
		}
		return list[0];
	}
	public int last()
	/**
	 * Returns the last element of the list
	 * @return list[count-1] last element of the list
	 */
	{
		if(count == 0)// if there are no elements
		{
			return -1;
		}
		return list[count-1];
	}
	public int size()
	/**
	 * Returns the current number of possible locations in the list
	 * @return list.length size of the list
	 */
	{
		return list.length;
	}
}
