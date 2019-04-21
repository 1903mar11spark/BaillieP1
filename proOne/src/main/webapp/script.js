



let user = {};

window.onload = function() {
	populateUser();
}

function populateUser() {
	//send GET request to SessionServlet to obtain session information
	fetch("http://localhost:8084/proOne/session").then(function(response) {
		return response.json();
	}).then(function(data) {
		//check whether there was a valid session
		//define behavior for no user returned
		if (data.session === null) {
			window.location = "http://localhost:8084/proOne/EmployeeHome";
		} else {
			//define behavior for user returned
			user = data;
			document.getElementById("username").innerText = "username: "+user.username;
			document.getElementById("firstname").innerText = "firstname: "+user.firstname;
			document.getElementById("lastname").innerText = "lastname: "+user.lastname;
			document.getElementById("email").innerText = "email: "+user.email;
		}
	});

}

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