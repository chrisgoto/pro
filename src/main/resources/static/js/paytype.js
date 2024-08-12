/**
 * 
 */



"use strict";

function modifyData(payObj) {
	console.log(payObj);
	if (payObj.id != null) {
		document.getElementById("paytype-id").value = payObj.id;
		document.getElementById("type-name").value = payObj.typeName;
		document.getElementById("type").value = payObj.type;
	}
}