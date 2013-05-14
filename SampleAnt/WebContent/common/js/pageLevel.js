jQuery(function() {
  (function($) {
    //뭐하는 코드 인지 의도 파악 필요
    //$('#imgService').attr('src', $('#imgService').attr('src').replace('.gif', 'http://errdoc.gabia.net/404.html') );
    $('.serviceLnb a').eq(0).addClass('on');
    $('#serviceLnb').css('display', 'block');
    
    function getContextPath(){
        var offset=location.href.indexOf(location.host)+location.host.length;
        var ctxPath=location.href.substring(offset,location.href.indexOf('/',offset+1));
        return ctxPath;
    }
    
    //
    var showGallery = function(){
        var jObj = $('#gallery_view');
    	
          jObj.css('display', 'block');
          $('#gallery_heads').css('cssText', 'left:0; top:0; width:100%; height:100%;');
          $('#gallery_heads').attr('src', getContextPath() + '/user/gallery/list.do');
    };
    
    var showBoard = function() {
        var jObj = $('#gallery_view');

        jObj.css('display', 'block');
        $('#gallery_heads').css('cssText', 'left:0; top:0; width:100%; height:100%;');
        $('#gallery_heads').attr('src', getContextPath() + '/user/userboard/list.do');
    };

    $("dt").bind('click', function() {
    	$('#sitemap').css('display', 'none')
    });

    //--------------- close 버튼 바인드---------------
    $('img[id="close_sitemap"]').css('cursor', 'pointer').bind('click', function() {
        $('#sitemap').css('display', 'none')
      });
    
    $('img[id="close_language"]').css('cursor', 'pointer').bind('click', function() {
        $('#language').css('display', 'none')
      });

    $('img[id="close_gallery"]').css('cursor', 'pointer').bind('click', function() {
        $('#gallery_view').css('display', 'none')
      });

  //--------------- close 버튼 바인드---------------
    
  //--------------- 메뉴  버튼 바인드---------------
    $('img[alt="Site map"]').css('cursor', 'pointer').bind('click', function() {
      $('#sitemap').css('display', 'block')
    });
    
    $('img[alt="language_setup"]').css('cursor', 'pointer').bind('click', function() {
      $('#language').css('display', 'block')
    });
    
    $('dt[title="Contact us"]').bind('click', function() {
      $('#contact').css('display', 'block')
    });    

    $('img[alt="userboard"]').css('cursor', 'pointer').bind('click', showBoard);
    
    $('img[alt="gallery"]').css('cursor', 'pointer').bind('click', showGallery);

    //--------------- 메뉴  버튼 바인드---------------
    
    $('#dragWrap_about').kinetic();
    $('#about_up').mousedown(function() {
      $('#dragWrap_about').kinetic('start', {
        velocityY : - 10
      });
    });
    $('#about_up').mouseup(function() {
      $('#dragWrap_about').kinetic('end');
    });
    $('#about_down').mousedown(function() {
      $('#dragWrap_about').kinetic('start', {
        velocityY : 10
      });
    });
    $('#about_down').mouseup(function() {
      $('#dragWrap_aboutr').kinetic('end');
    });
    
    $('#dragWrap_service01').kinetic();
    $('#service01_up').mousedown(function() {
      $('#dragWrap_service01').kinetic('start', {
        velocityY : - 10
      });
    });
    $('#service01_up').mouseup(function() {
      $('#dragWrap_service01').kinetic('end');
    });
    $('#service01_down').mousedown(function() {
      $('#dragWrap_service01').kinetic('start', {
        velocityY : 10
      });
    });
    $('#service01_down').mouseup(function() {
      $('#dragWrap_service01').kinetic('end');
    });
    
    $('#dragWrap_service02').kinetic();
    $('#service02_up').mousedown(function() {
      $('#dragWrap_service02').kinetic('start', {
        velocityY : - 10
      });
    });
    $('#service02_up').mouseup(function() {
      $('#dragWrap_service02').kinetic('end');
    });
    $('#service02_down').mousedown(function() {
      $('#dragWrap_service02').kinetic('start', {
        velocityY : 10
      });
    });
    $('#service02_down').mouseup(function() {
      $('#dragWrap_service02').kinetic('end');
    });
    
    $('#dragWrap_service03').kinetic();
    $('#service03_up').mousedown(function() {
      $('#dragWrap_service03').kinetic('start', {
        velocityY : - 10
      });
    });
    $('#service03_up').mouseup(function() {
      $('#dragWrap_service03').kinetic('end');
    });
    $('#service03_down').mousedown(function() {
      $('#dragWrap_service03').kinetic('start', {
        velocityY : 10
      });
    });
    $('#service03_down').mouseup(function() {
      $('#dragWrap_service03').kinetic('end');
    });
    
    $('#dragWrap_service04').kinetic();
    $('#service04_up').mousedown(function() {
      $('#dragWrap_service04').kinetic('start', {
        velocityY : - 10
      });
    });
    $('#service04_up').mouseup(function() {
      $('#dragWrap_service04').kinetic('end');
    });
    $('#service04_down').mousedown(function() {
      $('#dragWrap_service04').kinetic('start', {
        velocityY : 10
      });
    });
    $('#service04_down').mouseup(function() {
      $('#dragWrap_service04').kinetic('end');
    });
    
    $('#dragWrap_media').kinetic();
    $('#media_up').mousedown(function() {
      $('#dragWrap_media').kinetic('start', {
        velocityY : - 10
      });
    });
    $('#media_up').mouseup(function() {
      $('#dragWrap_media').kinetic('end');
    });
    $('#media_down').mousedown(function() {
      $('#dragWrap_media').kinetic('start', {
        velocityY : 10
      });
    });
    $('#media_down').mouseup(function() {
      $('#dragWrap_media').kinetic('end');
    });
    
    $('#dragWrap_portfolio').kinetic();
    $('#portfolio_up').mousedown(function() {
      $('#dragWrap_portfolio').kinetic('start', {
        velocityY : - 10
      });
    });
    $('#portfolio_up').mouseup(function() {
      $('#dragWrap_portfolio').kinetic('end');
    });
    $('#portfolio_down').mousedown(function() {
      $('#dragWrap_portfolio').kinetic('start', {
        velocityY : 10
      });
    });
    $('#portfolio_down').mouseup(function() {
      $('#dragWrap_portfolio').kinetic('end');
    });
    
    //웹페이지 전체 링크포커스 없애기 스크립트
    var myAnchors = $("A");
    for (i = 0; i < myAnchors.length; i++) {
      myAnchors [i].onfocus = new Function("myAnchors[" + i + "].blur()");
    }
    
  }) (jQuery);
});
