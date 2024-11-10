from flask import Blueprint, abort, request, render_template, redirect
import json
import requests
from flask import flash
router = Blueprint('router', __name__)

@router.route('/')
def index():
    return render_template('template.html')

@router.route('/misoperaciones')
def listaoperaciones():
    r = requests.get('http://localhost:8090/api/operacion/all')
    data =  r.json()
    return render_template('operacion/listas.html', lista = data["data"])

@router.route('/formulario')
def formulario():
    return render_template('operacion/guardar.html')

@router.route('/guardar', methods=['POST'])
def guardar():
    codigo = request.form.get('codigo')
    data = {"codigo": codigo}

    r = requests.post('http://localhost:8090/api/operacion/save', json=data)

    if r.status_code == 200:
        flash('Codigo guardado correctamente')
        return redirect('/misoperaciones')
    else:
        flash('Error al guardar el codigo')
        return redirect('/misoperaciones')

