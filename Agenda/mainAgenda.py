import pymongo
from ClaseAgenda import Agenda


cliente = pymongo.MongoClient("mongodb://localhost:27017")

agenda = Agenda(cliente,"Agenda","TablaAgenda")


while True:
    
    print("--------- 1. Insertar Contacto -----------")
    print("--------- 2. Borrar Contacto -------------")
    print("--------- 3. Actualizar Contacto ---------")
    print("--------- 4. Mostrar ---------------------")
    print("--------- 5. Salir -----------------------")
    opcion = input("Selecciona una opción: ")
    

    if opcion == "1":
        print("Has seleccionado la opción 1.")
        nombre = input("Introduce el Nombre: ")
        apellido = input("Introduce el Apellido: ")
        telefono = input("Introduce el Telefono: ")
        email = input("Introduce el Email: ")

        agenda.insertar_contacto(nombre,apellido,telefono,email)
        print("Contacto agregado correctamente")


    elif opcion == "2":
        print("Has seleccionado la opción 2.")
        nombre = input("Introduzca el nombre del contacto para borrarlo: ")
        agenda.borrar_contacto(nombre) 
        
    elif opcion == "3":
        print("Has seleccionado la opción 3.")

        telefono = input("Introduce el Telefono para identificar el contacto: ")

        nombre = input("Introduce el Nombre: ")
        apellido = input("Introduce el Apellido: ")
        email = input("Introduce el Email: ")
        agenda.actualizar_contacto(nombre,apellido,telefono,email)

    elif opcion == "4":
        print("Lista: ")
        agenda.ListarArrayList()
        
    elif opcion == "5":
        print("Adiós.")
        break
    
    else:
        print("Opción inválida. Inténtalo de nuevo.")