$('#modificarFactura :submit').click(
        function (event) {
            // Evitamos que se envíe el formulario
            event.preventDefault();

            // Tomamos el número de categoría
            // y lo asignamos al campo oculto para enviarlo
            var selectedAsText = $('#paciente-datalist').val();
            var valueAsLong = $(
                    '#paciente-list [value="' + selectedAsText
                    + '"]').data('value');
            $('#paciente').val(valueAsLong);

            $('#modificarFactura').submit();
        });
        