/*************************************************
Készítette: Mester Gábor
http://avvoltoio.extra.hu/
*************************************************/
import java.io.*;
import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.lang.Runnable.*;
import java.util.Timer;
import java.util.TimerTask;
import java.io.IOException;
public class amobacanvas
    extends Canvas implements Runnable
{ //main nyit
private Image dbImage;
private Graphics dbg;
Image    backBuffer;
Graphics    backBufferGraphics;

private boolean vRenderLoop;
private amoba amobaa;
private Display display;
int cv, cv1, cv2, cv3, cv4, maxo, maxx, maxy, sor, osz;
int currentLine;
boolean enemy, startGame;
int jall; //játék állapot fut, nyert, vesztett, döntetlen
int i, j, muveveg;
int sx, sy;
private Image offscreen = null;
Image backImage, startImage, xplayer, o, ures, restart, win, lost, nowin, empty, selectimage, selectrestart, selecto, selectx;
public static int[][] tabla, prior, select;

public amobacanvas() { //cnyit
try{
		//System.out.println("CANVAS");
		startGame=true;
		setFullScreenMode(true);
		tabla = new int[22][22];
		prior = new int[22][22];
		select = new int[9][10];
		maxy=0;
		maxo=-3;
		maxx=0;
		jall=0;
		muveveg=1;
		currentLine = 10;
		enemy=false;
		for(cv=0; cv<22; cv++){//
					for(cv2=0; cv2<22; cv2++){//
						tabla[cv][cv2]=0;
					}//
			}//
		for(cv=0; cv<22; cv++ ){//
						for(cv2=0; cv2<22; cv2++){//
							prior[cv][cv2]=0;
						}//
			}//
		for(cv=0; cv<9; cv++ ){//
						for(cv2=0; cv2<10; cv2++){//
							select[cv][cv2]=0;
						}//
			}//
		select[5][5]=1;
		sx=0; sy=0;
		cv1=0;
		backImage = Image.createImage( "/back.png");
		xplayer = Image.createImage( "/x.png");
		o = Image.createImage( "/0.png");
		ures = Image.createImage( "/ures.png");
		restart = Image.createImage( "/restart.png");
		win = Image.createImage( "/win.png");
		lost = Image.createImage( "/lost.png");
		nowin = Image.createImage( "/nowin.png");
		empty = Image.createImage( "/empty.png");
		selectimage = Image.createImage( "/select.png");
		selecto = Image.createImage( "/selecto.png");
		selectx = Image.createImage( "/selectx.png");
		startImage = Image.createImage( "/avvo128.png");
	selectrestart = Image.createImage( "/restart2.png");
	if( !isDoubleBuffered() ){
	            offscreen = Image.createImage( 128, 160 );
	        }
	

      new Thread(this).start();
      //run();
    }catch(Exception e){
      e.printStackTrace();
    }
	//super(true);
	//this.amobaa = amobaa;
	//display = Display.getDisplay(amobaa);
	//vRenderLoop=false;
	}  //czár



/*
// init - method is called the first time you enter the HTML site with the applet
public void init() { //initnyit
	tabla = new int[22][22];
	prior = new int[22][22];
	select = new int[9][10];
	maxy=0;
	maxo=-3;
	maxx=0;
	jall=0;
	muveveg=1;
	currentLine = 10;
	enemy=false;
	for(cv=0; cv<22; cv++){//
				for(cv2=0; cv2<22; cv2++){//
					tabla[cv][cv2]=0;
				}//
		}//
	for(cv=0; cv<22; cv++ ){//
					for(cv2=0; cv2<22; cv2++){//
						prior[cv][cv2]=0;
					}//
		}//
	for(cv=0; cv<9; cv++ ){//
					for(cv2=0; cv2<10; cv2++){//
						select[cv][cv2]=0;
					}//
		}//
	select[0][0]=1;
	sx=0; sy=0;
	cv1=0;
	try
      {
	xplayer = Image.createImage( "/x.png");
	o = Image.createImage( "/0.png");
	ures = Image.createImage( "/ures.png");
	restart = Image.createImage( "/restart.png");
	win = Image.createImage( "/win.png");
	lost = Image.createImage( "/lost.png");
	nowin = Image.createImage( "/nowin.png");
	empty = Image.createImage( "/empty.png");
	selectimage = Image.createImage( "/select.png");
	selectrestart = Image.createImage( "/restart2.png");
	} catch(IOException exp)
	      {
	          System.out.println("Image not found" + exp.getMessage());
      }
	}				   //init zár
*/
// start - method is called every time you enter the HTML - site with the applet
public void start() {//
	// define a new thread
	vRenderLoop=true;
	Thread th = new Thread (this);
	// start this thread
	th.start ();
	}		 //start zár
// stop - method is called if you leave the site with the applet
public void stop() {
	vRenderLoop=false;
	}//

// destroy method is called if you leave the page finally (e. g. closing browser)

public void keyPressed(int keyCode) {				//input nyit
//System.out.println("KEY");
	//if(enemy==false){
	if(startGame==false){
	boolean kcode=false;
	int bill = getGameAction(keyCode);
	switch(keyCode){
		case 49: for(cv=0; cv<9; cv++ ){	   //for1 nyit
								for(cv2=0; cv2<10; cv2++){ //for2 nyit
									if(select[cv][cv2]==1){ //
									sx=cv; sy=cv2;			}//
								}  //for2 zár
					}	 //for1 zár
				if(sx>0 && sy>0) { select[sx][sy]=0; select[sx-1][sy-1]=1;
				}
				kcode=true;
		break;
		case 51: for(cv=0; cv<9; cv++ ){					 //for1 nyit
									for(cv2=0; cv2<10; cv2++){	//for2 nyit
										if(select[cv][cv2]==1){  //
										sx=cv; sy=cv2;		   }//
									}	//for2 zár
						}	 //for1 zár
					if(sx<8 && sy>0) { select[sx][sy]=0; select[sx+1][sy-1]=1;
					}//
				  kcode=true;
		break;
		case 55: for(cv=0; cv<9; cv++ ){	   //for1 nyit
								for(cv2=0; cv2<10; cv2++){ //for2 nyit
									if(select[cv][cv2]==1){ //
									sx=cv; sy=cv2;			}//
								}  //for2 zár
					}	 //for1 zár
				if(sx>0 && sy<9) { select[sx][sy]=0; select[sx-1][sy+1]=1;
				}
				kcode=true;
		break;
		case 57: for(cv=0; cv<9; cv++ ){	   //for1 nyit
								for(cv2=0; cv2<10; cv2++){ //for2 nyit
									if(select[cv][cv2]==1){ //
									sx=cv; sy=cv2;			}//
								}  //for2 zár
					}	 //for1 zár
				if(sx<8 && sy<9) { select[sx][sy]=0; select[sx+1][sy+1]=1;
				}
				kcode=true;
		break;

	}
	switch(bill){
		case LEFT: for(cv=0; cv<9; cv++ ){	   //for1 nyit
					for(cv2=0; cv2<10; cv2++){ //for2 nyit
						if(select[cv][cv2]==1){ //
						sx=cv; sy=cv2;			}//
					}  //for2 zár
		}	 //for1 zár
	if(sx>0) { select[sx][sy]=0; select[sx-1][sy]=1;
	}  //
	break;
	case RIGHT:
	//System.out.println("KEY_right");
		for(cv=0; cv<9; cv++ ){					 //for1 nyit
						for(cv2=0; cv2<10; cv2++){	//for2 nyit
							if(select[cv][cv2]==1){  //
							sx=cv; sy=cv2;		   }//
						}	//for2 zár
			}	 //for1 zár
		if(sx<8) { select[sx][sy]=0; select[sx+1][sy]=1;
		}//
	break;
	case UP:
		for(cv=0; cv<9; cv++ ){//
						for(cv2=0; cv2<10; cv2++){//
							if(select[cv][cv2]==1){//
							sx=cv; sy=cv2;		   }//
						}//

			}//
		if(sy>0) { select[sx][sy]=0; select[sx][sy-1]=1;
		}//
		break;
	case DOWN:
		for(cv=0; cv<9; cv++ ){//
						for(cv2=0; cv2<10; cv2++){//
							if(select[cv][cv2]==1)
							{sx=cv; sy=cv2;
					}//
					}//

			}//
		if(sy<9) { select[sx][sy]=0; select[sx][sy+1]=1;
		}//
	break;
	case GAME_A: if(kcode==false){for(cv=0; cv<9; cv++ ){	   //for1 nyit
					for(cv2=0; cv2<10; cv2++){ //for2 nyit
						if(select[cv][cv2]==1){ //
						sx=cv; sy=cv2;			}//
					}  //for2 zár
		}	 //for1 zár
	if(sx>0 && sy>0) { select[sx][sy]=0; select[sx-1][sy-1]=1;
	}}
	break;
	case GAME_B: if(kcode==false){for(cv=0; cv<9; cv++ ){					 //for1 nyit
						for(cv2=0; cv2<10; cv2++){	//for2 nyit
							if(select[cv][cv2]==1){  //
							sx=cv; sy=cv2;		   }//
						}	//for2 zár
			}	 //for1 zár
		if(sx<8 && sy>0) { select[sx][sy]=0; select[sx+1][sy-1]=1;
		}//
		}
		break;
	case GAME_C: if(kcode==false){for(cv=0; cv<9; cv++ ){	   //for1 nyit
					for(cv2=0; cv2<10; cv2++){ //for2 nyit
						if(select[cv][cv2]==1){ //
						sx=cv; sy=cv2;			}//
					}  //for2 zár
		}	 //for1 zár
	if(sx>0 && sy<9) { select[sx][sy]=0; select[sx-1][sy+1]=1;
	}}
	break;
	case GAME_D: if(kcode==false){for(cv=0; cv<9; cv++ ){	   //for1 nyit
					for(cv2=0; cv2<10; cv2++){ //for2 nyit
						if(select[cv][cv2]==1){ //
						sx=cv; sy=cv2;			}//
					}  //for2 zár
		}	 //for1 zár
	if(sx<8 && sy<9) { select[sx][sy]=0; select[sx+1][sy+1]=1;
	} }
	break;


	case FIRE:
		for(cv=0; cv<9; cv++ ){//f1n
						for(cv2=0; cv2<10; cv2++){//
							if(select[cv][cv2]==1){//
							sx=cv; sy=cv2;	   }//

						}//

			}//f1z
		if(sy<9 && jall==0) {  //if6 nyit
		if(tabla[sx][sy]==0){  //if7 nyit
					tabla[sx][sy]=1;
					cv1++;
					enemy=true;
					if((Jatek.WinsGame4(sx,sy, tabla))==1){ jall=1; //nyertél you win
						enemy=false;
					}
					if(cv1>=81) jall=3; //döntetlen
				}	  //if7 zár

		} //if6 zár
		else
		{	//else nyit
			enemy=false;
			jall=0;
			cv1=0;

			sx=0; sy=0; cv=0; cv2=0; cv3=0; cv4=0;
			maxy=0;
			maxo=-3;
			maxx=0;
			for(cv=0; cv<22; cv++ ){//
							for(cv2=0; cv2<22; cv2++){//
								tabla[cv][cv2]=0;
							}//
					}//
			for(cv=0; cv<22; cv++ ){//
								for(cv2=0; cv2<22; cv2++){//
									prior[cv][cv2]=0;
								}//
			}//
			for(cv=0; cv<9; cv++ ){//
								for(cv2=0; cv2<10; cv2++){//
									select[cv][cv2]=0;
								}//
			}//
			select[5][5]=1;
		}		 //else zár
		break;
	}
	} //startGame vége
	startGame=false;
	//repaint();
	//run();
   //}
  }	  //input zár
  public void render(Graphics g)
  {

  }

public void run () {
	// lower ThreadPriority
	//System.out.println("RUN");
	Thread.currentThread().setPriority(Thread.MIN_PRIORITY);

	// run a long while (true) this means in our case "always"
	while (true)
	{
		//System.out.println("RUN_while");
			try
			{
			// Stop thread for 20 milliseconds
			Thread.sleep (20);

			}
			catch (InterruptedException ex)
			{
			// do nothing
			}
	if(enemy==true && jall==0)
	{	  //if1 nyit
		enemy=false;
		for(cv=0; cv<22; cv++ ){
					for(cv2=0; cv2<22; cv2++){
						prior[cv][cv2]=0;
					}
		}
	/////////////////////////priortábla feltöltése//////////////////////////////
	for(cv=0;cv<9;cv++)
			for(cv2=0;cv2<9;cv2++){	   // for1 nyit
				if(tabla[cv][cv2]!=1 && tabla[cv][cv2]!=2){	//if2n
					tabla[cv][cv2]=2;
					if(Jatek.WinsGame2(cv, cv2, tabla)==1){
						prior[cv][cv2]+=20;
					}
					tabla[cv][cv2]=0;
				}		  //if2z
				else prior[cv][cv2]=(-1);
				if(tabla[cv][cv2]!=1 && tabla[cv][cv2]!=2){	 //if3n
					tabla[cv][cv2]=1;
					if(Jatek.WinsGame2(cv, cv2, tabla)==1){
						prior[cv][cv2]+=10;
					}
					tabla[cv][cv2]=0;
				}											  //if3z

				if(tabla[cv][cv2]!=1 && tabla[cv][cv2]!=2){	  //if4n
					tabla[cv][cv2]=2;
					if(Jatek.WinsGame3(cv, cv2, tabla)==1){
						prior[cv][cv2]+=3;
					}
					tabla[cv][cv2]=0;
				}										   //if4z
				else prior[cv][cv2]=(-1);
				if(tabla[cv][cv2]!=1 && tabla[cv][cv2]!=2){ //i1n
					tabla[cv][cv2]=1;
					if(Jatek.WinsGame3(cv, cv2, tabla)==1){ //i2n
						prior[cv][cv2]+=2;
					} //i2z
					tabla[cv][cv2]=0;
				} //i1z
				if(tabla[cv][cv2]!=1 && tabla[cv][cv2]!=2){ //i1n
					tabla[cv][cv2]=2;
					if(Jatek.WinsGame4(cv, cv2, tabla)==1){ //i2n
						prior[cv][cv2]+=60;
					} //i2z
					tabla[cv][cv2]=0;
				} //i1z
				else prior[cv][cv2]=(-1);
				if(tabla[cv][cv2]!=1 && tabla[cv][cv2]!=2){//i1n
					tabla[cv][cv2]=1;
					if(Jatek.WinsGame4(cv, cv2, tabla)==1){//i2n
						prior[cv][cv2]+=30;
					}//i2z
					tabla[cv][cv2]=0;
				}//i1z
				if(tabla[cv][cv2]!=1 && tabla[cv][cv2]!=2){ //i1n
					tabla[cv][cv2]=2;
					if(Jatek.WinsGame5(cv, cv2, tabla)==1){ //i2n
							prior[cv][cv2]+=2;
						}//i2z
						tabla[cv][cv2]=0;
					}//i1z
				else prior[cv][cv2]=(-1);
				if(tabla[cv][cv2]!=1 && tabla[cv][cv2]!=2){ //i1n
					tabla[cv][cv2]=1;
					if(Jatek.WinsGame5(cv, cv2, tabla)==1){ //i2n
						prior[cv][cv2]+=1;
					} //i2z
					tabla[cv][cv2]=0;
				}	 //i1z
			}								   //for1 zár

	///////////////////////////feltöltés vége///////////////////////////
	maxo=-3;
	for(cv=0; cv<9; cv++ ){ //ellenség rak a prior tábla alapján f1n
			for(cv2=0; cv2<9; cv2++){ //f2n
				if(tabla[cv][cv2]!=1 && tabla[cv][cv2]!=2){ //i1n
					if(maxo<prior[cv][cv2]){  //i2n
						maxo=prior[cv][cv2];
						maxx=cv;
						maxy=cv2;
					} //i2z
				}  //i1z
			}  //f2z
		} //f1z

	tabla[maxx][maxy]=2;

	if(Jatek.WinsGame4(maxx,maxy, tabla)==1) jall=2;
	cv1++;
	 //for zár
		}	 //if1 zár
	// repaint the applet
	repaint();

	try
	{ //tn
	// Stop thread for 20 milliseconds
	Thread.sleep (20);
	} //tz
	catch (InterruptedException ex)
	{ //cn
	// do nothing

	} //cz

	// set ThreadPriority to maximum value
	Thread.currentThread().setPriority(Thread.MAX_PRIORITY);

	}		 //while zár
}	 // run zár


/** paint - method allows you to paint into your applet. This method is called e.g. if you move your browser window or if you call repaint() */
public void paint (Graphics g) { //paint nyit
//System.out.println("PAINT");
Graphics saved = g;
if( offscreen != null ){
        g = offscreen.getGraphics();
    }

	// set color
//g.setColor (Color.red);
g.drawImage (backImage, 0, 0, Graphics.TOP | Graphics.LEFT);
	for(cv=0; cv<9; cv++ ){	//f1n
			for(cv2=0; cv2<9; cv2++){ //f2n
				if(tabla[cv][cv2]==0)
					g.drawImage (ures, cv*14, cv2*14, Graphics.TOP | Graphics.LEFT);
				if(tabla[cv][cv2]==1)
					g.drawImage (xplayer, cv*14, cv2*14, Graphics.TOP | Graphics.LEFT);
				if(tabla[cv][cv2]==2)
					g.drawImage (o, cv*14, cv2*14, Graphics.TOP | Graphics.LEFT);
				}					  //f2z
			}			 //f1z

g.drawImage (restart, 0, 126, Graphics.TOP | Graphics.LEFT);
for(cv=0; cv<9; cv++ ){	   //f1n
					for(cv2=0; cv2<10; cv2++){  //f2n
						if(select[cv][cv2]==1){ //i1n
						if(cv2<9){
						if(tabla[cv][cv2]==0)
						g.drawImage (selectimage, cv*14, cv2*14, Graphics.TOP | Graphics.LEFT);
						if(tabla[cv][cv2]==1)
						g.drawImage (selectx, cv*14, cv2*14, Graphics.TOP | Graphics.LEFT);
						if(tabla[cv][cv2]==2)
						g.drawImage (selecto, cv*14, cv2*14, Graphics.TOP | Graphics.LEFT);
						}
						else g.drawImage (selectrestart, 0, 126, Graphics.TOP | Graphics.LEFT);
					} //i1z
					} //f2z
		}	  //f1z


if(jall==0) g.drawImage (empty, 63, 126, Graphics.TOP | Graphics.LEFT);
if(jall==1) g.drawImage (win, 63, 126, Graphics.TOP | Graphics.LEFT);
if(jall==2)	g.drawImage (lost, 63, 126, Graphics.TOP | Graphics.LEFT);
if(jall==3) g.drawImage (nowin, 63, 126, Graphics.TOP | Graphics.LEFT);
if(startGame==true)
g.drawImage (startImage, 0, 0, Graphics.TOP | Graphics.LEFT);
if( g != saved ){
        saved.drawImage( offscreen, 1, 1,
                         Graphics.LEFT | Graphics.TOP );
    }

}	 //paint zár


}	//main zár