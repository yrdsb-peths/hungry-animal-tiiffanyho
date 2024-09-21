import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Food
 * 
 * @author Tiffany 
 * @version Sep 2024
 */
public class Bread extends Actor
{
    /**
     * Act - do whatever the Bread wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int speed = 1;
    
    public void act()
    {
        //Apple falls downwards.
        int x = getX();
        int y = getY() + 2;
        setLocation(x, y);
        
        //Remove apple and draw game over when apple gets to bottom
        MyWorld world = (MyWorld) getWorld();
        if(getY() >= world.getHeight())
        {
            world.gameOver();
            world.removeObject(this);
        }
    }
    
    public void setSpeed(int spd)
    {
        speed = spd;
    }
}
