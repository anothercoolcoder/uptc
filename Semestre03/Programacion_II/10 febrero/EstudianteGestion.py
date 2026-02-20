from estudiante import EstudianteEjemplo
import pandas as pd
import lxml
from flask import Flask,request,jsonify
from flask_cors import CORS
app = Flask(__name__)
CORS(app)
estudiantes = []


nuevoEstudiante = EstudianteEjemplo("Jorge",31,4)
nuevoEstudiante2 = EstudianteEjemplo("Ana",27,2)
nuevoEstudiante3 = EstudianteEjemplo("Luis",29,3)

estudiantes.append(nuevoEstudiante.to_json())
estudiantes.append(nuevoEstudiante2.to_json())
estudiantes.append(nuevoEstudiante3.to_json())
print(estudiantes)

informacion = pd.DataFrame(estudiantes)

print(informacion)

informacion.to_json("archivoNuevo.json")
informacion.to_csv("archivoNuevo.csv")
informacion.to_xml("archivoNuevo.xml")

@app.route("/listarEstudiantes",methods=['GET'])
def listarEstudiantes():
    return estudiantes

@app.route("/crearEstudiante",methods=['POST'])
def crearEstudiante():
    datos = request.get_json()
    nombre = datos.get("nombre")
    edad = datos.get("edad")
    promedio = datos.get("promedio")
    nuevoEstudianteDatos = EstudianteEjemplo(nombre,edad,promedio)
    estudiantes.append(nuevoEstudianteDatos.to_json())
    return jsonify({
        "mensaje": "Estudiante creado"
    })


if __name__ == '__main__':
    app.run(debug=True)