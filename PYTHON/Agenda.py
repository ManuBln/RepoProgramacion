import pymongo

class Agenda:

    def __init__(self, cliente, nombre_bd, nombre_coleccion):

        self.cliente = cliente
        self.bd = self.cliente[nombre_bd]
        self.coleccion = self.db[nombre_coleccion]
        self.contactos = []


def insertar_contacto(self, nombre, apellidos, telefono, email):
    documento = {"Nombre" : nombre , "Apellidos" : apellidos, "Telefono" : telefono, "Email" : email }









#Establecer la conexion con la base de datos

client = pymongo.MongoClient("mongodb://localhost:27017")

#Crear una base de datos y una colección
db = client["Agenda"]
coleccion = db["TablaAgenda"]

#Insertar un documento en la coleccion
#documento = {"Nombre" : "Manuel" , "Apellidos" : "Cordero"}
documento = {"Nombre" : "Manuel"}
coleccion.insert_one(documento)

#Borrar
coleccion.delete_one({"Nombre" : "Manuel"})#Borra el primero que se llame Manuel
coleccion.delete_many({"Nombre" : "Manuel"})#Borra todos los que se llamen Manuel

#Buscar documentos en la colección
resultados = coleccion.find({"Nombre" : "Manuel"})



while True:
    print("1. Insertar Contacto")
    print("2. Borrar Contacto")
    print("3. Actualizar Contacto")
    print("4. Salir")


    opcion = input("Selecciona una opción: ")

    if opcion == "1":
        print("Has seleccionado la opción 1.")
    elif opcion == "2":
        print("Has seleccionado la opción 2.")
    elif opcion == "3":
         break
    elif opcion == "4":
        print("Adiós.")
        break
    else:
        print("Opción inválida. Inténtalo de nuevo.")