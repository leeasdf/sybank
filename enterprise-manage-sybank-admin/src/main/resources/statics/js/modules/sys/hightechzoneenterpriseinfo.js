$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/hightechzoneenterpriseinfo/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '企业名称', name: 'enterpriseName', index: 'enterprise_name', width: 80 }, 			
			{ label: '组织机构编码', name: 'organizationCode', index: 'organization_code', width: 80 }, 			
			{ label: '营业执照号', name: 'businessLicenseNo', index: 'business_license_no', width: 80 }, 			
			{ label: '税号', name: 'taxNo', index: 'tax_no', width: 80 }, 			
			{ label: '注册日期', name: 'esDate', index: 'es_date', width: 80 }, 			
			{ label: '注册资本', name: 'regCap', index: 'reg_cap', width: 80 }, 			
			{ label: '入园时间', name: 'entryDate', index: 'entry_date', width: 80 }, 			
			{ label: '创建时间', name: 'createtime', index: 'createtime', width: 80 }, 			
			{ label: '统一社会信用代码', name: 'creditCode', index: 'credit_code', width: 80 }, 			
			{ label: '行业归属 1先进装备制造产业 2电子信息及互联网应用产业 3新材料产业 4新能源与节能环保产业 5生物医药与健康产业 6现代服务业 7其他', name: 'industryType', index: 'industry_type', width: 80 }, 			
			{ label: '数据状态：1-正常 0-删除', name: 'dataState', index: 'data_state', width: 80 }, 			
			{ label: '更新时间', name: 'updateTime', index: 'update_time', width: 80 }			
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
		highTechZoneEnterpriseInfo: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.highTechZoneEnterpriseInfo = {};
		},
		update: function (event) {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
			var url = vm.highTechZoneEnterpriseInfo.id == null ? "sys/hightechzoneenterpriseinfo/save" : "sys/hightechzoneenterpriseinfo/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.highTechZoneEnterpriseInfo),
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
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "sys/hightechzoneenterpriseinfo/delete",
                    contentType: "application/json",
				    data: JSON.stringify(ids),
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
		getInfo: function(id){
			$.get(baseURL + "sys/hightechzoneenterpriseinfo/info/"+id, function(r){
                vm.highTechZoneEnterpriseInfo = r.highTechZoneEnterpriseInfo;
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