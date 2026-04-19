class PersonaEstructura: 

    def __init__(self,nombre,edad,genero):
        self.nombre = nombre
        self.edad = edad
        self.genero = genero

    def to_json(self):
        return self.__dict__