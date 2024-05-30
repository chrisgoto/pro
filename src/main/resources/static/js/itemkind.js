/**
 * 
 */

"use strict";

function modifyData(userObj) {
	console.log(userObj);
	if (userObj.id != null) {
		document.getElementById("itemkind-id").value = userObj.id;
		document.getElementById("kind-name").value = userObj.kindName;

	}
}