from ClaseAgenda import agenda
import pymongo

client = pymongo.MongoClient("mongodb://localhost:27017")
db = client["Agenda"]
coleccion = db["TablaAgenda"]


Agenda = agenda.init(client,db,coleccion)


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