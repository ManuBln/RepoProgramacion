

class Agenda:
    
    def __init__(self):
        self.contactos = []
        
    def insertar_contacto(self, nombre, apellido, telefono, email):
        documento = {"nombre" : nombre , "apellido" : apellido , "telefono" : telefono ,"email" : email}
        self.contactos.append(documento)#ArrayList

    def borrar_contacto(self, nombre):      
       for recorre in self.contactos:
           if recorre["nombre"]==nombre:
               self.contactos.remove(recorre)

    def actualizar_contacto (self, nombre, apellido, telefono, email):
        for recorre in self.contactos:
            if recorre["telefono"]==telefono:#Si el telefono es el mismo que la Aux,
                recorre["nombre"]=nombre
                recorre["apellido"]=apellido
                recorre["email"]=email

    def ListarArrayList (self):
        for listar in self.contactos:
            print("Nombre: " + listar["nombre"])
            print("Apellido: " + listar["apellido"])
            print("Telefono: " + listar["telefono"])
            print("Email: " + listar["email"])



        



