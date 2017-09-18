$(document)
		.ready(
				function() {
					var iCnt = 0;

					// Crear un elemento div añadiendo estilos CSS
					var container = $(document.createElement('div')).css({
						padding : '5px',
						margin : '20px',
						width : '170px',
						border : '1px dashed',
						borderTopColor : '#999',
						borderBottomColor : '#999',
						borderLeftColor : '#999',
						borderRightColor : '#999'
					});

					$('#btAddselect')
							.click(
									function() {
										if (iCnt <= 19) {

											iCnt = iCnt + 1;

											// Añadir caja de texto.
											$(container)
													.append(
															'<input type=text class="input" id=tbselect'
																	+ iCnt
																	+ ' '
																	+ 'value="Elemento de Texto '
																	+ iCnt
																	+ '" />');

											if (iCnt == 1) {

												var divSubmit = $(document
														.createElement('div'));
												$(divSubmit)
														.append(
																'<input type=button class="btselect" onclick="GetTextValue()"'
																		+ 'id=btSubmitSelect value=Enviar />');

											}

											$('#select').after(container,
													divSubmit);
										} else { // se establece un limite
											// para añadir elementos, 20
											// es el limite

											$(container)
													.append(
															'<label>Limite Alcanzado</label>');
											$('#btAddselect').attr('class',
													'bt-disable');
											$('#btAddselect').attr('disabled',
													'disabled');

										}
									});

					$('#btRemoveselect').click(function() { // Elimina un elemento
						// por click
						if (iCnt != 0) {
							$('#tbselect' + iCnt).remove();
							iCnt = iCnt - 1;
						}

						if (iCnt == 0) {
							$(container).empty();

							$(container).remove();
							$('#btSubmitSelect').remove();
							$('#btAddselect').removeAttr('disabled');
							$('#btAddselect').attr('class', 'bt')

						}
					});

					$('#btRemoveAllselect').click(function() { // Elimina todos los
						// elementos del
						// contenedor

						$(container).empty();
						$(container).remove();
						$('#btSubmitSelect').remove();
						iCnt = 0;
						$('#btAddselect').removeAttr('disabled');
						$('#btAddselect').attr('class', 'btselect');

					});
				});

// Obtiene los valores de los textbox al dar click en el boton "Enviar"
var divValue, values = '';

function GetTextValue() {

	$(divValue).empty();
	$(divValue).remove();
	values = '';

	$('.input').each(function() {
		divValue = $(document.createElement('div')).css({
			padding : '5px',
			width : '200px'
		});
		values += this.value + '<br />'
	});

	$(divValue).append('<p><b>Tus valores añadidos</b></p>' + values);
	$('body').append(divValue);

}

$(document)
		.ready(
				function() {
					var iCnt = 0;

					// Crear un elemento div añadiendo estilos CSS
					var container = $(document.createElement('div')).css({
						padding : '5px',
						margin : '20px',
						width : '170px',
						border : '1px dashed',
						borderTopColor : '#999',
						borderBottomColor : '#999',
						borderLeftColor : '#999',
						borderRightColor : '#999'
					});

					$('#btAddfrom')
							.click(
									function() {
										if (iCnt <= 19) {

											iCnt = iCnt + 1;

											// Añadir caja de texto.
											$(container)
													.append(
															'<input type=text class="input" id=tbfrom'
																	+ iCnt
																	+ ' '
																	+ 'value="Elemento de Texto '
																	+ iCnt
																	+ '" />');

											if (iCnt == 1) {

												var divSubmit = $(document
														.createElement('div'));
												$(divSubmit)
														.append(
																'<input type=button class="btfrom" onclick="GetTextValue()"'
																		+ 'id=btSubmitfrom value=Enviar />');

											}

											$('#from').after(container,
													divSubmit);
										} else { // se establece un limite
											// para añadir elementos, 20
											// es el limite

											$(container)
													.append(
															'<label>Limite Alcanzado</label>');
											$('#btAddfrom').attr('class',
													'bt-disable');
											$('#btAddfrom').attr('disabled',
													'disabled');

										}
									});

					$('#btRemovefrom').click(function() { // Elimina un elemento
						// por click
						if (iCnt != 0) {
							$('#tbfrom' + iCnt).remove();
							iCnt = iCnt - 1;
						}

						if (iCnt == 0) {
							$(container).empty();

							$(container).remove();
							$('#btSubmitfrom').remove();
							$('#btAddfrom').removeAttr('disabled');
							$('#btAddfrom').attr('class', 'btfrom')

						}
					});

					$('#btRemoveAllfrom').click(function() { // Elimina todos los
						// elementos del
						// contenedor

						$(container).empty();
						$(container).remove();
						$('#btSubmitfrom').remove();
						iCnt = 0;
						$('#btAddfrom').removeAttr('disabled');
						$('#btAddfrom').attr('class', 'btfrom');

					});
				});

// Obtiene los valores de los textbox al dar click en el boton "Enviar"
var divValue, values = '';

function GetTextValue() {

	$(divValue).empty();
	$(divValue).remove();
	values = '';

	$('.input').each(function() {
		divValue = $(document.createElement('div')).css({
			padding : '5px',
			width : '200px'
		});
		values += this.value + '<br />'
	});

	$(divValue).append('<p><b>Tus valores añadidos</b></p>' + values);
	$('body').append(divValue);

}

$(document)
		.ready(
				function() {
					var iCnt = 0;

					// Crear un elemento div añadiendo estilos CSS
					var container = $(document.createElement('div')).css({
						padding : '5px',
						margin : '20px',
						width : '170px',
						border : '1px dashed',
						borderTopColor : '#999',
						borderBottomColor : '#999',
						borderLeftColor : '#999',
						borderRightColor : '#999'
					});

					$('#btAddwhere')
							.click(
									function() {
										if (iCnt <= 19) {

											iCnt = iCnt + 1;

											// Añadir caja de texto.
											$(container)
													.append(
															'<input type=text class="input" id=tbwhere'
																	+ iCnt
																	+ ' '
																	+ 'value="Elemento de Texto '
																	+ iCnt
																	+ '" />');

											if (iCnt == 1) {

												var divSubmit = $(document
														.createElement('div'));
												$(divSubmit)
														.append(
																'<input type=button class="btwhere" onclick="GetTextValue()"'
																		+ 'id=btSubmitwhere value=Enviar />');

											}

											$('#where').after(container,
													divSubmit);
										} else { // se establece un limite
													// para añadir elementos, 20
													// es el limite

											$(container)
													.append(
															'<label>Limite Alcanzado</label>');
											$('#btAddwhere').attr('class',
													'bt-disable');
											$('#btAddwhere').attr('disabled',
													'disabled');

										}
									});

					$('#btRemovewhere').click(function() { // Elimina un elemento
														// por click
						if (iCnt != 0) {
							$('#tbwhere' + iCnt).remove();
							iCnt = iCnt - 1;
						}

						if (iCnt == 0) {
							$(container).empty();

							$(container).remove();
							$('#btSubmitwhere').remove();
							$('#btAddwhere').removeAttr('disabled');
							$('#btAddwhere').attr('class', 'btwhere')

						}
					});

					$('#btRemoveAllwhere').click(function() { // Elimina todos los
															// elementos del
															// contenedor

						$(container).empty();
						$(container).remove();
						$('#btSubmit').remove();
						iCnt = 0;
						$('#btAddwhere').removeAttr('disabled');
						$('#btAddwhere').attr('class', 'btwhere');

					});
				});

// Obtiene los valores de los textbox al dar click en el boton "Enviar"
var divValue, values = '';

function GetTextValue() {

	$(divValue).empty();
	$(divValue).remove();
	values = '';

	$('.input').each(function() {
		divValue = $(document.createElement('div')).css({
			padding : '5px',
			width : '200px'
		});
		values += this.value + '<br />'
	});

	$(divValue).append('<p><b>Tus valores añadidos</b></p>' + values);
	$('body').append(divValue);

}
