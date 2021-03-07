var LIST = {
	fn_init : function(){

    LIST.fn_reload();


  },

  fn_reload : function(){
    setInterval(function(){
      LIST.fn_getAuthLog();
    },10000);
  },

  //AuthLog data to dataTable ajax call 
  fn_getAuthLog : function(){
    baseUrl = window.location;
    table = $('#postList').DataTable({
      columns: [
        {data: 'event_time' , title: '측정시간', orderable : true},
        {data: 'user_id' , title: 'user_id',visible : false},
        {data: 'user_name' , title: '이름', orderable : true},
        //{data: 'reserved' , title: 'reserved', orderable : true},
        {data: 'temperature' , title: '온도', orderable : true},
        {data: 'indexKey' , title: 'indexKey', visible : false}
      ],
      scrollX : false,
      columnDefs: [
        { targets: 0, "width": "20%", className: 'dt-center'},
        { targets: 1, "width": "20%", className: 'dt-center'},
        { targets: 2, "width": "20%", className: 'dt-center'},
        { targets: 3,
            "width": "20%",
            className: 'dt-center',
            "render" : function(data, type){
              if(data < 1){
                //data = '<div value="0">!온도체크실패!</div>';
                data = '<div style="display:none">'+0+'</div>'+'<div>'+'온도체크실패'+'</div>';
              }else if(data > 37.5){
                data = '<div style="color: #ff0202", "font-weight: bold">'+data+'</div>'; 
              }
              return data;
            }
            
        },
        { targets: 4, "width": "20%", className: 'dt-center'}
        //{ targets: 5, "width": "20%", className: 'dt-center'}
      ],
      order: [[ 0, 'desc' ]],
      select: {
        style: 'multi'
      },
      sAjaxSource: "/getAuthLog",
      sServerMethod: 'GET',
      //bProcessing: true,
      //bServerSide: true,
      //iDisplayStart : 0,
      //iDisplayLength : 10,
      searching : true,
      info: false,
      pagingType: 'full_numbers',
      lengthMenu: [10, 20, 50, 100],
    });	
  }
}


$(document).ready(function(){
  LIST.fn_init(); //
});