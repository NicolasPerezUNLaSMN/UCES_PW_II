from django.db import models

# Create your models here.


class Persona(models.Model):
    
    nombre = models.CharField(max_length=30)
    apellido = models.CharField(max_length=30)
    edad = models.IntegerField()
    descriocion = models.TextField()
    nacimiento = models.DateField()
    peso = models.FloatField()
    argentino = models.BooleanField()
    foto = models.ImageField()
    
    
class Mascota(models.Model):
    
    apodo = models.CharField(max_length=30)
    raza = models.CharField(max_length=30)
    
    dueño = models.ForeignKey(Persona, on_delete=models.CASCADE, blank=True, null=True)
    