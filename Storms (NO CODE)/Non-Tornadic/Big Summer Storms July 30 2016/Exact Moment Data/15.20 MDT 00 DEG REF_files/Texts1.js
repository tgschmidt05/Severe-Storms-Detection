var font = '\'webFont\', \'Arial Narrow\', sans-serif';
var againSize = 8;
var againText = "TRY AGAIN";

var TPText1 = "LAUNCH A TORPEDO AT THE ENEMY SHIP";

var FTPText1 = "MISSION: AIM  WITH THE TORPEDO SIGHT";

var FTPText2_1 = "ENEMY NOT DESTROYED!";
var FTPText2_2 = "IMPROVE YOUR BATTLE SKILLS IN GAME";

var FTPText3_1 = "ENEMY DESTROYED!";
var FTPText3_2 = "THERE ARE MANY MORE TORPEDOES TO FIRE";






function drawTPText(ctx)
{
		ctx.font = 'bold 12pt '+font;			
		ctx.textBaseline = "middle";
		ctx.textAlign = "center";		
		ctx.fillStyle = "#FFFFFF";
		ctx.shadowColor = "Black";
		ctx.shadowBlur = 2; 
		ctx.shadowOffsetX = 1;
		ctx.shadowOffsetY = 1.2;
		ctx.fillText(TPText1, 0, 15);
}

function drawFTPText(ctx)
{
		ctx.font = 'bold 12pt '+font;			
		ctx.textBaseline = "middle";
		ctx.textAlign = "center";		
		ctx.fillStyle = "#FFFFFF";
		ctx.shadowColor = "Black";
		ctx.shadowBlur = 2; 
		ctx.shadowOffsetX = 1;
		ctx.shadowOffsetY = 1.2;
		if(topTextState==0)		{			
			
			ctx.fillText(FTPText1, 0, 44);			
		}
		if(topTextState==1)
		{
			ctx.font = 'bold 14pt '+font;	
			ctx.fillText(FTPText2_1, 0, 20);
			ctx.fillText(FTPText2_2, 0, 44);
		}
		if(topTextState==2)
		{
			ctx.font = 'bold 14pt '+font;	
			ctx.fillText(FTPText3_1, 0, 20);
			ctx.font = 'bold 13pt '+font;	
			ctx.fillText(FTPText3_2, 0, 44);
		}
}