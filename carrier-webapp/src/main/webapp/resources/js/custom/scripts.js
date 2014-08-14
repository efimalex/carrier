
function updateSelectBusModelOptions(lookupUrl, parentSelectElementId, childSelectElementId) {
    $.ajaxSetup({
        async: false
    });
    $.getJSON(lookupUrl,
        {searchId: $('#' + parentSelectElementId).val()},
        function(data) {
            var html = '<option value=""></option>';
            var len = data.length;
            for (var i = 0; i< len; i++) {
                html += '<option value="' + data[i].id + '">' + data[i].name + '</option>';
            }

            $('#' + childSelectElementId).html(html);
        }
    );
    $.ajaxSetup({
        async: true
    });
}

function setSelectedById(selectElementId, selId) {
    console.log(selId);
    $('#' + selectElementId + ' option').removeAttr('selected');
    $('#' + selectElementId + ' option[value=' + selId.toString() + ']').attr('selected', 'selected');
}