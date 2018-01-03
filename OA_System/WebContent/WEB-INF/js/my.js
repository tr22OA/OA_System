//遍历导航栏，为导航栏增加点击事件
					for(var i = 0; i < navs.length; i++) {
						//增加点击事件
						$(navs[i]).click(function() {
							var nav = $(this);
							alert(nav);

							//声明一个boolean变量，判断TAB上是否有相同
							var flag = true;
							//寻找所有tab
							var lis = tab.find("li");
							//遍历tabs
							for(var i = 0; i < lis.length; i++) {
								//获取每个tab
								var that = $(lis[i]);
								//判断tab最大为20
								if(lis.length < 20) {
									//判断tab是否已存在，如果存在则跳转到该页面
									if(that[0].title == nav[0].title) {
										//移除之前高亮显示的tab
										$(".layui-this").removeClass("layui-this");
										//让现在存在tab显示
										that.addClass("layui-this");

										//将tab内容替换，将以前的内容隐藏
										$(".layui-show").removeClass("layui-show");
										//找到要显示的tab内容
										var tabId = "#" + that[0].title;
										//显示tab内容
										$(tabId).addClass("layui-show")
										flag = false;
										break;
									}
								}
							}
							//判断如果不存在，就添加一个tab，然后跳转到那个tab
							if(flag) {
								//移除以前显示的tab样式
								$(".layui-this").removeClass("layui-this");
								//追加一个tab
								tab.append('<li title="' + nav[0].title + '" class="layui-this">' + nav.html() + '</li>');
								//隐藏现在的tab内容
								$(".layui-show").removeClass("layui-show");
								//增加一个tab内容
								$(".layui-tab-content").append('<div id="' + nav[0].title + '" class="layui-tab-item layui-show">' + nav[0].title + '</div>')
								element.render();
							}
						});
					}