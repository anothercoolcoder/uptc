from student import studentExample
import pandas as pd
from flask import Flask, request, jsonify

students = []
app = Flask(__name__)

newStudent = studentExample("Jorge", 31, 4)
students.append(newStudent.to_json())

info = pd.DataFrame(students)
info.to_json("newFile.json")
info.to_csv("csv.csv")
info.to_xml("xml.xml")

@app.route("/mentionStudents", methods=['GET'])
def mentionStudents():
    return jsonify(students)

@app.route("/createStudent", methods=['POST'])
def createStudent():
    data = request.get_json()
    
    name = data.get("name")
    age = data.get("age")
    averageGrades = data.get("averageGrades")
    
    newStudent = studentExample(name, age, averageGrades)
    students.append(newStudent.to_json())
    
    return jsonify({
        "message": "Estudiante creado"
    })

if __name__ == '__main__':
    app.run(debug=True)
