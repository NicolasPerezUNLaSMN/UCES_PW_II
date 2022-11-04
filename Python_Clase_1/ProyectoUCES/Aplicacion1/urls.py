from django.urls import path
from Aplicacion1 import views

urlpatterns = [

   path('inicio', views.inicio, name="Inicio"),
    
]
