
var tpj;
var revapi26;
var revapi346;
var revapi96;

tpj=jQuery;


function load_rev_slider_1() {
    if(tpj("#rev_slider_26_1").revolution == undefined){
        revslider_showDoubleJqueryError("#rev_slider_26_1");
    }else{
        revapi26 = tpj("#rev_slider_26_1").show().revolution({
            sliderType:"standard",
            jsFileLocation:"revolution/js/",
            sliderLayout:"fullscreen",
            dottedOverlay:"none",
            delay:9000,
            navigation: {
                keyboardNavigation:"off",
                keyboard_direction: "horizontal",
                mouseScrollNavigation:"off",
                 mouseScrollReverse:"default",
                onHoverStop:"off",
                touch:{
                    touchenabled:"on",
                    touchOnDesktop:"off",
                    swipe_threshold: 75,
                    swipe_min_touches: 50,
                    swipe_direction: "horizontal",
                    drag_block_vertical: false
                },

                arrows: {
                    style:"metis",
                    enable:true,
                    hide_onmobile:false,
                    hide_onleave:false,
                    tmp:'',
                    left: {
                        h_align:"right",
                        v_align:"bottom",
                        h_offset:80,
                        v_offset:10
                    },
                    right: {
                        h_align:"right",
                        v_align:"bottom",
                        h_offset:10,
                        v_offset:10
                    }
                },
                bullets: {
                    enable:false,
                    hide_onmobile:false,
                    style:"bullet-bar",
                    hide_onleave:false,
                    direction:"horizontal",
                    h_align:"right",
                    v_align:"bottom",
                    h_offset:30,
                    v_offset:30,
                    space:5,
                    tmp:''
                }
            },
            responsiveLevels:[1240,1024,778,480],
            visibilityLevels:[1240,1024,778,480],
            gridwidth:[1270,1024,778,480],
            gridheight:[729,600,600,480],
            lazyType:"none",
            parallax: {
                type:"scroll",
                origo:"slidercenter",
                speed:2000,
                levels:[5,10,15,20,25,30,35,40,45,46,47,48,49,50,51,55],
            },
            shadow:0,
            spinner:"off",
            stopLoop:"off",
            stopAfterLoops:-1,
            stopAtSlide:-1,
            shuffle:"off",
            autoHeight:"off",
            fullScreenAutoWidth:"off",
            fullScreenAlignForce:"off",
            fullScreenOffsetContainer: ".site-header",
            fullScreenOffset: "0px",
            hideThumbsOnMobile:"off",
            hideSliderAtLimit:0,
            hideCaptionAtLimit:0,
            hideAllCaptionAtLilmit:0,
            debugMode:false,
            fallbacks: {
                simplifyAll:"off",
                nextSlideOnWindowFocus:"off",
                disableFocusListener:false,
            }
        });
    }
};

function load_rev_slider_2() {
    if(tpj("#rev_slider_one").revolution == undefined){
        revslider_showDoubleJqueryError("#rev_slider_one");
    }else{
        revapi26 = tpj("#rev_slider_one").show().revolution({
            sliderType:"standard",
            jsFileLocation:"revolution/js/",
            sliderLayout:"fullscreen",
            dottedOverlay:"none",
            delay:9000,
            navigation: {
                keyboardNavigation:"off",
                keyboard_direction: "horizontal",
                mouseScrollNavigation:"off",
                 mouseScrollReverse:"default",
                onHoverStop:"off",
                touch:{
                    touchenabled:"on",
                    touchOnDesktop:"off",
                    swipe_threshold: 75,
                    swipe_min_touches: 50,
                    swipe_direction: "horizontal",
                    drag_block_vertical: false
                },
                
                arrows: {
                    style: "uranus",
                    enable: true,
                    hide_onmobile: false,
                    hide_onleave: false,
                    left: {
                        h_align: "left",
                        v_align: "center",
                        h_offset: 0,
                        v_offset: 0
                    },
                    right: {
                        h_align: "right",
                        v_align: "center",
                        h_offset: 0,
                        v_offset: 0
                    }
                },
                bullets: {
                    enable:true,
                    hide_onmobile:false,
                    style:"hephaistos",
                    
                    hide_onleave:false,
                    direction:"horizontal",
                    h_align:"center",
                    v_align:"bottom",
                    h_offset:0,
                    v_offset:30,
                    space:5,
                    tmp:''
                }							
            },
            responsiveLevels:[1240,1024,778,480],
            visibilityLevels:[1240,1024,778,480],
            gridwidth:[1270,1024,778,480],
            gridheight:[729,768,768,720],
            lazyType:"none",
            parallax: {
                type:"scroll",
                origo:"slidercenter",
                speed:2000,
                levels:[5,10,15,20,25,30,35,40,45,46,47,48,49,50,51,55],
            },
            shadow:0,
            spinner:"off",
            stopLoop:"off",
            stopAfterLoops:-1,
            stopAtSlide:-1,
            shuffle:"off",
            autoHeight:"off",
            fullScreenAutoWidth:"off",
            fullScreenAlignForce:"off",
            fullScreenOffsetContainer: "",
            fullScreenOffset: "30px",
            hideThumbsOnMobile:"off",
            hideSliderAtLimit:0,
            hideCaptionAtLimit:0,
            hideAllCaptionAtLilmit:0,
            debugMode:false,
            fallbacks: {
                simplifyAll:"off",
                nextSlideOnWindowFocus:"off",
                disableFocusListener:false,
            }
        });
    }
};

function load_rev_slider_3() {
    if(tpj("#rev_slider_three").revolution == undefined){
        revslider_showDoubleJqueryError("#rev_slider_three");
    }else{
        revapi26 = tpj("#rev_slider_three").show().revolution({
            sliderType:"standard",
            jsFileLocation:"revolution/js/",
            sliderLayout:"fullwidth",
            dottedOverlay:"none",
            delay:9000,
            navigation: {
                keyboardNavigation:"off",
                keyboard_direction: "horizontal",
                mouseScrollNavigation:"off",
                 mouseScrollReverse:"default",
                onHoverStop:"off",
                touch:{
                    touchenabled:"on",
                    touchOnDesktop:"off",
                    swipe_threshold: 75,
                    swipe_min_touches: 50,
                    swipe_direction: "horizontal",
                    drag_block_vertical: false
                },

                arrows: {
                    style:"metis",
                    enable:true,
                    hide_onmobile:true,
                    hide_onleave:false,
                    tmp:'',
                    left: {
                        h_align:"left",
                        v_align:"bottom",
                        h_offset:10,
                        v_offset:10
                    },
                    right: {
                        h_align:"right",
                        v_align:"bottom",
                        h_offset:10,
                        v_offset:10
                    }
                },
                bullets: {
                    enable:true,
                    hide_onmobile:false,
                    style:"hesperiden",
                    hide_onleave:false,
                    direction:"horizontal",
                    h_align:"center",
                    v_align:"bottom",
                    h_offset:0,
                    v_offset:30,
                    space:5,
                    tmp:''
                }
            },
            responsiveLevels:[1240,1024,778,480],
            visibilityLevels:[1240,1024,778,480],
            gridwidth:[1220,1024,778,480],
            gridheight:[694,694,694,600],
            lazyType:"none",
            parallax: {
                type:"scroll",
                origo:"slidercenter",
                speed:2000,
                levels:[5,10,15,20,25,30,35,40,45,46,47,48,49,50,51,55],
            },
            shadow:0,
            spinner:"off",
            stopLoop:"off",
            stopAfterLoops:-1,
            stopAtSlide:-1,
            shuffle:"off",
            autoHeight:"off",
            fullScreenAutoWidth:"off",
            fullScreenAlignForce:"off",
            fullScreenOffsetContainer: ".site-header",
            fullScreenOffset: "0px",
            hideThumbsOnMobile:"off",
            hideSliderAtLimit:0,
            hideCaptionAtLimit:0,
            hideAllCaptionAtLilmit:0,
            debugMode:false,
            fallbacks: {
                simplifyAll:"off",
                nextSlideOnWindowFocus:"off",
                disableFocusListener:false,
            }
        });
    }
};

function load_rev_slider_5() {
	if(tpj("#rev_slider_346_1").revolution == undefined){
		revslider_showDoubleJqueryError("#rev_slider_346_1");
	}else{
        
		revapi346 = tpj("#rev_slider_346_1").show().revolution(
            {
                "sliderType":"standard",
                "jsFileLocation":"//server.local/revslider/wp-content/plugins/revslider/public/assets/js/",
                "sliderLayout":"fullscreen",
                "dottedOverlay":"none",
                "delay":9000,
                "particles":{
                   "startSlide":"2",
                   "endSlide":"2",
                   "zIndex":"1",
                   "particles":{
                      "number":{
                         "value":80
                      },
                      "color":{
                         "value":"#ffffff"
                      },
                      "shape":{
                         "type":"circle",
                         "stroke":{
                            "width":0,
                            "color":"#ffffff",
                            "opacity":1
                         },
                         "image":{
                            "src":""
                         }
                      },
                      "opacity":{
                         "value":0.5,
                         "random":true,
                         "min":0.25,
                         "anim":{
                            "enable":false,
                            "speed":3,
                            "opacity_min":0,
                            "sync":false
                         }
                      },
                      "size":{
                         "value":2,
                         "random":true,
                         "min":0.5,
                         "anim":{
                            "enable":false,
                            "speed":40,
                            "size_min":1,
                            "sync":false
                         }
                      },
                      "line_linked":{
                         "enable":false,
                         "distance":150,
                         "color":"#ffffff",
                         "opacity":0.4,
                         "width":1
                      },
                      "move":{
                         "enable":true,
                         "speed":1,
                         "direction":"none",
                         "random":true,
                         "min_speed":1,
                         "straight":false,
                         "out_mode":"out"
                      }
                   },
                   "interactivity":{
                      "events":{
                         "onhover":{
                            "enable":false,
                            "mode":"repulse"
                         },
                         "onclick":{
                            "enable":false,
                            "mode":"repulse"
                         }
                      },
                      "modes":{
                         "grab":{
                            "distance":400,
                            "line_linked":{
                               "opacity":0.5
                            }
                         },
                         "bubble":{
                            "distance":400,
                            "size":40,
                            "opacity":0.4
                         },
                         "repulse":{
                            "distance":200
                         }
                      }
                   }
                },
                "navigation":{
                   "keyboardNavigation":"off",
                   "keyboard_direction":"horizontal",
                   "mouseScrollNavigation":"off",
                   "mouseScrollReverse":"default",
                   "onHoverStop":"off",
                   "arrows":{
                      "style":"uranus",
                      "enable":false,
                      "hide_onmobile":false,
                      "hide_onleave":false,
                      "left":{
                         "h_align":"left",
                         "v_align":"center",
                         "h_offset":0,
                         "v_offset":0
                      },
                      "right":{
                         "h_align":"right",
                         "v_align":"center",
                         "h_offset":0,
                         "v_offset":0
                      }
                   },
                   "bullets":{
                      "enable":true,
                      "hide_onmobile":false,
                      "style":"hephaistos",
                      "hide_onleave":false,
                      "direction":"horizontal",
                      "h_align":"center",
                      "v_align":"bottom",
                      "h_offset":0,
                      "v_offset":30,
                      "space":5,
                      "tmp":""
                   }
                },
                "responsiveLevels":[
                   1240,
                   1240,
                   1240,
                   480
                ],
                "visibilityLevels":[
                   1240,
                   1240,
                   1240,
                   480
                ],
                "gridwidth":[
                   1200,
                   1200,
                   1200,
                   480
                ],
                "gridheight":[
                   800,
                   800,
                   800,
                   700
                ],
                "lazyType":"none",
                "parallax":{
                   "type":"mouse+scroll",
                   "origo":"slidercenter",
                   "speed":400,
                   "speedbg":0,
                   "speedls":0,
                   "levels":[
                      1,
                      2,
                      3,
                      4,
                      5,
                      6,
                      7,
                      8,
                      12,
                      16,
                      47,
                      48,
                      49,
                      50,
                      51,
                      55
                   ]
                },
                "shadow":0,
                "spinner":"off",
                "stopLoop":"off",
                "stopAfterLoops":-1,
                "stopAtSlide":-1,
                "shuffle":"off",
                "autoHeight":"off",
                "fullScreenAutoWidth":"off",
                "fullScreenAlignForce":"off",
                "fullScreenOffsetContainer":".site-header",
                "fullScreenOffset":"0px",
                "hideThumbsOnMobile":"off",
                "hideSliderAtLimit":0,
                "hideCaptionAtLimit":0,
                "hideAllCaptionAtLilmit":0,
                "debugMode":false,
                "fallbacks":{
                   "simplifyAll":"off",
                   "nextSlideOnWindowFocus":"off",
                   "disableFocusListener":false
                }
             }
        );
		var ua = window.navigator.userAgent;
		var msie = ua.indexOf("MSIE ");

		if(msie > 0 || !!navigator.userAgent.match(/Trident.*rv\:11\./) || ('CSS' in window && 'supports' in window.CSS && !window.CSS.supports('mix-blend-mode', 'screen'))) {
		 
			 var bgColor = 'rgba(245, 245, 245, 0.5)';
			 //jQuery('.rev_slider .tp-caption[data-blendmode]').removeAttr('data-blendmode').css('background', bgColor);
			 jQuery('.rev_slider .tp-caption.tp-blendvideo[data-blendmode]').remove();
			}	


		// BEFORE/AFTER INITIALISATION
		RevSliderBeforeAfter(tpj, tpj("#rev_slider_346_1"), {
	        arrowStyles: {
	            leftIcon: "fa fa-caret-left",
	            rightIcon: "fa fa-caret-right",
	            topIcon: "fa fa-caret-up",
	            bottomIcon: "fa fa-caret-down",
	            size: "35",
	            color: "#ffffff",
	            bgColor: "transparent",
	            spacing: "10",
	            padding: "0",
	            borderRadius: "0"
	        },
	        dividerStyles: {
	            width: "1",
	            color: "rgba(255, 255, 255, 0.5)"
	        },
	        onClick: {
	            time: "500",
	            easing: "Power2.easeOut",
	        },
	        cursor: "move",
	        carousel: false
	    });	

		// PARTICLES INITIALISATION
    	// RsParticlesAddOn(revapi346);
		
	}
};

function load_rev_slider_6() {				
    if (tpj===undefined) { tpj = jQuery; if("off" == "on") tpj.noConflict();}
if(tpj("#slider-video").revolution == undefined){
    revslider_showDoubleJqueryError("#slider-video");
}else{
    revapi96 = tpj("#slider-video").show().revolution({
        sliderType:"standard",
        jsFileLocation:"revolution/js/",
        sliderLayout:"fullScreen",
        dottedOverlay:"none",
        delay:9000,
        revealer: {
            direction: "tlbr_skew",
            color: "#ffffff",
            duration: "1500",
            delay: "0",
            easing: "Power3.easeOut",
            spinner: "2",
            spinnerColor: "rgba(0,0,0,",
        },
        navigation: {
            keyboardNavigation:"off",
            keyboard_direction: "horizontal",
            mouseScrollNavigation:"off",
                         mouseScrollReverse:"default",
            onHoverStop:"off",
            arrows: {
                style:"uranus",
                enable:false,
                hide_onmobile:false,
                hide_onleave:false,
                tmp:'',
                left: {
                    h_align:"left",
                    v_align:"center",
                    h_offset:20,
                    v_offset:50
                },
                right: {
                    h_align:"right",
                    v_align:"center",
                    h_offset:20,
                    v_offset:50
                }
            }
        },
        responsiveLevels:[1240,1024,778,480],
        visibilityLevels:[1240,1024,778,480],
        gridwidth:[1240,1024,778,480],
        gridheight:[800,700,600,500],
        lazyType:"none",
        parallax: {
            type:"scroll",
            origo:"slidercenter",
            speed:400,
            speedbg:0,
            speedls:0,
            levels:[5,10,15,20,25,30,35,40,45,-10,-15,-20,-25,50,51,55],
        },
        shadow:0,
        spinner:"spinner5",
        stopLoop:"off",
        stopAfterLoops:-1,
        stopAtSlide:-1,
        shuffle:"off",
        autoHeight:"off",
        fullScreenOffsetContainer: ".site-header",
        hideThumbsOnMobile:"off",
        hideSliderAtLimit:0,
        hideCaptionAtLimit:0,
        hideAllCaptionAtLilmit:0,
        debugMode:false,
        fallbacks: {
            simplifyAll:"off",
            nextSlideOnWindowFocus:"off",
            disableFocusListener:false,
        }
    });
}; /* END OF revapi call */

// RsRevealerAddOn(tpj, revapi96, "<div class='rsaddon-revealer-spinner rsaddon-revealer-spinner-2'><div class='rsaddon-revealer-2' style='border-top-color: {{color}}0.65); border-bottom-color: {{color}}0.15); border-left-color: {{color}}0.65); border-right-color: {{color}}0.15)'><\/div><\/div>");

            RsTypewriterAddOn(tpj, revapi96);

};