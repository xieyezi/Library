"use strict";

//Esc Key 
$.fn.escape = function(callback) {
    return this.each(function() {
        jQuery(document).on("keydown", this, function(e) {
            var keycode = ((typeof e.keyCode != 'undefined' && e.keyCode) ? e.keyCode : e.which);
            if (keycode === 27) {
                callback.call(this, e);
            };
        });
    });
};

//Menu Navigation Hamburger
var navigationRight = jQuery('.menu-wrap');

function Navigation() {
    var bodyEl = document.body,
        content = document.querySelector('#close-button'),
        openbtn = document.getElementById('open-button'),
        closebtn = document.getElementById('close-button'),
        isOpen = false;

    function init() {
        initEvents();
    }

    function initEvents() {
        openbtn.addEventListener('click', toggleMenu);
        if (closebtn) {
            closebtn.addEventListener('click', toggleMenu);
        }

        // close the menu element if the target it´s not the menu element or one of its descendants..
        content.addEventListener('click', function(ev) {
            var target = ev.target;
            if (isOpen && target !== openbtn) {
                toggleMenu();
            }
        });
    }

    function toggleMenu() {
        if (isOpen) {
            classie.remove(bodyEl, 'show-menu');
        } else {
            classie.add(bodyEl, 'show-menu');
        }
        isOpen = !isOpen;
    }

    navigationRight.escape(function() {
        if (isOpen) {
            classie.remove(bodyEl, 'show-menu');
            classie.remove(openbtn, 'active')
        }
        isOpen = !isOpen;
    });

    init();
};

//Tabs
function Tabs() {
    [].slice.call(document.querySelectorAll('.ef-tabs')).forEach(function(el) {
        new CBPFWTabs(el);
    });
};

//Dribble 
function getDribbbleThumbs() {
    jQuery.jribbble.setToken(dribbbleToken);
    jQuery.jribbble.users(dribbbleName).shots({
        per_page: numberOfItems
    }).then(function(shots) {
        var html = [];
        shots.forEach(function(shot) {
            html.push('<div class="col-md-4 col-sm-4 col-xs-12 mix">');
            html.push('<div class="img dribbble-shot">');
            html.push('<img src="' + shot.images.normal + '">');
            html.push('<div class="overlay-thumb">');
            html.push('<div class="details">');
            html.push('<span class="title">' + shot.title + '</span>');
            html.push('</div>');
            html.push('<span class="btnBefore"></span><span class="btnAfter"></span>');
            html.push('<a class="main-portfolio-link" href="' + shot.html_url + '" target="_blank">');
            html.push('</div>');
            html.push('</div>');
            html.push('</div>');
        });
        jQuery('#work-grid').html(html.join(''));
    });
};



//Scroll Top 
$.fn.scrollToTop = function() {
    jQuery(this).hide().removeAttr('href');
    if (jQuery(window).scrollTop() != '0') {
        jQuery(this).fadeIn('slow')
    }
    var scrollDiv = jQuery(this);
    jQuery(window).scroll(function() {
        if (jQuery(window).scrollTop() == '0') {
            jQuery(scrollDiv).fadeOut('slow')
        } else {
            jQuery(scrollDiv).fadeIn('slow')
        }
    });
    jQuery(this).on('click', function() {
        jQuery('html, body').animate({
            scrollTop: 0
        }, 'slow')
    })
};

//Detect Mobile
var isMobile = {
    Android: function() {
        return navigator.userAgent.match(/Android/i);
    },
    BlackBerry: function() {
        return navigator.userAgent.match(/BlackBerry/i);
    },
    iOS: function() {
        return navigator.userAgent.match(/iPhone|iPad|iPod/i);
    },
    Opera: function() {
        return navigator.userAgent.match(/Opera Mini/i);
    },
    Windows: function() {
        return navigator.userAgent.match(/IEMobile/i);
    },
    any: function() {
        return (isMobile.Android() || isMobile.BlackBerry() || isMobile.iOS() || isMobile.Opera() || isMobile.Windows());
    }
};

//Parallax Scroll
function parallaxScroll() {
    var scrolledY = jQuery(window).scrollTop();
    var headerImage = jQuery('.ef-parallax-bg');
    headerImage.css('background-position', 'center -' + ((scrolledY * 0.4)) + 'px');
};

//History Slider
function historySlider() {
    //History Images slide
    var historyimages = jQuery('#history-images');
    if (historyimages.length > 0) {
        historyimages.owlCarousel({
            singleItem: true,
            pagination: false,
            autoPlay: 2000,
            slideSpeed: 300
        });
    }
};

//Like
function likeEf() {
    jQuery('.like-product').on('click',  function() {
        jQuery(this).find('i').toggleClass('press');
        jQuery(this).find('i').removeClass('ion-ios-heart-outline');
        jQuery(this).find('span.like-product').toggleClass('press');
        if (jQuery(this).find('i').hasClass('press') || jQuery(this).find('i').hasClass('ion-ios-heart-outline')) {
            jQuery(this).find('.output').html(function(i, val) {
                return val * 1 + 1
            });
            jQuery(this).find('i').addClass('ion-ios-heart');
            jQuery(this).find('i').removeClass('ion-ios-heart-outline');
        } else {
            jQuery(this).find('.output').html(function(i, val) {
                return val * 1 - 1
            });
            jQuery(this).find('i').removeClass('ion-ios-heart');
            jQuery(this).find('i').addClass('ion-ios-heart-outline');

        }
    });
};

//Document Ready
jQuery(document).ready(function($) {
    
    //Navigation Sub Menu Triggering
    jQuery('.menu-item-has-children, .page_item_has_children').hover(function() {
        jQuery(this).children('.sub-menu').stop().slideDown(200);
    }, 
    function() {
        jQuery(this).children('.sub-menu').stop().slideUp(200);
    });

    //Mobile Menu Open/Close 
    jQuery('#open-mobile-menu').on('click', function() {
        var self = jQuery(this);
        var mobileMenu = jQuery('.menu-wrap-2');

        if (mobileMenu.hasClass('is-open')) {
            self.removeClass('active');
            mobileMenu.removeClass('is-open');
        } else {
            mobileMenu.addClass('is-open');
            self.addClass('active');
        }
    });

    //Dribbble
    if (jQuery('.dribble-grid').length > 0) {
        getDribbbleThumbs();
    };

    //Menu Right Side
    if (navigationRight.length > 0) {
        Navigation();
    };

    //Parallax Background on Desktop
    if (!isMobile.any()) {
        jQuery(window).on('scroll', function() {
            parallaxScroll();
        });
    };

    // Switch class on filter
    var showfilter = jQuery('.works-filter');
    jQuery('button.nav').on('click', function() {
        var self = jQuery(this);
        self.toggleClass('open');
        showfilter.toggleClass('open');
    });

    //Architecure Slider
    var archSlider = jQuery('#arch-slider');
    var prev = jQuery('.prev-slide');
    var next = jQuery('.next-slide');
    //Arch slider
    if (archSlider.length > 0) {
        archSlider.owlCarousel({
            singleItem: true,
            pagination: false,
            autoPlay: 5000,
            slideSpeed: 300,

        });
        prev.on('click', function() {
            archSlider.trigger('owl.prev');
        });
        next.on('click', function() {
            archSlider.trigger('owl.next');
        });
    };

    //Single Project Slider
    var singleProjectSlider = jQuery('.single-slider');
    if (singleProjectSlider.length > 0) {
        singleProjectSlider.owlCarousel({
            singleItem: true,
            pagination: false,
            autoPlay: 5000,
            slideSpeed: 300,

        });
        prev.on('click', function() {
            singleProjectSlider.trigger('owl.prev');
        });
        next.on('click', function() {
            singleProjectSlider.trigger('owl.next');
        });
    };

    //Team Slider
    var teamMembers = jQuery('.team');
    if (teamMembers.length > 0) {
        teamMembers.owlCarousel({
            pagination: true,
            items: 3,
            margin: 20,
            autoHeight: true,
            itemsDesktop: [1199, 3],
            itemsDesktopSmall: [980, 2],
            itemsTablet: [768, 2],
            itemsMobile: [479, 1]
        });
    };

    //Tabs Slider
    var tabsSlider = jQuery('#tabs-slider');
    if (tabsSlider.length > 0) {
        tabsSlider.owlCarousel({
            singleItem: true,
            pagination: false,
            autoPlay: 3000,
            slideSpeed: 600,
        });
    };

    //Search
    var wrap = jQuery('.js-ui-search');
    var close = jQuery('.js-ui-close');
    var input = jQuery('.js-ui-text');
    close.on('click', function() {
        wrap.toggleClass('open');
    });
    input.on('transitionend webkitTransitionEnd oTransitionEnd', function() {
        if (wrap.hasClass('open')) {
            input.focus();
        } else {
            return;
        }
    });

    //Finished loader
    Pace.on("done", function() {
        jQuery(".cover").addClass('animated fadeOutRight').fadeOut(1000);
    });

    //Magnific Popup  
    jQuery('.popup-video').magnificPopup({
        type: 'iframe',
        closeOnContentClick: true,
        closeBtnInside: false,
        fixedContentPos: true,
        mainClass: 'mfp-no-margins mfp-with-zoom', // class to remove default margin from left and right side
        image: {
            verticalFit: true
        },
        zoom: {
            enabled: true,
            duration: 300 // don't foget to change the duration also in CSS
        }
    });

    //Kenburnsy Slides
    jQuery('#slider-ef').kenburnsy();

    //Scroll Top
    jQuery('#scroll-top').scrollToTop();

    //Like
    likeEf();

    //Slider 
    historySlider();

    //Get social sharing
  //  getSocialButtons();

    //Init Tabs
    Tabs();

    //WOW Animation init 
    new WOW().init();

});

//Window Load
jQuery(window).load(function($) {
    
    /*Init Portfolio*/
    var container = jQuery("#work-grid");
    if (container.length > 0) {
        container.isotope({
            layoutMode: 'masonry',
            transitionDuration: '0.7s',
            columnWidth: 60
        });
    };

    //Filter Portfolio
    jQuery('a.filter').on('click', function() {
        var to_filter = jQuery(this).attr('data-filter');
        if (to_filter == 'all') {
            container.isotope({
                filter: '.mix'
            });
        } else {
            container.isotope({
                filter: '.' + to_filter
            });
        }
    });

    //Switch Classes portfolio
    jQuery('.filter').on('click', function() {
        jQuery('a.filter').removeClass('active');
        jQuery(this).addClass('active');
    });
});
(function($) {
	// page scroll
$(function() {
  $('a[href*=#]:not([href=#])').click(function() {
    if (location.pathname.replace(/^\//,'') == this.pathname.replace(/^\//,'') && location.hostname == this.hostname) {
      var target = $(this.hash);
      target = target.length ? target : $('[name=' + this.hash.slice(1) +']');
      if (target.length) {
        $('html,body').animate({
          scrollTop: target.offset().top -16
        }, 1000);
        return false;
      }
    }
  });
});
	
}(jQuery));
