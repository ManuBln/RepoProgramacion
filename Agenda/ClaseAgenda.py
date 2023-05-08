

class agenda:
    def init(self, cliente, Agenda, TablaAgenda):
        self.cliente = cliente
        self.db = self.cliente[Agenda]
        self.coleccion = self.db[TablaAgenda]
        self.contactos = []

    def insertar_contacto(self, nombre, apellido, telefono, email):
        documento = {"nombre" : nombre , "apellido" : apellido , "telefono" : telefono ,"email" : email}
        self.coleccion.insert_one(documento)
        self.contactos.append(documento)

    def borrar_contacto(self, nombre):
       self.coleccion.delete_one({"nombre" : nombre})
       for recorre in self.contactos:
           if recorre["nombre"]==nombre:
               self.contactos.remove(recorre)

    def actualizar_contacto (self, nombre, apellido, telefono, email):
        self.coleccion.update_one({"telefono" : telefono},{"$set":{"nombre" : nombre , "apellido" : apellido ,"email" : email}})
        for recorre in self.contactos:
            if recorre["telefono"]==telefono:
                recorre["nombre"]=nombre
                recorre["apellido"]=apellido
                recorre["email"]=email

        



