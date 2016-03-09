/**
 * 
 */
function dateFormat(date) {
	var formattedDate = new Date(list.regDate);
	var years = formattedDate.getFullYear();
	var months = formattedDate.getMonth() + 1;
	var days = formattedDate.getDate();
	return years + '.' + months +'.'+ days;
}