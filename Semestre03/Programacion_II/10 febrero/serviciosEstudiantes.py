from flask import Flask,request,jsonify
from EstudianteGestion import Estudiante
from flask_cors import CORS
app = Flask(__name__)
CORS(app)
estudiantes = []
@app.route('/primerSerivicio')
def mensaje():
    return 'Bienvenidos'

@app.route('/estudiantes', methods = ['GET'])
def getListStudents():
    nuevoEstudiante = Estudiante("Jorge",31,1234)
    estudiantes.append(nuevoEstudiante.to_json())
    return jsonify(estudiantes)

@app.route('/estudiantes/agregar', methods = ['POST'])
def addStudent():
    data = request.get_json()
    nombre = data.get('nombre')
    edad = data.get('edad')
    identificacion = data.get('identificacion')

    nuevoEstudiante = Estudiante(nombre,edad,identificacion)
    estudiantes.append(nuevoEstudiante.to_json())
    
    return jsonify({"mensaje": "Estudiante agregado"})

if __name__ == '__main__':
    app.run(debug=True)