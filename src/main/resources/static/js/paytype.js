/**
 * 
 */



"use strict";

function modifyData(userObj) {
	console.log(userObj);
	if (userObj.id != null) {
		document.getElementById("paytype-id").value = userObj.id;
		document.getElementById("type-name").value = userObj.typeName;
		document.getElementById("type").value = userObj.type;
	}
}