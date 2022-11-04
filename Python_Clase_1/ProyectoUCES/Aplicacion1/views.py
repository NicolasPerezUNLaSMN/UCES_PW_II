from django.shortcuts import render
from django.http.response import HttpResponse
# Create your views here.


def inicio(request):
    
    
    return HttpResponse("Esto es una prueba del inicio")
    #return render(request, 'Aplicacion1/inicio.html')