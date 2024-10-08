import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Hero.
 * 
 * @author Tiffany 
 * @version Sep 2024
 */
public class Elephant extends Actor
{
    /**
     * Act - do whatever the Elephant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootSound eatingSound = new GreenfootSound("eating.mp3");
    GreenfootImage[] idleRight = new GreenfootImage[8];
    GreenfootImage[] idleLeft = new GreenfootImage[8];
    //direction elephant is facing
    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    /**
     * constructor - the code that gets run one time when object is created
     */
    public Elephant()
    {
        for(int i = 0; i < 8; i++)
        {
            idleRight[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleRight[i].scale(80, 80);
        }
        
        for(int i = 0; i < idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(80, 80);
        }
        
        //Initial elephant image
        setImage(idleRight[0]);
        
        int imageIndex = 0;
    }
    
    /**
     * animate the elephant
     */
    int imageIndex = 0;
    public void animateElephant()
    {
        if(animationTimer.millisElapsed() < 190)
        {
            return;
        }
        animationTimer.mark();
        if(facing.equals("right"))
        {
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;
        }
        else
        {
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
    }
    
    public void act()
    {
        // Add your action code here.
        if(Greenfoot.isKeyDown("left"))
        {
            move(-4);
            facing = "left";
        } 
        else if(Greenfoot.isKeyDown("right"))
        {
            move(4);
            facing = "right";
        }
        checkFoodCollision();
        
        //Animate the elephant
        animateElephant();
        
    }
    
    
    /**
     * Eat the bread and spawn new bread once eaten.
     */
    public void checkFoodCollision()
    {
        Actor actor = getOneIntersectingObject(Food.class);
        if(actor !=null)
        {
            Food food = (Food) actor;
            MyWorld world = (MyWorld) getWorld();
            
            world.increaseScore(food.value);
            getWorld().removeObject(food);
            world.createFood();
        }
    }
}
