from student import studentExample
import pandas as pd
from flask import Flask, request, jsonify
students = []
## pip install flask
app = Flask(__name__)

newStudent = studentExample("Jorge", 31, 4)

students.append(newStudent.to_json())

print(students)

info = pd.DataFrame(students)
print(info)

info.to_json("newFile.json")
info.to_csv("csv.csv")
info.to_xml("xml.xml")

@app.route("/mentionStudents",methods=['GET'])
def mentionStudents():
    return students

if __name__ == '__main__':
    app.run(debug=True)