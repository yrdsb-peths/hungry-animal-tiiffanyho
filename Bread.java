import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Bread extends Food
{
    /**
     * Act - do whatever the Bread wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int speed = 1;
    
    public Bread(){
        super(1);
    }
    
    public void act()
    {
        down(speed);
    }
    
    public void setSpeed(int level)
    {
        this.speed = level + 2;
    }
}
