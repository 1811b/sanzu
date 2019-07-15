define("home/widget/book_tab",function(require,exports,module){"use strict";function t(t){this.conf=$.extend({$el:null,hasButton:!1,evt:"click",effect:"",isAutoPlay:!1,navEl:".nav-item",contentEl:".content-item",curCls:"current"},t),this.init()}return t.prototype={constructor:t,init:function(){$(window).trigger("resize"),this.initTab()},initTab:function(){var t=this.conf.$el,n=this.conf.evt,i=this.conf.hasButton,c=this.conf.effect,e=this.conf.isAutoPlay,o=this.conf.navEl,s=this.conf.contentEl,a=this.conf.curCls;seajs.use("jdf/2.0.0/ui/tab/1.0.0/tab",function(f){var u=t.tab({navEl:o,contentEl:s,curCls:a,evt:n,effect:c,isAutoPlay:e,onChange:function(t){t.contentEl.o2lazyload({source:"data-lazy-src",webpQuality:95})}});i&&(t.find(".tab-prev").click(function(){u.prev()}),t.find(".tab-next").click(function(){u.next()}))})}},t});define("home/widget/book_nav",function(require,exports,module){"use strict";function t(t){this.conf=$.extend({$el:null},t),this.init()}return t.prototype={constructor:t,init:function(){this.initEvent()},initEvent:function(){var t=this.conf.$el;t.delegate(".book_nav_body .item","mouseenter",function(){var t=$(this),e=t.find(".item_body"),o=(t.index(),e.find(".book_nav_sub"),$(".book_nav").offset().top),i=t.offset().top-o,n=(e.outerHeight()-t.outerHeight())/2,s=$(".book_nav").height()-(t.offset().top-o+t.outerHeight());e.outerHeight()/2>s?e.css("bottom",-s):e.css("top",n>i?-i:-n),e.show(),t.addClass("item_hover")}).delegate(".book_nav_body .item","mouseleave",function(){$(this).removeClass("item_hover").find(".item_body").hide()})}},t});define("home/widget/book_badge",function(require,exports,module){"use strict";function e(e){this.conf=$.extend({$el:null},e),this.init()}return e.prototype={constructor:e,init:function(){this.getBadge()},getBadge:function(){var e=this;$.ajax({type:"get",async:!1,url:"//vip.jd.com/medal/getMedalByMedalIdAndPin.html",dataType:"jsonp",data:{mid:60},scriptCharset:"utf-8",crossDomain:!0,success:function(i){if(i&&i.success===!0){var t,n,o,l,s=i.result,a=s.medal.medalFather,r=[];if(s&&s.medalUser){l=s.medalUser.level,t=s.medal.medalChildList;for(var c in t)n=t[c],r[n.level]=n.imgurl;r[0]=a.imgurl,o="//img13.360buyimg.com/vip/"+r[l]}else o="//img13.360buyimg.com/vip/"+a.imgurl;e.conf.$el.find(".icon").attr("src",o)}},error:function(e,i){window.console&&console.log(i)}})}},e});define("home/widget/book_rank",function(require,exports,module){"use strict";function t(t){this.conf=$.extend({$el:null},t),this.init()}return t.prototype={constructor:t,init:function(){$(window).trigger("resize"),this.initTab(),this.conf.$el.find(".p-item").mouseover(function(){$(this).siblings().removeClass("current"),$(this).addClass("current")})},initTab:function(){var t=this.conf.$el;seajs.use("jdf/2.0.0/ui/tab/1.0.0/tab",function(n){t.tab({navEl:".nav-item",contentEl:".content-item",curCls:"current",evt:"mouseover",onChange:function(t){t.contentEl.find(".p-item").removeClass("current").eq(0).addClass("current"),t.contentEl.o2lazyload({source:"data-lazy-src",webpQuality:95})}})})}},t});define("home/widget/book_news",function(require,exports,module){"use strict";function i(i){this.conf=$.extend({$el:null},i),this.init()}return i.prototype={constructor:i,init:function(){$(window).trigger("resize"),this.initScroll()},initScroll:function(){var i=this.conf.$el;seajs.use("jdf/2.0.0/ui/slider/1.0.0/slider",function(t){i.slider({contentEl:".content-item",curCls:"current",isAutoPlay:!0,isLoop:!0,isAlignX:!1,visible:1,step:1})})}},i});define("home/widget/book_hot",function(require,exports,module){"use strict";var t=$(".book_hot").find(".item");t.hover(function(){$(this).siblings().removeClass("current"),$(this).addClass("current")})});define("home/widget/book_author",function(require,exports,module){"use strict";function e(e){this.conf=$.extend({$el:null},e),this.init()}return e.prototype={constructor:e,init:function(){$(window).trigger("resize"),this.initScroll()},initScroll:function(){var e=this.conf.$el;seajs.use(["jdf/2.0.0/ui/slider/1.0.0/slider","channel/lib/1.2.0/js/webp"],function(n){e.slider({contentEl:".p-item",curCls:"current",visible:4,step:4,nextEl:".tab-next",prevEl:".tab-prev",interval:3e3,onChange:function(e){e.screenContentEls.imgWebp()}})})}},e});define("home/widget/book_found",function(require,exports,module){"use strict";exports.init=function(i){var e,t=i.find(".list"),o=t.data("channel"),n=t.data("floor"),d=1,c='{for item in list}{if item.subPosition == 8}<li class="p-item" clstag="channel|keycount|'+o+"|"+n+'_item_${item.id}"><a href="//fxhh.jd.com/detail.html?id=${item.id}" target="_blank"><div class="p-img"><img src="${item.goodsPic}" width="200" height="200"></div><div class="p-name">${item.recommendTheme}</div><div class="p-sub">${item.recommendReason}</div><div class="p-num"><i></i><em>${item.likeNum}</em></div></a></li>{/if}{/for}',s=function(i){var e=$(i).offset().top+$(i).outerHeight(),t=document.documentElement.scrollTop||document.body.scrollTop||0,o=document.documentElement.clientHeight||document.body.clientHeight||0;t>=e-o&&(d+=1,d>5?$(window).unbind("scroll",a):m(d))},a=function(){clearTimeout(e),e=setTimeout(function(){s(t)},300)};$(window).bind("scroll",a);var m=function(){$.ajax({url:"//ai.jd.com/index_new?app=Discovergoods&action=getDiscZdmGoodsListForCateId",data:{cateId:1713,page:d,pageSize:12,cateLevel:2},dataType:"jsonp",timeout:3e3,success:function(e){i.css("height","auto"),0==e.code&&e.list.length>0?seajs.use("jdf/1.0.0/unit/trimPath/1.0.0/trimPath",function(){t.find(".clr").before(c.process(e))}):$(window).unbind("scroll",a)},error:function(){$(window).unbind("scroll",a),i.hide()}})};m()}});define("home/widget/book_elevator",function(require,exports,module){"use strict";function t(t){this.conf=$.extend({$el:null},t),this.init()}var e=function(t,e,i){var o,n,l,r=null,s=0;i||(i={});var a=function(){s=i.leading===!1?0:(new Date).getTime(),r=null,l=t.apply(o,n),r||(o=n=null)};return function(){var c=(new Date).getTime();s||i.leading!==!1||(s=c);var h=e-(c-s);return o=this,n=arguments,h<=0||h>e?(clearTimeout(r),r=null,s=c,l=t.apply(o,n),r||(o=n=null)):r||i.trailing===!1||(r=setTimeout(a,h)),l}};return t.prototype={init:function(){this.$elevatorEles=$("[data-elevator]"),this.$win=$(window),this.setStyle(),this.initEvent()},setStyle:function(){var t=this.conf.$el,e=document.documentElement.clientWidth,i=1210,o="ie6"===o2.detect.browser().browser;if(!o){var n=parseInt(.5*document.documentElement.clientHeight-.5*t.height(),10);t.css({top:n})}t.css({right:(e-i)/2-t.width()-10}),e<1380&&t.css({right:0})},initEvent:function(){this.conf.$el.delegate(".book_elevator_item_btn","click",$.proxy(this.go,this)),$(window).bind("scroll.elevator",$.proxy(e(this.onScroll,500),this)).bind("resize.elevator",$.proxy(this.setStyle,this))},go:function(t){t&&t.preventDefault();var e=$(t.currentTarget),i=e.parent(),o=i.index(),n=0;e.hasClass("book_elevator_top")||(n=this.$elevatorEles.eq(o).offset().top),$("body,html").stop(!1,!0).animate({scrollTop:n},300)},onScroll:function(){var t=this.$win,e=t.scrollTop(),i=this.conf.$el,o=-1,n=t.height()/3;if(e>=100&&e+n>=this.$elevatorEles.eq(0).offset().top){i.fadeIn();var l=this.$elevatorEles;l.each(function(t){var i=$(this),l=i.offset().top;i.outerHeight();e+n>=l&&(o+=1)}),i.find(".book_elevator_item_btn").removeClass("book_elevator_item_btn_active").eq(o).addClass("book_elevator_item_btn_active")}else i.fadeOut()}},t});window.tplVersion={book_author_tpl:"b305f3640ddf5f35",book_badge_tpl:"c834bd0302980b9a",book_brand_tpl:"17462fb06a14c643",book_category_tpl:"83b6758ebedb8cf6",book_discount_tpl:"28ad9b9548398970",book_features_tpl:"8336bce9b04f7b2a",book_hot_tpl:"9947fcae39ac128c",book_nav_tpl:"ab91de72fd6f3b5e",book_found_tpl:"1015470df51d8d90",book_news_tpl:"c6f720d178f52ab5",book_rank_tpl:"3058ee27f57abeaa",book_slider_tpl:"b631fc94d74dcf9b",book_act_tpl:"9a1f05614b7afc31",book_new_tpl:"f82c4c7aa87d5cd0",book_recommend_tpl:"e107a2c552094057"};