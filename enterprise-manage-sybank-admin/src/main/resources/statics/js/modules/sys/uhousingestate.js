$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/uhousingestate/list',
        datatype: "json",
        colModel: [			
			{ label: 'estateId', name: 'estateId', index: 'estate_id', width: 50, key: true },
			{ label: '小区编号', name: 'estateNo', index: 'estate_no', width: 80 }, 			
			{ label: '小区名称', name: 'name', index: 'name', width: 80 }, 			
			{ label: '90天成交套数', name: 'ninetyDaysDealNum', index: 'ninety_days_deal_num', width: 80 }, 			
			{ label: '正在出租套数', name: 'rentingNum', index: 'renting_num', width: 80 }, 			
			{ label: '城市', name: 'cityId', index: 'city_id', width: 80 }, 			
			{ label: '区域', name: 'areaCodeId', index: 'area_code_id', width: 80 }, 			
			{ label: '板块', name: 'plateId', index: 'plate_id', width: 80 }, 			
			{ label: '建筑年代', name: 'buildYears', index: 'build_years', width: 80 }, 			
			{ label: '标签', name: 'tag', index: 'tag', width: 80 }, 			
			{ label: '上月二手房参考均价', name: 'lastMonthAveragePrice', index: 'last_month_average_price', width: 80 }, 			
			{ label: '在售二手房套数', name: 'secondHandHousrNum', index: 'second_hand_housr_num', width: 80 }, 			
			{ label: '小区所属商圈', name: 'businessCircle', index: 'business_circle', width: 80 }, 			
			{ label: '建筑类型', name: 'buildType', index: 'build_type', width: 80 }, 			
			{ label: '物业费（平米/月）', name: 'propertyFee', index: 'property_fee', width: 80 }, 			
			{ label: '物业公司', name: 'propertyCompany', index: 'property_company', width: 80 }, 			
			{ label: '开发商', name: 'developCompany', index: 'develop_company', width: 80 }, 			
			{ label: '楼栋总数(栋)', name: 'buildSumNo', index: 'build_sum_no', width: 80 }, 			
			{ label: '房屋总数', name: 'houseSumNo', index: 'house_sum_no', width: 80 }, 			
			{ label: '附近门店', name: 'nearbyStores', index: 'nearby_stores', width: 80 }, 			
			{ label: '地铁站', name: 'subway', index: 'subway', width: 80 }, 			
			{ label: '数据状态', name: 'dataStatus', index: 'data_status', width: 80 }, 			
			{ label: '创建人', name: 'creator', index: 'creator', width: 80 }, 			
			{ label: '修改人', name: 'updator', index: 'updator', width: 80 }, 			
			{ label: '创建时间', name: 'createTime', index: 'create_time', width: 80 }, 			
			{ label: '修改时间', name: 'updateTime', index: 'update_time', width: 80 }, 			
			{ label: '备注', name: 'remark', index: 'remark', width: 80 }			
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		uHousingEstate: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.uHousingEstate = {};
		},
		update: function (event) {
			var estateId = getSelectedRow();
			if(estateId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(estateId)
		},
		saveOrUpdate: function (event) {
			var url = vm.uHousingEstate.estateId == null ? "sys/uhousingestate/save" : "sys/uhousingestate/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.uHousingEstate),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function (event) {
			var estateIds = getSelectedRows();
			if(estateIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "sys/uhousingestate/delete",
                    contentType: "application/json",
				    data: JSON.stringify(estateIds),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								$("#jqGrid").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(estateId){
			$.get(baseURL + "sys/uhousingestate/info/"+estateId, function(r){
                vm.uHousingEstate = r.uHousingEstate;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});