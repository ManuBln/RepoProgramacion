import pymongo


class Agenda:
    def __init__(self, cliente, nombre_bd, nombre_coleccion):

        self.cliente = cliente
        self.bd = self.cliente[nombre_bd]
        self.coleccion = self.db[nombre_coleccion]
        self.contactos = []


    
    def insertar_contacto(self, nombre, apellidos, telefono, email):
    documento = {"Nombre" : nombre , "Apellidos" : apellidos, "Telefono" : telefono, "Email" : email }
