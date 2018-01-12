/**********************************
* Icon Animation .JS Fragment File
***********************************/
var iconAnimationName = "Square Tiles";
var iconAnimationVersion = 2.1;
var spriteSheetName = "spritesheet_square_tiles.png";
var spriteSheet = new Image();

// For rescaling on other unit sizes
var iconUnitScale = 1.; // Scale = 1 for 300x250
var iconRegistrationX = 0; // Null registration point of animation. Adjust as needed on other unit sizes (728x90, 160x600)
var iconRegistrationY = 0; // 0, 0 is based on the 300x250

// From Dynamic API
// should be 1.7 by default
var iconAnimationStartTime = parseFloat(dynamicContent.Google_AdWords_Tangram_Feed__Canada_feed[0].Start_Time_Icon_Animation); //Start_Time_Icon_Animation
var copyBatch2StartTime = parseFloat(dynamicContent.Google_AdWords_Tangram_Feed__Canada_feed[0].Start_Time_Text_2); //Start_Time_Icon_Animation

var squarePartCount = 10;
var squareParts = [];
var squarePartStartX = [486, 530, 563, 490, 523, 563, 462, 515, 580, 500];
var squarePartStartY = [-6, 0, -8, 35, 28, 30, 80, 68, 67, 500];
var squarePartDockX = [];
var squarePartDockY = [];

var squarePartsCornerDockX = 492;
var squarePartsCornerDockY = 8;
var squarePartWidth = 24;
var squarePartHeight = 24;

var squarePartSpriteSheetStartX = 9;
var squarePartSpriteSheetStartY = 271;
var squarePartSpriteSheetSpacingX = 40;
var squarePartSpriteSheetSpacingY = 40;

var yellowSquareDelay = 1; // yellow square appears how many seconds after animation starts


function createIconParts()
{
	var i = 0;
	var tempElement;
	var iconHolder = $("#iconHolder");
	var tempPos = "";

	// Create Phone Icon Parts & attach to DOM
	for (i = 0; i < squarePartCount; i++)
	{
		tempElement =  document.createElement("div");
		tempElement.setAttribute("id", "squarePart" + i);
		tempElement.setAttribute("class", "sprite square" + i);
		iconHolder.appendChild(tempElement);
		squareParts[i] = $("#squarePart" + i);

		// Compute Docking positions
		if (i < 9)
		{
			squarePartDockX[i] = squarePartsCornerDockX + squarePartWidth * (i % 3);
			squarePartDockY[i] = squarePartsCornerDockY + squarePartHeight * Math.floor(i / 3);
		}
		else 
		{
			// Special Case for Yellow Square
			squarePartDockX[i] = squarePartsCornerDockX;
			squarePartStartX[i] = squarePartDockX[i];
			squarePartDockY[i] = squarePartsCornerDockY + squarePartHeight;
			squarePartStartY[i] = squarePartDockY[i];
		}

		// compute spritesheet position
		tempPos = "-" + (squarePartSpriteSheetStartX + (i % 5) * squarePartSpriteSheetSpacingX) + "px -" + (squarePartSpriteSheetStartY + Math.floor( i / 5) * squarePartSpriteSheetSpacingY) + "px";
		TweenLite.to(squareParts[i], 0, {opacity:0, width:squarePartWidth, height:squarePartHeight,
			backgroundPosition:tempPos,
			x:(squarePartStartX[i] * iconUnitScale + iconRegistrationX), 
			y:(squarePartStartY[i] * iconUnitScale + iconRegistrationY)}
			);
	}

	// iconHolder.style.top = '-85px';
	// iconHolder.style.left = '350px';
	// TweenLite.to(iconHolder, 0, {scale:.78, transform3d:0});
}

function initIconAnimations()
{
	// Timeline Markers Definitions
	tlIcon.addLabel("dockSquares", iconAnimationStartTime);
	tlIcon.addLabel("showYellowSquare", copyBatch2StartTime + yellowSquareDelay);


	// Animation Definitions
	dockSquareParts();
	tlIcon.to(squareParts[9], 0.3, {opacity:1}, "showYellowSquare");

	// End Animation
}

function dockSquareParts()
{
	var i = 0;
	var regularSquareCount = squarePartCount - 1;
	for (i = 0; i < regularSquareCount; i ++)
	{
		tlIcon.to(squareParts[i], 0.3, {opacity:1}, "dockSquares");
		tlIcon.to(squareParts[i], 1.2, {x:(squarePartDockX[i] * iconUnitScale + iconRegistrationX), y:(squarePartDockY[i] * iconUnitScale + iconRegistrationY), ease:Power4.easeInOut}, "dockSquares");
	}
}

// Create and initialize icon parts + animation
createIconParts();
initIconAnimations();

console.log("Animation: " + iconAnimationName + " ver " + iconAnimationVersion);
console.log("-----");

// play animation once spritesheet is confirmed to have loaded
function onSpriteSheetLoad(e)
{
	// startAnimations is called from main.js
	// it will play the main timeline (tl)
	// + your icon timeline (tlIcon) at the same time
	startAnimations(); // STARTS THE ENTIRE UNIT ANIMATION when SpriteSheet is loaded
}

spriteSheet.addEventListener("load", onSpriteSheetLoad, false);
spriteSheet.src = spriteSheetName;
