$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/urentalhousing/list',
        datatype: "json",
        colModel: [			
			{ label: 'rentalHousingId', name: 'rentalHousingId', index: 'rental_housing_id', width: 50, key: true },
			{ label: '出租房ID', name: 'housingEstateNo', index: 'housing_estate_no', width: 80 }, 			
			{ label: '标题', name: 'title', index: 'title', width: 80 }, 			
			{ label: '小区id', name: 'housingEstateId', index: 'housing_estate_id', width: 80 }, 			
			{ label: '小区名称', name: 'housingEstateName', index: 'housing_estate_name', width: 80 }, 			
			{ label: '户型(室)', name: 'doorModelRoom', index: 'door_model_room', width: 80 }, 			
			{ label: '户型(厅)', name: 'doorModelHall', index: 'door_model_hall', width: 80 }, 			
			{ label: '户型(卫)', name: 'doorModelToilet', index: 'door_model_toilet', width: 80 }, 			
			{ label: '面积', name: 'area', index: 'area', width: 80 }, 			
			{ label: '朝向', name: 'toward', index: 'toward', width: 80 }, 			
			{ label: '城市', name: 'city', index: 'city', width: 80 }, 			
			{ label: '区域', name: 'areaCode', index: 'area_code', width: 80 }, 			
			{ label: '板块', name: 'plate', index: 'plate', width: 80 }, 			
			{ label: '楼层', name: 'floor', index: 'floor', width: 80 }, 			
			{ label: '建筑年代', name: 'buildYears', index: 'build_years', width: 80 }, 			
			{ label: '出租价格', name: 'price', index: 'price', width: 80 }, 			
			{ label: '看过此房的人数', name: 'watchedNo', index: 'watched_no', width: 80 }, 			
			{ label: '地铁站', name: 'subway', index: 'subway', width: 80 }, 			
			{ label: '标签', name: 'tag', index: 'tag', width: 80 }, 			
			{ label: '描述', name: 'desc', index: 'desc', width: 80 }, 			
			{ label: '发布时间', name: 'publishTime', index: 'publish_time', width: 80 }, 			
			{ label: '租赁方式', name: 'leaseMode', index: 'lease_mode', width: 80 }, 			
			{ label: '付款方式', name: 'payMode', index: 'pay_mode', width: 80 }, 			
			{ label: '房屋现状', name: 'housingSituation', index: 'housing_situation', width: 80 }, 			
			{ label: '供暖方式', name: 'heatingMethod', index: 'heating_method', width: 80 }, 			
			{ label: '是否有衣柜', name: 'wardrobeFlag', index: 'wardrobe_flag', width: 80 }, 			
			{ label: '是否有桌椅', name: 'tableFlag', index: 'table_flag', width: 80 }, 			
			{ label: '是否有电视', name: 'tvFlag', index: 'tv_flag', width: 80 }, 			
			{ label: '是否有冰箱', name: 'refrigeratorFlag', index: 'refrigerator_flag', width: 80 }, 			
			{ label: '是否有洗衣机', name: 'washMachineFlag', index: 'wash_machine_flag', width: 80 }, 			
			{ label: '是否有空调', name: 'airConditionFlag', index: 'air_condition_flag', width: 80 }, 			
			{ label: '是否有热水器', name: 'waterHeaterFlag', index: 'water_heater_flag', width: 80 }, 			
			{ label: '是否有微波炉', name: 'microwaveOvenFlag', index: 'microwave_oven_flag', width: 80 }, 			
			{ label: '是否有暖气', name: 'heatingFlag', index: 'heating_flag', width: 80 }, 			
			{ label: '是否有宽带', name: 'broadbandFlag', index: 'broadband_flag', width: 80 }, 			
			{ label: '是否有天然气', name: 'naturalGasFlag', index: 'natural_gas_flag', width: 80 }, 			
			{ label: '小区介绍', name: 'housingEstateDesc', index: 'housing_estate_desc', width: 80 }, 			
			{ label: '交通出行', name: 'transportation', index: 'transportation', width: 80 }, 			
			{ label: '周边配套', name: 'peripheral', index: 'peripheral', width: 80 }, 			
			{ label: '房源亮点', name: 'propertiesWindow', index: 'properties_window', width: 80 }, 			
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
		uRentalHousing: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.uRentalHousing = {};
		},
		update: function (event) {
			var rentalHousingId = getSelectedRow();
			if(rentalHousingId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(rentalHousingId)
		},
		saveOrUpdate: function (event) {
			var url = vm.uRentalHousing.rentalHousingId == null ? "sys/urentalhousing/save" : "sys/urentalhousing/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.uRentalHousing),
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
			var rentalHousingIds = getSelectedRows();
			if(rentalHousingIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "sys/urentalhousing/delete",
                    contentType: "application/json",
				    data: JSON.stringify(rentalHousingIds),
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
		getInfo: function(rentalHousingId){
			$.get(baseURL + "sys/urentalhousing/info/"+rentalHousingId, function(r){
                vm.uRentalHousing = r.uRentalHousing;
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