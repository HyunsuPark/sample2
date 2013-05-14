jQuery(function( $ ){
	/**
	 * Most jQuery.localScroll's settings, actually belong to jQuery.ScrollTo, check it's demo for an example of each option.
	 * @see http://flesler.demos.com/jquery/scrollTo/
	 * You can use EVERY single setting of jQuery.ScrollTo, in the settings hash you send to jQuery.LocalScroll.
	 */
	
	// The default axis is 'y', but in this demo, I want to scroll both
	// You can modify any default like this
	$.localScroll.defaults.axis = 'xy';
	
	// Scroll initially if there's a hash (#something) in the url 
	$.localScroll.hash({
		target: '#container', // Could be a selector or a jQuery object too.
		queue:true,
		duration:1500
	});
	
	/**
	 * NOTE: I use $.localScroll instead of $('#navigation').localScroll() so I
	 * also affect the >> and << links. I want every link in the page to scroll.
	 */
	$.localScroll({
		target: '#container', // could be a selector or a jQuery object too.
		queue:true,
		duration:1500,
		hash:true,
		onBefore:function( e, anchor, $target ){
			// The 'this' is the settings object, can be modified		
			//alert(anchor.id);

			//lnb img reset
			$('.lnb img').each(function(){			
				var lnbImgSrc = $(this).attr('src').replace('_on.gif', '.gif');
				$(this).attr('src', lnbImgSrc);				
			});		
			
			
			if (anchor.id == 'about'){
				$('#imgAbout').attr('src', $('#imgAbout').attr('src').replace('.gif', '_on.gif') );
				$('#serviceLnb').css('display', 'none');
				$('#dragWrap_about').scrollTo({top:'0px', left:'0px'}, 800 );
			}
			else if(anchor.id == 'service01' || anchor.id == 'service02' || anchor.id == 'service03' || anchor.id == 'service04'){
				$('#imgService').attr('src', $('#imgService').attr('src').replace('.gif', '_on.gif') );
				$('.serviceLnb a').each(function(){				
					$(this).removeClass('on');
				});
				
				if (anchor.id == 'service01'){
					$('.serviceLnb a').eq(0).addClass('on');
					$('#dragWrap_service01').scrollTo({top:'0px', left:'0px'}, 800 );
				}else if (anchor.id == 'service02'){
					$('.serviceLnb a').eq(1).addClass('on')
					$('#dragWrap_service02').scrollTo({top:'0px', left:'0px'}, 800 );
				}else if (anchor.id == 'service03'){
					$('.serviceLnb a').eq(2).addClass('on');
					$('#dragWrap_service03').scrollTo({top:'0px', left:'0px'}, 800 );
				}else if (anchor.id == 'service04'){
					$('.serviceLnb a').eq(3).addClass('on');
					$('#dragWrap_service04').scrollTo({top:'0px', left:'0px'}, 800 );
				}
				$('#serviceLnb').css('display', 'block');
				
			}else if(anchor.id == 'media' ){
				$('#imgMedia').attr('src', $('#imgMedia').attr('src').replace('.gif', '_on.gif') );
				$('#serviceLnb').css('display', 'none');
				$('#dragWrap_media').scrollTo({top:'0px', left:'0px'}, 800 );
			}else if(anchor.id == 'portfolio'){
				$('#imgPortfolio').attr('src', $('#imgPortfolio').attr('src').replace('.gif', '_on.gif') );
				$('#serviceLnb').css('display', 'none');
				$('#dragWrap_portfolio').scrollTo({top:'0px', left:'0px'}, 800 );
			}			
		},
		onAfter:function( anchor, settings ){
			// The 'this' contains the scrolled element (#content)			
			
		}
	});
});



