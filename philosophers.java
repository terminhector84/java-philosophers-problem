//Authors
//Stephen Koffler.
//Hector Tapias.
//Zion Adeyanju.

public class NewThinker extends Thread{
	
		//philosopher object properties
	
		public int philNumber;
		public int mealsAday;
		static boolean[] sticks = {true, true, true, true, true};	
	

		//constructor created to require philNumber to be specified
		//as well as mealsAday which counts how many times the philosopher has eaten
		
		public NewThinker(int philNumber, int mealsAday) {
			
			this.philNumber = philNumber;
			this.mealsAday = mealsAday;

		}	
		// the run method states that a phil is hungry and then 
		//will start the phil objects picking up sticks. Run() calls itself recursively

		public void run() { 
			
			//timer in run() delays start up to 2.5 seconds
			//to reduce occurrences of a phil eating twice in a row.
			
				waitt();
				
			//System.out.println("p" + this.philNumber + 	" just got hungry");
				
				pick_up_sticks(this.philNumber);
				
	            run();

		}
		
		//NewThinker object instances initialized with their indices and mealsAday counter = 0. 
		
		static NewThinker p0 = new NewThinker(0, 0);
		static NewThinker p1 = new NewThinker(1, 0);
		static NewThinker p2 = new NewThinker(2, 0);
		static NewThinker p3 = new NewThinker(3, 0);
		static NewThinker p4 = new NewThinker(4, 0);
		
		
		//Array of objects will help with accessing the mealsAday counter inside the pick_up_sticks method
		static NewThinker [] thinkers = {p0, p1, p2, p3, p4};

		public static void main(String[] args) {
			
			//each objects starts the run()
			p0.start();		
			p1.start();
			p2.start();
			p3.start();
			p4.start();		

		}
		
		//method waitt runs the timer with a randomized number of milliseconds
		public static void waitt() {
			
			//current time plus a random number up to 2000
			double startTime = System.currentTimeMillis() +  Math.random() * 2000;

			while(startTime > System.currentTimeMillis()){}
			
		}
		
		//synchronized method checks the philNumber, then checks if the sticks
		//to the left and right are available (true). If they are, he will pick them up. 
		//(set to false). After eating for a random time up to 3.5 seconds the phil
		// will put down his sticks and call the think_and_get_hungry method.
		
		synchronized public static void pick_up_sticks(int phil_instance) {
			
			//use circular logic to handle the left and right boolean values
			//that represent the chopsticks on the left and right of the philosophers
			
			int left = (phil_instance  - 1) % sticks.length;
			int right = (phil_instance  + 1) % sticks.length;
			
			if (left == -1) {
				left = sticks.length-1;
			}
			
			//checks that the chopsticks to the left and right are available
			//if they are available the philosopher picks them up and eats
			//inside the condition there is a counter that increments the 
			//number of times the philosopher has eaten
			//after the waitt method executes the philosopher drops the chopsticks 
			
			if(sticks[left] == true && sticks[right] == true) {
				
				sticks[left] = false;
				sticks[right] = false;
				
				System.out.println("p" +phil_instance+ " picked up the chopsticks");
				
				thinkers[phil_instance].mealsAday ++;
				
				System.out.println("p" + phil_instance + " is eating...");
				System.out.println("p" + phil_instance + " has eaten " + thinkers[phil_instance].mealsAday + " times");
				
				waitt();
				
				sticks[left] = true;
				sticks[right] = true;
				
				System.out.println("p" +phil_instance+ " puts down the chopsticks");
				
				think(phil_instance);

			}
	   	
		}
		
		//After finishing eating, the philosopher will start thinking again for at least
		//3.5 seconds and up to 7 seconds. Then he will start the run() process 
		//over again where he waits for his two chopsticks to be available.
		
		public static void think(int phil_instance) {
			
			System.out.println("p" + phil_instance + " is thinking...");
			waitt();
			
		}

	}