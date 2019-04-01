$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/rpttnbasicinfo/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '企业主键', name: 'enterpriseId', index: 'enterprise_id', width: 80 }, 			
			{ label: '企业名称', name: 'entName', index: 'ent_name', width: 80 }, 			
			{ label: '工商注册号', name: 'regNo', index: 'reg_no', width: 80 }, 			
			{ label: '公司类型', name: 'entType', index: 'ent_type', width: 80 }, 			
			{ label: '行业', name: 'industryPhyName', index: 'industry_phy_name', width: 80 }, 			
			{ label: '纳税人识别号', name: 'ideNum', index: 'ide_num', width: 80 }, 			
			{ label: '统一信用代码', name: 'creCode', index: 'cre_code', width: 80 }, 			
			{ label: '英文名称', name: 'engName', index: 'eng_name', width: 80 }, 			
			{ label: '组织机构代码', name: 'orgCode', index: 'org_code', width: 80 }, 			
			{ label: '登记机关', name: 'regAuthority', index: 'reg_authority', width: 80 }, 			
			{ label: '营业期限', name: 'opePeriod', index: 'ope_period', width: 80 }, 			
			{ label: '核准日期', name: 'appDate', index: 'app_date', width: 80 }, 			
			{ label: '注册地址', name: 'regAddress', index: 'reg_address', width: 80 }, 			
			{ label: '', name: 'busScope', index: 'bus_scope', width: 80 }, 			
			{ label: '公司名称', name: 'cmpName', index: 'cmp_name', width: 80 }, 			
			{ label: '注册时间', name: 'regTime', index: 'reg_time', width: 80 }, 			
			{ label: '法人姓名', name: 'legalPerson', index: 'legal_person', width: 80 }, 			
			{ label: '注册资本', name: 'regCap', index: 'reg_cap', width: 80 }, 			
			{ label: '公司状态', name: 'status', index: 'status', width: 80 }, 			
			{ label: '创建人ID', name: 'creator', index: 'creator', width: 80 }, 			
			{ label: '创建时间', name: 'createTime', index: 'create_time', width: 80 }, 			
			{ label: '修改人ID', name: 'updater', index: 'updater', width: 80 }, 			
			{ label: '修改时间', name: 'updateTime', index: 'update_time', width: 80 }, 			
			{ label: '数据状态：1-正常 0-删除', name: 'dataState', index: 'data_state', width: 80 }			
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
		rptTnBasicInfo: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.rptTnBasicInfo = {};
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
			var url = vm.rptTnBasicInfo.id == null ? "sys/rpttnbasicinfo/save" : "sys/rpttnbasicinfo/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.rptTnBasicInfo),
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
				    url: baseURL + "sys/rpttnbasicinfo/delete",
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
			$.get(baseURL + "sys/rpttnbasicinfo/info/"+id, function(r){
                vm.rptTnBasicInfo = r.rptTnBasicInfo;
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