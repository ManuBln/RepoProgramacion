import pymongo
from ClaseAgenda import Agenda


client = pymongo.MongoClient("mongodb://localhost:27017")
db = client["Agenda"]
coleccion = db["TablaAgenda"]


agenda = Agenda.init(client,"Agenda","TablaAgenda")


while opcion < 5 and opcion > 0:
    
    print("1. Insertar Contacto")
    print("2. Borrar Contacto")
    print("3. Actualizar Contacto")
    print("4. Salir")

    

    opcion = input("Selecciona una opción: ")

    if opcion == "1":
        print("Has seleccionado la opción 1.")
        nombre = input("Introduce el Nombre")
        apellido = input("Introduce el Apellido")
        telefono = input("Introduce el Telefono")
        email = input("Introduce el Email")

        agenda.insertar_contacto(nombre,apellido,telefono,email)
        print("Contacto agregado correctamente")


    elif opcion == "2":
        print("Has seleccionado la opción 2.")
        
    elif opcion == "3":
         break
    elif opcion == "4":
        print("Adiós.")
        break
    else:
        print("Opción inválida. Inténtalo de nuevo.")