import pymongo

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



