import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.Map.Entry;

public class Zwayam_Placement
{
	public static <K, V> void printing(Map<K, V> m)
	{
		Set<Map.Entry<K, V>> s = m.entrySet();
		for(Map.Entry<K, V> x : s)
		{
			System.out.println(x.getKey() + "-->" + x.getValue());
		}
	}
	public static < K, V extends Comparable< ? super V>> Map<K, V> sorting(Map<K, V> unsortedMap)
	{
		Set<Map.Entry<K, V>> s = unsortedMap.entrySet();
		List<Map.Entry<K, V>> list = new LinkedList<Map.Entry<K, V>>(s);

		Collections.sort(list, new Comparator<Map.Entry<K, V>>(){
			public int compare(Map.Entry<K, V> m1, Map.Entry<K, V> m2)
			{
				return m2.getValue().compareTo(m1.getValue());
			}
		});

		Map<K, V> result = new LinkedHashMap<K, V>();
		for(Map.Entry<K, V> entry : list)
		{
			result.put(entry.getKey(), entry.getValue());
		}
		return result;

	}
	public void maxOccuringString(ArrayList<String> A)
	{
		String ans = "";
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		for(int iter = 0; iter < A.size(); iter++)
		{
			String st = A.get(iter);
			Integer val = hm.get(st);
			if(val != null)
			{
				hm.put(st, val+1);
			}
			else
			{
				hm.put(st, 1);
			}
		}
		//printing(hm);
		Zwayam_Placement  z = new Zwayam_Placement ();
		Map<String, Integer> hm_ans = z.sorting(hm);
		//printing(hm_ans);

		Set<Map.Entry<String, Integer>> s = hm_ans.entrySet();
		for(Map.Entry<String, Integer> x : s)
		{
			System.out.println(x.getKey());
			break;
		}
	}
	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		File f1 = new File("C:\\Users\\DELL\\Desktop\\zwayam.txt");
		FileReader fr = new FileReader(f1);
		BufferedReader br = new BufferedReader(fr);
		String str = "";
		String st;
		while((st = br.readLine()) != null)
		{
			str = str +  st;
		}
		fr.close();
		br.close();
		//System.out.println(str);
		String s = "";
		ArrayList<String> as = new ArrayList<String>();
		for(int iter = 0; iter < str.length() ;iter++)
		{
			if(str.charAt(iter) == ' ')
			{
				if(s.length() == 0)
				{
					continue;
				}
				else
				{
					as.add(s);
					s = "";
				}
			}
			else
			{
				s = s + str.charAt(iter);
				if(iter == str.length()-1)
				{
					as.add(s);
				}
			}
		}
		Zwayam_Placement zp = new Zwayam_Placement();
		zp.maxOccuringString(as);
	}
}
