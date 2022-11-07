from django.urls import path
from Aplicacion1 import views

urlpatterns = [

   path('inicio', views.inicio, name="Inicio"),
   


    path('persona/list', views.PersonaList.as_view(), name='ListPersona'),
    path('persona/<pk>', views.PersonaDetalle.as_view(), name='DetailPersona'),
    path('nuevo', views.PersonaCreacion.as_view(), name='NewPersona'),
    path('persona/editar/<pk>', views.PersonaUpdate.as_view(), name='EditPersona'),
    path('persona/borrar/<pk>', views.PersonaDelete.as_view(), name='DeletePersona'),
    
]
