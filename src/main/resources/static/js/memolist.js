/**
 * 
 */

"use strict";

function openDayList(memoListObj, url) {
	console.log(memoListObj);
	let paramts_year = memoListObj.yearRecord;
	console.log(url + "?yearRecord=" + paramts_year);

	window.open(url + "?yearRecord=" + paramts_year)
}
