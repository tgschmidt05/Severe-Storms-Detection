var splashArray = new Array();

function addSplash(torp)
{
	var spO = {};
	spO.sx = torp.x2D1;
	spO.sy = torp.y2D1;
	spO.x = spO.sx;
	spO.y = spO.sy;	
	spO.dist = 0;
	spO.ang = torp.ang;
	spO.scale = torp.scale*0.7;	
	spO.rotate = Math.random()*10;
	splashArray.push(spO);	
	
}
var dx = -20;
function addSplash3D(sx,sy,sz,ang,dist,dx,torped)
{
	var spO = {};
	spO.sx = sx;
	spO.sy = sy;
	spO.sz = sz;	
	spO.dist = dist;
	spO.dDist = 0;
	//spO.sScale = scale;
	spO.scale = 0.46;
	spO.ang = ang;
	spO.dx = 0;
	spO.ddx = torped.dx;
	spO.alpha = 0.6+Math.random()*0.3;
	spO.rotate = Math.random()*10;
	spO.torped = torped;
	splashArray.push(spO);	
	
}

function drawSplash(ctx)
{

	/*for(var i =0;i<splashArray.length;i++)
	{
		splashArray[i].x = splashArray[i].x+(splashArray[i].fx-splashArray[i].x)/2;
		splashArray[i].y = splashArray[i].y+(splashArray[i].fy-splashArray[i].y)/2;
		splashArray[i].scale-=0.011;
		
		ctx.save();		
		ctx.translate(splashArray[i].x,splashArray[i].y);
		ctx.scale(splashArray[i].scale,splashArray[i].scale);
		ctx.rotate(splashArray[i].rotate);
			ctx.drawImage(img_splash.pic,-10,-10);
		ctx.restore();
		if(splashArray[i].scale<0)
		{
			splashArray.splice(i,1);
			i--;
		}
	}*/

	/*for(var t=0;t<torpedArray.length;t++)
	{	
			
			torpedArray[t].z = torpedArray[t].sz-Math.sin(torpedArray[t].ang)*torpedArray[t].dist;
			torpedArray[t].x = torpedArray[t].sx-Math.cos(torpedArray[t].ang)*torpedArray[t].dist;
			torpedArray[t].z2 = torpedArray[t].sz-Math.sin(torpedArray[t].ang)*torpedArray[t].dist*0.5;
			torpedArray[t].x2 = torpedArray[t].sx-Math.cos(torpedArray[t].ang)*torpedArray[t].dist*0.5;				
			torpedArray[t].x2D = calcul3d({x:torpedArray[t].x,y:torpedArray[t].y,z:torpedArray[t].z}).x;
			torpedArray[t].y2D = calcul3d({x:torpedArray[t].x,y:torpedArray[t].y,z:torpedArray[t].z}).y;
			torpedArray[t].x2D2 = calcul3d({x:torpedArray[t].x2,y:torpedArray[t].y,z:torpedArray[t].z2}).x;
			torpedArray[t].y2D2 = calcul3d({x:torpedArray[t].x2,y:torpedArray[t].y,z:torpedArray[t].z2}).y;
			
			
	}	*/	
	
	/*for(var i =0;i<splashArray.length;i++)
	{
		//splashArray[i].dDist+=2;
		//splashArray[i].scale-=0.011;
		
		splashArray[i].z = splashArray[i].sz-Math.sin(splashArray[i].ang)*(splashArray[i].dist);
		splashArray[i].x = splashArray[i].sx-Math.cos(splashArray[i].ang)*(splashArray[i].dist);
		//splashArray[i].sx+=1;		
		//splashArray[i].ang-=0.005;			
		splashArray[i].scale3D = calcul3d({x:splashArray[i].x,y:splashArray[i].y,z:splashArray[i].z}).scale*splashArray[i].scale;
			//torpedArray[t].scale = calcul3d({x:torpedArray[t].x,y:torpedArray[t].y,z:torpedArray[t].z}).scale;
				
		ctx.save();
		
		ctx.translate(calcul3d({x:splashArray[i].x,y:splashArray[i].sy,z:splashArray[i].z}).x,calcul3d({x:splashArray[i].x,y:splashArray[i].sy,z:splashArray[i].z}).y);
		
		ctx.scale(splashArray[i].scale3D,splashArray[i].scale3D);
		ctx.rotate(splashArray[i].rotate);
		ctx.drawImage(img_splash.pic,-10,-10);
		ctx.restore();			
		
		
		if(splashArray[i].scale<0)
		{
			splashArray.splice(i,1);
			i--;
		}
	}*/
	
	
	
	for(var i =0;i<splashArray.length;i++)
	{
		splashArray[i].dDist+=0.6;
		splashArray[i].scale-=0.004;
		splashArray[i].alpha-=0.015;
		splashArray[i].z = splashArray[i].sz-Math.sin(splashArray[i].ang)*(splashArray[i].dist+splashArray[i].dDist);
		splashArray[i].x = splashArray[i].sx-Math.cos(splashArray[i].ang)*(splashArray[i].dist+splashArray[i].dDist);
		var splash3D = calcul3d({x:splashArray[i].x,y:y3D,z:splashArray[i].z});
		
		splashArray[i].scale3D = splash3D.scale*splashArray[i].scale;
		splashArray[i].ddx+=splashArray[i].dx;
		//splashArray[i].dscale += calcul3d({x:splashArray[i].x,y:splashArray[i].y,z:splashArray[i].z}).scale;
			//torpedArray[t].scale = calcul3d({x:torpedArray[t].x,y:torpedArray[t].y,z:torpedArray[t].z}).scale;
		//splashArray[i].dx+=splashArray[i].ddx;
		
		ctx.save();
		
		ctx.translate(splash3D.x+splashArray[i].torped.dx,splash3D.y);
		
		ctx.scale(splashArray[i].scale3D,splashArray[i].scale3D);
		ctx.rotate(splashArray[i].rotate);
		
		ctx.globalAlpha = splashArray[i].alpha;
		ctx.drawImage(img_splash.pic,-10,-10);
		ctx.restore();			
		
		
		if(splashArray[i].alpha<0.1)
		{
			splashArray.splice(i,1);
			i--;
		}
	}
	

	/*for(var i =0;i<splashArray.length;i++)
	{
		
		splashArray[i].scale-=0.011;		
		splashArray[i].dist += 1;
		splashArray[i].x = splashArray[i].sx+Math.cos(splashArray[i].ang)*splashArray[i].dist;	
		splashArray[i].y = splashArray[i].sy+Math.sin(splashArray[i].ang)*splashArray[i].dist;
		ctx.save();
		console.log(splashArray[i].ang)
		ctx.translate(splashArray[i].x,splashArray[i].y);
		ctx.scale(splashArray[i].scale,splashArray[i].scale);
		ctx.rotate(splashArray[i].rotate);
		ctx.drawImage(img_splash.pic,-10,-10);
		ctx.restore();
		
		if(splashArray[i].scale<0)
		{
			splashArray.splice(i,1);
			i--;
		}
	}*/
}