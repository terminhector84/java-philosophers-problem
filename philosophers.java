package ultimateSolution;

public class NewThinker extends Thread{
	
		public int philNumber;
		public int mealsAday;
		static boolean stick0=true;	//one boolean for each chopstick
		static boolean stick1=true;	//true means not being used.
		static boolean stick2=true;
		static boolean stick3=true;
		static boolean stick4=true;

		//constructor created to require philNumber to be specified
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
				
				System.out.println("p" + this.philNumber + 	" just got hungry");
	            pick_up_sticks(this.philNumber);

	            run();

		}
		
		//NewThinker objects. 
		static NewThinker p0 = new NewThinker(0, 0);
		static NewThinker p1 = new NewThinker(1, 0);
		static NewThinker p2 = new NewThinker(2, 0);
		static NewThinker p3 = new NewThinker(3, 0);
		static NewThinker p4 = new NewThinker(4, 0);

		public static void main(String[] args) {

			p0.start();		//each objects starts the run()
			p1.start();
			p2.start();
			p3.start();
			p4.start();		

		}
		
		public static void waitt() {
			
			double startTime = System.currentTimeMillis() +  2000;

			while(startTime > System.currentTimeMillis()){}
			
		}
		
		//synchronized method checks the philNumber, then checks if the sticks
		//to the left and right are available (true). If they are, he will pick them up. 
		//(set to false). After eating for a random time up to 3.5 seconds the phil
		// will put down his sticks and call the think_and_get_hungry method.
		
		synchronized public static void pick_up_sticks(int phil_instance) {
			
			if( (phil_instance == 0) && stick4 == true && stick0 == true) {
				
				
//				sticks[arr.elngth-1] && sticks[0]
						
				stick4 = false;
				System.out.println("p" + phil_instance + " picked up the chopstick to his" + " left");
				
				stick0 = false;
				System.out.println("p" +phil_instance+ " picked up the chopstick to his " + " right");
				
				p0.mealsAday ++;
				
				System.out.println("p0 has eaten " + p0.mealsAday + " times");
				
				System.out.println("p" + phil_instance + " is eating...");
				
				waitt();
				
				stick4 = true;
				System.out.println("p" + phil_instance + " put down the chopstick to his " + " left");
				
				stick0 = true;
				System.out.println("p" +phil_instance+ " put down the chopstick to his " + " right");
				
				think(phil_instance);

			}
			else if (phil_instance == 1 && stick0 == true && stick1 == true) {
				
				stick0 = false;
				System.out.println("p" +phil_instance+ " picked up the chopstick to his "+ " left");
				
				stick1 = false;
				System.out.println("p" +phil_instance+ " picked up the chopstick to his "+ " right");
				
				p1.mealsAday ++;
				System.out.println("p1 has eaten " + p1.mealsAday + " times");
				
				System.out.println("p" + phil_instance + " is eating...");
				
				waitt();
				
				stick0 = true;
				System.out.println("p" + phil_instance + " put down the chopstick to his "+ " left");
				
				stick1 = true;
				System.out.println("p" +phil_instance+ " put down the chopstick to his " + " right");
				
				think(phil_instance);

			}
			if( (phil_instance == 2) && stick1 == true && stick2 == true) {
				
				stick1 = false;
				System.out.println("p" + phil_instance + " picked up the chopstick to his "	+ " left");
				
				stick2 = false;
				System.out.println("p" +phil_instance+ " picked up the chopstick to his " + " right");
				
				p2.mealsAday ++;
				System.out.println("p2 has eaten " + p2.mealsAday + " times");
				
				System.out.println("p" + phil_instance + " is eating...");
				
				waitt();
				
				stick1 = true;
				System.out.println("p" + phil_instance + " put down the chopstick to his " + " left");
				
				stick2 = true;
				System.out.println("p" +phil_instance+ " put down the chopstick to his " + " right");
				
				think(phil_instance);

			}	
			if( (phil_instance == 3) && stick2 == true && stick3 == true) {
				
				stick2 = false;
				System.out.println("p" + phil_instance + " picked up the chopstick to his "	+ " left");
				
				stick3 = false;
				System.out.println("p" +phil_instance+ " picked up the chopstick to his "+ " right");
				
				p3.mealsAday ++;
				System.out.println("p3 has eaten " + p3.mealsAday + " times");
				
				System.out.println("p" + phil_instance + " is eating...");
				
				waitt();
				
				stick2 = true;
				System.out.println("p" + phil_instance + " put down the chopstick to his " + " left");
				
				stick3 = true;
				System.out.println("p" +phil_instance+ " put down the chopstick to his " + " right");
				
				think(phil_instance);

			}
			if( (phil_instance == 4) && stick3 == true && stick4 == true) {
				
				stick3 = false;
				System.out.println("p" + phil_instance + " picked up the chopstick to his " + " left");
				
				stick4 = false;
				System.out.println("p" +phil_instance+ " picked up the chopstick to his " + " right");
				
				p4.mealsAday ++;
				System.out.println("p4 has eaten " + p4.mealsAday + " times");
				
				System.out.println("p" + phil_instance + " is eating...");
				
				waitt();
				
				stick3 = true;
				System.out.println("p" + phil_instance + " put down the chopstick to his " + " left");
				
				stick4 = true;
				System.out.println("p" +phil_instance+ " put down the chopstick to his " + " right");
				
				think(phil_instance);

			}	   	
		}
		
		//After finishing eating, the phil will start thinking again for at least
		//3.5 seconds and up to 7 seconds. Then he will start the run() process 
		//over again where he waits for his two chopsticks to be available.
		
		public static void think(int phil_instance) {
			
			System.out.println("p" + phil_instance + " is thinking...");
			waitt();
			
		}

	}

//create functionality for two synchronized methods