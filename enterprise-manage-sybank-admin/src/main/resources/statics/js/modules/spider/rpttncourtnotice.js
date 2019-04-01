$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'spider/rpttncourtnotice/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '企业主键', name: 'enterpriseId', index: 'enterprise_id', width: 80 }, 			
			{ label: '企业名称', name: 'entName', index: 'ent_name', width: 80 }, 			
			{ label: '企业名称', name: 'publishdate', index: 'publishdate', width: 80 }, 			
			{ label: '上诉方', name: 'party1', index: 'party1', width: 80 }, 			
			{ label: ' 被诉方', name: 'party2', index: 'party2', width: 80 }, 			
			{ label: '公告类型', name: 'bltntypename', index: 'bltntypename', width: 80 }, 			
			{ label: '法院', name: 'courtcode', index: 'courtcode', width: 80 }, 			
			{ label: '公告内容', name: 'content', index: 'content', width: 80 }, 			
			{ label: '创建人ID', name: 'creator', index: 'creator', width: 80 }, 			
			{ label: '创建时间', name: 'createTime', index: 'create_time', width: 80 }, 			
			{ label: '修改人ID', name: 'updater', index: 'updater', width: 80 }, 			
			{ label: '修改时间', name: 'updateTime', index: 'update_time', width: 80 }, 			
			{ label: '数据状态：1-正常 0-删除', name: 'dataState', index: 'data_state', width: 80 }, 			
			{ label: '天眼查法院公告ID', name: 'announceId', index: 'announce_id', width: 80 }, 			
			{ label: '公告内容', name: 'reason', index: 'reason', width: 80 }, 			
			{ label: '公告编号', name: 'bltnno', index: 'bltnno', width: 80 }, 			
			{ label: '公告状态', name: 'bltnstate', index: 'bltnstate', width: 80 }, 			
			{ label: '被诉方联系号码', name: 'judgephone', index: 'judgephone', width: 80 }, 			
			{ label: '被诉方名称', name: 'dealgradename', index: 'dealgradename', width: 80 }, 			
			{ label: '被诉方', name: 'dealgrade', index: 'dealgrade', width: 80 }, 			
			{ label: '省份', name: 'province', index: 'province', width: 80 }, 			
			{ label: '公告类型', name: 'bltntype', index: 'bltntype', width: 80 }, 			
			{ label: '展示文本日期', name: 'showtxtdate', index: 'showtxtdate', width: 80 }, 			
			{ label: '临时存储序号', name: 'tmpsaversn', index: 'tmpsaversn', width: 80 }, 			
			{ label: '公告页', name: 'publishpage', index: 'publishpage', width: 80 }, 			
			{ label: '被诉方字符串', name: 'party2str', index: 'party2Str', width: 80 }, 			
			{ label: 'tycId', name: 'tycId', index: 'tyc_id', width: 80 }, 			
			{ label: '判决人', name: 'judge', index: 'judge', width: 80 }, 			
			{ label: '上诉方字符串', name: 'party1str', index: 'party1Str', width: 80 }			
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
		rptTnCourtNotice: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.rptTnCourtNotice = {};
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
			var url = vm.rptTnCourtNotice.id == null ? "spider/rpttncourtnotice/save" : "spider/rpttncourtnotice/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.rptTnCourtNotice),
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
				    url: baseURL + "spider/rpttncourtnotice/delete",
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
			$.get(baseURL + "spider/rpttncourtnotice/info/"+id, function(r){
                vm.rptTnCourtNotice = r.rptTnCourtNotice;
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