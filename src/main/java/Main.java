public class Main
{
	public static void main(String[] args) {
		Queue<Character> q = new Queue<Character>();
	    q.insert('c');
	    q.insert('c');
	    q.insert('a');
	    q.insert('c');
	    q.insert('c');
	    
	    Queue<String> q1 = new Queue<String>();
	    q1.insert("stav");
	    q1.insert("ori");
	    q1.insert("ziv");
	    q1.insert("adi");
	    
	    Queue<Integer> q2 = new Queue<Integer>();
	    q2.insert(1);
	    q2.insert(3);
	    q2.insert(1);
	    q2.insert(5);

	    
	    System.out.println(ex1(q));
	    System.out.println(ex2(q1));
	    ex3(q2);
	}
	public static Queue<Integer> copyQint(Queue<Integer> q)
	{
	    Queue<Integer> h = new Queue<Integer>();
	    Queue<Integer> q2 = new Queue<Integer>();
	    while(!q.isEmpty())
	    {
	        q2.insert(q.head());
	        h.insert(q.remove());
	    }
	    while(!q2.isEmpty())
	    {
	        q.insert(q2.remove());
	    }
	    return h;
	}
	
	public static Queue<Character> copyQchar(Queue<Character> q)
	{
	    Queue<Character> h = new Queue<Character>();
	    Queue<Character> q2 = new Queue<Character>();
	    while(!q.isEmpty())
	    {
	        q2.insert(q.head());
	        h.insert(q.remove());
	    }
	    while(!q2.isEmpty())
	    {
	        q.insert(q2.remove());
	    }
	    return h;
	}
	
	public static Queue<String> copyQstring(Queue<String> q)
	{
	    Queue<String> h = new Queue<String>();
	    Queue<String> q2 = new Queue<String>();
	    while(!q.isEmpty())
	    {
	        q2.insert(q.head());
	        h.insert(q.remove());
	    }
	    while(!q2.isEmpty())
	    {
	        q.insert(q2.remove());
	    }
	    return h;
	}
	
	public static boolean isIn(Queue<Integer> q, int x)
	{
	    Queue<Integer> temp = new Queue<Integer>();
	    boolean found = false;
	    while(!q.isEmpty())
	    {
	        if(q.head()==x)
	            found = true;
	        temp.insert(q.remove());
	    }
	    while(!temp.isEmpty())
	    {
	        q.insert(temp.remove());
	    }
	    return found;
	}
//******************************************************************************************	
	public static Queue<Integer> ex1(Queue<Character> q)
	{
	    //O(n)
	    int count = 1;
	    Queue<Integer> h = new Queue<Integer>();
	    Queue<Character> q2 = copyQchar(q);
	    while(!q2.isEmpty())
	    {
	        char k = q2.remove();
	        if(q2.isEmpty())
	        {
	            h.insert(count);
	            return h;
	        }
	        if(q2.head() == k)
	        {
	            count++;
	        }
	        else
	        {
	            h.insert(count);
	            count = 1;
	        }
	    }
	    return h;
	}
	
	public static boolean ex2(Queue<String> q)
	{
	    //O(n^2)
	    Queue<String> q2 = copyQstring(q);
	    Queue<String> q3 = copyQstring(q);
	    while(!q2.isEmpty())
	    {
	        q3.remove();
	        while(!q3.isEmpty())
	        {
	            if((q2.head()).equals(q3.head()))
	                return true;
	            q3.remove();
	        }
	        q2.remove();
	        q3 = copyQstring(q2);
	        
	    }
	    return false;
	  
	}
	
	public static void ex3(Queue<Integer> q)
	{
	    Queue<Integer> h = new Queue<Integer>();
	    Queue<Integer> q4 = copyQint(q);
	    
	    while(!q4.isEmpty())
	    {
	        int k = q4.remove();
	        if(!isIn(h,k))
	            h.insert(k);
	    }
	    System.out.println(h);
	}
}
