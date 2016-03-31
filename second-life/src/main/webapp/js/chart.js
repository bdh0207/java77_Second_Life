/**
 * 차트 작업
 */
var svg;
var w;
var h;

$(window).load(function(){
  w = 460;
  h = 200;

  svg = d3.select('#graph-area')
          .append('svg')
          .attr('width', w)
          .attr('height',h);
});
