$(function() {
	$(".menuTd").mouseenter(function() {
		$(this).css("background", "#FF78FF");
		$(this).css("border", "5px inset #0033FF");
	});
	$(".menuTd").mouseleave(function() {
		$(this).css("background", "#FFCCFF");
		$(this).css("border", "5px solid #FFCCFF");
	});
	$(".menuTd").mousedown(function() {
		$(this).css("background", "#FF33FF");
		$(this).css("border", "5px outset #0033CC");
	});
	$(".menuTd").mouseup(function() {
		$(this).css("background", "#FF78FF");
		$(this).css("border", "5px inset #0033FF");
	});
	$("#titleDiv").click(function() {
		location.href = "http://localhost/jul103"
	});
	$("#delete").click(function() {
		let rusure = prompt("진짜 탈퇴할거임?");
		if (rusure) {
			location.href = "http://localhost/jul103/userInfo.delete"
		}
	});
	$(".menuDiv").click(function() {
		let type = $(this).attr("id");
		location.href = "http://localhost/jul103/calcpage.show?r_type=" + type;
	});
	$("#ats").click(function() {
		$("#stai").removeAttr("checked");
		$("#atsi").attr("checked", "checked");
	});
	$("#sta").click(function() {
		$("#atsi").removeAttr("checked");
		$("#stai").attr("checked", "checked");
	});
});