function boardUpdate(path) {
	location.href = "BoardUpdateController?b=" + path;
}

function boardDelete(path) {
	location.href = "BoardDeleteController?b=" + path;
}