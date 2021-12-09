
import java.util.*;
import javafx.scene.media.*;
import javafx.scene.paint.ImagePattern;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.animation.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.text.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.image.Image;



public class KillCorona extends Application {
    private static final int W=600, H=400; //setting dimensions for GUI Screen
    //storing paths of image assets in variables such as vaccine shooter, covid, vaccine drops
    private String corona_img_path="C:/HW7/images/covid.png"; 
    private String vaccine_img_path="C:/HW7/images/vaccine.png";
    private String drop_img_path="C:/HW7/images/drop.png";
    //creating image objects for all assets whose locations were saved in previous lines
    private Image corona_img=new Image(corona_img_path);
    private Image vaccine_img=new Image(vaccine_img_path);
    private Image drop_img=new Image(drop_img_path);

    //creating arraylists to store each vaccine drop and covid 
    private Node v;
    private ArrayList<Node> drops=new ArrayList<Node>();
    private ArrayList<Node> c=new ArrayList<Node>();

    private Group board=new Group(); //container for the screen and initializing it
    Text displayScore,displayLives; //textfields for scores and lives display

    private int Ddrop=10, modifier=100, lives= 3, score=0,Dcovid=-4, covidCount=modifier-1; //initializing game states which includes, scores, lives, factor by which we will alter covids production 

    boolean yesNorth, yesSouth,YesWest,YesEast,yesthrow; //flags to ensure shooter moving up, down, right, left and whther he is shooting or not

    @Override
    public void start(Stage stage) throws Exception{ 
        v=new ImageView(vaccine_img); //imageview for displaying vaccine shooter

        AudioClip buzzer = new AudioClip(getClass().getResource("/audio/youlose.mp3").toExternalForm()); //background music and storing it in the media player
        Media bg = new Media(getClass().getResource("/audio/backgroundMusic.mp3").toExternalForm());
        MediaPlayer mediaPlayer = new MediaPlayer(bg);

        //setting font size, style, and coordinates to display score on the screen
        displayScore=new Text(110,15,"Score: "+score);
        displayScore.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        displayScore.setFill(Color.WHITE);
        //setting font size, style, and coordinates to display remaining lives of the vaccine shooter on the screen
        displayLives=new Text(200,15,"Lives: "+lives);
        displayLives.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        displayLives.setFill(Color.WHITE);

        
        board.getChildren().addAll(v,displayScore,displayLives);//setting everyhting in the container 
                  
        moveVaccine(50,H/2); //a helper function that serves as the mover for vaccine shooter

        Image img=new Image("C:/HW7/images/bg.png"); //setting background image for the game
      
        Scene scene=new Scene(board,W,H,Color.BLACK); //setting screen color, width and height
        scene.setFill(new ImagePattern(img)); //invoking background image

        scene.setOnKeyPressed(new EventHandler<KeyEvent>(){ //handling keybord event here.
            @Override
            public void handle(KeyEvent event){ //whenever a key is pressed do the following
                switch(event.getCode()){
                    case UP: yesNorth=true; break; //if up arrow key pressed, then move up
                    case DOWN: yesSouth=true;break; //if down arrow key pressed, then move down
                    case LEFT: YesWest=true; break; //if left arrow key pressed, then move left
                    case RIGHT: YesEast=true; break; //if right arrow key pressed, then move right
                    case SPACE: if(!yesthrow){ //if space bar pressed then shoot vaccine capsule 
                        ImageView adrop=new ImageView(drop_img); //vaccine capsule sprite image view
                        Node newDrop=adrop; 
                        newDrop.relocate(v.getLayoutX()+v.getBoundsInLocal().getWidth(),v.getLayoutY()); //drop moving towards covid
                        drops.add(newDrop); //add it to the arraylist
                        board.getChildren().add(newDrop);//add it to the container in order to display 
                        yesthrow=true; //set yesthrow to true as vaccine shooter will continue shooting until space bar is kept pressed
                    } 
                    break; //default case

                }

            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>(){ //as soon as the keys are released, revert back the flags
            @Override
            public void handle(KeyEvent event){
                switch(event.getCode()){
                    case UP: yesNorth=false; break; //stop moving up
                    case DOWN: yesSouth=false;break;//stop moving down
                    case LEFT: YesWest=false; break; //stop moving left
                    case RIGHT: YesEast=false; break;  //stop moving right
                    case SPACE: yesthrow=false;break; //stop shooting vaccine
                }

            }

        });
        stage.setScene(scene);
        stage.setTitle("Kill Corona!"); //setting title for the game on the title bar
        mediaPlayer.play(); //start background music
        stage.show(); //start display

        AnimationTimer timer=new AnimationTimer(){ //it will keep the sprites moving on the scene
            @Override
            public void handle(long now){ 
                int changeX=0,changeY=0;  //variables to keep track of changing
                if(yesNorth) //if moving up flag is true then, move shooter up
                    changeY-=3;
                if(yesSouth) //if moving down flag is true then, move shooter down
                    changeY+=3;
                if(YesEast) //if moving right flag is true then, move shooter right
                    changeX+=3;
                if(YesWest) //if moving left flag is true then, move shooter left
                    changeX-=3;

                covidCount++; //increment covid count on the screen
                if(covidCount%modifier==0){ //it keeps track of the number of covid produced on the screen
                    if(modifier>20)
                        modifier--;
                    Node newcovid=new ImageView(corona_img);//covid sprite
                    newcovid.relocate(W,(int)(Math.random()*(H-newcovid.getBoundsInLocal().getHeight()))); //covid moving towards vaccine shooter
                    c.add(newcovid);//append it to the covid arraylist 
                    board.getChildren().add(newcovid); //add it to the container finally to display on screen
                }
                moveVaccine(v.getLayoutX()+changeX,v.getLayoutY()+changeY); // a mover function for the vaccine shooter
                throwDrop(Ddrop); //a helper function to determine throwing of the vaccine capsule
                moveCovid(Dcovid); //mover function for the covid
                checkHit(); //a helper function to check whether capsule has hit covid
                if(lives==0){ //if the lives of vaccine shooter finishes then finally end  the game as layer has lost.
                    mediaPlayer.stop(); //at this point, stop background music
                    buzzer.play(); //and play game over sound effect
                    Text gameover =new Text(W/2 -180,H/2,"CORONA KILLED YOU!"); //display message for game over moment
                    gameover.setFill(Color.RED);
                    gameover.setFont(Font.font("Chiller",FontWeight.BOLD,50));
                    board.getChildren().add(gameover);
                    this.stop();//stop the game
                    
                    

                }

            }
        };
        timer.start(); 
    }
    private void moveVaccine(double x, double y){ //the function is the mover function for vaccine 
        if(x>=0 && x<=150 && y>=0 && y<=H-v.getBoundsInLocal().getHeight()){  //The vaccine shooter can only move if he is within the biundaries of the screen other wise it will stop once it ahs reached the boundary
            v.relocate(x,y);
        }

    }
    private void moveCovid(int delta){ //the function is the helper function for moving covid 
        for(int i=0; i<c.size();i++){ //move all covids from right to left i.e. from production spot to the vaccine shooter side
            if(c.get(i).getLayoutX()>-c.get(i).getBoundsInLocal().getWidth()){
                c.get(i).relocate(c.get(i).getLayoutX()+delta, c.get(i).getLayoutY());
            }
            else{ //if the covid has reached boundary of the screen then remove it from the screen
                board.getChildren().remove(c.get(i));
                c.remove(i);
                lives--; //decrement live as vaccine shooter was not able to kill it 
                displayLives.setText("Lives: "+lives); //render remaining lives on screen
            }

        }
        
    }
    private void throwDrop(int delta){ //the function serves as a mover function for vaccine capsules 
        for(int i=0; i<drops.size();i++){ //for every capsule that is produced, move it from the vaccine shooter to the right side 
            if(drops.get(i).getLayoutX()<W){
                drops.get(i).relocate(drops.get(i).getLayoutX()+delta, drops.get(i).getLayoutY());
            }
            else{ //if it has reached the boundary of the screen then remove it from the screen 
                drops.remove(i); 
            }

        }
        
    }

    private void checkHit(){ //the function makes sure whether capsule has hit covid or not on the basis of the coordinates of screen
        for(int i=0;i<drops.size();i++){ //iterating over vaccine capsules that has been shooted so far
            for(int j=0; j<c.size();j++){ //iterating over covids that has been produced so far
                if(drops.get(i).getBoundsInParent().intersects(c.get(j).getBoundsInParent())){ //if vaccine drop coordinates intersects with the covid coordinates then hit has occur
                    board.getChildren().remove(c.get(j)); //hence remove that particular covid from container
                    c.remove(j); //and delete that covid from covid array list too as it has died
                    board.getChildren().remove(drops.get(i)); //and also remove the vaccine drop as it has exhausted after killing covid
                    drops.remove(i); //and delete that drop from drop array list too
                    score++; //increment score on every covid kill
                    displayScore.setText("Score: "+score); //render score on screen

                }

            }
        }
    }

    public static void main(String[] args) {
        launch(args); //launch the game
    }


}