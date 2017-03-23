/* USAGE
 var table = $('#example');
 var dTable = table.find("table").DataTable( {
 "columnDefs": [
 { type: "frenchString", targets: 0 }
 ],
 "fnInitComplete": function() {
 activateSearch(table, dTable);
 }
 } );
 activateSearch(table, dTable);
 */

// Source : https://datatables.net/plug-ins/sorting/chinese-string
jQuery.extend( jQuery.fn.dataTableExt.oSort, {
    "frenchString-asc" : function (s1, s2) {
        return getText(s1).localeCompare(getText(s2));
    },

    "frenchString-desc" : function (s1, s2) {
        return getText(s2).localeCompare(getText(s1));
    }
} );

// Fast way to get the same result as $(string).text() and remove special characters
function getText(string) {
    if (!string) return "";
    return string.replace(/<[^>]*>/g, "")
        .replace( /\n/g, ' ' )
        .replace( /[àáâäåã]/g, 'a' )
        .replace( /ç/g, 'c' )
        .replace( /[éèêë]/g, 'e' )
        .replace( /[íìîï]/g, 'i' )
        .replace( /[óòôöõø]/g, 'o' )
        .replace( /[úùûü]/g, 'u' )
        .replace( /[ýÿ]/g, 'y' )
        .replace( /ž/g, 'z' )
        .replace( /ñ/g, 'n' )
        .replace( /š/g, 's' )
        .replace( /æ/g, 'ae' )
        .replace( /œ/g, 'oe' )
        .trim();
}

// Source : https://datatables.net/plug-ins/filtering/type-based/accent-neutralise
jQuery.fn.DataTable.ext.type.search.frenchString = function (data) {
    return (data ? getText(data) : "");

};

// Use it after creating the datatable
// Note: search will be triggered twice but this one should override the default one
function activateSearch(table, dTable) {
    table.find("input[type='search']").keyup( function () {
        dTable
            .search(
                jQuery.fn.DataTable.ext.type.search.frenchString(this.value)
            )
            .draw()
    } );
}
