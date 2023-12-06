/*
 *project objective: To develop a bingo games where user not only can play in classic mode with difference level
 * 				     but also can customize their own bingo board.
 * 
 *problem solving: 1. Create a competent computer engine to play bingo with human player
 *                 2. Customize bingo board for user to track their progress or set their goal easily and make it playful 
 *                 and entertain to play, it can be a bingo wish list, a to-do-list, a monthly goal or other which
 *                 contain 25 activities and tasks.
 *                 
 *Mechanics/ Content strategy:
 *					1. The Uniqueness of this bingo programming system
 *					1.1 Customize bingo is uniquely link games to project planning tools, the customize bingo make it more flexible and
 *						entertain for the user to process and track their plans. 
 *					1.2 Bingo 1 to 25 in this system make it versatile for user to change difference ways of playing this game for example
 *						user can train their memorization by not displaying bingo board. They can display view all board to do strategic
 *						analysis to select the best digit, the user can also view his/her own bingo board to experience the original bingo
 *						game experience.
 *					1.3 This system also provided machine generate board, users do not need to manually insert numbers inside the system.
 *					2. The system is targeted for all range of people
 *					2.1 The elder is able to improve mental health, for example, improves cognitive function, improve memory, 
 *						better hand-eye coordination, the system provided maximum of 4 human players make increase the social engagement.
 *                      This system is relatively easy to play than playing bingo in real life, this is because the bingo is a fast-pace
 *                      game, it requires players to remember the numbers as they are called and locate them quickly on their card, but this
 *                      system make it automatically recorded, so, it is easily to play for elder person.
 *                  2.2 The children and adult are also the target user, this is because unlike chess and sudoku which require a fair amount
 *                  	 of energy and time to learn, people might also feel uncomfortable about their skills which make them unable to enjoy 
 *                  	learning, children and adult can play bingo to get benefit same as the elder person, they can enjoy the game since
 *                      bingo is just about luck. In this system, we provide "customize bingo" mode make it more suitable for this group of
 *                      people, children and adult can create their own bingo which contains their plans or tasks, which not only make them
 *                      enjoy the process but also accomplish something mention in their plan. Their can either follow their fate by choosing
 *                      machine generator or accomplish their plan and tasks themselves until they getting five points which mean "Bingo".
 * * */



import java.util.Scanner;
import java.util.ArrayList;

public class Sample3 {
	
	//size of bingo board
	public static final int row = 5;
	public static final int column = 5;
	//totalNum = row * column
	public static final int totalNum = 25;
		
	//global scanner 
	public static Scanner scanner = new Scanner(System.in);
		
	//2D ArrayList (human player)
	public static ArrayList<ArrayList<Integer>> humanPlayer = new  ArrayList<ArrayList<Integer>>();
	//4 human ArrayLists
	public static ArrayList<Integer> human01 = new ArrayList<Integer>();
	public static ArrayList<Integer> human02 = new ArrayList<Integer>();
	public static ArrayList<Integer> human03 = new ArrayList<Integer>();
	public static ArrayList<Integer> human04 = new ArrayList<Integer>();
	
	//Array store 25 contents in gameMode -> "customize bingo"
	public static String[] contentOfCustomizeBingo;
	
	//2D ArrayList (machine player)
	public static ArrayList<ArrayList<Integer>> machinePlayer = new  ArrayList<ArrayList<Integer>>();
	//3 machine ArrayLists
	public static ArrayList<Integer> machine01 = new ArrayList<Integer>();
	public static ArrayList<Integer> machine02 = new ArrayList<Integer>();
	public static ArrayList<Integer> machine03 = new ArrayList<Integer>();
	
	// two game mode -> 1 = "bingo 1 to 25" -> 2 = "customize bingo"
	public static int gameMode=0;
	
	// store digit that is drew by opponent and receive the drew digits
	public static int storeDraw = 0;
	// store digit
	public static int storeNumber = 0; 
	// indicate the arraylist store in  2 dimension arraylist
	public static int playerNum1 = 0;
	// number of machine player selected by user
	public static int machinePlayerNum = 0;
	// number of human player selected by user
	public static int humanPlayerNum = 0;
	
	public static void main(String[] args) {
		
		// add ArrayList into 2D ArrayList
		humanPlayer.add(human01);
		humanPlayer.add(human02);
		humanPlayer.add(human03);
		humanPlayer.add(human04);
		
		machinePlayer.add(machine01);
		machinePlayer.add(machine02);
		machinePlayer.add(machine03);
		
		boolean startGame = true;
		while(startGame) {
		// print type of game mode
		System.out.println(" \n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println(" Welcome to Bingo programming system !");
		System.out.println(" This system provides two different game modes !");
		System.out.println(" Select \"About the system\" for more information !\n");
		System.out.println(" Select BINGO GAME mode !!");
		System.out.println(" 1. Bingo one to twenty-five");
		System.out.println(" 2. Customize Bingo");
		System.out.println(" 3. About this system");
		System.out.println(" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.print(" Enter one digits form 1 to 3: ");
		// input type of game mode
		gameMode = scanner.nextInt();
		
		// about
		if(gameMode==3) {
			while(gameMode==3) {
			about();
			System.out.print("\n Click digit \"1\" to continue the game: ");
			int continueGame=scanner.nextInt();
			System.out.println();
			if(continueGame==1) {
			System.out.println(" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			System.out.println(" Enter BINGO GAME mode!!");
			System.out.println(" 1. Bingo 1 to 25");
			System.out.println(" 2. Customize Bingo");
			System.out.println(" 3. About this system");
			System.out.println(" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			System.out.print(" Enter one digits form 1 to 3: ");
			gameMode = scanner.nextInt();
			}
			}
		}
		//input bingo 1 to 25
		if(gameMode==1) {
		//print number of player
		System.out.println("\n >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println(" How many players?(include human and machine player)");
		System.out.println(" 2 players ");
		System.out.println(" 3 players ");
		System.out.println(" 4 players ");
		System.out.println(" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.print(" Enter one digits from 2 to 4: ");
		int totalPlayerNum = scanner.nextInt();
		
		System.out.println("\n >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println(" How many human players?");
		if(totalPlayerNum == 4) {
		//print number of human player
		System.out.println(" 1 human player (recommended)");
		System.out.println(" 2 human players ");
		System.out.println(" 3 human players ");
		System.out.println(" 4 human players ");
		System.out.println(" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.print(" Enter one digits from 1 to 4: "); 
		}else if (totalPlayerNum == 3) {
			System.out.println(" 1 human player (recommended)");
			System.out.println(" 2 human players ");
			System.out.println(" 3 human players ");
			System.out.println(" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			System.out.print(" Enter one digits from 1 to 3: "); 	
		}else{
			System.out.println(" 1 human player (recommended)");
			System.out.println(" 2 human players ");
			System.out.println(" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			System.out.print(" Enter one digits from 1 to 2: "); 	
		}
		humanPlayerNum = scanner.nextInt();
		
		//print game levels 
		System.out.println("\n >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println(" Bingo Game level ");
		System.out.println(" level 1 [EASY]");
		System.out.println(" level 2 [MEDIUM]");
		System.out.println(" level 3 [HARD]");
		System.out.println(" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.print(" Pick a level: ");
		int machinePlayerLevel = scanner.nextInt();
		
		machinePlayerNum = totalPlayerNum - humanPlayerNum;
		
		for(playerNum1=0; playerNum1<humanPlayerNum; playerNum1++) {
			//print two ways to generate bingo board for human
			System.out.println("\n >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			System.out.println(" Player "+(playerNum1+1)+" !!");
			System.out.println(" Which way to generate your bingo Board??");
			System.out.println(" 1.Manually insert yourself");
			System.out.println(" 2.Machine help you auto generate");
			System.out.println(" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			System.out.print(" Pick either one method by enter digit 1 or 2: ");
			int inputGenerateBingoBoard = scanner.nextInt();
			
			if(inputGenerateBingoBoard==1) {
				// manually insert 25 digits into bingo board to human player
				humanGenerateBoard(humanPlayer,playerNum1);
				}else {
					// machine generate 25 digits into bingo board to human player
					machineGenerateBoard(humanPlayer,playerNum1);
					}
	    }
	    
	    for(playerNum1=0;playerNum1<machinePlayerNum;playerNum1++) {
	    	// machine generate 25 digits into bingo board to machine player
	    	machineGenerateBoard(machinePlayer,playerNum1);
	    }
	    // compute higher number of player between human and machine	
	    int higherNum = 0;
	    if(machinePlayerNum>=humanPlayerNum) {
	    	higherNum = machinePlayerNum;
	    	}else{
	    		higherNum = humanPlayerNum;
	    		}
	    
	    int count = 1;
	    outerloop:
		while(true) {
			// print number of round
			System.out.println("\n ++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println(" Round "+ count);
			System.out.println(" ++++++++++++++++++++++++++++++++++++++++++++++++++++");
			// loop number of time base on higherNum
			for(playerNum1=0;playerNum1<higherNum;playerNum1++) {
			
				if(playerNum1<humanPlayerNum) {
					System.out.println(" \n>>>Player "+(playerNum1+1)+"<<<");
					printBoard(humanPlayer,playerNum1);
					humanPlayerSetting(humanPlayer,playerNum1);
					// to draw a digit
					humanDraw(humanPlayer,playerNum1);							
				}
				for(int i=0;i<humanPlayerNum;i++) {
					// human player delete digit based on other players draw.
					checkDraw(humanPlayer,i);
					if(bingoPoint(humanPlayer,i)>=5) { 
						break outerloop;
					}
				}
				for(int i=0;i<machinePlayerNum;i++) {
					// machine player delete digit based on other players draw.
					checkDraw(machinePlayer,i);
					if(bingoPoint(machinePlayer,i)>=5) {	
						break outerloop;
					}
				}
				
				if(playerNum1<machinePlayerNum) {
					if(machinePlayerLevel==1) {
						System.out.println();
						System.out.println(" >>>Machine "+(playerNum1+1)+"<<<");
						machineDrawLevel1(machinePlayer,playerNum1);
				    	}else if(machinePlayerLevel==2) {
				    		machineDrawLevel2(machinePlayer,playerNum1);
				    		}else {
				    			machineDrawLevel3(machinePlayer,playerNum1);
				    		}
				}
				for(int i=0;i<humanPlayerNum;i++) {
					checkDraw(humanPlayer,i);
					if(bingoPoint(humanPlayer,i)>=5) { 
						break outerloop;
					}
				}
				for(int i=0;i<machinePlayerNum;i++) {
					checkDraw(machinePlayer,i);
					if(bingoPoint(machinePlayer,i)>=5) {
						break outerloop;
					}
				}	
			}
			count++;
		}
		System.out.println(" ##  ##  ##  ##  ##  ##  ##  ##  ##  ##  ##  ##  ##");
		System.out.println( " Bingo!! Congratulation");
		System.out.println(" ##  ##  ##  ##  ##  ##  ##  ##  ##  ##  ##  ##  ##");
		count = 0;
		for(int i=0;i<humanPlayerNum;i++) {
			if(bingoPoint(humanPlayer,i)>=5) { 
				// print machine player who have >=5 bingo points
				System.out.println(" human player "+(i+1)+" win");
				count++;
			}
		}
		for(int i=0;i<machinePlayerNum;i++) {
			if(bingoPoint(machinePlayer,i)>=5) {	
				// print machine player who have >=5 bingo points
					System.out.println(" Machine player "+(i+1)+" win");
					count++;
				}
			}
		
		if(count==1) {
			System.out.println(" total "+ count + " player won!!");
			}else {
				System.out.println( " total "+ count + " players won!!");
			}
		// gameMode1 end#
		// gameMode2 start
		}else if(gameMode==2){
			// print type of customize bingo
			System.out.println("\n >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			System.out.println(" Welcome to CUSTOMIZE BINGO!!");
			System.out.println(" 1.Customize your own bingo");
			System.out.println(" 2.Sample one - Self-care bingo");
			System.out.println(" 3.Sample two - social-distancing bingo");
			System.out.println(" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			System.out.print(" Enter one digit between 1 to 3: ");
			int inputCustomBingo = scanner.nextInt();
			
			//customize new bingo
			if(inputCustomBingo==1) {
			System.out.println("\n Enter the content inside the bingo");
			String tempString="";
			contentOfCustomizeBingo = new String[25];
				for(int i=0;i<totalNum;i++) {
					System.out.print(" content "+(i+1)+": ");
					if(i==0) {
						 tempString= scanner.nextLine();
					}
				    tempString= scanner.nextLine();
					contentOfCustomizeBingo[i]= tempString;
				}
				
			}else if(inputCustomBingo==2) {
						// sample 1
						contentOfCustomizeBingo = new String[] {"watch movie","hike a mountain","read 1 book","1 day no internet","donate to charity",
																"meditate 3 times", "listen 1 album","spend 50 hours outdoor","1 day fast","go to gym",
																"organiza a room","visit a museum","write detail about next vacation","walk 15 km",
																"log training for 1 week","cook food","medidate 5 times","nature wareness day","go to play",
																"ask close friend 10 questions","eat healthy food","practise some hobby","post picture",
																"decrease screen time in social media platform","no netflex"};
				
				}else{
						    // sample 2
							contentOfCustomizeBingo = new String[] {"take a walk around your neighborhond while practicing social distancing",
																	"organize multiple areas of your home","watch at least one video","take a digital course",
																	"do research on your ancestry through - family search","read 5 e-books","wash hands ",
																	"read News","take some quiz","lose track of time","read a book in genre you wouldn't normally read",				
																	"do not touch your face","dance in your living room","do a window visit with senior neighbors",
																	"stop talking to yourself around the house","call a family members","try a simple science experience",
																	"play a board game","bake a treat","do exercise","make a card for someone","build with legos and blocks",
																	"sleep 12 hours a day","make a random act of kindness","complete a project you have been putting off"};
							
					}
			// print way to arrange 25 digits in bingo board
			System.out.println("\n >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			System.out.println(" Way to arrange 25 digits in Bingo Board");
			System.out.println(" 1. Sort in ascending order");
			System.out.println(" 2. randomly sort by machine.");
			System.out.println(" 3. insert digits yourself");
			System.out.println(" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			System.out.print(" Enter one digits between 1 and 3: ");
			int inputDigitsSortInBingoBoard = scanner.nextInt();
			System.out.println();
			
			if(inputDigitsSortInBingoBoard==1) {
				// print 1 to 25 in ascending order
				for(int i =0; i<totalNum; i++) {
					humanPlayer.get(playerNum1).add(1+i);
				} 
				System.out.println("  >>>THE BINGO BOARD<<<");
				printBoard(humanPlayer,playerNum1);
			}else if(inputDigitsSortInBingoBoard==2){
					//machine generate 1 to 25 digits randomly
					machineGenerateBoard(humanPlayer,playerNum1);
					System.out.println("  >>>THE BINGO BOARD<<<");
					printBoard(humanPlayer,playerNum1);
				}else {
						// human manually generate 1 to 25 digits
						humanGenerateBoard(humanPlayer,playerNum1);
						System.out.println("  >>>THE BINGO BOARD<<<");
						printBoard(humanPlayer,playerNum1);
					}
			
			// print what type of player draw the digit
			System.out.println("\n >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			System.out.println(" Who draw the digit!!? ");
			System.out.println(" 1.You draw or select the digit.");
			System.out.println(" 2.Machine draw the digit.");
			System.out.println(" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			System.out.print(" Enter one digit between 1 to 2: ");
			int playerDrawBingo = scanner.nextInt();
			System.out.println();
			boolean noWinner = true;
			
			if(playerDrawBingo ==1) {
				while(noWinner) {
					// print rule
					System.out.println("\n >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
					System.out.println(" 	Insert relative digits when you have acomplished");
					System.out.println(" the activity mention in the content.");
					System.out.println("    For Example: 4. play bingo.");
					System.out.println(" 	When you done the activity \"play bingo\" you can ");
					System.out.println("    insert digits 4.");
					System.out.println(" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");
					printBoard(humanPlayer,playerNum1);
					humanPlayerSetting(humanPlayer, playerNum1);
					// human player draw or select the digit
					humanDraw(humanPlayer,playerNum1);
					if(bingoPoint(humanPlayer,playerNum1)>=5) { 
						noWinner = false;
					}
				}
			}else {
				while(noWinner) {
					printBoard(humanPlayer,playerNum1);
					humanPlayerSetting(humanPlayer,playerNum1);
					
					// machine player draw the digit
					machineDrawLevel1(humanPlayer,playerNum1);
					// print digit drew by machine
					System.out.println(" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
					System.out.println(" Machine...start drawing...Got it!!");
					System.out.println(" Please complete this activity!!");
					System.out.println(" ##  ##  ##  ##  ##  ##  ##  ##  ##  ##  ##  ##  ##");
					System.out.println(" Content "+storeNumber+": "+contentOfCustomizeBingo[storeNumber-1]);
					System.out.println(" ##  ##  ##  ##  ##  ##  ##  ##  ##  ##  ##  ##  ##\n");
					int countNum=0;
				    while(true) {
				    	// print rule
				    	System.out.println(" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
					    System.out.println(" Please finish the content before continuos!!");
					    System.out.println(" 1. Continuos");
					    if(countNum<1) {
					    System.out.println(" 2. Give Up or unable to acheive it");
					    }else if(countNum<2) {
					    	System.out.println(" 2. Give Up or unable to acheive it - ><! are you still wanna choose me!!!??");
					    	}else if(countNum<3){
					    		System.out.println(" 2. Give Up or unable to acheive it - ><! give yourself one last chance!");
					    		}
					    System.out.println(" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
						System.out.print(" Enter one digit between 1 to 2: ");	
					
					    int contentProgressInput = scanner.nextInt();
					    System.out.println();
					    if(contentProgressInput==1) {
					    	machineDrawDigit(humanPlayer,playerNum1,storeNumber);
							if(bingoPoint(humanPlayer,playerNum1)>=5) { 
								noWinner = false;
							}
							break;
					    }else {
							    countNum++;
							    if(countNum==3) {
							    System.out.println(" ##  ##  ##  ##  ##  ##  ##  ##  ##  ##  ##  ##  ##  ");
							    System.out.println(" Okay, at least you done your best!! and honest by the way ;)");
							    System.out.println(" ##  ##  ##  ##  ##  ##  ##  ##  ##  ##  ##  ##  ##  ");
							    break;
							    }
					    	}

				    }
				}
			}
			// print Bingo!! when player finish the game
			System.out.println(" ##  ##  ##  ##  ##  ##  ##  ##  ##  ##  ##  ##  ##  ");
			System.out.println( " Bingo!! Congratulation");
			System.out.println(" ##  ##  ##  ##  ##  ##  ##  ##  ##  ##  ##  ##  ##  ");
			printBoard(humanPlayer,playerNum1);
			//gameMode 2 end#
				}
		System.out.println(" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("1. GO BACK TO HOME PAGE");
		System.out.println("2. Exit this Game");
		System.out.println(" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.print("Enter one digit between 1 and 2: ");
		int endGame = scanner.nextInt();
		if(endGame==2) {
			startGame = false;
		}
		}
	}
	// human player's setting
	public static void humanPlayerSetting(ArrayList<ArrayList<Integer>>player,int playerNum) {
		int inputNum = 0;
		if(gameMode==1) {
		
		while(true) {
		System.out.println("\n >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println(" Setting -> Your can select one digit!!");
		System.out.println(" 1. Show all player bingo board");
		System.out.println(" 2. exit");
		System.out.println(" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.print(" Enter digit 1 to 2: ");
		inputNum = scanner.nextInt();
		System.out.println();
		
		if(inputNum == 1) {
			// print all player bingo board
				for(playerNum=0;playerNum<humanPlayerNum;playerNum++) {
					System.out.println("\n human player "+(playerNum+1)+" :");
					printBoard(humanPlayer,playerNum);
				}
				for(playerNum=0;playerNum<machinePlayerNum;playerNum++) {
					System.out.println("\n Machine player "+(playerNum+1)+" :");
					printBoard(machinePlayer,playerNum);
				}
			}else {
				break;
			}
		}
		System.out.println();
			}else {
				
				while(true) {
				// gameMode2
				System.out.println("\n >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				System.out.println(" Setting -> You can select 1 digit!!");
				System.out.println(" 1. Show the contents ");
				System.out.println(" 2. exit");
				System.out.println(" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				System.out.print(" Enter digit 1 to 2: ");
				inputNum = scanner.nextInt();
				System.out.println();
				
				if(inputNum == 1) {
					// print bingo board and 25 contents
					System.out.println();
					System.out.println("  >>>THE BINGO BOARD<<<");
					printBoard(player,playerNum);
					System.out.println();
					System.out.println("  >>>THE CONTENTS SECTION<<<");
					for(int i=0;i<contentOfCustomizeBingo.length;i++) {
						if(i<9) {
							System.out.print(" ");
						}
						System.out.println(" "+(i+1)+": "+contentOfCustomizeBingo[i]);
					}
				}else { break;}
	
			System.out.println();
				}
			}
	}
	// human manual generate board
	public static void humanGenerateBoard(ArrayList<ArrayList<Integer>>player,int playerNum) {
		ArrayList<Integer> sampleNum = new ArrayList<Integer>();
		for(int i=0;i<25;i++) {
			sampleNum.add(i+1);
		}
		System.out.println("\n ##  ##  ##  ##  ##  ##  ##  ##  ##  ##  ##  ##  ##  ");
		System.out.println(" Enter digit 1 to 25 randomly");
		System.out.println(" ##  ##  ##  ##  ##  ##  ##  ##  ##  ##  ##  ##  ##  \n");
		
		for(int i=0;i<25;i++) {
				
			System.out.print(" Enter digit "+(i+1)+" = ");
			int input = scanner.nextInt();
			player.get(playerNum).add(input);
				
			for(int j=0;j<i;j++) {
				if(player.get(playerNum).get(i)==player.get(playerNum).get(j)) {
					System.out.println("\n ##  ##  ##  ##  ##  ##  ##  ##  ##  ##  ##  ##  ## ");
					System.out.println(" duplicate element "+player.get(playerNum).remove(i));
					System.out.println(" ##  ##  ##  ##  ##  ##  ##  ##  ##  ##  ##  ##  ## ");
					System.out.println("\n Please select digit below");
					System.out.println(" "+sampleNum.toString()+"\n");
					i--;
					break;
					}else if(player.get(playerNum).get(i)>25 || player.get(playerNum).get(i)<=0) {
						System.out.println("\n ##  ##  ##  ##  ##  ##  ##  ##  ##  ##  ##  ##  ##  ");
						System.out.println(" Enter integer between 1 to 25 ");
						System.out.println(" ##  ##  ##  ##  ##  ##  ##  ##  ##  ##  ##  ##  ##  ");
						System.out.println("\n Please select digit below");
						player.get(playerNum).remove(i);
						System.out.println(sampleNum.toString());
						System.out.println();
						i--;
						break;
					}
			}	
			if(sampleNum.contains(input)) {
				sampleNum.remove(sampleNum.indexOf(input));
				if(!sampleNum.isEmpty()) {
					System.out.println();
					System.out.print(" "+"Select digits: ");
					System.out.println(sampleNum.toString());
					System.out.println();
					}
			}
				
		}
		System.out.println("\n Board generated!!\n");
		System.out.println("  >>> Player "+ (playerNum+1)+ "board <<<");
        printBoard(player,playerNum);
        System.out.println();
	}
	// auto generate board
	public static void machineGenerateBoard(ArrayList<ArrayList<Integer>>player,int playerNum) {
		
	    for (int i = 0; i < 25; i++)  player.get(playerNum).add(i);
	    for (int i = 0; i < 25; i++) {
	    	int index = (int)(Math.random() * 25+1);
	      	player.get(playerNum).remove(i);
	      	player.get(playerNum).add(i, index);
	      	for(int j=0;j<i;j++) {
				if(player.get(playerNum).get(i)==player.get(playerNum).get(j)) {
					i--;
					break;
	           }
	      	}
	    } 
	}
	// manual draw digit 
	public static void humanDraw(ArrayList<ArrayList<Integer>>player,int playerNum) {
		
		boolean condition = true;
		while(condition) {
		System.out.println(" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	    System.out.print(" Enter 1 digit between 1 to 25 to draw: ");
		int playerInput = scanner.nextInt();
		System.out.println();
			if(player.get(playerNum).indexOf(playerInput)==-1) {
				System.out.println(" The number is selected :(");
				condition = true;
				}else {
					System.out.println(" ##  ##  ##  ##  ##  ##  ##  ##  ##  ##  ##  ##  ## ");
					System.out.println(" human player "+(playerNum+1)+" draw "+ playerInput);
					System.out.println(" ##  ##  ##  ##  ##  ##  ##  ##  ##  ##  ##  ##  ## ");
					System.out.println();
					int temp = player.get(playerNum).indexOf(playerInput);
					storeDraw = playerInput;
					player.get(playerNum).remove(player.get(playerNum).indexOf(playerInput));
					player.get(playerNum).add(temp, 0);
					condition = false;
				}
		}		
	}
	// machine level 1
	public static void machineDrawLevel1(ArrayList<ArrayList<Integer>>player,int playerNum) {
		boolean condition = true;
		while(condition) {
			int number = (int) (Math.random()*25+1);
				if(player.get(playerNum).indexOf(number)==-1) {
					condition = true;
				}else if(gameMode==2) {
					storeNumber = number;
					condition = false;
					}else {
						machineDrawDigit(player,playerNum,number);
						condition = false;
					}
		}
	}
	// machine level 2
	public static void machineDrawLevel2(ArrayList<ArrayList<Integer>>player,int playerNum) {

		int i =0;
		int j =0;
		int sumRow=0;
		int rowNumber=0;
		
		//scan row
		for(i=0;i<25;i+=5) {
			int row=0;
			for(j=0;j<5;j++) {
				if(player.get(playerNum).get(i+j)==0) {
					if(row>sumRow) {
						rowNumber=i;
						sumRow=row;
					}
				}
			}
		}
		//scan column 
		int sumColumn =0;
		int columnNumber=0;
		for(i=0;i<5;i++) {
			int column= 0;
			for(j=0;j<25;j+=5) {
				if(player.get(playerNum).get(i+j)==0) {
					column++;
					if(column>sumColumn) {
						columnNumber=i;
						sumColumn=column;
					}
				}              
			}
		}
		//scan diagonal
		int sumDiagonal=0;
		for(i=0;i<25;i+=6) {
			if(player.get(playerNum).get(i)==0) {
				sumDiagonal++;
			}
		}
		//scan inverse diagonal
		int sumInverseDiagonal=0;
		for(i=4;i<25;i+=4) {
			if(player.get(playerNum).get(i)==0) {
				sumInverseDiagonal++;
			}
		}
		int drawLevel=0;
		int number=0;
		
		if(sumRow>sumColumn && sumRow>sumDiagonal && sumRow>sumInverseDiagonal) {
			for(j=0;j<5;j++) {
				if(!(player.get(playerNum).get(rowNumber+j)==0)) {
					number=player.get(playerNum).get(rowNumber+j);
				}
			}
			}else if(sumColumn>sumDiagonal && sumColumn>sumInverseDiagonal) {
				for(j=0;j<25;j+=5) {
					if(!(player.get(playerNum).get(columnNumber+j)==0)) {
						number=player.get(playerNum).get(columnNumber+j);
					}
				}
				}else if(sumDiagonal> sumInverseDiagonal) {
					for(i=0;i<25;i+=6) {
						if(!(player.get(playerNum).get(i)==0)) {
							number=player.get(playerNum).get(i);
							}
						}
					}else if(sumInverseDiagonal>sumDiagonal) {
						for(i=4;i<25;i+=4){
							if(!(player.get(playerNum).get(i)==0)) {
								number=player.get(playerNum).get(i);
							}
						}
						}else {
							machineDrawLevel1(player, playerNum);
							drawLevel=1;
						}
		if(!(drawLevel==1)) {
		machineDrawDigit(player,playerNum,number);
		}
	}
	// machine level 3
	public static void machineDrawLevel3(ArrayList<ArrayList<Integer>>player,int playerNum) {
		ArrayList<Integer> advanceTest = new ArrayList<Integer>();
		int sum = 0;
		int i=0;
		int j=0;
		
		//row
		for(i=0;i<25;i+=5) {
			for(j=0; j<5; j++) {
				if(player.get(playerNum).get(i+j)==0) {
				sum += 1;
				}
			}
			for(j=0;j<row;j++) {
				advanceTest.add((i+j),sum);
			}
			sum=0;
		}
		//column
		for(i=0;i<column;i++) {
			for(j=0; j<25; j+=5) {
				if(player.get(playerNum).get(i+j)==0) {
					sum += 1;
				}
			}
			for(j=0; j<25; j+=5) {
			advanceTest.add((i+j), (advanceTest.get(i+j)+sum));
			}
			sum=0;
		}
		//diagonal
		for(i=0;i<totalNum;i+=6) {
			if(player.get(playerNum).get(i)==0) {
				sum += 1;
				advanceTest.add((i), (advanceTest.get(i)+sum));
			}sum=0;
		}sum=0;	
		//inverse diagonal
		for(i=4;i<totalNum;i+=4) {
			if(player.get(playerNum).get(i)==0) {
				sum += 1;
				advanceTest.add((i+j), (advanceTest.get(i)+sum));
			}sum=0;
		}sum=0;
	   int number =0;
	   
	   for(int n=0;n<25;n++) {
		   int highestDigit = 0;
		   if(!(player.get(playerNum).get(n)==0) && advanceTest.get(n)>highestDigit) {
			   highestDigit=advanceTest.get(n);
			   number = player.get(playerNum).get(n);
		   }
	   }
	    machineDrawDigit(player,playerNum,number);
	} 
    // machine draw digits and print
	public static void machineDrawDigit(ArrayList<ArrayList<Integer>>player,int playerNum,int number) {
		
    	int temp = player.get(playerNum).indexOf(number);
    	System.out.println();
    	System.out.println(" ##  ##  ##  ##  ##  ##  ##  ##  ##  ##  ##  ##  ##");
		System.out.println(" machine player "+(playerNum+1) +" draw "+number);
		System.out.println(" ##  ##  ##  ##  ##  ##  ##  ##  ##  ##  ##  ##  ##"); 
		
		if(gameMode==2) {
    		System.out.println("/n >>>Completed>>>");
    	}
		System.out.println();
		storeDraw=number;
		player.get(playerNum).remove(player.get(playerNum).indexOf(number));
		player.get(playerNum).add(temp, 0);
		
	}
    // check draw from other players
	public static void checkDraw(ArrayList<ArrayList<Integer>>player,int playerNum) {		
    	int temp = player.get(playerNum).indexOf(storeDraw);
    	if(temp == -1) {
    	// no action
    	}else {
    		player.get(playerNum).remove(temp);
    		player.get(playerNum).add(temp,0);
			}
	}
    // print bingo board
	public static void printBoard(ArrayList<ArrayList<Integer>>player,int playerNum) {
		
			System.out.println();
			System.out.println("  --- --- BINGO --- --- ");
		    System.out.println();
			
			for(int i=0;i<=20;i+=5) {
				System.out.print("  ");
				for(int j=0;j<5;j++) {
					if(player.get(playerNum).get(j+i)<10) {
						System.out.print(" ");
					}System.out.print(" ");
					System.out.print(player.get(playerNum).get(j+i)+" ");
				}System.out.println();
				System.out.println();	
			}
			System.out.println("  --- --- ---- --- --- ");
			System.out.println("  Bingo: "+ bingoPoint(player,playerNum));
		}
	// the bingo points and rule
	public static int bingoPoint(ArrayList<ArrayList<Integer>>player,int playerNum) {
		int count= 0;
		int sumRow = 0;
		//scan row
		for(int i=0;i<25;i+=5) {
			sumRow = 0;
			for(int j=0;j<5;j++) {
			sumRow += player.get(playerNum).get(i+j);
			}
			if(sumRow==0) {
				count+=1;
			}
		}
		//scan column   
		int sumColumn =0;
		for(int i=0;i<5;i++) {
			sumColumn= 0;
			for(int j=0;j<25;j+=5) {
				sumColumn += player.get(playerNum).get(i+j);
			}
			if(sumColumn==0) {
				count+=1;
			}
		}
		// scan diagonal
		int sumDiagonal=0;
		for(int i=0;i<25;i+=6) {
			sumDiagonal += player.get(playerNum).get(i);
		}
		if(sumDiagonal==0) {
			count+=1;
		}
		// scan inverse diagonal
		int sumInverseDiagonal=0;
		for(int i=4;i<25;i+=4) {
			sumInverseDiagonal += player.get(playerNum).get(i);
		}
		if(sumInverseDiagonal==0) {
			count+=1;
		}
		return count;
	}
	// about the system
	public static void about() {
		System.out.println("\n >>>>>>>>>>>>>>>>>>>ABOUT<<<<<<<<<<<<<<<<<<<<");
		System.out.println("\n >>> The first Game Mode is bingo one to twenty-five <<<");
		System.out.println("\n >>> >>> RULE <<< <<<\n");
		System.out.println(" 1. 5 rows * 5 columns of bingo Card which equally fill up with 25 digits.");
		System.out.println(" 2. Enter 25 digits randomly but without duplicate of each others.");
		System.out.println(" 3. 1 player draws 1 time in a round. ");
		System.out.println(" 4. Drew digits become digit \"0\" and cannot been draw again.");
		System.out.println(" 5. The drew digits will become \"0\" in others player's bingo board or bingo card.");
		System.out.println(" 5. 5 \"0\" in row, column, diaganol, inverse diaganol will increase 1 bingo point.");
		System.out.println(" 6. who the first gather 5 bingo points will bingo or win the game!!");
		System.out.println("\n >>>What New inside the system!!<<<");
		System.out.println(" 1. This system are able for 2 to 4 players with the maximum of 4 human players or 3 machine players plus 1 human players.");
		System.out.println(" 2. This system have three levels of machine players");
		System.out.println("     2.1 Level 1 will random generate draw");
		System.out.println("     2.2 Level 2 will find which line \"0\" is the highest and draw the first digit which is not \"0\" in the line.");
		System.out.println("     2.3 Level 3 will evaluate all digits and find out which digits have highest \"0\" ");
		System.out.println(" 3. When human player inserting digits into bingo card, system will show which card haven't been choose automaticaly.");
		System.out.println(" 4. Human Player can view their bingo card and/or other's bingo card.");
		System.out.println(" 5. Human and machine player can automative generate bingo card.");
		System.out.println("\n >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("Insert digit");
		System.out.println("1. Go to Next Page");
		System.out.println("2. Exit about");
		System.out.println(" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.print("Enter one digit between 1 to 2: ");
		int nextPage=scanner.nextInt();
		
		if(nextPage==1) {
		System.out.println("\n >>>>>>>>>>>>>>>>>>>ABOUT<<<<<<<<<<<<<<<<<<<<");
		System.out.println("\n >>> The Second Game Mode is Customize bingo <<<");
		System.out.println("\n >>> >>> RULE <<< <<<\n");
		System.out.println(" 1. same as bingo one to twen");
		System.out.println(" 2. there is only one player which insert twenty-five "
				+ "contents inside the bingo cards.");
		System.out.println(" 3. Three ways to sort the twenty-five digits into the bingo card");
		System.out.println("	  3.1 Sort in ascending order one to twenty-five");
		System.out.println("	  3.2 Sort randomly by machine");
		System.out.println("	  3.3 Human insert twenty-five digits mannually");
		System.out.println(" 4. the player need to achieve, attend or realize something inside the contents.");
		System.out.println(" 5. either human or machine help to select a digit or draw a digit");
		System.out.println("      5.1 human select what have been accomplish.");
		System.out.println("      5.2 Machine draw a digit for human player to accomplish.");
		System.out.println("\n EXAMPLE 1 - to-do-list\n");
		System.out.println(" content 1: exercise 30 minits");
		System.out.println(" content 2: read book 40 minits");
		System.out.println(" content 3: nap 30 minits");
		System.out.println(" content 4: drink 500ml of water");
		System.out.println(" content 5: watch youtube 20 minits");
		System.out.println(" ...\n");
		System.out.println(" EXAMPLE 2 - Monthly-Goal\n");
		System.out.println(" content 1: finish project 1");
		System.out.println(" content 2: finish project 2");
		System.out.println(" content 3: finish short course");
		System.out.println(" content 4: finish tv series");
		System.out.println(" content 5: learn new hobby");
		System.out.println(" ...\n");
		System.out.println(" EXAMPLE 3 and 4 can find the samples inside the system.");
		System.out.println(" EXAMPLE 3 - Social-distencing-list");
		System.out.println(" EXAMPLE 4 - Self-care-list");
		System.out.println("\n >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("Insert digit");
		System.out.println("1. Go to Next Page");
		System.out.println("2. Exit about");
		System.out.println(" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.print("Enter one digit between 1 to 2: ");
		nextPage=scanner.nextInt();
		if(nextPage==1) {
		System.out.println("\n >>>>>>>>>>>>>>>>>>>ABOUT<<<<<<<<<<<<<<<<<<<<\n");
		System.out.println(" Symbol in this system");
		System.out.println(" >>>>>>>>>>>>>>>>>>>>>>> mean process or player need to input something");
		System.out.println(" --- --- --- --- --- --- mean component of bingo board");
		System.out.println(" ## ## ## ## ## ## ## ## mean digit draw or selected ");
		System.out.println(" +++++++++++++++++++++++ mean one round");
		System.out.println(" >>>>>>>>        <<<<<<< mean emphasize words");
		}
		}
	}
}