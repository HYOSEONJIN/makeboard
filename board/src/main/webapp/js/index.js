


var LIST = {
	fn_init : function(){
    LIST.fn_getAuthLog();
    //LIST.fn_reload();


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
        {data: 'postidx' , title: '글번호', orderable : true},
        
        {data: 'postTitle' , title: '제목', orderable : true},
        {data: 'postWriter' , title: '글쓴이',orderable : true},
        {data: 'postDate' , title: '날짜', orderable : true}
      ],
      scrollX : false,
      columnDefs: [
        { targets: 0, "width": "5%", className: 'dt-center'},
        { targets: 1, "width": "60%", className: 'dt-center'},
        { targets: 2, "width": "15%", className: 'dt-center'},
        { targets: 3, "width": "20%", className: 'dt-center'}
      ],
      order: [[ 0, 'desc' ]],
      select: {
        style: 'multi'
      },
      sAjaxSource: "/list",
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


  $('#postList tbody').on('click', 'tr', function () {
    var data = table.row( this ).data();
    console.log(data.postidx);
    // var link = 'localhost:8080/post?postidx='+data.postidx;
    location.href= 'post?postidx='+data.postidx;
    
} );
});