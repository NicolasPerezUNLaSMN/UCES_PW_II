from django.shortcuts import render
from django.http.response import HttpResponse
# Create your views here.



#Para hacer CBV
from django.views.generic import ListView
from django.views.generic.detail import DetailView
from django.views.generic.edit import  UpdateView, DeleteView, CreateView


from Aplicacion1.models import *




def inicio(request):
    
    
    #return HttpResponse("Esto es una prueba del inicio")
    return render(request, 'Aplicacion1/index.html')


#CRUD--- PERSONA

class PersonaList(ListView):
    
    model = Persona
   
    template_name = "Aplicacion1/personas_list.html"
    
class PersonaDelete(DeleteView):
    
    model = Persona
    template_name = "Aplicacion1/persona_confirm_delete.html"
    
    
class PersonaDetalle(DetailView):
    
    model = Persona
    template_name = "Aplicacion1/persona_detalle.html"

class PersonaUpdate(UpdateView):
    model = Persona
    success_url  = "/Aplicacion1/persona/list"
    fields = ["nombre","apellido","edad","descripcion","nacimiento","peso","argentino","foto"]

    

class PersonaCreacion(CreateView):
    model = Persona
    success_url  = "/Aplicacion1/persona/list"
    fields = ["nombre","apellido","edad","descripcion","nacimiento","peso","argentino","foto"]
    
