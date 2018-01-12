var drawButton = function(ctx, obj) {
ctx.clearRect(0, 0, w, h);
ctx.save();
ctx.transform(obj.scaleX,0,0,obj.scaleY,obj.x,obj.y);

ctx.globalAlpha = obj.alpha;
ctx.save();
ctx.transform(1,0,0,1,28.4,2.75);
ctx.beginPath();
ctx.moveTo(42.6,-17.75);
ctx.quadraticCurveTo(42.6,-20.75,39.6,-20.75);
ctx.lineTo(-96.4,-20.75);
ctx.quadraticCurveTo(-99.4,-20.75,-99.4,-17.75);
ctx.lineTo(-99.4,12.25);
ctx.quadraticCurveTo(-99.4,15.25,-96.4,15.25);
ctx.lineTo(39.6,15.25);
ctx.quadraticCurveTo(42.6,15.25,42.6,12.25);
ctx.lineTo(42.6,-17.75);
ctx.closePath();
ctx.fill();
ctx.shadowColor = "transparent";
ctx.closePath();
ctx.restore();
ctx.translate(-71, -18);
var pattern = ctx.createPattern(obj.pic, 'repeat');
ctx.fillStyle = pattern;
ctx.shadowColor = "#000000";
ctx.shadowBlur = 10; 
ctx.shadowOffsetX = 0;
ctx.shadowOffsetY = 0;
ctx.fill();
ctx.shadowColor = "transparent";
ctx.translate(+71, +18);


ctx.font = "bold 10pt "+font;
		//
ctx.shadowColor = "#8E1A0D";
ctx.shadowBlur = 0; 
ctx.shadowOffsetX = 1 * obj.scaleX;
ctx.shadowOffsetY = 1 * obj.scaleY;
ctx.textBaseline = "middle";
ctx.textAlign = "center";
		//
ctx.fillStyle = "#FFFFFF";
ctx.fillText("PLAY FOR FREE", 0, 0);


ctx.restore();

};