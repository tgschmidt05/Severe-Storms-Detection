(function (lib, img, cjs, ss) {

var p; // shortcut to reference prototypes
lib.webFontTxtFilters = {}; 

// library properties:
lib.properties = {
	width: 600,
	height: 500,
	fps: 24,
	color: "#FFFFFF",
	opacity: 1.00,
	webfonts: {},
	manifest: [
		{src:"images/BCWI5035_online_big_box_300x250_template_v3.jpg", id:"BCWI5035_online_big_box_300x250_template_v3"},
		{src:"images/BCWI_5127_300x250_ThisThat_July19_EO_atlas_P_.png", id:"BCWI_5127_300x250_ThisThat_July19_EO_atlas_P_"}
	]
};



lib.ssMetadata = [
		{name:"BCWI_5127_300x250_ThisThat_July19_EO_atlas_P_", frames: [[0,0,300,610],[0,612,300,65]]}
];


lib.webfontAvailable = function(family) { 
	lib.properties.webfonts[family] = true;
	var txtFilters = lib.webFontTxtFilters && lib.webFontTxtFilters[family] || [];
	for(var f = 0; f < txtFilters.length; ++f) {
		txtFilters[f].updateCache();
	}
};
// symbols:



(lib.BCWI5035_online_big_box_300x250_template_v3 = function() {
	this.initialize(img.BCWI5035_online_big_box_300x250_template_v3);
}).prototype = p = new cjs.Bitmap();
p.nominalBounds = new cjs.Rectangle(0,0,300,250);


(lib.corky1111111 = function() {
	this.spriteSheet = ss["BCWI_5127_300x250_ThisThat_July19_EO_atlas_P_"];
	this.gotoAndStop(0);
}).prototype = p = new cjs.Sprite();



(lib.corkyarm = function() {
	this.spriteSheet = ss["BCWI_5127_300x250_ThisThat_July19_EO_atlas_P_"];
	this.gotoAndStop(1);
}).prototype = p = new cjs.Sprite();



(lib.greenbox = function(mode,startPosition,loop) {
	this.initialize(mode,startPosition,loop,{});

	// copy
	this.shape = new cjs.Shape();
	this.shape.graphics.f("#FFFFCC").s().p("AgGAnQgDgDAAgEQAAgFADgDQADgCADAAQAEAAADACQADADAAAFQAAAEgDADQgDADgEAAQgDAAgDgDgAgHAQIAAg5IAPAAIAAA5g");
	this.shape.setTransform(130.7,11.5);

	this.shape_1 = new cjs.Shape();
	this.shape_1.graphics.f("#FFFFCC").s().p("AgGAoIgGgDIgHgFIgFgGIgEgIQgEgIAAgKIACgIIADgJQACgIAHgGQAFgGAIgCQAGgDAJAAIAMABIAIACIgEAQIgEgBIgEgBIgDgBIgEAAQgGAAgFACQgDACgDAEQgDADgCAFQgCAGgBAEQAAANAHAHQAHAIAJAAIAEAAIADgBIAAgaIARAAIAAAmIgGACIgFABIgHABIgGAAQgIAAgHgDg");
	this.shape_1.setTransform(124.3,11.4);

	this.shape_2 = new cjs.Shape();
	this.shape_2.graphics.f("#FFFFCC").s().p("AAdAqIgtgvIAAAvIgRAAIAAhTIAGAAIAsAuIAAguIARAAIAABTg");
	this.shape_2.setTransform(116.2,11.4);

	this.shape_3 = new cjs.Shape();
	this.shape_3.graphics.f("#FFFFCC").s().p("AgHAqIAAhTIAPAAIAABTg");
	this.shape_3.setTransform(110,11.4);

	this.shape_4 = new cjs.Shape();
	this.shape_4.graphics.f("#FFFFCC").s().p("AAdAqIgugvIAAAvIgQAAIAAhTIAGAAIAsAuIAAguIARAAIAABTg");
	this.shape_4.setTransform(103.9,11.4);

	this.shape_5 = new cjs.Shape();
	this.shape_5.graphics.f("#FFFFCC").s().p("AAdAqIgugvIAAAvIgQAAIAAhTIAGAAIAsAuIAAguIARAAIAABTg");
	this.shape_5.setTransform(95.3,11.4);

	this.shape_6 = new cjs.Shape();
	this.shape_6.graphics.f("#FFFFCC").s().p("AAVAqIgGgNIgeAAIgGANIgSAAIAlhTIAFAAIAlBTgAgKAPIAUAAIgKgYg");
	this.shape_6.setTransform(86.8,11.4);

	this.shape_7 = new cjs.Shape();
	this.shape_7.graphics.f("#FFFFCC").s().p("AgaAqIAAhTIASAAIAABDIAiAAIAAAQg");
	this.shape_7.setTransform(79.8,11.4);

	this.shape_8 = new cjs.Shape();
	this.shape_8.graphics.f("#FFFFCC").s().p("AgeAqIAAhTIASAAQAUAAAMAIQAFADADAGQADAGAAAIQAAAIgDADQgDAGgFAEQgKAIgQAAIgHAAIAAAXgAgNADIAGAAQAKAAAFgDIAEgDQACgDgBgEQABgDgCgDIgEgFQgDgCgDgBIgJgBIgGAAg");
	this.shape_8.setTransform(72.6,11.4);

	this.shape_9 = new cjs.Shape();
	this.shape_9.graphics.f("#FFFFCC").s().p("AgHAqIAAhDIgZAAIAAgQIBBAAIAAAQIgZAAIAABDg");
	this.shape_9.setTransform(61.6,11.4);

	this.shape_10 = new cjs.Shape();
	this.shape_10.graphics.f("#FFFFCC").s().p("AAOAqIgPgaIgEABIgEAAIgGAAIAAAZIgRAAIAAhTIASAAQALAAAGACQAIACAGADQAGAEACAGQADAGAAAIIgBAIIgDAEQgDAGgHAEIATAegAgPACIAGAAIAJgBQADgBADAAQACgBACgDIABgGIgBgHIgEgEQgFgEgKAAIgGAAg");
	this.shape_10.setTransform(54.6,11.4);

	this.shape_11 = new cjs.Shape();
	this.shape_11.graphics.f("#FFFFCC").s().p("AAVAqIgGgNIgeAAIgGANIgSAAIAlhTIAFAAIAlBTgAgKAPIAUAAIgKgYg");
	this.shape_11.setTransform(46.3,11.4);

	this.shape_12 = new cjs.Shape();
	this.shape_12.graphics.f("#FFFFCC").s().p("AgHAqIAAhDIgaAAIAAgQIBDAAIAAAQIgaAAIAABDg");
	this.shape_12.setTransform(39.6,11.4);

	this.shape_13 = new cjs.Shape();
	this.shape_13.graphics.f("#FFFFCC").s().p("AgSApIgNgEIAFgPIAFACIAHABIAHACIAHAAQAHAAAEgCIACgCIABgEIgBgEIgEgDIgFgDIgEgCIgKgEIgJgDQgEgDgDgEQgCgFAAgGQAAgHACgEQADgFAEgDQAEgCAGgCIALgBIAJABIAHABIAGABIADABIgEAQIgLgDIgMgBQgDAAgEACQgEABAAAEQAAABAAAAQAAABABABQAAAAAAAAQAAABABAAIADADIAGADIAEACIAKAEQAFACAEABQAEADACAEQADAFAAAGQAAAGgCAEQgCAFgEADQgEADgHACQgGACgIAAQgMgBgFgBg");
	this.shape_13.setTransform(32.4,11.4);

	this.shape_14 = new cjs.Shape();
	this.shape_14.graphics.f("#002147").s().p("AgGAnQgDgDAAgEQAAgFADgDQADgCADAAQAEAAADACQADADAAAFQAAAEgDADQgDADgEAAQgDAAgDgDgAgHAQIAAg5IAPAAIAAA5g");
	this.shape_14.setTransform(131.2,11.9);

	this.shape_15 = new cjs.Shape();
	this.shape_15.graphics.f("#002147").s().p("AgGAoIgGgDIgHgFIgFgGIgEgIQgEgIAAgKIACgIIADgJQACgIAHgGQAFgGAIgCQAGgDAJAAIAMABIAIACIgFAQIgDgBIgEgBIgDgBIgEAAQgGAAgFACQgDACgDAEQgDADgCAFQgCAGgBAEQAAANAHAHQAHAIAJAAIAEAAIADgBIAAgaIARAAIAAAmIgGACIgFABIgHABIgGAAQgIAAgHgDg");
	this.shape_15.setTransform(124.8,11.9);

	this.shape_16 = new cjs.Shape();
	this.shape_16.graphics.f("#002147").s().p("AAdAqIgtgvIAAAvIgRAAIAAhTIAGAAIAsAuIAAguIARAAIAABTg");
	this.shape_16.setTransform(116.6,11.9);

	this.shape_17 = new cjs.Shape();
	this.shape_17.graphics.f("#002147").s().p("AgHAqIAAhTIAPAAIAABTg");
	this.shape_17.setTransform(110.5,11.9);

	this.shape_18 = new cjs.Shape();
	this.shape_18.graphics.f("#002147").s().p("AAdAqIgugvIAAAvIgQAAIAAhTIAGAAIAsAuIAAguIARAAIAABTg");
	this.shape_18.setTransform(104.4,11.9);

	this.shape_19 = new cjs.Shape();
	this.shape_19.graphics.f("#002147").s().p("AAdAqIgugvIAAAvIgQAAIAAhTIAGAAIAsAuIAAguIARAAIAABTg");
	this.shape_19.setTransform(95.7,11.9);

	this.shape_20 = new cjs.Shape();
	this.shape_20.graphics.f("#002147").s().p("AAVAqIgGgNIgeAAIgGANIgSAAIAlhTIAFAAIAlBTgAgKAPIAUAAIgKgYg");
	this.shape_20.setTransform(87.3,11.8);

	this.shape_21 = new cjs.Shape();
	this.shape_21.graphics.f("#002147").s().p("AgaAqIAAhTIASAAIAABDIAiAAIAAAQg");
	this.shape_21.setTransform(80.2,11.9);

	this.shape_22 = new cjs.Shape();
	this.shape_22.graphics.f("#002147").s().p("AgeAqIAAhTIASAAQAUAAAMAIQAFADADAGQADAGAAAIQAAAIgDADQgDAGgEAEQgLAIgQAAIgHAAIAAAXgAgNADIAGAAQAKAAAFgDIAEgDQACgDgBgEQABgDgCgDIgEgFQgDgCgDgBIgJgBIgGAAg");
	this.shape_22.setTransform(73.1,11.9);

	this.shape_23 = new cjs.Shape();
	this.shape_23.graphics.f("#002147").s().p("AgHAqIAAhDIgZAAIAAgQIBBAAIAAAQIgZAAIAABDg");
	this.shape_23.setTransform(62.1,11.9);

	this.shape_24 = new cjs.Shape();
	this.shape_24.graphics.f("#002147").s().p("AAOAqIgPgaIgEABIgEAAIgGAAIAAAZIgRAAIAAhTIASAAQALAAAGACQAIACAGADQAGAEACAGQADAGAAAIIgBAIIgDAEQgDAGgHAEIATAegAgPACIAGAAIAJgBQADgBADAAQACgBACgDIABgGIgBgHIgEgEQgFgEgKAAIgGAAg");
	this.shape_24.setTransform(55.1,11.9);

	this.shape_25 = new cjs.Shape();
	this.shape_25.graphics.f("#002147").s().p("AAVAqIgGgNIgeAAIgGANIgSAAIAlhTIAFAAIAlBTgAgKAPIAUAAIgKgYg");
	this.shape_25.setTransform(46.8,11.8);

	this.shape_26 = new cjs.Shape();
	this.shape_26.graphics.f("#002147").s().p("AgHAqIAAhDIgaAAIAAgQIBDAAIAAAQIgZAAIAABDg");
	this.shape_26.setTransform(40.1,11.9);

	this.shape_27 = new cjs.Shape();
	this.shape_27.graphics.f("#002147").s().p("AgSApIgNgEIAFgPIAFACIAHABIAHACIAHAAQAHAAAEgCIACgCIABgEIgBgEIgEgDIgFgDIgEgCIgKgEIgJgDQgEgDgDgEQgCgFAAgGQAAgHACgEQADgFAEgDQAEgCAGgCIALgBIAJABIAHABIAGABIADABIgEAQIgLgDIgMgBQgDAAgEACQgEABAAAEQAAABAAAAQAAABABABQAAAAAAAAQAAABABAAIADADIAGADIAEACIAKAEQAFACAEABQAEADACAEQADAFAAAGQAAAGgCAEQgCAFgEADQgEADgHACQgGACgIAAQgMgBgFgBg");
	this.shape_27.setTransform(32.9,11.9);

	this.timeline.addTween(cjs.Tween.get({}).to({state:[{t:this.shape_27},{t:this.shape_26},{t:this.shape_25},{t:this.shape_24},{t:this.shape_23},{t:this.shape_22},{t:this.shape_21},{t:this.shape_20},{t:this.shape_19},{t:this.shape_18},{t:this.shape_17},{t:this.shape_16},{t:this.shape_15},{t:this.shape_14},{t:this.shape_13},{t:this.shape_12},{t:this.shape_11},{t:this.shape_10},{t:this.shape_9},{t:this.shape_8},{t:this.shape_7},{t:this.shape_6},{t:this.shape_5},{t:this.shape_4},{t:this.shape_3},{t:this.shape_2},{t:this.shape_1},{t:this.shape}]}).wait(1));

	// Layer 1
	this.shape_28 = new cjs.Shape();
	this.shape_28.graphics.lf(["#1B462F","#7BB95F"],[0,1],0,-10.7,0,10.7).s().p("AofBrQgOgBgKgJQgKgKAAgPIAAiPQAAgOAKgLQAKgKAOAAIQ+AAQAPAAAKAKQAKALAAAOIAACPQAAAPgKAKQgKAJgPABg");
	this.shape_28.setTransform(81.6,11.5);

	this.shape_29 = new cjs.Shape();
	this.shape_29.graphics.lf(["#1B462F","#7BB95F"],[0,1],0,-10.7,0,10.7).s().p("AofBrQgOgBgKgJQgKgKAAgPIAAiPQAAgOAKgLQAKgKAOAAIQ+AAQAPAAAKAKQAKALAAAOIAACPQAAAPgKAKQgKAJgPABg");
	this.shape_29.setTransform(81.5,11.4,1.024,1.127,180);

	this.timeline.addTween(cjs.Tween.get({}).to({state:[{t:this.shape_29},{t:this.shape_28}]}).wait(1));

	// blue
	this.shape_30 = new cjs.Shape();
	this.shape_30.graphics.lf(["#1E416F","#00ABE9"],[0,1],0,-10.7,0,10.7).s().p("AofBrQgNAAgLgLQgKgKAAgOIAAiPQAAgOAKgLQAKgKAOAAIQ+AAQAPAAAKAKQAKALAAAOIAACPQAAAOgKAKQgKALgPAAg");
	this.shape_30.setTransform(81.6,11.5);

	this.shape_31 = new cjs.Shape();
	this.shape_31.graphics.lf(["#1E416F","#00ABE9"],[0,1],0,-10.7,0,10.7).s().p("AofBrQgNAAgLgLQgKgKAAgOIAAiPQAAgOAKgLQAKgKAOAAIQ+AAQAPAAAKAKQAKALAAAOIAACPQAAAOgKAKQgKALgPAAg");
	this.shape_31.setTransform(81.4,11.4,1.024,1.124,180);

	this.timeline.addTween(cjs.Tween.get({}).to({state:[{t:this.shape_31},{t:this.shape_30}]}).wait(1));

}).prototype = p = new cjs.MovieClip();
p.nominalBounds = new cjs.Rectangle(22.2,-0.6,118.5,24.1);


(lib.arm = function(mode,startPosition,loop) {
	this.initialize(mode,startPosition,loop,{});

	// Layer 1
	this.instance = new lib.corkyarm();
	this.instance.setTransform(11.4,0,0.529,0.529,19.3);

	this.timeline.addTween(cjs.Tween.get(this.instance).wait(1));

}).prototype = p = new cjs.MovieClip();
p.nominalBounds = new cjs.Rectangle(0,0,161.2,85);


(lib.STARTPLANNING = function(mode,startPosition,loop) {
	this.initialize(mode,startPosition,loop,{});

	// Layer 1
	this.instance = new lib.greenbox();
	this.instance.setTransform(42.3,16.5,0.961,0.961,0,0,0,66.2,12.3);

	this.timeline.addTween(cjs.Tween.get(this.instance).wait(1));

}).prototype = p = new cjs.MovieClip();
p.nominalBounds = new cjs.Rectangle(0,4.1,113.9,23.2);


(lib.corky = function(mode,startPosition,loop) {
	this.initialize(mode,startPosition,loop,{});

	// timeline functions:
	this.frame_359 = function() {
		if(!this.alreadyExecuted){
		     this.alreadyExecuted=true;
		     this.loopNum=1;
		} else {
		     this.loopNum++;
		     if(this.loopNum==2){
		     this.stop();
		     }
		}
	}

	// actions tween:
	this.timeline.addTween(cjs.Tween.get(this).wait(359).call(this.frame_359).wait(1));

	// Layer 1
	this.instance = new lib.corky1111111();
	this.instance.setTransform(0,34.2,0.401,0.401,-16.5);

	this.timeline.addTween(cjs.Tween.get(this.instance).wait(360));

	// arm
	this.instance_1 = new lib.corkyarm();
	this.instance_1.setTransform(16,272.9,0.529,0.529,-87.7);

	this.instance_2 = new lib.arm();
	this.instance_2.setTransform(41.9,133.1,0.999,0.999,29.9,0,0,132.4,62.1);
	this.instance_2._off = true;

	this.timeline.addTween(cjs.Tween.get({}).to({state:[{t:this.instance_1,p:{rotation:-87.7,x:16,y:272.9}}]}).to({state:[{t:this.instance_1,p:{rotation:18.8,x:-79.7,y:72.2}}]},30).to({state:[{t:this.instance_1,p:{rotation:-16.5,x:-93.2,y:156}}]},50).to({state:[{t:this.instance_2}]},52).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).to({state:[{t:this.instance_2}]},1).wait(1));
	this.timeline.addTween(cjs.Tween.get(this.instance_2).wait(132).to({_off:false},0).wait(1).to({regX:80.6,regY:42.5,scaleX:1,scaleY:1,rotation:30,x:6.9,y:90.2},0).wait(106).to({rotation:24.1,x:2.6,y:94.1},0).wait(1).to({rotation:18.2,x:-1.2,y:98.4},0).wait(1).to({rotation:12.2,x:-4.6,y:103},0).wait(1).to({rotation:6.3,x:-7.4,y:108},0).wait(1).to({rotation:0.4,x:-9.8,y:113.2},0).wait(1).to({rotation:-5.5,x:-11.5,y:118.6},0).wait(1).to({rotation:-11.5,x:-12.7,y:124.2},0).wait(1).to({rotation:-17.4,x:-13.4,y:129.9},0).wait(1).to({rotation:-23.3,y:135.7},0).wait(1).to({rotation:-29.2,x:-12.8,y:141.4},0).wait(1).to({rotation:-35.2,x:-11.7,y:147},0).wait(1).to({rotation:-41.1,x:-10,y:152.5},0).wait(110));

}).prototype = p = new cjs.MovieClip();
p.nominalBounds = new cjs.Rectangle(0,0,184.9,274.3);


// stage content:



(lib.BCWI_5127_300x250_ThisThat_July19_EOpurple = function(mode,startPosition,loop) {
	this.initialize(mode,startPosition,loop,{});

	// timeline functions:
	this.frame_359 = function() {
		if(!this.alreadyExecuted){
		     this.alreadyExecuted=true;
		     this.loopNum=1;
		} else {
		     this.loopNum++;
		     if(this.loopNum==2){
		     this.stop();
		     }
		}
	}

	// actions tween:
	this.timeline.addTween(cjs.Tween.get(this).wait(359).call(this.frame_359).wait(1));

	// border
	this.shape = new cjs.Shape();
	this.shape.graphics.f().s("#221F20").ss(1,2,0,3).p("A3bzhMAu3AAAMAAAAnDMgu3AAAg");
	this.shape.setTransform(299.6,250.1,1.996,1.992);

	this.timeline.addTween(cjs.Tween.get(this.shape).wait(360));

	// START PLANNING
	this.instance = new lib.STARTPLANNING();
	this.instance.setTransform(204.8,349.3,2,2,0,0,0,81.4,14);
	this.instance.alpha = 0;
	this.instance._off = true;

	this.timeline.addTween(cjs.Tween.get(this.instance).wait(230).to({_off:false},0).wait(1).to({regX:56.9,regY:15.6,x:155.8,y:352.5,alpha:0.1},0).wait(1).to({alpha:0.2},0).wait(1).to({alpha:0.3},0).wait(1).to({alpha:0.4},0).wait(1).to({alpha:0.5},0).wait(1).to({alpha:0.6},0).wait(1).to({alpha:0.7},0).wait(1).to({alpha:0.8},0).wait(1).to({alpha:0.9},0).wait(1).to({alpha:1},0).wait(120));

	// corky
	this.instance_1 = new lib.corky();
	this.instance_1.setTransform(794.3,267.2,2,2,0,0,0,92.5,137.1);

	this.timeline.addTween(cjs.Tween.get(this.instance_1).wait(1).to({regX:40.3,x:671},0).wait(1).to({x:652.2},0).wait(1).to({x:633.3},0).wait(1).to({x:614.5},0).wait(1).to({x:595.6},0).wait(1).to({x:576.8},0).wait(1).to({x:557.9},0).wait(1).to({x:539},0).wait(1).to({x:520.2},0).wait(1).to({x:501.3},0).wait(1).to({x:482.5},0).wait(1).to({x:463.6},0).wait(1).to({x:444.8},0).wait(1).to({x:425.9},0).wait(346));

	// Wines BC logo
	this.shape_1 = new cjs.Shape();
	this.shape_1.graphics.f("#FFFFFF").s().p("AgwB4IAAjvIBhAAIAAAdIhAAAIAABIIA7AAIAAAbIg7AAIAABvg");
	this.shape_1.setTransform(197.7,430.4,0.827,0.827);

	this.shape_2 = new cjs.Shape();
	this.shape_2.graphics.f("#FFFFFF").s().p("Ag0BeQgPgeAAhAQAAhAAPgdQARgdAjAAQAlAAAQAdQAPAdAABAQAABAgPAdQgQAfglgBQgjAAgRgdgAgbhFQgIAUAAAxQABAxAHAUQAIAYATAAQAVAAAHgYQAIgUgBgxQAAgxgHgUQgIgYgUAAQgTAAgIAYg");
	this.shape_2.setTransform(185.6,430.4,0.827,0.827);

	this.shape_3 = new cjs.Shape();
	this.shape_3.graphics.f("#FFFFFF").s().p("AgvB4IAAjvIBfAAIAAAdIg+AAIAABIIA4AAIAAAbIg4AAIAABRIA+AAIAAAeg");
	this.shape_3.setTransform(158.9,430.4,0.827,0.827);

	this.shape_4 = new cjs.Shape();
	this.shape_4.graphics.f("#FFFFFF").s().p("AAfB4Ig9inIAACnIgfAAIAAjvIAeAAIA+CmIAAimIAfAAIAADvg");
	this.shape_4.setTransform(147,430.4,0.827,0.827);

	this.shape_5 = new cjs.Shape();
	this.shape_5.graphics.f("#FFFFFF").s().p("AgPB4IAAjvIAfAAIAADvg");
	this.shape_5.setTransform(137.6,430.4,0.827,0.827);

	this.shape_6 = new cjs.Shape();
	this.shape_6.graphics.f("#FFFFFF").s().p("AAeB4IgeipIgcCpIgbAAIgpjvIAhAAIAXCjIAcijIAZAAIAcCjIAXijIAhAAIgpDvg");
	this.shape_6.setTransform(126.7,430.4,0.827,0.827);

	this.shape_7 = new cjs.Shape();
	this.shape_7.graphics.f("#FFFFFF").s().p("AAnB4IgMgvIg1AAIgLAvIghAAIA4jvIAdAAIA4DvgAgUAuIApAAIgVhng");
	this.shape_7.setTransform(362.3,430.4,0.827,0.827);

	this.shape_8 = new cjs.Shape();
	this.shape_8.graphics.f("#FFFFFF").s().p("AgPB4IAAjvIAfAAIAADvg");
	this.shape_8.setTransform(353.7,430.4,0.827,0.827);

	this.shape_9 = new cjs.Shape();
	this.shape_9.graphics.f("#FFFFFF").s().p("Ag5B4IAAjvIAtAAQAhAAARAOQAPAOAAAhQABAYgIANQgHAOgSAFQAUADAIANQAJANAAAYQAAAjgRARQgRARghAAgAgXBaIAKAAQAUAAAIgIQAKgJgBgWQABgXgKgJQgIgKgTAAIgLAAgAgXgQIALAAQAiAAAAglQAAgVgIgIQgJgJgRAAIgLAAg");
	this.shape_9.setTransform(345.5,430.4,0.827,0.827);

	this.shape_10 = new cjs.Shape();
	this.shape_10.graphics.f("#FFFFFF").s().p("AA0B4IgKinIgfCnIgVAAIgginIgKCnIgeAAIAVjvIAeAAIAfClIAhilIAcAAIAWDvg");
	this.shape_10.setTransform(332,430.4,0.827,0.827);

	this.shape_11 = new cjs.Shape();
	this.shape_11.graphics.f("#FFFFFF").s().p("AgvBpQgPgPAAgkIAAivIAgAAIAACyQAAAiAeAAQAfAAAAgiIAAiyIAgAAIAACvQAAAkgPAPQgPARghAAQggAAgPgRg");
	this.shape_11.setTransform(318,430.6,0.827,0.827);

	this.shape_12 = new cjs.Shape();
	this.shape_12.graphics.f("#FFFFFF").s().p("AgyB4IAAjvIAhAAIAADRIBEAAIAAAeg");
	this.shape_12.setTransform(307.8,430.4,0.827,0.827);

	this.shape_13 = new cjs.Shape();
	this.shape_13.graphics.f("#FFFFFF").s().p("AgzBdQgQgdAAhAQAAhAAQgdQAQgdAjAAQAlAAAQAdQAPAdAABAQAABAgPAdQgQAfglgBQgjABgQgfgAgbhFQgHAUAAAxQAAAxAHAUQAIAYATAAQAVAAAIgYQAGgTAAgyQABgxgIgUQgIgYgUAAQgSAAgJAYg");
	this.shape_13.setTransform(295.6,430.4,0.827,0.827);

	this.shape_14 = new cjs.Shape();
	this.shape_14.graphics.f("#FFFFFF").s().p("Ag0ACQAAh9BLABQARAAANAGIAAAfQgOgHgLAAQgaAAgKAYQgMAWAAAvQAABbAtAAQANAAAPgJIAAAgQgQAJgSgBQhHAAAAh5g");
	this.shape_14.setTransform(284.4,430.4,0.827,0.827);

	this.shape_15 = new cjs.Shape();
	this.shape_15.graphics.f("#FFFFFF").s().p("AAdB4IAAh3Ig5AAIAAB3IggAAIAAjvIAgAAIAABcIA5AAIAAhcIAgAAIAADvg");
	this.shape_15.setTransform(267.9,430.4,0.827,0.827);

	this.shape_16 = new cjs.Shape();
	this.shape_16.graphics.f("#FFFFFF").s().p("AgwBvIAAghQAXAOARAAQANAAAJgJQAIgIAAgPQAAgPgLgOQgFgGgWgTQgUgOgIgOQgKgQAAgVQAAgcARgRQASgSAXAAQAWAAAVAKIAAAhQgUgOgRAAQgNAAgJAKQgKAJAAAPQAAAPAMAMQAGAHAVATQAUAOAJAPQAJAQAAAUQAAAcgRASQgSASgaAAQgUAAgWgMg");
	this.shape_16.setTransform(168.7,430.5,0.827,0.827);

	this.shape_17 = new cjs.Shape();
	this.shape_17.graphics.f("#FFFFFF").s().p("AgwBvIAAghQAWAOASAAQANAAAJgJQAIgIAAgPQABgPgLgOQgGgGgVgTQgVgPgIgNQgKgQAAgVQAAgcARgRQASgTAXABQAWAAAVAKIAAAhQgUgOgQAAQgOAAgJAKQgKAJAAAPQAAAPAMANQAGAGAWATQAUAOAIAPQAJAQAAAUQAAAcgRASQgSASgaAAQgUAAgWgMg");
	this.shape_17.setTransform(256.3,430.4,0.827,0.827);

	this.shape_18 = new cjs.Shape();
	this.shape_18.graphics.f("#FFFFFF").s().p("AgPB4IAAjvIAfAAIAADvg");
	this.shape_18.setTransform(248.5,430.4,0.827,0.827);

	this.shape_19 = new cjs.Shape();
	this.shape_19.graphics.f("#FFFFFF").s().p("AgPB4IAAjRIgtAAIAAgeIB5AAIAAAeIgtAAIAADRg");
	this.shape_19.setTransform(240.7,430.4,0.827,0.827);

	this.shape_20 = new cjs.Shape();
	this.shape_20.graphics.f("#FFFFFF").s().p("AgPB4IAAjvIAfAAIAADvg");
	this.shape_20.setTransform(233,430.4,0.827,0.827);

	this.shape_21 = new cjs.Shape();
	this.shape_21.graphics.f("#FFFFFF").s().p("AAaB4Ig1h2IgBAAIAAB2IggAAIAAjvIAnAAQAkAAARAOQARAOAAAjQABA2guADIA5B3gAgcgOIAKAAQATAAAIgKQAIgJgBgXQABgUgJgIQgIgHgTAAIgJAAg");
	this.shape_21.setTransform(225.2,430.4,0.827,0.827);

	this.shape_22 = new cjs.Shape();
	this.shape_22.graphics.f("#FFFFFF").s().p("Ag4B4IAAjvIAsAAQAiAAAPAOQARAOAAAhQAAAYgIANQgIAOgRAFQATADAJANQAIANAAAYQAAAjgQARQgRARghAAgAgYBaIALAAQAUAAAIgIQAJgJAAgWQAAgXgJgJQgJgKgTAAIgLAAgAgYgQIAMAAQARAAAIgJQAJgJAAgTQAAgVgIgIQgIgJgSAAIgMAAg");
	this.shape_22.setTransform(213.3,430.4,0.827,0.827);

	this.shape_23 = new cjs.Shape();
	this.shape_23.graphics.f("#FFFFFF").s().p("AhOCeQggghAAgvQAAgeAOgaQA3hnAFgOQAJgaACgRQAEgjgQgQQAbAAANAXQARAagMAhQgIAXgKAXIgRAhQAOgEANAAQAuAAAhAgQAhAggBAuQABAvghAhQghAgguAAQgtAAghgggAgxAcQgVAVAAAdQAAAeAVAUQAVAVAcAAQAdAAAVgVQAUgUABgeQgBgdgUgVQgVgVgdAAQgcAAgVAVg");
	this.shape_23.setTransform(71.6,410.5,0.827,0.827);

	this.shape_24 = new cjs.Shape();
	this.shape_24.graphics.f("#FFFFFF").s().p("AhHBPQghghAAguQAAgtAhghQAgggAtAAQAgAAAbAQQAaARAOAbIgrAJQgWgcgigBQgcABgVAUQgUAVAAAcQAAAdAUAVQAVAUAcABQAgAAAWgaIArAJQgOAagaAQQgaAPgfAAQgtABggghg");
	this.shape_24.setTransform(90.7,417,0.827,0.827);

	this.shape_25 = new cjs.Shape();
	this.shape_25.graphics.f("#FFFFFF").s().p("AhNBPQgighABguQgBgtAighQAgggAtAAQAuAAAgAgQAiAhAAAtQAAAugiAhQggAhgugBQgtABggghgAgxgxQgUAVAAAcQAAAdAUAVQAVAUAcABQAdgBAVgUQAVgVgBgdQABgbgVgWQgVgUgdgBQgcABgVAUg");
	this.shape_25.setTransform(81.6,434.1,0.827,0.827);

	this.shape_26 = new cjs.Shape();
	this.shape_26.graphics.f("#FFFFFF").s().p("AhNBPQghghgBguQABgtAhghQAgggAtAAQAuAAAhAgQAhAhgBAtQABAughAhQghAhgugBQgtABggghgAgxgxQgUAVAAAcQAAAdAUAVQAWAUAbABQAdgBAVgUQAUgVABgdQgBgcgUgVQgVgVgdAAQgcAAgVAVg");
	this.shape_26.setTransform(71.4,451.2,0.827,0.827);

	this.shape_27 = new cjs.Shape();
	this.shape_27.graphics.f("#FFFFFF").s().p("AhOBPQggghAAguQAAgtAgghQAhggAtAAQAuAAAhAgQAgAhABAtQgBAuggAhQghAhgugBQgtABghghgAgxgxQgVAVAAAcQAAAdAVAVQAVAUAcABQAdgBAVgUQAUgVAAgdQAAgbgUgWQgVgUgdgBQgcABgVAUg");
	this.shape_27.setTransform(61.6,434.1,0.827,0.827);

	this.shape_28 = new cjs.Shape();
	this.shape_28.graphics.f("#FFFFFF").s().p("AhOBPQggghgBguQABgtAgghQAhggAtAAQAuAAAhAgQAhAhgBAtQABAughAhQghAhgugBQgtABghghgAgxgxQgUAWAAAbQAAAdAUAVQAVAVAcAAQAdAAAUgVQAWgVAAgdQAAgbgWgWQgUgUgdgBQgbABgWAUg");
	this.shape_28.setTransform(51.8,417,0.827,0.827);

	this.timeline.addTween(cjs.Tween.get({}).to({state:[{t:this.shape_28},{t:this.shape_27},{t:this.shape_26},{t:this.shape_25},{t:this.shape_24},{t:this.shape_23},{t:this.shape_22},{t:this.shape_21},{t:this.shape_20},{t:this.shape_19},{t:this.shape_18},{t:this.shape_17},{t:this.shape_16},{t:this.shape_15},{t:this.shape_14},{t:this.shape_13},{t:this.shape_12},{t:this.shape_11},{t:this.shape_10},{t:this.shape_9},{t:this.shape_8},{t:this.shape_7},{t:this.shape_6},{t:this.shape_5},{t:this.shape_4},{t:this.shape_3},{t:this.shape_2},{t:this.shape_1}]}).wait(360));

	// savour this place
	this.shape_29 = new cjs.Shape();
	this.shape_29.graphics.f("#FFFFFF").s().p("AgZAaQgLgLAAgPQAAgPALgLQALgLAOAAQAPAAALALQALALAAAPQAAAPgLALQgLAMgPAAQgOAAgLgMg");
	this.shape_29.setTransform(307.7,125.2);

	this.shape_30 = new cjs.Shape();
	this.shape_30.graphics.f("#FFFFFF").s().p("AhlCpIAAlRIDJAAIAAA2IiRAAIAABaIBzAAIAAAxIhzAAIAABdICTAAIAAAzg");
	this.shape_30.setTransform(287.6,111.7);

	this.shape_31 = new cjs.Shape();
	this.shape_31.graphics.f("#FFFFFF").s().p("AgNCjQgPgGgNgHQgNgJgMgKQgLgLgJgOQgJgOgHgPQgOghAAgsQAAgqAOghQAOghAWgVQALgLANgJQANgHAPgGQAbgLAfAAQAZAAATAEIAbAIIgOAzIgcgHIgagCQgXgBgUAJQgSAIgOAPQgOAQgHAXQgIAXAAAbQAAAdAIAXQAIAWAOAQQAOAQASAIQASAIAYAAQAQAAAPgEIAXgGIAPAvQgLAFgTAEQgUAFgUAAQggAAgbgLg");
	this.shape_31.setTransform(259.6,111.7);

	this.shape_32 = new cjs.Shape();
	this.shape_32.graphics.f("#FFFFFF").s().p("ABdCrIgZg9IiKAAIgZA9Ig4AAICOlUIARAAICQFUgAg0BAIBlAAIgyh8g");
	this.shape_32.setTransform(231.2,111.5);

	this.shape_33 = new cjs.Shape();
	this.shape_33.graphics.f("#FFFFFF").s().p("AhkCpIAAlRIA4AAIAAEeICRAAIAAAzg");
	this.shape_33.setTransform(203.5,111.7);

	this.shape_34 = new cjs.Shape();
	this.shape_34.graphics.f("#FFFFFF").s().p("Ah2CpIAAlRIBCAAQBWAAArAdQAqAdAAA+QAAA3goAfQgUAPgdAHQgdAIglAAIgaAAIAABlgAg+ARIAaAAQA0AAAXgRQAMgHAGgMQAFgNAAgQQAAgQgFgNQgGgMgMgJQgMgIgTgEQgRgFgbAAIgaAAg");
	this.shape_34.setTransform(175.6,111.7);

	this.shape_35 = new cjs.Shape();
	this.shape_35.graphics.f("#FFFFFF").s().p("AgpCrIgggFIgbgIIgWgKIASgwIATAHIAaAIIAdAFIAeADQAhAAAQgLQAJgFAEgIQAFgIAAgLQAAgMgHgIQgFgIgKgHIgXgMIgZgLIgogQQgTgGgPgMQgPgMgJgQQgJgRAAgZQAAgYAJgRQAJgRAQgLQAQgLAWgFQAWgFAYAAQAlAAAZAGIAiAKIgPAyQgVgHgVgEQgWgEgVAAQgZAAgQAJQgIAEgEAHQgEAIAAAJQAAALAFAIQAGAJAKAGIAXAMIAZALIAnAQQATAJAPAKQAPALAKARQAJARAAAZQAAAVgHARQgHASgQAMQgPANgZAHQgZAHgiAAg");
	this.shape_35.setTransform(132.4,111.7);

	this.shape_36 = new cjs.Shape();
	this.shape_36.graphics.f("#FFFFFF").s().p("AgbCpIAAlRIA3AAIAAFRg");
	this.shape_36.setTransform(111.2,111.7);

	this.shape_37 = new cjs.Shape();
	this.shape_37.graphics.f("#FFFFFF").s().p("ABMCpIAAiRIiXAAIAACRIg5AAIAAlRIA5AAIAACNICXAAIAAiNIA5AAIAAFRg");
	this.shape_37.setTransform(87.1,111.7);

	this.shape_38 = new cjs.Shape();
	this.shape_38.graphics.f("#FFFFFF").s().p("AgbCpIAAkbIhmAAIAAg2IEDAAIAAA2IhmAAIAAEbg");
	this.shape_38.setTransform(55.4,111.7);

	this.shape_39 = new cjs.Shape();
	this.shape_39.graphics.f("#FFFFFF").s().p("ABACpIhEhtIgUABIgVABIgZAAIAABrIg4AAIAAlRIBBAAQBVAAAqAcQAVAPALAWQAKAWAAAfQAABDg9AcIBQB8gAhGANIAZAAQA1AAAWgPQAXgQAAggQAAgggXgRQgMgIgSgEQgSgEgbAAIgZAAg");
	this.shape_39.setTransform(213.7,57);

	this.shape_40 = new cjs.Shape();
	this.shape_40.graphics.f("#FFFFFF").s().p("AhgCJQgRgRgJgaQgIgaAAgiIAAjNIA4AAIAADKQAABaBKAAQBNAAAAhaIAAjKIA2AAIAADNQAAAhgIAaQgJAagRASQgjAjg+AAQg+AAgigjg");
	this.shape_40.setTransform(180.1,57.3);

	this.shape_41 = new cjs.Shape();
	this.shape_41.graphics.f("#FFFFFF").s().p("Ag7ChQgPgGgMgJQgMgIgKgMQgLgLgJgOQgIgOgFgQQgMggAAgnQAAgmAMggQAFgQAIgOQAJgOALgMQAKgLAMgJQAMgJAPgGQAcgMAfAAQAgAAAdAMQAOAGAMAJQAMAJAKALQALAMAIAOQAJAOAGAQQAFAQAEASQACASAAASQAAATgCASQgEASgFAQQgMAggWAXQgVAXgbAMQgdANggAAQgfAAgcgNgAgmhvQgSAJgNAQQgMAQgIAXQgHAWAAAZQAAAcAHAXQAIAWAMAQQANAQASAJQASAJAUAAQAVAAASgJQASgJANgQQAMgQAIgWQAHgXAAgcQAAgZgHgWQgIgXgMgQQgNgQgSgJQgSgJgVAAQgUAAgSAJg");
	this.shape_41.setTransform(145.6,57);

	this.shape_42 = new cjs.Shape();
	this.shape_42.graphics.f("#FFFFFF").s().p("AgHCrIiQlVIA7AAIBeDnIBejnIA4AAIiOFVg");
	this.shape_42.setTransform(113.4,57.2);

	this.shape_43 = new cjs.Shape();
	this.shape_43.graphics.f("#FFFFFF").s().p("ABdCqIgZg8IiKAAIgZA8Ig4AAICOlUIARAAICQFUgAg0A/IBlAAIgyh7g");
	this.shape_43.setTransform(85,56.8);

	this.shape_44 = new cjs.Shape();
	this.shape_44.graphics.f("#FFFFFF").s().p("AgpCrIgggFIgbgIIgWgKIASgwIATAHIAaAIIAdAFIAeADQAhAAAQgLQAJgFAEgIQAFgIAAgLQAAgMgHgIQgFgIgKgHIgXgMIgZgLIgogQQgTgGgPgMQgPgMgJgQQgJgRAAgZQAAgYAJgRQAJgRAQgLQAQgLAWgFQAWgFAYAAQAlAAAZAGIAiAKIgPAyQgVgHgVgEQgWgEgVAAQgZAAgQAJQgIAEgEAHQgEAIAAAJQAAALAFAIQAGAJAKAGIAXAMIAZALIAnAQQATAJAPAKQAPALAKARQAJARAAAZQAAAVgHARQgHASgQAMQgPANgZAHQgZAHgiAAg");
	this.shape_44.setTransform(55.1,57);

	this.shape_45 = new cjs.Shape();
	this.shape_45.graphics.f("#FFFFFF").s().p("AgOCjQgPgFgNgJQgNgHgLgMQgLgKgKgOQgIgOgHgQQgNgggBgsQABgqANghQANghAXgWQALgKANgJQANgIAOgFQAbgLAgAAQAZAAAUAEIAbAJIgQAyIgbgHIgbgDQgWAAgUAJQgRAIgOAQQgOAPgJAXQgHAXAAAbQAAAeAIAWQAIAXAOAQQAOAPASAIQATAIAWAAQARAAAQgEIAVgGIAQAuQgLAGgTAEQgTAFgWAAQgfAAgcgLg");
	this.shape_45.setTransform(273.6,359.7);

	this.shape_46 = new cjs.Shape();
	this.shape_46.graphics.f("#FFFFFF").s().p("ABdCqIgZg7IiKAAIgZA7Ig4AAICOlUIARAAICQFUgAg0BAIBlAAIgyh8g");
	this.shape_46.setTransform(245.2,359.5);

	this.shape_47 = new cjs.Shape();
	this.shape_47.graphics.f("#FFFFFF").s().p("ABdCqIgZg7IiKAAIgZA7Ig4AAICOlUIARAAICQFUgAg0BAIBlAAIgyh8g");
	this.shape_47.setTransform(120.3,359.5);

	this.shape_48 = new cjs.Shape();
	this.shape_48.graphics.f("#FFFFFF").s().p("AgbCpIAAkbIhmAAIAAg2IEDAAIAAA2IhmAAIAAEbg");
	this.shape_48.setTransform(55.4,359.7);

	this.shape_49 = new cjs.Shape();
	this.shape_49.graphics.f("#FFFFFF").s().p("AiBCpIAAlRIA6AAIAtADQAUACASAFQAlAKAbAVQAaAUAOAgQAHAQADATQAEAUAAAUQAAAWgEATQgDATgHAQQgOAggaAVQgbAUglAKQgSAFgUACIgtADgAhJB2IAcAAQA6AAAdgeQAegeAAg5QAAg2gdgfQgegeg6AAIgcAAg");
	this.shape_49.setTransform(124,305);

	this.shape_50 = new cjs.Shape();
	this.shape_50.graphics.f("#FFFFFF").s().p("AB0CrIjBjcIAADaIg2AAIAAlTIATAAIC9DZIAAjXIA3AAIAAFTg");
	this.shape_50.setTransform(90,305);

	this.shape_51 = new cjs.Shape();
	this.shape_51.graphics.f("#FFFFFF").s().p("AhlCpIAAlRIDJAAIAAA2IiRAAIAABaIBzAAIAAAxIhzAAIAABdICTAAIAAAzg");
	this.shape_51.setTransform(118.4,360);

	this.shape_52 = new cjs.Shape();
	this.shape_52.graphics.f("#FFFFFF").s().p("ABACpIhEhtIgUABIgVABIgZAAIAABrIg4AAIAAlRIBBAAQBVAAAqAcQAVAPALAWQAKAWAAAfQAABDg9AcIBQB8gAhGANIAZAAQA1AAAWgPQAXgQAAggQAAgggXgRQgMgIgSgEQgSgEgbAAIgZAAg");
	this.shape_52.setTransform(304.5,305.3);

	this.shape_53 = new cjs.Shape();
	this.shape_53.graphics.f("#FFFFFF").s().p("AhlCpIAAlRIDJAAIAAA2IiRAAIAABaIBzAAIAAAxIhzAAIAABdICTAAIAAAzg");
	this.shape_53.setTransform(274.9,305.3);

	this.shape_54 = new cjs.Shape();
	this.shape_54.graphics.f("#FFFFFF").s().p("Ag8ChQgNgGgNgJQgMgIgKgMQgLgLgIgOQgIgOgHgQQgMggABgnQgBgmAMggQAHgQAIgOQAIgOALgMQAKgLAMgJQANgJANgGQAdgMAfAAQAgAAAdAMQANAGANAJQAMAJAKALQALAMAIAOQAIAOAHAQQAFAQAEASQACASAAASQAAATgCASQgEASgFAQQgMAggWAXQgUAXgcAMQgdANggAAQgfAAgdgNgAgmhvQgSAJgNAQQgMAQgIAXQgHAWAAAZQAAAcAHAXQAIAWAMAQQANAQASAJQASAJAUAAQAVAAASgJQASgJANgQQAMgQAHgWQAIgXAAgcQAAgZgIgWQgHgXgMgQQgNgQgSgJQgSgJgVAAQgUAAgSAJg");
	this.shape_54.setTransform(212.4,305.3);

	this.shape_55 = new cjs.Shape();
	this.shape_55.graphics.f("#FFFFFF").s().p("AhlCpIAAlRIDJAAIAAA2IiRAAIAABaIBzAAIAAAxIhzAAIAABdICTAAIAAAzg");
	this.shape_55.setTransform(168.7,305.3);

	this.shape_56 = new cjs.Shape();
	this.shape_56.graphics.f("#FFFFFF").s().p("AgNCjQgPgGgNgHQgNgJgMgKQgMgLgIgOQgJgNgHgQQgOghAAgsQAAgqAOghQAOghAWgVQALgMANgHQANgJAPgFQAagLAgAAQAZAAATAEIAbAIIgOAzIgcgHIgagCQgXAAgUAIQgRAIgPAPQgOAQgHAXQgIAXAAAbQAAAdAIAXQAIAWAOAQQAOAQASAIQASAIAYAAQARAAAOgDIAXgHIAPAuQgLAGgTAEQgTAFgWAAQgfAAgbgLg");
	this.shape_56.setTransform(140.7,305.3);

	this.shape_57 = new cjs.Shape();
	this.shape_57.graphics.f("#FFFFFF").s().p("ABdCqIgZg7IiKAAIgZA7Ig4AAICOlUIARAAICQFUgAg0A/IBlAAIgyh7g");
	this.shape_57.setTransform(231.6,250.4);

	this.shape_58 = new cjs.Shape();
	this.shape_58.graphics.f("#FFFFFF").s().p("ABMCpIAAiRIiXAAIAACRIg5AAIAAlRIA5AAIAACNICXAAIAAiNIA5AAIAAFRg");
	this.shape_58.setTransform(198.4,250.6);

	this.shape_59 = new cjs.Shape();
	this.shape_59.graphics.f("#FFFFFF").s().p("AgbCpIAAkbIhmAAIAAg2IEDAAIAAA2IhmAAIAAEbg");
	this.shape_59.setTransform(166.7,250.6);

	this.shape_60 = new cjs.Shape();
	this.shape_60.graphics.f("#FFFFFF").s().p("ABdCqIgZg7IiKAAIgZA7Ig4AAICOlUIARAAICQFUgAg0A/IBlAAIgyh7g");
	this.shape_60.setTransform(56.9,250.4);

	this.shape_61 = new cjs.Shape();
	this.shape_61.graphics.f("#FFFFFF").s().p("AgOCjQgPgFgNgJQgNgHgLgMQgLgKgKgOQgIgOgHgQQgNggAAgsQAAgqANghQANggAXgWQALgMANgHQANgJAOgFQAbgLAgAAQAZAAAUAEIAbAIIgQAzIgbgHIgbgDQgWABgUAIQgRAIgOAQQgOAPgJAXQgHAXAAAbQAAAdAIAXQAIAWAOARQAOAPASAIQATAIAWAAQARAAAQgDIAVgHIAQAuQgLAGgTAEQgTAFgWAAQgfAAgcgLg");
	this.shape_61.setTransform(259.2,275.8);

	this.shape_62 = new cjs.Shape();
	this.shape_62.graphics.f("#FFFFFF").s().p("ABOCpIhTiIIhPCIIg5AAIBsizIhiieIA/AAIBIB3IBGh3IA5AAIhiCkIBtCtg");
	this.shape_62.setTransform(80.1,275.8);

	this.shape_63 = new cjs.Shape();
	this.shape_63.graphics.f("#FFFFFF").s().p("AgYCjQgdgLgXgWQgMgKgJgOQgJgOgHgQQgOggAAgsQAAgUAEgUQADgSAIgRQANghAYgWQAXgVAfgLQAdgLAiAAQAZAAAVAEQAVAFALAFIgPAyIgNgEIgQgDIgRgDIgOgBQgaAAgTAJQgWAIgPAQQgPAPgIAXQgJAWAAAcQAAAdAIAXQAJAWANAQQAPAPAUAJQASAIAYAAIAUgCIAQgDIAAhvIA2AAIAACWIgUAHIgYAFIgZAEIgWABQghAAgcgLg");
	this.shape_63.setTransform(194,221.1);

	this.shape_64 = new cjs.Shape();
	this.shape_64.graphics.f("#FFFFFF").s().p("AB0CrIjBjcIAADaIg2AAIAAlTIATAAIC9DZIAAjXIA3AAIAAFTg");
	this.shape_64.setTransform(163.6,221.1);

	this.shape_65 = new cjs.Shape();
	this.shape_65.graphics.f("#FFFFFF").s().p("AgbCpIAAlRIA3AAIAAFRg");
	this.shape_65.setTransform(141.6,221.1);

	this.shape_66 = new cjs.Shape();
	this.shape_66.graphics.f("#FFFFFF").s().p("AgbCpIAAlRIA3AAIAAFRg");
	this.shape_66.setTransform(100.5,221.1);

	this.shape_67 = new cjs.Shape();
	this.shape_67.graphics.f("#FFFFFF").s().p("Ah2CpIAAlRIBCAAQBWAAArAdQAqAdAAA+QAAA3goAfQgUAPgdAHQgdAIglAAIgaAAIAABlgAg+ARIAaAAQA0AAAXgRQAMgHAGgMQAFgNAAgQQAAgQgFgNQgGgMgMgJQgMgIgTgEQgRgFgbAAIgaAAg");
	this.shape_67.setTransform(55.1,221.1);

	this.shape_68 = new cjs.Shape();
	this.shape_68.graphics.f("#FFFFFF").s().p("AgbCpIAAh5Ih4jYIA9AAIBWCdIBZidIA7AAIh4DUIAAB9g");
	this.shape_68.setTransform(228.6,166.4);

	this.shape_69 = new cjs.Shape();
	this.shape_69.graphics.f("#FFFFFF").s().p("ABACpIhEhtIgUABIgVABIgZAAIAABrIg4AAIAAlRIBBAAQBVAAAqAcQAVAPALAWQAKAWAAAfQAABDg9AcIBQB8gAhGANIAZAAQA1AAAWgPQAXgQAAggQAAgggXgRQgMgIgSgEQgSgEgbAAIgZAAg");
	this.shape_69.setTransform(202.1,166.4);

	this.shape_70 = new cjs.Shape();
	this.shape_70.graphics.f("#FFFFFF").s().p("AhgCJQgRgRgJgaQgIgaAAgiIAAjNIA4AAIAADKQAABaBKAAQBNAAAAhaIAAjKIA2AAIAADNQAAAhgIAbQgJAZgRARQgjAkg+AAQg+AAgigjg");
	this.shape_70.setTransform(170.5,166.7);

	this.shape_71 = new cjs.Shape();
	this.shape_71.graphics.f("#FFFFFF").s().p("Ag7ChQgOgGgNgJQgMgIgLgMQgKgLgJgOQgIgOgGgQQgLgggBgnQABgmALggQAGgQAIgOQAJgOAKgMQALgLAMgJQANgJAOgGQAcgMAfAAQAgAAAcAMQAPAGAMAJQAMAJALALQAKAMAJAOQAHAOAGAQQAHAQACASQADASABASQgBATgDASQgCASgHAQQgMAggUAXQgWAXgcAMQgcANggAAQgfAAgcgNgAgmhvQgSAJgNAQQgNAQgHAXQgHAWAAAZQAAAcAHAXQAHAWANAQQANAQASAJQASAJAUAAQAVAAASgJQASgJANgQQANgQAGgWQAIgXAAgcQAAgZgIgWQgGgXgNgQQgNgQgSgJQgSgJgVAAQgUAAgSAJg");
	this.shape_71.setTransform(138,166.4);

	this.shape_72 = new cjs.Shape();
	this.shape_72.graphics.f("#FFFFFF").s().p("ABdCrIgZg8IiKAAIgZA8Ig4AAICOlUIARAAICQFUgAg0BAIBlAAIgyh8g");
	this.shape_72.setTransform(81.4,166.2);

	this.shape_73 = new cjs.Shape();
	this.shape_73.graphics.f("#FFFFFF").s().p("ABOCpIhTiIIhPCIIg5AAIBtizIhiieIA+AAIBIB3IBGh3IA5AAIhjCkIBuCtg");
	this.shape_73.setTransform(244.5,111.7);

	this.shape_74 = new cjs.Shape();
	this.shape_74.graphics.f("#FFFFFF").s().p("AhlCpIAAlRIDJAAIAAA2IiRAAIAABaIBzAAIAAAxIhzAAIAABdICTAAIAAAzg");
	this.shape_74.setTransform(217.8,111.7);

	this.shape_75 = new cjs.Shape();
	this.shape_75.graphics.f("#FFFFFF").s().p("AB0CrIjBjcIAADaIg2AAIAAlTIATAAIC9DZIAAjXIA3AAIAAFTg");
	this.shape_75.setTransform(188.6,111.7);

	this.shape_76 = new cjs.Shape();
	this.shape_76.graphics.f("#FFFFFF").s().p("ABACpIhEhtIgUABIgVABIgZAAIAABrIg4AAIAAlRIBBAAQBVAAAqAcQAVAPALAWQAKAWAAAfQAABDg9AcIBQB8gAhGANIAZAAQA1AAAWgPQAXgQAAggQAAgggXgRQgMgIgSgEQgSgEgbAAIgZAAg");
	this.shape_76.setTransform(148.3,111.7);

	this.shape_77 = new cjs.Shape();
	this.shape_77.graphics.f("#FFFFFF").s().p("AhgCJQgRgRgJgaQgIgaAAgiIAAjNIA4AAIAADKQAABaBKAAQBNAAAAhaIAAjKIA2AAIAADNQAAAhgIAbQgJAZgRASQgjAjg+AAQg+AAgigjg");
	this.shape_77.setTransform(116.7,112);

	this.shape_78 = new cjs.Shape();
	this.shape_78.graphics.f("#FFFFFF").s().p("Ag7ChQgOgGgNgJQgMgIgLgMQgKgLgJgOQgHgOgGgQQgNggAAgnQAAgmANggQAGgQAHgOQAJgOAKgMQALgLAMgJQANgJAOgGQAcgMAfAAQAgAAAcAMQAOAGANAJQANAJAKALQAKAMAJAOQAHAOAGAQQAHAQACASQAEASAAASQAAATgEASQgCASgHAQQgLAggVAXQgWAXgcAMQgcANggAAQgfAAgcgNgAgmhvQgSAJgNAQQgMAQgIAXQgHAWAAAZQAAAcAHAXQAIAWAMAQQANAQASAJQASAJAUAAQAVAAASgJQASgJANgQQAMgQAIgWQAHgXAAgcQAAgZgHgWQgIgXgMgQQgNgQgSgJQgSgJgVAAQgUAAgSAJg");
	this.shape_78.setTransform(84.2,111.7);

	this.shape_79 = new cjs.Shape();
	this.shape_79.graphics.f("#FFFFFF").s().p("AgbCpIAAh5Ih4jYIA9AAIBWCdIBZidIA7AAIh4DUIAAB9g");
	this.shape_79.setTransform(54.9,111.7);

	this.shape_80 = new cjs.Shape();
	this.shape_80.graphics.f("#FFFFFF").s().p("AB0CrIjBjcIAADaIg2AAIAAlTIATAAIC9DZIAAjXIA3AAIAAFTg");
	this.shape_80.setTransform(137.8,57);

	this.shape_81 = new cjs.Shape();
	this.shape_81.graphics.f("#FFFFFF").s().p("Ah2CpIAAlRIBCAAQBWAAArAdQAqAdAAA+QAAA3goAfQgUAPgdAHQgdAIglAAIgaAAIAABlgAg+ARIAaAAQA0AAAXgRQAMgHAGgMQAFgNAAgQQAAgQgFgNQgGgMgMgJQgMgIgTgEQgRgFgbAAIgaAAg");
	this.shape_81.setTransform(55.1,57);

	this.timeline.addTween(cjs.Tween.get({}).to({state:[]}).to({state:[{t:this.shape_44},{t:this.shape_43,p:{x:85,y:56.8}},{t:this.shape_42,p:{x:113.4,y:57.2}},{t:this.shape_41},{t:this.shape_40},{t:this.shape_39,p:{x:213.7,y:57}},{t:this.shape_38,p:{x:55.4,y:111.7}},{t:this.shape_37,p:{y:111.7}},{t:this.shape_36,p:{x:111.2,y:111.7}},{t:this.shape_35,p:{x:132.4,y:111.7}},{t:this.shape_34,p:{x:175.6,y:111.7}},{t:this.shape_33,p:{x:203.5,y:111.7}},{t:this.shape_32,p:{x:231.2,y:111.5}},{t:this.shape_31},{t:this.shape_30,p:{x:287.6,y:111.7}},{t:this.shape_29,p:{x:307.7,y:125.2}}]},30).to({state:[{t:this.shape_32,p:{x:56.9,y:304.8}},{t:this.shape_50,p:{y:305,x:90}},{t:this.shape_49,p:{y:305}},{t:this.shape_48,p:{x:55.4,y:359.7}},{t:this.shape_37,p:{y:359.7}},{t:this.shape_47},{t:this.shape_38,p:{x:146.5,y:359.7}},{t:this.shape_34,p:{x:189.6,y:359.7}},{t:this.shape_33,p:{x:217.5,y:359.7}},{t:this.shape_46,p:{x:245.2,y:359.5}},{t:this.shape_45},{t:this.shape_30,p:{x:301.6,y:359.7}},{t:this.shape_29,p:{x:321.7,y:373.2}}]},50).to({state:[{t:this.shape_60},{t:this.shape_50,p:{y:250.6,x:90}},{t:this.shape_49,p:{y:250.6}},{t:this.shape_59},{t:this.shape_58},{t:this.shape_57},{t:this.shape_48,p:{x:257.8,y:250.6}},{t:this.shape_34,p:{x:56.7,y:305.3}},{t:this.shape_33,p:{x:84.6,y:305.3}},{t:this.shape_43,p:{x:112.3,y:305.1}},{t:this.shape_56},{t:this.shape_55,p:{x:168.7,y:305.3}},{t:this.shape_54},{t:this.shape_42,p:{x:244.7,y:305.5}},{t:this.shape_53,p:{x:274.9,y:305.3}},{t:this.shape_52,p:{x:304.5,y:305.3}},{t:this.shape_38,p:{x:55.4,y:360}},{t:this.shape_37,p:{y:360}},{t:this.shape_51,p:{x:118.4,y:360}},{t:this.shape_39,p:{x:148,y:360}},{t:this.shape_30,p:{x:176.7,y:360}},{t:this.shape_29,p:{x:196.8,y:373.5}}]},51).to({state:[{t:this.shape_81},{t:this.shape_33,p:{x:81,y:57}},{t:this.shape_43,p:{x:106.7,y:56.8}},{t:this.shape_80},{t:this.shape_79},{t:this.shape_78},{t:this.shape_77},{t:this.shape_76},{t:this.shape_75},{t:this.shape_74},{t:this.shape_73},{t:this.shape_38,p:{x:272.8,y:111.7}},{t:this.shape_35,p:{x:53.5,y:166.4}},{t:this.shape_72},{t:this.shape_42,p:{x:107.8,y:166.6}},{t:this.shape_71},{t:this.shape_70},{t:this.shape_69},{t:this.shape_68},{t:this.shape_67},{t:this.shape_46,p:{x:79.5,y:220.9}},{t:this.shape_66},{t:this.shape_52,p:{x:122.1,y:221.1}},{t:this.shape_65},{t:this.shape_64},{t:this.shape_63},{t:this.shape_55,p:{x:53.4,y:275.8}},{t:this.shape_62},{t:this.shape_34,p:{x:109.7,y:275.8}},{t:this.shape_53,p:{x:135.7,y:275.8}},{t:this.shape_39,p:{x:163.3,y:275.8}},{t:this.shape_36,p:{x:182.8,y:275.8}},{t:this.shape_51,p:{x:201.9,y:275.8}},{t:this.shape_50,p:{y:275.8,x:229.9}},{t:this.shape_61},{t:this.shape_30,p:{x:285.2,y:275.8}},{t:this.shape_29,p:{x:303.3,y:289.3}}]},59).wait(170));

	// background
	this.instance_2 = new lib.BCWI5035_online_big_box_300x250_template_v3();
	this.instance_2.setTransform(600,0,2,2,0,0,180);

	this.timeline.addTween(cjs.Tween.get(this.instance_2).wait(360));

}).prototype = p = new cjs.MovieClip();
p.nominalBounds = new cjs.Rectangle(299.2,243,979.9,548.5);

})(lib = lib||{}, images = images||{}, createjs = createjs||{}, ss = ss||{});
var lib, images, createjs, ss;