import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author Tiffany
 * @version September 2024
 */
public class MyWorld extends World
{
    public static int score = 0;
    Label scoreLabel;
    int level = 1;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);
        
        //Create the elephant object
        Elephant elephant = new Elephant();
        addObject(elephant, 300, 320);
        
        //Create a label
        scoreLabel = new Label(0, 80);
        addObject(scoreLabel, 50, 50);
        
        createFood();
    }
    
    /**
     * End the game and draw "grameOver"
     * 
     */
    
    public void gameOver()
    {
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel, 300, 200);
    }
    /**
     * Increase score
     */
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
        
        if(score % 5 == 0)
        {
            level +=1;
        }
    }
    
    public void createFood()
    {
        int rand = Greenfoot.getRandomNumber(2);
        Food food;
        if(rand == 0) {
            food = new Bread();
        } else {
            food = new Orange();
        }
        int x = Greenfoot.getRandomNumber(600);
        addObject(food, x, 0);
    }
}
