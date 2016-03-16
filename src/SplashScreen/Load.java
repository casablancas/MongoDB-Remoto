/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SplashScreen;

import javax.swing.JProgressBar;

/**
 *
 * @author Alejandro
 */
public class Load extends Thread{
    
    JProgressBar progress;

    public Load(JProgressBar progress) {
        super();
        this.progress = progress;
    }

    @Override
    public void run() {
        
        for(int i=1; i<=100; i++)
        {
            progress.setValue(i);
            pause(25);
        }
    }
    
    public void pause(int miliSecond)
    {
        try
        {
            Thread.sleep(miliSecond);
        }catch(Exception e)
        {
        
        }
    }
}
