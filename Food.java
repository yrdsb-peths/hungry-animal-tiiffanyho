import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public abstract class Food extends Actor {
    int value;
    
    public Food(int value) {
        this.value = value;
    }
    
    public void down(int speed) 
    {
        setLocation(getX(), getY() + 4);
        
        MyWorld world = (MyWorld) getWorld();
        if(getY() >= world.getHeight())
        {
            world.gameOver();
            world.removeObject(this);
        }
    }
}
