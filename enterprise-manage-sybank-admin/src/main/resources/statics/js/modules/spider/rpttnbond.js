$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'spider/rpttnbond/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '企业主键', name: 'enterpriseId', index: 'enterprise_id', width: 80 }, 			
			{ label: '企业名称', name: 'entName', index: 'ent_name', width: 80 }, 			
			{ label: '', name: 'bId', index: 'b_id', width: 80 }, 			
			{ label: '', name: 'bondName', index: 'bond_name', width: 80 }, 			
			{ label: '', name: 'bondNum', index: 'bond_num', width: 80 }, 			
			{ label: '', name: 'publisherName', index: 'publisher_name', width: 80 }, 			
			{ label: '', name: 'bondType', index: 'bond_type', width: 80 }, 			
			{ label: '', name: 'publishTime', index: 'publish_time', width: 80 }, 			
			{ label: '', name: 'publishExpireTime', index: 'publish_expire_time', width: 80 }, 			
			{ label: '', name: 'bondTimeLimit', index: 'bond_time_limit', width: 80 }, 			
			{ label: '', name: 'bondTradeTime', index: 'bond_trade_time', width: 80 }, 			
			{ label: '', name: 'calInterestType', index: 'cal_interest_type', width: 80 }, 			
			{ label: '', name: 'bondStopTime', index: 'bond_stop_time', width: 80 }, 			
			{ label: '', name: 'creditRatingGov', index: 'credit_rating_gov', width: 80 }, 			
			{ label: '', name: 'debtRating', index: 'debt_rating', width: 80 }, 			
			{ label: '', name: 'faceValue', index: 'face_value', width: 80 }, 			
			{ label: '', name: 'refInterestRate', index: 'ref_interest_rate', width: 80 }, 			
			{ label: '', name: 'faceInterestRate', index: 'face_interest_rate', width: 80 }, 			
			{ label: '', name: 'realIssuedQuantity', index: 'real_issued_quantity', width: 80 }, 			
			{ label: '', name: 'planIssuedQuantity', index: 'plan_issued_quantity', width: 80 }, 			
			{ label: '', name: 'issuedPrice', index: 'issued_price', width: 80 }, 			
			{ label: '', name: 'interestDiff', index: 'interest_diff', width: 80 }, 			
			{ label: '', name: 'payInterestHz', index: 'pay_interest_hZ', width: 80 }, 			
			{ label: '', name: 'startCalInterestTime', index: 'start_cal_interest_time', width: 80 }, 			
			{ label: '', name: 'exeRightType', index: 'exe_right_type', width: 80 }, 			
			{ label: '', name: 'exeRightTime', index: 'exe_right_time', width: 80 }, 			
			{ label: '', name: 'escrowAgent', index: 'escrow_agent', width: 80 }, 			
			{ label: '', name: 'flowRange', index: 'flow_range', width: 80 }, 			
			{ label: '', name: 'remark', index: 'remark', width: 80 }, 			
			{ label: '', name: 'tip', index: 'tip', width: 80 }, 			
			{ label: '', name: 'bCreateTime', index: 'b_create_time', width: 80 }, 			
			{ label: '', name: 'bUpdateTime', index: 'b_update_time', width: 80 }, 			
			{ label: '', name: 'isDelete', index: 'is_delete', width: 80 }, 			
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
		rptTnBond: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.rptTnBond = {};
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
			var url = vm.rptTnBond.id == null ? "spider/rpttnbond/save" : "spider/rpttnbond/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.rptTnBond),
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
				    url: baseURL + "spider/rpttnbond/delete",
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
			$.get(baseURL + "spider/rpttnbond/info/"+id, function(r){
                vm.rptTnBond = r.rptTnBond;
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