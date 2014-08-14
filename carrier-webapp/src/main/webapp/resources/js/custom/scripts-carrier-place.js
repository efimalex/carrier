$(document).ready(function() {
    $("#users").change(function() {
        return onChangeEvent("#users", "#selectedUserId");
    });
});
