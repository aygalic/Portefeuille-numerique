$(document).ready(function(){
        
    
    
    
animationHover('#bounceIn','bounceIn');
animationHover('#pulse1','pulse');
animationHover('#pulse2','pulse');
    
animationClick('#bounceOutUp1','bounceOutUp');
animationClick('#bounceOutUp2','bounceOutUp');
animationClick('#bounceOutUp3','bounceOutUp');


function animationHover(element, animation){
  element = $(element);
  element.hover(
    function() {
      element.addClass('animated ' + animation);
    },
    function(){
      //wait for animation to finish before removing classes
      window.setTimeout( function(){
        element.removeClass('animated ' + animation);
      });
    }
  );
};

function animationClick(element, animation){
  element = $(element);
  element.click(
    function() {
      element.addClass('animated ' + animation);
      //wait for animation to finish before removing classes
      window.setTimeout( function(){
          element.removeClass('animated ' + animation);
      },2000);
    }
  );
};   
    
    
    
        // Scroll the whole document
        $('#navbar').localScroll({target:'body'});

});