$(function () {
    $("[data-toggle='tooltip']").tooltip();
});

function showDialog(msg, timeout) {
    $("#message-info").text(msg);
    $("#message-dialog").modal("show");
    if (null !== timeout) {
        setTimeout('$("#message-dialog").modal("hide")', timeout);
    }
}

function showSuccessDialog() {
    showInfoDialog($.i18n.prop("operation-succeed"));
}

function showInfoDialog(msg) {
    showDialog(msg, 2000);
}

function showFailureDialog(msg) {
    showDialog(msg, null);
}

function authorityControl() {
    $.ajax({
        type: "HEAD",
        url: "/",
        complete: function (xhr, data) {
            if ("guest" === xhr.getResponseHeader("identify")) {
                $("table").on("all.bs.table", function () {
                    $(".index-content .btn-xs").not(".btn-info").attr("disabled", true);
                    $(".index-content .btn-xs").not(".btn-info").removeClass().addClass("btn-xs");
                });
            }
            if ("" === $("#authority").text()) {
                $("#authority").text(xhr.getResponseHeader("identify"));
            }
        }
    });
}

function showDeleteConfirmModal() {
    $("#confirm-info").text($.i18n.prop("confirm-to-delete"));
    $("#confirm-dialog").modal({backdrop: 'static', keyboard: true});
}

function showShutdownConfirmModal() {
    $("#confirm-info").text($.i18n.prop("confirm-to-close"));
    $("#confirm-dialog").modal({backdrop: 'static', keyboard: true});
}

function showUpdateConfirmModal() {
    $("#confirm-info").text($.i18n.prop("update-job-confirm-info"));
    $("#confirm-dialog").modal({backdrop: 'static', keyboard: true});
}

function showAddJobConfirmModal() {
    $("#confirm-info").text($.i18n.prop("add-job-confirm-info"));
    $("#confirm-dialog").modal({backdrop: 'static', keyboard: true});
}

function i18n(lang) {
    jQuery.i18n.properties({
        name: 'message',
        path: '/i18n/',
        mode: 'map',
        language: lang,
        cache: true,
        encoding: 'UTF-8',
        callback: function () {
            for (var i in $.i18n.map) {
                $('[data-lang="' + i + '"]').html($.i18n.prop(i));
            }
        }
    });
}

function doLocale() {
    if ($("#content").hasClass("lang-en")) {
        i18n("en");
    } else {
        i18n("zh");
    }
}

function switchLanguage() {
    $("#lang-zh").click(function () {
        $("#content").removeClass("lang-en").addClass("lang-zh");
        doLocale();
    });
    $("#lang-en").click(function () {
        $("#content").removeClass("lang-zh").addClass("lang-en");
        doLocale();
    });
}

/**
 * ??????????????????????????????????????????
 */
function initLanguage() {
    //?????????????????????
    var lan = (navigator.language || navigator.browserLanguage);
    if (lan && lan.toLowerCase().indexOf('zh') > -1) {
        //???????????????
        $("#lang-zh").click();
    }
}