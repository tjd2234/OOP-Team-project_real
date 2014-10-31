
public class RecursiveDemo {
	 //return (a + b); implement Add function here
		public static int recAdd(int a, int b){
			
			//count the absolute number of b and add 1 or -1 depending on the sign of b
			if(b>0)
			{
				--b;
				int i=recAdd(a,b);
				return ++i;
			}
			else if(b<0)
			{
				++b;
				int i=recAdd(a,b);
				return --i;
			}
			else
				return a;        	       
		}

		//return (a * b); implement Multiplication function here
	        public static int recMul(int a, int b){
	        	
	        	//if one of both is zero, return 0
	        	if(a==0 || b==0)
	        		return 0;
	        	
	        	//default - count the number of b(b>0) and add recAdd(a,a) n times(n is the number of b)
	        	if(b>1)
	        	{
	        		b--;
	        		int i = recMul(a,b);
	        		return recAdd(i,a);
	        	}
	        	else if(b<-1 && a>0) // using default, just change sign. 
	        	{
	        		return -recMul(a,-b);
	        	}
	        	else if(b<-1 && a<0) // using default, just change sign.
	        	{
	        		return recMul(-a,-b);
	        	}
	        	else
	        		return a;
	        }


	    public static void main(String[] args){
	            if (args.length == 3){
	                    int X = Integer.parseInt(args[1]);
	                    int Y = Integer.parseInt(args[2]);
			
			if(args[0].equals("Add")){
	            	        // Add
	                    	int result_add = recAdd(X, Y);
	                        System.out.println("Add " + X + " " + Y + " " + result_add);
			}
			if(args[0].equals("Mul")){
	                    	// Multiplication
	                        int result_mul = recMul(X, Y);
	    	                System.out.println("Mul " + X + " " + Y + " " + result_mul);
			}
		}
	            else{
	                    // Print error message if no given arguments
	                    System.out.println("Wrong argument is given");
	            }
	 }



	}
