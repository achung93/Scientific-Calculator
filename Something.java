import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Something {

	
	public String insidePar(ArrayList parr){
		
		int val = 0;
		parr.add(null);
		
		for(int i=0;parr.get(i)!=null;i++){
			
			if(parr.get(i+1)!=null && parr.get(i+1).equals("/")){
											
				s.push(parr.get(i));		
				parr.remove(i);
				//div.add(computeThis.get(i));
				s.push(parr.get(i));
				
				parr.remove(i);
				//div.add(computeThis.get(i));
				s.push(parr.get(i));
			
				String newval = getVal();
				
				parr.set(i, newval);
				i--;
				
				
				
			}
		
			
		}
	
	for(int i=0;parr.get(i)!=null;i++){
		
		if(parr.get(i+1)!=null && parr.get(i+1).equals("*")){
			
			
			s.push(parr.get(i));

			parr.remove(i);
			//div.add(computeThis.get(i));
			s.push(parr.get(i));
			
			parr.remove(i);
			//div.add(computeThis.get(i));
			s.push(parr.get(i));
		
			String newval = getVal();
			
			parr.set(i, newval);
			
			i--;
			
			
			
		}
	
		
	}
	
	
		Stack e = new Stack();
		
		for(int i=0;parr.get(i)!=null;i++){
			e.push((String)parr.get(i));
		}
		
	
		
		while(e.size()!=1){
			
			//System.out.println("e is " + e);
			int g = Integer.parseInt((String) e.pop());
			String h = (String)e.pop();
			int f = Integer.parseInt((String) e.pop());
			//System.out.println("g is " + g);
			//System.out.println("h is " + h);
			//System.out.println("f is " + f);
			
			if(h.equals("+")){
				String p = Integer.toString(g+f);
				e.push(p);
			}
			
			if(h.equals("-")){
				String o = Integer.toString(f-g);
				e.push(o);
			}
			
			
		}
		
		val = Integer.parseInt((String)e.pop());
		//System.out.println("val is " + val);
		
		String g = Integer.toString(val);
		return g;
		
		
	}
	
	
	Stack s  = new Stack();
	
	public String getVal(){
		
		
		int value = 0;
		int g = Integer.parseInt((String) s.pop());		
		String h = (String)s.pop();
		int f = Integer.parseInt((String) s.pop());
		
		if(h.equals("/")){
			value = f/g;
		}
		
		if(h.equals("*")){
			value = g*f;
		}
		
		String val = Integer.toString(value);
		return val;
		
	}
	
	
	public int sciCalc(String str){
		
		str = str.replaceAll("\\s+", "");
		

		ArrayList <String> computeThis = new ArrayList<String>();
		ArrayList <String> div = new ArrayList<String>();
		int val = 0;
		//ArrayList passToPar = new ArrayList();
		String st = "";
		int openPar = 0;
		
				
		
		for(int i=0;i<str.length();i++){
			
			while((i<str.length()) && Character.isDigit(str.charAt(i))){
				
				st = st + str.charAt(i);
				
				i++;
			}
			if(!st.equals("")){
				computeThis.add(st);
			}
			
			if(i<str.length()){
				
				if(Character.toString(str.charAt(i)).equals("(")){
					openPar++;
				}
				computeThis.add(Character.toString(str.charAt(i)));
			}
		
			st = "";
		}
			
		
		computeThis.add(null);
		
		int counter = 1;
	
		while(openPar>0){
		
			for(int i=0;computeThis.get(i)!=null;i++){		
			
				if(computeThis.get(i).equals("(") && counter==openPar){	
					ArrayList passToPar = new ArrayList();
					//System.out.println("computethis get i is " + computeThis.get(i) + " and i is " + i);
					computeThis.remove(i);
						//System.out.println("compute this is " + computeThis);
						while(!computeThis.get(i).equals(")")){	
								passToPar.add(computeThis.get(i));
								computeThis.remove(i);
					
						}
						String element = insidePar(passToPar);
						computeThis.set(i, element);
				
						
				
				}
				
				if(computeThis.get(i).equals("(")){
					counter++;
				}
			}
			//System.out.println("compute this is " + computeThis);
			openPar--;
			counter = 1;
		}
		
		
		//System.out.println("compute this is " + computeThis);
		
		for(int i=0;computeThis.get(i)!=null;i++){
			
			if(computeThis.get(i+1)!=null && computeThis.get(i+1).equals("/")){
											
				
				s.push(computeThis.get(i));		//i is num before division
	
				computeThis.remove(i);
				div.add(computeThis.get(i));
				s.push(computeThis.get(i));
				
				computeThis.remove(i);
				div.add(computeThis.get(i));
				s.push(computeThis.get(i));
			
				String newval = getVal();
				
				computeThis.set(i, newval);
				//System.out.println("compThis is " + computeThis);
				i--;
				
				
				
			}
		
			
		}
		
		for(int i=0;computeThis.get(i)!=null;i++){
			
			if(computeThis.get(i+1)!=null && computeThis.get(i+1).equals("*")){
				
				
				s.push(computeThis.get(i));
	
				computeThis.remove(i);
				div.add(computeThis.get(i));
				s.push(computeThis.get(i));
				
				computeThis.remove(i);
				div.add(computeThis.get(i));
				s.push(computeThis.get(i));
			
				String newval = getVal();
				
				computeThis.set(i, newval);
				
				i--;
				
				
				
			}
		
			
		}
		
		
			Stack e = new Stack();
			//System.out.println("compute this is " + computeThis);
			for(int i=0;computeThis.get(i)!=null;i++){
				e.push((String)computeThis.get(i));
			}
			
			//System.out.println("stack is " + e);
			//System.out.println("size is " + e.size());
			while(e.size()>1){
				//System.out.println("im in here");
				int g = 0;
				String h = null;
				int f = 0;
				
				if(!e.isEmpty()){
					g = Integer.parseInt((String) e.pop());
					//System.out.println("im in here");
				}
				
				if(!e.isEmpty()){
					 h = (String)e.pop();
				}
				
				if(!e.isEmpty()){
					f = Integer.parseInt((String) e.pop());
				}
				
				/*if(e.isEmpty()){
					break;
				}*/
				
				if(h.equals("+")){
					String p = Integer.toString(g+f);
					e.push(p);
				}
				
				if(h.equals("-")){
					String o = Integer.toString(f-g);
					e.push(o);
				}
					
				
			}
			
			if(!e.isEmpty()){
				val = Integer.parseInt((String)e.pop());
			}
			
			return val;
			
		
	}
	
	public boolean check(String str){
		
		char start;
		char end;
		int endindex = str.length()-1;
		
		for(int i=0;i<str.length()/2;i++){
			
			start = str.charAt(i);
			end = str.charAt(endindex);
			
			if(start!=end){
				return false;
			}
			
			endindex--;
			
			
		}
		
		return true;
	}
	
	
	
	public static void main(String[] args) {
		
		Something x = new Something();
		
		System.out.print("Answer is ");
		System.out.println(x.sciCalc("(3*(2+9)) + 7*5*8"));
	
		
		ArrayList <String> h = new ArrayList();
		
		
		
		

}
}
