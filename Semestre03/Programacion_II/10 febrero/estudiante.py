class EstudianteEjemplo:

    def __init__(self,nombre,edad,promedio):
        self.nombre = nombre
        self.edad = edad
        self.promedio = promedio
    
    def to_json(self):
        return self.__dict__