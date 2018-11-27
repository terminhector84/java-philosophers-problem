package ultimateSolution;


public class Philosopher extends Thread{
	public int philNumber;
	public String name;
	public boolean eating;
	public boolean hungry;
	public boolean thinking;
	
	//constructor created to require initial values to be specified
	//for philosopher number, name, 
	//whether he is eating, and whether he is hungry.
	public Philosopher(int philNumber, String name, boolean eating, boolean hungry, boolean thinking) {
		this.philNumber = philNumber;
		this.name = name;
		this.eating = eating;
		this.hungry = hungry;
		this.thinking = thinking;
		
	}	
	// the run method will start a philosopher eating 
	//if he is hungry and if neither of his L or R 
	//neighbors is eating

	public void run() { 
		
		boolean eating_left;
		
		boolean eating_right;
		
		eating_left = check_left(this.philNumber);
		
		eating_right = check_right(this.philNumber);
		
		
		if ((eating_left == false && eating_right == false) && this.hungry == true) {
			
			eat();
			
		}
	
			
			think();
			
		
		
		
		
		run(); //recursive call to continually run the run()
				//method
			
	}
			
	 //Philosopher objects. 1 and 3 are initialized at false
	 //to prevent all five philosophers from eating simultaneously
	 //at start.
		static Philosopher p0 = new Philosopher(0,"Confucius", false, false, true);
		static Philosopher p1 = new Philosopher(1, "Socrates", false, false, true);
		static Philosopher p2 = new Philosopher(2, "Plato", false, false, true);
		static Philosopher p3 = new Philosopher(3, "Descartes", false, false, true);
		static Philosopher p4 = new Philosopher(4, "Sartre", false, false, true);

		//Philosopher array
		static Philosopher[] WiseTable = {p0, p1, p2, p3, p4};	
		

		
		
		
		
//		WiseTable[Math.random() * WiseTable.length()].hungry  = true; 
				
		
	public static void main(String[] args) {
			
		
		p0.start();		//each objects starts the run()
		p1.start();
		p2.start();
		p3.start();
		p4.start();		
		
		
		
}
	public boolean check_right(int philNumber) {
		
		boolean eating_to_the_right;
		
		if (this.philNumber == 4) {
			
			eating_to_the_right = WiseTable[0].eating;
			
		}else {
			
			eating_to_the_right = WiseTable[this.philNumber + 1].eating;
			
		}
			
		return eating_to_the_right;
	}
	
	public boolean check_left(int philNumber) {
		
		boolean eating_to_the_left;
		
		if (this.philNumber == 0){
			
			eating_to_the_left = WiseTable[4].eating;
		}
			
		else {
			
			eating_to_the_left = WiseTable[this.philNumber - 1].eating;
			
		}
			
		return eating_to_the_left;	
	}
	
	public void think() {
		
		System.out.println("#" + (this.philNumber + 1) + "  " +  this.name +	" is thinking... and hungry " + this.hungry  + " ?");
		
		double startTime = System.currentTimeMillis() + 10000;
		
		
	    while(startTime > System.currentTimeMillis()) {
	    	
	    	this.hungry = false;
	    	this.thinking = false;
	    	this.eating = false;
	    	
	    }
	   this.hungry = true;
	    	
	    	
	}
	    
	
    	public void eat() {
    		
    		
    		boolean eating_left;
    		
    		boolean eating_right;
    		
    		eating_left = check_left(this.philNumber);
    		
    		eating_right = check_right(this.philNumber);
    		
    		
  

    		System.out.println("#" + (this.philNumber + 1) + "  " +  this.name +	" is eating...");
    		
    		double startTime = System.currentTimeMillis() + 7500;
    		
    		if ((eating_left == false && eating_right == false) && this.hungry == true) {
    	    	    while(startTime > System.currentTimeMillis()) {
    	    	    	
    	    	    	this.eating = true;
    	    	    	this.thinking = false;
    	    	    	this.hungry = false;
    	    		
    	    	   }
    		}else {
    			
    			this.eating = false;
       	     	this.hungry = false;
       	     	this.thinking = true;
       	     	
    		}
    	    	    
    	}
	}
	
	
		
	
