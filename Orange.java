import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Orange extends Food
{
    /**
     * Act - do whatever the Orange wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int speed = 3;
    public Orange() 
    {
        super(10);
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
