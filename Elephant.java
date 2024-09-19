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
    public void act()
    {
        // Add your action code here.
        if(Greenfoot.isKeyDown("left"))
        {
            move(-1);
        } 
        else if(Greenfoot.isKeyDown("right"))
        {
            move(1);
        }
        eat();
    }
    
    
    /**
     * Eat the bread and spawn new bread once eaten.
     */
    public void eat()
    {
        if(isTouching(Bread.class))
        {
            removeTouching(Bread.class);
            MyWorld world = (MyWorld) getWorld();
            world.createBread();
            world.increaseScore();
        }
    }
}
