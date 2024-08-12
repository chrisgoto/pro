/**
 * 
 */

"use strict";

function modifyData(itemObj) {
	console.log(itemObj);
	if (userObj.id != null) {
		document.getElementById("itemkind-id").value = itemObj.id;
		document.getElementById("kind-name").value = itemObj.kindName;

	}
}