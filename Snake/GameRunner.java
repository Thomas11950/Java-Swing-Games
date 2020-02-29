import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import javax.swing.Timer;

import java.util.*;

public class GameRunner extends JApplet implements KeyListener, ActionListener
{
	private int count = 0;
	private ArrayList<Food> foods;
    public static Random gen = new Random();
    private Snake player;
    public void init()
    {    
    	player = new Snake();
    	foods = new ArrayList<Food>();
        getContentPane().setBackground(Color.WHITE);    
        addKeyListener(this);
        setFocusable(true);
    	Timer t = new Timer(50,this);
    	t.start();
    }
    
    public void paint(Graphics g)
    {
        super.paint(g);
        setSize(500,500);
        player.draw(g);
        for(Food f:foods){
        	f.draw(g);
        }
    }

	@Override
	public void keyPressed(KeyEvent event) {
		// TODO Auto-generated method stub
		int code = event.getKeyCode();
		if(code == KeyEvent.VK_UP && !player.getDirection().equals("down")){
			player.setDirection("up");
		}
		if(code == KeyEvent.VK_DOWN&& !player.getDirection().equals("up")){
			player.setDirection("down");
		}
		if(code == KeyEvent.VK_RIGHT&&!player.getDirection().equals("left")){
			player.setDirection("right");
		}
		if(code == KeyEvent.VK_LEFT && !player.getDirection().equals("right")){
			player.setDirection("left");
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(foods.isEmpty()){
			foods.add(new Food());
		}
		player.update();
		int eaten = player.checkEat(foods);
		if(eaten != -1){
			foods.remove(eaten);
		}
		repaint();
		count++;
	}    
}
