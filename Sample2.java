 /*
   * Objective:
  * In this day and age of advanced technology,
  * many youths have little knowledge of the traditional games their parents used to enjoy.
  * For the project, I aim to provide youths with a virtual version of this experience.
  *
  * 1.Tikam tikam:
  *
  * A traditional lottery game for children. 
  * A child buys a ticket with a randomised number on it and 
  * depending on his luck it may correspond to a prize. 
  *
  * 2.Orya-pekya-som:
  *
  * A very simple and classic hand game often played by children. 
  * Player will place his hand either palm up or palm down.
  * The player whose hand position is the odd one out wins that round.
  *
  *
  * Problem Solving:
  *
  * 1.Tikam tikam:
  *
  * Allow the user to purchase ticket and prevent them from purchasing a ticket that is unavailable.
  * At the same time, inform the user which ticket number has been purchased.
  * List out the prizes won by each ticket.
  * Do not allow the user to purchase ticket quantity exceeding quantity available.
  * At the end of the game, inform the user of the total amount spent and tickets purchased.
  *
  * 2.Orya-pekya-som:
  *
  * Allow users to choose the number of rounds they wish to play and prevent a negative number from being entered.
  * If incorrect moves are entered, player will be prompted to enter 0 or 1.
  * Only successful rounds will be counted. 
  * At the end of the game, player will be informed of the number of wins and draws.
  * 
  */



import java.util.Scanner;


public class Sample2{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Set Variables For Tikam 
        int ticketQty;
        int avaTicketQty = 101;
        double totalCost = 0;
        int totalTicket = 0;
        
        String[] tickets = new String[101];
        int[] ticketNumbers = new int[101];
        String[] prizes = new String[101];
        
        // Set Variables For Orhya Pekya Som
        int draw = 0;
        int pCountWon = 0;
        int p1CountWon = 0;
        int p2CountWon = 0;
        
        
        //Use For loop to assign tikam array prize
        
        prizes[0] = "First Prize Emo Bunny Plush (U=x=U)";
        
        for(int j=1; j< 4; j++){
        prizes[j] =  "Second Prize Crying Kitty Plush (=^;w;^=)";	
        }
        
        for(int j=4; j< 9; j++){
        prizes[j] =  "Third Prize Angry Bear Plush (*-(I)-*)";	
        }
        
        for(int j=9; j< 16; j++){
        prizes[j] = "Fourth Prize Ecstatic Puppy Plush (U^I^U)";	
        }
        
        for(int j=16; j< 31; j++){
        prizes[j] = "Fifth Prize Starstruck Piggy Plush(*(00)*)";	
        }
        
        for(int j=31; j< 61; j++){
        prizes[j] = "Special Prize Bat Plush %(=^..^=)%";	
        }

        for(int j=61; j< 101; j++){
        prizes[j] = "Consolation Prize Piggy Plush (^(oo)^)";	
        }        
        
       // Randomise Prize
       for (int i = 0; i < prizes.length; i++) {
       int rand = (int)(Math.random() * prizes.length);
       String temp = prizes[i];
       prizes[i] = prizes[rand]; 
       prizes[rand] = temp;
          }
      
          
        //ticket  
        for(int i=0;i<=100;i++)
        {
          tickets[i]="("+i+")";      
        }
        
        // Game Selection Menu
        
       System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
       System.out.println("\n Traditional Game Menu");
       System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
       System.out.println("\n 1.Play Tikam Tikam      ");
       System.out.println("\n 2.Play Orhya Pekya Som    ");
       System.out.println("\n 0.To Exit The Game     ");
       System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");  
       System.out.print("\n Select Option: "); 
       int game=input.nextInt();
       
       switch(game)
       	
       {        case 0:	
                System.out.println( " ");  
                	
                // end game
                System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
 	            System.out.println("\n Thanks For Playing");   
                System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                
                System.exit(1);
                
       case 1:        
       while(true) {


    
       // Tikam Tikam Game Menu
       
       System.out.println("\n ");
       System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
       System.out.println("\n Tikam Tikam Game Menu");
       System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
       System.out.println("\n 1.Start Playing      ");
       System.out.println("\n 2.Instructions     ");
       System.out.println("\n 3.List Of Prizes     ");
       System.out.println("\n 0.To Exit The Game    ");
       System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");  
       System.out.print("\n Select Option: "); 

       int tikam=input.nextInt();
       
       switch(tikam)
       	
       {        //Exit Game
                case 0:	
                System.out.println( " ");  
                	
                // Total cost spent on tickets & total tickets purchased
                System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("\n Total Tickets Purchased: " + totalTicket);   
                System.out.println("\n Total Amount Spent: RM" + totalCost);  	
                System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("\n Thanks For Playing");   
                System.exit(1);
                  
                //Start Game
                case 1:
                          
                
                //Input qty of ticket
                System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");	
                System.out.println("\n Price: RM10.00 per Ticket ");	
                System.out.println("\n Number of Tickets Available: " + avaTicketQty    );	
                System.out.print("\n Quantity Of Tickets You Wish To Purchase: ");
                ticketQty=input.nextInt();
                System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                
                
                
                // Tikam Tikam Available Ticket
                for(int i=0;i<=100;i++)
                {
                if((i==11)||(i==21)||(i==31)||(i==41)||(i==51)||(i==61)||(i==71)||(i==81)||(i==91))
                {
                System.out.println("\n");  
                }
                System.out.print(     tickets[i]);

                }	         
                	    
                int index;  
                	
                //Prevent buyer from buying more tickets than is avaliable	
                
                if (ticketQty > avaTicketQty) {
                System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("\n You Tried To Purchase " +ticketQty + " tickets");		
                System.out.println("\n Only " +avaTicketQty + " tickets" + " Are Avaliable For Purchase");
                System.out.println("\n Please Try Again.");
	
                }	
                //Prompt user to enter positive number of ticket	
                else if (ticketQty <=0){
                
                System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.print("Please Select A Postive Number Of Tickets");
                	
                }
                	
               else if (ticketQty <= avaTicketQty){
             
                 
                //select ticket no
                System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.print("Select Your Lucky Ticket NO. :");
                System.out.print(" ");
                
                
              
             
                for(int i=0;i<ticketQty;i++)
                {

                ticketNumbers[i]=input.nextInt();

                index=ticketNumbers[i];
               
                //Prevent a purchased ticket from being purchased again
                if (tickets[index]=="(x)"){
                	
               	//Inform user which ticket has been purchased
                System.out.println( "Ticket No. " + index + " Has Been Purchased. Please Pick Another Number.");
                }else {
                tickets[index]="(x)";
                avaTicketQty--;
              
                totalCost += 10;
                totalTicket++;
                
          
                //Print out ticket no. & prize won
                System.out.println( "Your Ticket No." + index + " : You Won "+ prizes[index]);
                }
                }     
                }break;  
                
                
                
                //Instructions
                case 2:
               	
                   System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                   System.out.println("\n Tikam Tikam Game Instructions                   ");
                   System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                   System.out.println("\n 1.Please Enter the Qty of Tickets To Purchase   ");
                   System.out.println("\n 2.Select Your Lucky Ticket Number               ");
                   System.out.println("\n 3.Win Cute Plushies !!!                         ");
                   
                   		
               break;
            
               //List Of Prizes          
               case 3:
               	
               	   System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                   System.out.println("\n Tikam Tikam Game List Of Prizes  ");
                   System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                   System.out.println("\n Prizes                                     | Qty");
                   System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                   System.out.println("\n First Prize Emo Bunny Plush (U=x=U)        | 1  ");
                   System.out.println("\n Second Prize Crying Kitty Plush (=^;w;^=)  | 3  ");
                   System.out.println("\n Fourth Prize Ecstatic Puppy Plush (U^I^U)  | 7  ");
                   System.out.println("\n Fifth Prize Starstruck Piggy Plush(*(00)*) | 15 ");
                   System.out.println("\n Special Prize Bat Plush %(=^..^=)%         | 30 ");   
                   System.out.println("\n Consolation Prize Piggy Plush (^(oo)^)     | 40 "); 
                   System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");	
                   System.out.println("\n Total                                      | 101");
                   
                   break;
              

            default:
            	   System.out.println("\n Invalid Option Entered");
            	   System.out.println("\n Please Key In 1 or 2 or 3 or 0.");
            	   break;
                }
       

        }
       
       case 2:        
       while(true) {
       	// Orhya Pekya Som Game Menu
       
       System.out.println("\n ");
       System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
       System.out.println("\n Orhya Pekya Som Game Menu");
       System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
       System.out.println("\n 1.Start Playing      ");
       System.out.println("\n 2.Instructions     ");
       System.out.println("\n 0.To Exit The Game     ");
       System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");  
       System.out.print("\n Select Option: "); 

       int orhya=input.nextInt();
       
       switch(orhya){
       		case 0:	
                System.out.println( " ");  
                	
                // Total 
                System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("\n You Won " + pCountWon + " Times.");
                System.out.println("\n Player 1 Won " + p1CountWon + " Times.");
                System.out.println("\n Player 2 Won " + p2CountWon + " Times.");
                System.out.println("\n Draws: " + draw);
                System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("\n Thanks For Playing");   
                System.exit(1);
                //instructions
                case 2:  System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("\n Orhya Pekya Som Game Instructions                   ");
                System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("\n 1.There Are Three Players In The Game   ");
                System.out.println("\n 2.You Will Be Playing Against Computer Player 1 and Computer Player 2    ");
                System.out.println("\n 3.Please Play Palm Up (0) Or Palm Down (1)");
                System.out.println("\n 4.The Odd One Out Wins");
                System.out.println("\n 5.When All Players Play The Same Hand It Ends In A Tie");
                   
                break;	
                   	
                default:
            	System.out.println("\n Invalid Option Entered");
            	System.out.println("\n Please Key In 0 or 1 or 2.");
                break;   
     
           
    case 1:
               //Input no. of rounds
                System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");	
                System.out.print("\n How Many Rounds Do You Wish To Play:  ");
                int round=input.nextInt();
                //Prompt user to key in positive number of rounds
                if(round<1){
                System.out.print("\n Please Select A Positive Number Of Rounds  ");	
                } else { for(int i=1;i<=round;i++){
    

       
    	// Generate palm
    	int comPlayer1 = (int)(Math.random() * 2);
    	int comPlayer2 = (int)(Math.random() * 2);

    	// Prompt the user to enter palm up or palm down
    	System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    	System.out.print("\n Please Select Palm Up (0), Palm Down (1): ");
    	int player = input.nextInt();

        //Prevent user from entering other options
        if (player != 0 && player != 1){
        	                   
        System.out.println("\n Invalid Option Entered");
        System.out.println("\n Please Key In 0 or 1 to Play.");
        i--;
            	
    
    }
    	else if
    	(player == 0 && comPlayer1 == 0 && comPlayer2 == 0 ){
          			System.out.println("\n You Played Palm Up.");
          			System.out.println("\n Computer Player 1 Played Palm Up.");
          			System.out.println("\n Computer Player 2 Played Palm Up.");
          			System.out.println("\n It Is A Draw");
          			draw++;
          		  }
          			
        		else if (player == 1 && comPlayer1 == 0 && comPlayer2 == 0){
        			System.out.println("\n You Played Palm Down.");
          			System.out.println("\n Computer Player 1 Played Palm Up.");
          			System.out.println("\n Computer Player 2 played palm Up.");
          			System.out.println("\n You Won the game");
          			
          			pCountWon++;
          			;    
        		 }
        			
        		else if (player == 1 && comPlayer1 == 0 && comPlayer2 == 1){
        			System.out.println("\n You played palm down.");
          			System.out.println("\n Computer Player 1 played palm up.");
          			System.out.println("\n Computer Player 2 played palm down.");
          			System.out.println("\n Player 1 Wins the game");
          			
          		    p1CountWon++;
          		     
        			
        		}
        		    else if (player == 0 && comPlayer1 == 0 && comPlayer2 == 1){
        			System.out.println("\n You played palm up.");
          			System.out.println("\n Computer Player 1 Played Palm Up.");
          			System.out.println("\n Computer Player 2 Played Palm Down.");
          			System.out.println("\n Player 2 Wins The Game");
          			
          			p2CountWon++;
          		
          			
        			
        		}
          		
        
      	
	               else if (player == 0 && comPlayer1 == 1 && comPlayer2 == 0){
          			System.out.println("\n You Played Palm Up.");
          			System.out.println("\n Computer Player 1 Played Palm Down.");
          			System.out.println("\n Computer Player 2 Played Palm Up.");
          			System.out.println("\n Player 1 Wins The Game");
          		
          			p1CountWon++;
          		
          			}
          			
        		else if (player == 1 && comPlayer1 == 1 && comPlayer2 == 0){
        			System.out.println("\n You played palm down.");
          			System.out.println("\n Computer Player 1 Played Palm Down.");
          			System.out.println("\n Computer Player 2 Played Palm Up.");
          			System.out.println("\n Player 2 Wins The Game");
          			
          			p2CountWon++;
          			   
        		 }
        			
        		else if (player == 1 && comPlayer1 == 1 && comPlayer2 == 1){
        			System.out.println("\n You Played Palm Down.");
          			System.out.println("\n Computer Player 1 Played Palm Down.");
          			System.out.println("\n Computer Player 2 Played Palm Down.");
          			System.out.println("\n It Is A Draw");
          			draw++;
          			
        		}
        		    else if (player == 0 && comPlayer1 == 1 && comPlayer2 == 1){
        			System.out.println("\n You played palm up.");
          			System.out.println("\n Computer Player 1 Played Palm Down.");
          			System.out.println("\n Computer Player 2 Played Palm Down.");
          			System.out.println("\n You Won The Game");
          			
          			pCountWon++;
          		    

        		}
       	
       	      
       	 
                   	
       	
       

        	

        			
                }      
                
      	}
              
     

    }

       	      

                
       }
   default:System.out.println("\n Invalid Option Entered");
           System.out.println("\n Please Key In 0 Or 1 Or 2 To Play.");
   
    }
  

      	
        
    
    }



}