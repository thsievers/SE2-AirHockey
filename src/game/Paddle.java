package game;

import java.awt.*;

import main.Entity;
import main.Game;
import main.Handler;

public class Paddle extends Entity {
   private Dimension mousePosition, paddlePosition, screenDimensions;
   private int width, height;
   private boolean isLeft, isRight;

    public Paddle(Handler handler, float x,float y,int width,int height, boolean isLeft, boolean isRight){
        super(handler, x, y);
        this.isLeft = isLeft;
        this.isRight = isRight;
        
        screenDimensions = Toolkit.getDefaultToolkit().getScreenSize();
        
        this.width = width;
        this.height = height;
        //paddle hitbox
        this.hitBox = new Rectangle((int)x,(int)y,width,height);
    }
    

    @Override
    public void tick() {
        //make a square around the mouse and see if it collides with the left paddle, then if left is pressed, change its x and y according
        //to mouse position
        mousePosition = new Dimension(handler.getMouseManager().getMouseX(),handler.getMouseManager().getMouseY());
        paddlePosition = new Dimension((int)x,(int)y);
        if(handler.getGame().getMouseManager().isLeftClicked()&&this.isLeft == true){
            this.x = handler.getMouseManager().getMouseX();
            this.y = handler.getMouseManager().getMouseY();
            this.hitBox.setRect(this.x, this.y, width, height);
            
        }
        else if(handler.getGame().getMouseManager().isRightClicked()&&this.isLeft == true){
        	this.x = screenDimensions.width/5;
        	this.y = screenDimensions.height/2;
        }
        // TODO Auto-generated method stub

    }

    @Override
	public void render(Graphics g) {
        
        //g.fillOval((int)x,(int) y, 55,55);
        //this code is here to show mouse functionality with animation
        g.setColor(Color.black);
        g.fillOval((int)x-25,(int)y-25,width,height);
		
	}


	@Override
	public Rectangle getHitBox() {
		// TODO Auto-generated method stub
		return this.hitBox;
	}

  

    

    
    
}
