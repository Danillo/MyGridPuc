// INICIO - validações de listar curso

//desmarca todos os radios deixando apenas o selecionado marcado
function desmarcar(radio) {
	var formulario = document.getElementById('formulario');
	var campo;
	for (var item = 0; item < formulario.length; item++) {
		campo = formulario[item];
		if (campo.type == 'radio' && campo.name != radio.name) {
			campo.checked = false;
		}
	}
}

// armazena o identificador do item escolhido
function selecionarItem(campoHidden, radioSelecionado) {
	document.getElementById(campoHidden).value = radioSelecionado.value;
	console.log("begin");
	desmarcar(radioSelecionado);
	console.log("end");
}

// verifica se algum item esta selecionado
function validarSelecionado() {
	var formulario = document.getElementById('formulario');
	var campo;
	for (var item = 0; item < formulario.length; item++) {
		campo = formulario[item];
		if (campo.type == 'radio' && campo.checked) {
			return true;
		}
	}
	alert('É necessário selecionar um item da lista.');
	return false;
}

onlyNumber = function (e) {
	var tecla = (window.event) ? event.keyCode : e.which;
	if ((tecla > 47 && tecla < 58))
		return true;
	else {
		if (tecla == 8 || tecla == 0)
			return true;
		else
			return false;
	}
};

camposObrigatorios = function (){
	var codigo = document.getElementById("formulario:codigoCurso").value.length;
	var nome = document.getElementById("formulario:nome").value.length;
	var table = document.getElementById('formulario:matriz:0:idAnoSemestre');
	
	if (codigo < 1){
		alert("O campo [Código] está vazio!");
		return false;
	}
	if(codigo < 4){
		alert("O campo [Cógio] é de 4 digitos!");
		return false;
	}
	if(nome < 1){
		alert("O campo [Nome] está vazio!");
		return false;
	}
	if(table == null){
		alert("É preciso adicionar pelo menos um ano/semestre!!!");
		return false;
	}
	return true;
};

fieldEmpty = function(){
	var anosemestre = document.getElementById("formulario:anodig").value.length;
	if (anosemestre < 1 || anosemestre < 6){
		alert("Valor invalido");
		return false;
	}
	return true;
	console.log(anosemestre);
};
