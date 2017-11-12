//Could be used for restful api call
function myFunction() {
	$.ajax({
        url : 'books\firstBook',
        method : 'GET',
        async : false,
        complete : function(data) {
            console.log(data.responseText);
        }
    });
}