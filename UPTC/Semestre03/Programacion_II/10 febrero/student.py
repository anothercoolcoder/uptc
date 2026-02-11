class studentExample:
    def __init__(self, name, age, averageGrades):
        # self (python) = this (java)
        self.name = name
        self.age = age
        self.averageGrades = averageGrades
    def to_json(self):
        return self.__dict__