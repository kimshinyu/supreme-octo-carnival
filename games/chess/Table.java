package games.chess;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

///things to do
//movePiece
//checkedKing
//isValidMove
//change getInput to getInputAndMove

class Table{// will do a version with a matrix, and my objects will be the squares
	private Square[][] table;
	private ArrayList<String> log;
	private static Scanner input = new Scanner(System.in);
	private static int logCount = 0;

	public Table(){//initiate new table	//DONEdone
		this.log = new ArrayList<String>(); //new log
		this.table = new Square[8][8]; //new table
		int builderColour = 0; //0 for black to start//create pieces //set colour to build
		for(int rank = 0; rank < 8; rank ++){		//iterate by rank //I could do something like table.lenght() and table[i].lenght() and stuff, but I want it not to be different from 8 so whatever
			if(rank==6 || rank == 7){builderColour = 1;} //change colour to build //i'm guessing the colour will be mantained for rank = 7//1 for white
			for(int file = 0; file < 8; file ++){	//iterate by file
				switch(rank){			//changing the type to build defined by rank
					
					case 0: case 7:			//make pieces with classes
						switch(file){	//changing the type to build defined by file
							case 0: case 7: 	//make rook
								this.table[rank][file] = new Square(SquareType.ROOK, builderColour);
								break;
								
							case 1: case 6: 	//make knight
								this.table[rank][file] = new Square(SquareType.KNIGHT, builderColour);
								break;
								
							case 2: case 5: 	//make bishop
								this.table[rank][file] = new Square(SquareType.BISHOP, builderColour);
								break;
								
							case 3: 			//make queen
								this.table[rank][file] = new Square(SquareType.QUEEN, builderColour);
								break;
								
							case 4: 			//make king
								this.table[rank][file] = new Square(SquareType.KING, builderColour);
								break;
								
							default:			//in case of unexpected error
							System.out.println("There was an error in making pieces with classes.");
						}
						break;
						
					case 1: case 6:		//make pawns
						this.table[rank][file] = new Square(SquareType.PAWN, builderColour);
						break;
						
					case 2: case 3: 	//make EMPTY squares
					case 4: case 5: 	//make EMPTY squares
						this.table[rank][file] = new Square(SquareType.EMPTY, -1);
						break;
						
					default:			//in case of unexpected error
					System.out.println("There was an error in making pieces.");
				}
			}
		}
	}

	private int getInput(String s){
		System.out.println("Please enter the " + s + ": ");
		while(!input.hasNextInt()){
			String text = input.next();
			if("table".equals(text)){
				printTable();
			}
			if("log".equals(text)){
				printLog();
			}
			System.out.println("Please enter the " + s + ": ");
		}
		int result = input.nextInt();
		return result;
	}
	
	
	public void getInputAndMove(int colour){           //donedone

		int rankFrom = getInput("Vertical Position (RankFrom)");
		int fileFrom = getInput("Horizontal Position (FileFrom)");
		
		if( !inTable(rankFrom) || !inTable(fileFrom) || 
				SquareType.EMPTY == this.table[rankFrom][fileFrom].getType() || 
					this.table[rankFrom][fileFrom].getColour() != colour){
			
			//check if From data corresponds to correct colour 	&& not empty

			System.out.println("Please enter a correct piece to move.");
			System.out.println("Let's try it again.");
			
			getInputAndMove(colour);
			
		}else{
			
			System.out.println("You, (" + (colour == 0? "Black": "White") + "), are playing your " + table[rankFrom][fileFrom].getType() + ".");
			
			int rankTo = getInput("Vertical Position (RankTo)");
			int fileTo = getInput("Horizontal Position (FileTo)");
			
			if(inTable(fileTo) && inTable(rankTo) && //movimiento dentro de la tabla
					!(rankFrom == rankTo && fileFrom == fileTo) && //me estoy moviendo
						isValidMove(rankFrom,rankTo,fileFrom,fileTo)){ //el movimiento es válido
				movePiece(rankFrom,rankTo,fileFrom,fileTo);
			}
			else{
				System.out.println("A problem has ocurred with the validation of the movement.");
				System.out.println("Please enter again the information.");
				this.getInputAndMove(colour);
			}
		}
	}
 	
	public boolean checkedKing(){  //Returns true if there is a checked king  !!!!!!!!! FOR NOW IT RETURNS ONLY IF ONE OF THE KINGS DIES
		int kingCount = 0;
		for(Square[] rank : table){
			for(Square s : rank){
				kingCount = kingCount + (SquareType.KING == s.getType()?1:0);
			}
		}
		return kingCount == 1;
	}

	public void printTable(){//shows current state of the table  //DONEDONE
	    // Loop through all rows //taken from outside https://www.geeksforgeeks.org/print-2-d-array-matrix-java/
		System.out.println("[\tF0\t,\tF1\t,\tF2\t,\tF3\t,\tF4\t,\tF5\t,\tF6\t,\tF7\t]");
		int i = 0;
	    for (Square[] rank : this.table) {
	        // converting each row as string 
	        // and then printing in a separate line 
	    	System.out.print("R"+i);
	        System.out.println(Arrays.toString(rank));
	        i++;
		} 
	}
	
	public void printLog(){//prints out log//DONEDONE
		System.out.println(this.log.isEmpty()? "Log is empty.": this.log);
	}
	
	
	
	private void movePiece(int rankFrom,int rankTo,int fileFrom,int fileTo){//do everything necesary for movement						//!!!!!!!!!!!!!!!!!!
		Square fromSquare = this.table[rankFrom][fileFrom];
		Square toSquare = this.table[rankTo][fileTo];//if destination is empty, copy in TO and destroy in FROM 	//log movement		!!!!
		System.out.println(this.table[rankTo][fileTo].getType() == SquareType.EMPTY?
				"Your " + fromSquare.getType() + " has moved to " + rankTo + ":" + fileTo + ".":
					"Your " + fromSquare.getType() + " from square " + rankFrom + ":" + fileFrom + " has eaten the enemy " + toSquare.getType() + " from square " + rankTo + ":" + fileTo + ".");
		if(canRankUpPawn(fromSquare, rankTo)){ 				  //if PAWN&finalRank, check for change (ask for input) 	 //log movement											!!!!
			rankUpPawn(rankFrom,rankTo,fileFrom,fileTo);
			log.add("Pawn to " + fromSquare.getType() + "; ");
		}
		log.add(logCount++ + ". " + (fromSquare.getColour() == 0?"Black":"White") + fromSquare.getType() + " - " + rankFrom + ":" + fileFrom + " to " + rankTo + ":" + fileTo + "  \n");
		toSquare.setColour(fromSquare.getColour());
		toSquare.setType(fromSquare.getType());
		fromSquare.setType(SquareType.EMPTY);
		fromSquare.setColour(-1);
	}
	
	private boolean canRankUpPawn(Square fromSquare, int rankTo){
		return fromSquare.getType() == SquareType.PAWN && ((fromSquare.getColour() == 0 && rankTo == 7) || (fromSquare.getColour() == 1 && rankTo == 0));
	}
	
	private void rankUpPawn(int rankFrom,int rankTo,int fileFrom,int fileTo){
		Square fromSquare = this.table[rankFrom][fileFrom];
	    System.out.println("Your pawn has adquired a rank up! Please enter the desired rank: (QUEEN,ROOK,BISHOP,KNIGHT)");
		SquareType newRank = SquareType.EMPTY;
		while(newRank == SquareType.EMPTY || newRank == SquareType.KING || newRank == SquareType.PAWN){
			newRank = SquareType.valueOf(input.next());
			if(newRank == SquareType.EMPTY || newRank == SquareType.KING || newRank == SquareType.PAWN){
				System.out.println("Please enter a valid option (QUEEN,ROOK,BISHOP,KNIGHT): ");
			}else{
		        fromSquare.setType(newRank);
		        System.out.println("Your pawn has ranked up to a " + newRank + "!");
			}
		}
	}
	
	private boolean isValidMove(int rankFrom,int rankTo,int fileFrom,int fileTo){ //   !!!!!!!!!!!!!!!!!!!!!!!! //TO DO: implement against king suicide	
		
		if(areSameColour(rankFrom, rankTo, fileFrom, fileTo)){
			System.out.println("Invalid move. Pieces are of the same team.");
			return false;
		}
		switch(this.table[rankFrom][fileFrom].getType()){
			case PAWN:				//define if move valid for type																				!!!!
				//three cases: anywhere one step forward
								//starting position two steps forward
								//any position, enemy on diagonal forward one square of distance
				System.out.println("You have tried to move your " + this.table[rankFrom][fileFrom].getType() + ".");
				return 	((this.table[rankFrom][fileFrom].getColour() == 0
						&& ((rankFrom == 1 && rankTo == 3 && fileFrom == fileTo && table[2][fileFrom].getType() == SquareType.EMPTY) 
							|| (fileFrom == fileTo && rankTo-rankFrom == 1 && table[rankTo][fileTo].getType() == SquareType.EMPTY)
							|| (Math.abs(fileFrom-fileTo) == 1 && rankTo-rankFrom == 1 && areEnemies(rankFrom, rankTo, fileFrom, fileTo))
							))
						|| 
						(this.table[rankFrom][fileFrom].getColour() == 1 
						&& ((rankFrom == 6 && rankTo == 4 && fileFrom == fileTo && table[5][fileFrom].getType() == SquareType.EMPTY) 
							|| (fileFrom == fileTo && rankFrom-rankTo == 1 && table[rankTo][fileTo].getType() == SquareType.EMPTY)
							|| (Math.abs(fileFrom-fileTo) == 1 && rankFrom-rankTo == 1 && areEnemies(rankFrom, rankTo, fileFrom, fileTo))
							))
						);
			
			case ROOK:				//define if move valid for type																				!!!!
				System.out.println("You have tried to move your " + this.table[rankFrom][fileFrom].getType() + ".");
				return (((rankFrom == rankTo) && noHorizontalBlockage(rankFrom, fileFrom, fileTo))
				|| ((fileFrom == fileTo) && noVerticalBlockage(rankFrom, rankTo, fileFrom)));
			
			case KNIGHT:			//define if move valid for type																				!!!!
				System.out.println("You have tried to move your " + this.table[rankFrom][fileFrom].getType() + ".");
				return (Math.abs(rankFrom - rankTo) == 1 && Math.abs(fileFrom - fileTo) == 2) || (Math.abs(rankFrom - rankTo) == 2 && Math.abs(fileFrom - fileTo) == 1);
			
			case BISHOP:			//define if move valid for type																				!!!!
				System.out.println("You have tried to move your " + this.table[rankFrom][fileFrom].getType() + ".");
				return ((Math.abs(rankFrom - rankTo) == Math.abs(fileFrom - fileTo)) && noDiagonalBlockage(rankFrom, rankTo, fileFrom, fileTo));
			
			case QUEEN:				//define if move valid for type																				!!!!
				System.out.println("You have tried to move your " + this.table[rankFrom][fileFrom].getType() + ".");
				return (
						((Math.abs(rankFrom - rankTo) == Math.abs(fileFrom - fileTo)) && noDiagonalBlockage(rankFrom, rankTo, fileFrom, fileTo)) //se mueve diagonalmente
						|| (
								((rankFrom == rankTo) && noHorizontalBlockage(rankFrom, fileFrom, fileTo)) //se mueve horizontalmente
								|| ((fileFrom == fileTo) && noVerticalBlockage(rankFrom, rankTo, fileFrom)) //se mueve verticalmente
							)
						);
			
			case KING:				//define if move valid for type																				!!!!
				System.out.println("You have tried to move your " + this.table[rankFrom][fileFrom].getType() + ".");
				return Math.abs(rankFrom - rankTo) <= 1 && Math.abs(fileFrom - fileTo) <= 1;
				
			default:
				System.out.println("Error in type movement validation.");			//define error sysout		
				return false; //si no toma ningun tipo aceptable
		}
	}
	
	private boolean noHorizontalBlockage(int rank, int fileFrom, int fileTo){
		boolean result = !(fileFrom == fileTo);
		for(int i = 1 + (fileTo < fileFrom?fileTo:fileFrom); i < (fileTo < fileFrom?fileFrom:fileTo) ; i++){
			result = result && SquareType.EMPTY == this.table[rank][i].getType();
		}
		System.out.println(result?null:"Horizontal movement error.");
		return result;
	}
	
	private boolean noVerticalBlockage(int rankFrom, int rankTo, int file){
		boolean result = !(rankFrom == rankTo);
		for(int i = 1 + (rankTo < rankFrom?rankTo:rankFrom); i < (rankTo < rankFrom?rankFrom:rankTo) ; i++){
			result = result && SquareType.EMPTY == this.table[i][file].getType();
		}
		System.out.println(result?null:"Vertical movement error.");
		return result;
	}
	
	private boolean noDiagonalBlockage(int rankFrom,int rankTo,int fileFrom,int fileTo){
		boolean result = !(rankFrom == rankTo && fileFrom == fileTo);
			boolean situation = 0 > (rankFrom - rankTo)*(fileFrom - fileTo);
			if(situation){
				for(int i = 1 ; i < Math.abs(rankFrom - rankTo); i++){
					result = result && SquareType.EMPTY == (rankFrom < rankTo? this.table[rankFrom + i][fileFrom - i].getType(): this.table[rankFrom - i][fileFrom + i].getType());
				}
			}else{
				for(int i = 1 ; i < Math.abs(rankFrom - rankTo); i++){
					result = result && SquareType.EMPTY == (rankFrom < rankTo? this.table[rankFrom + i][fileFrom + i].getType(): this.table[rankFrom - i][fileFrom - i].getType());
				}
			}
		System.out.println(result?null:"Diagonal movement error.");
		return result;
	}
	
	private boolean inTable(int position){
		return !(position < 0 || position > 7);
	}
	
	private boolean areEnemies(int rankFrom,int rankTo,int fileFrom,int fileTo){
		return table[rankFrom][fileFrom].getType() != SquareType.EMPTY &&
				table[rankTo][fileTo].getType() != SquareType.EMPTY &&
				Math.abs(this.table[rankFrom][fileFrom].getColour() - this.table[rankTo][fileTo].getColour()) == 1;
	}
	
	private boolean areSameColour(int rankFrom,int rankTo,int fileFrom,int fileTo){
		return (this.table[rankFrom][fileFrom].getColour() - this.table[rankTo][fileTo].getColour()) == 0;
	}
	
}


















