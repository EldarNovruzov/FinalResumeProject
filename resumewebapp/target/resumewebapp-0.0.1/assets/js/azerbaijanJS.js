



jQuery(document).ready(function() {
    jQuery('.skillbar').each(function() {
        jQuery(this).find('.skillbar-bar').animate({ width: jQuery(this).attr('data-percent') }, 3000);
    });
});






// function createPDFObject() {
//        kendo.drawing.drawDOM("#main",
//     {
//         paperSize: "A4",
//         margin: { top: "1cm", bottom: "1cm" },
//         scale: 0.8,
//         height: 500
//     })
//         .then(function(group){
//         kendo.drawing.pdf.saveAs(group, "Exported.pdf")
//     });
// }


kendo.pdf.defineFont({
    "DejaVu Sans"             : "https://kendo.cdn.telerik.com/2016.2.607/styles/fonts/DejaVu/DejaVuSans.ttf",
    "DejaVu Sans|Bold"        : "https://kendo.cdn.telerik.com/2016.2.607/styles/fonts/DejaVu/DejaVuSans-Bold.ttf",
    "DejaVu Sans|Bold|Italic" : "https://kendo.cdn.telerik.com/2016.2.607/styles/fonts/DejaVu/DejaVuSans-Oblique.ttf",
    "DejaVu Sans|Italic"      : "https://kendo.cdn.telerik.com/2016.2.607/styles/fonts/DejaVu/DejaVuSans-Oblique.ttf",
    "WebComponentsIcons"      : "https://kendo.cdn.telerik.com/2017.1.223/styles/fonts/glyphs/WebComponentsIcons.ttf"
});




$(document).ready(function() {
    $(".export-pdf").click(function() {
        // Convert the DOM element to a drawing using kendo.drawing.drawDOM
        kendo.drawing.drawDOM($(".content-wrapper"),{
            margin: { top: "0 cm", bottom: "0 cm", left: "0 cm", right: "0 cm" },
            paperSize: "A2",
            multiPage: true
        })
            .then(function(group) {
                // Render the result as a PDF file
                return kendo.drawing.exportPDF(group, {
                });
            })
            .done(function(data) {
                // Save the PDF file
                kendo.saveAs({
                    dataURI: data,
                    fileName: "HR-Dashboard.pdf",
                });
            });
    });
});







// function prepareDiv() {
//     document.getElementById("send_div").value=document.getElementById("main").innerHTML;
// }