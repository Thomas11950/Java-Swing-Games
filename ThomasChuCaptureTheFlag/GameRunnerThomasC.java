import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import javax.swing.Timer;

import java.util.*;

public class GameRunnerThomasC extends JApplet implements KeyListener, ActionListener
{
    public static Random gen = new Random();
    Timer t;
    private ArrayList<Boolean> keys = new ArrayList<Boolean>();
    BallThomasC ball1 = new BallThomasC(5, 250);
    BallThomasC ball2 = new BallThomasC(495,250);
    FlagThomasC flag1 = new FlagThomasC(480,250,10,10,20,250);
    FlagThomasC flag2 = new FlagThomasC(20,250,440,10,480,250);
    ArrayList<ObstacleThomasC> obstacles = new ArrayList<ObstacleThomasC>(){
    	{
    	add(new ObstacleThomasC(245,10,10,210));
    	add(new ObstacleThomasC(245,270,10,210));
    	add(new ObstacleThomasC(30,320,430,10));
    	add(new ObstacleThomasC(30,160,430,10));
    	}
    };
    public void init()
    {    
    	t = new Timer(10, this);
    	t.start();
    	addKeyListener(this);
    	for(int i = 0; i < 8; i++){
    		keys.add(false);
    	}
        getContentPane().setBackground(Color.WHITE);    
        addKeyListener(this);
        setFocusable(true);
    }
    
    public void paint(Graphics g)
    {
        super.paint(g);
        setSize(500,500);
        g.setColor(Color.GREEN);
        ball1.CreateBall(g);
        g.setColor(Color.cyan);
        ball2.CreateBall(g);
        g.setColor(Color.CYAN);
        flag1.drawFlag(g);
        g.setColor(Color.green);
        flag2.drawFlag(g);
        g.setColor(Color.BLACK);
        for(ObstacleThomasC o: obstacles){
        	o.draw(g);
        }
    }

	public void keyPressed(KeyEvent key) {
		
		int code = key.getKeyCode();
		if(code == KeyEvent.VK_W){
			keys.set(0, true);
		}
		else if(code == KeyEvent.VK_A){
			keys.set(1, true);
		}
		else if(code == KeyEvent.VK_S){
			keys.set(2, true);
		}

		else if(code == KeyEvent.VK_D){
			keys.set(3, true);
		}

		else if(code == KeyEvent.VK_I){
			keys.set(4, true);
		}

		else if(code == KeyEvent.VK_J){
			keys.set(5, true);
		}

		else if(code == KeyEvent.VK_K){
			keys.set(6, true);
		}

		else if(code == KeyEvent.VK_L){
			keys.set(7, true);
		}
		
	}

	public void keyReleased(KeyEvent arg0) {
		int code = arg0.getKeyCode();
		if(code == KeyEvent.VK_W){
			keys.set(0, false);
		}
		else if(code == KeyEvent.VK_A){
			keys.set(1, false);
		}

		else if(code == KeyEvent.VK_S){
			keys.set(2, false);
		}

		else if(code == KeyEvent.VK_D){
			keys.set(3, false);
		}

		else if(code == KeyEvent.VK_I){
			keys.set(4, false);
		}

		else if(code == KeyEvent.VK_J){
			keys.set(5, false);
		}

		else if(code == KeyEvent.VK_K){
			keys.set(6, false);
		}

		else if(code == KeyEvent.VK_L){
			keys.set(7, false);
		}
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		ball1.detectObstacles(obstacles);
		ball2.detectObstacles(obstacles);
		flag1.checkForFlagTouch(flag2);
		flag2.checkForFlagTouch(flag1);

		flag1.checkProximity(ball1);
		flag2.checkProximity(ball2);
		flag1.checkForTag(ball2);
		flag2.checkForTag(ball1);
		ball1.CheckForTag(ball2);
		ball2.CheckForTag(ball1);
		if(flag1.taken() && ball2.getX() < 250 && ball2.getX() > 246)
			ball2.setCanLeft(false);
		if(flag2.taken() && ball1.getX() > 250 && ball1.getX() < 254)
			ball1.setCanRight(false);
		if(flag1.taken()&&flag2.taken()&&ball2.getX() > 242 && ball2.getX() < 246)
			ball2.setCanRight(false);
		if(flag1.taken()&&flag2.taken()&&ball1.getX() < 250 && ball1.getX() > 254)
			ball1.setCanLeft(false);
		if(keys.get(0))
			ball1.MoveUp();
		if(keys.get(1))
			ball1.MoveLeft();
		if(keys.get(2))
			ball1.MoveDown();
		if(keys.get(3))
			ball1.MoveRight();
		if(keys.get(4))
			ball2.MoveUp();
		if(keys.get(5))
			ball2.MoveLeft();
		if(keys.get(6))
			ball2.MoveDown();
		if(keys.get(7))
			ball2.MoveRight();
		repaint();
	}    

}
