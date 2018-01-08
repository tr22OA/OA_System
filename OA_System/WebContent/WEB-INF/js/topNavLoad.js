layui.define(['element', 'jquery'], function(exports) {
	var element = layui.element;
	var $ = layui.jquery;
	var layId;
	var Topnav = function() {
		this.TopnavConfig = {
			url: undefined,
			navFilter: undefined,
			afterHtml:undefined
		}
	}
	Topnav.prototype.set = function(params) {
		var _this = this;
		$.extend(true, _this.TopnavConfig, params);
		return _this;
	}
	var TopNav = new Topnav();
	exports("topNavLoad", function(option) {
		TopNav.render(option)
		return TopNav.set(option);
	});

	Topnav.prototype.render = function(option) {
		
	}
});