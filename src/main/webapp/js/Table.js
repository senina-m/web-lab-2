drawTable = function () {
    console.log('Start to draw table');

    let old_tbody = document.getElementById('table_body');

    $("table > tbody > tr").each(() => {
        console.log($(this).find('.FieldNameID').text(), $(this).find('.OperatorID').text());
    });
}