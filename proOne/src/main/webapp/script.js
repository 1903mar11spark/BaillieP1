

var curday = function(sp){
	today = new Date();
	var dd = today.getDate();
	var mm = today.getMonth()+1; //As January is 0.
	var yyyy = today.getFullYear();
	
	if(dd<10) dd='0'+dd;
	if(mm<10) mm='0'+mm;
	return (mm+sp+dd+sp+yyyy);
	};
	console.log(curday('/'));
	console.log(curday('-'));





// let user = {};
//
// window.onload = function() {
// 	populateUser();
// }
//
// function populateUser() {
// 	//send GET request to SessionServlet to obtain session information
// 	fetch("http://localhost:8084/proOne/Login").then(function(response) {
// 		return response.json();
// 	}).then(function(data) {
// 		if (data.session === null) {
// 			window.location = "http://localhost:8084/proOne/ManagerHome";
// 		} else {
// 			user = data;
// 			document.getElementById("username").innerText = user.username;
// 			document.getElementById("firstname").innerText = user.firstname;
// 			document.getElementById("lastname").innerText = user.lastname;
// 			document.getElementById("email").innerText = user.email;
// 		}
// 	});
//
// }

//window.onload = function (){
//    document.getElementById("enter").addEventListener('click', enterPage)
//  }
//  
//  function enterPage(){
//        let age = parseFloat(document.getElementById("age").value);
//        let party = parseFloat(document.getElementById("party").value);
//        if((10 < age && age < 60) && (0 <= party && party < 5)){
//            location.href = "page2.html";
//            } else {
//            location.href = "zombie.html";
//            }
//  }