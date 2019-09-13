# Proyecto-CC3002
Instrucciones de uso y estrategias de implementación de funcionalidades nuevas:  
Para pasar un objeto de un jugador a otro: unidad.giveItem(unidad, objeto)  
En este caso, es necesario que ambas unidades hagan modificaciones en la lista que contiene sus items, a la que solo se puede acceder desde el interior de la clase. Se implementa un método receiveItem, a través del cual se logran hacer los cambios a la unidad que recibe (con giveItem se ingresa a la que entrega).  
Para equipar un objeto: unidad.equipItem(objeto)  
En este caso se usa double dispatch. Se le entrega al objeto la tarea de decidir si equiparse o no a la unidad. Cada item posee metodos para equiparse a todas las unidades, pero los metodos que representan operaciones no permitidas se dejan vacíos en esa clase, y por lo tanto no tienen efecto al ser usados.  
Para utilizar el objeto equipado: unidad.useEquippedItem(unidadObjetivo)  
Se realiza una separación de tipo entre objetos, utilizándose las cateogrías de mágico y no mágico para construir la primera parte de las relaciones de debilidad y resistencia. Esto se hace mediante el uso de interfaces y clases abstractas (un para interfaz-clase abstracta para cada tipo). Luego, se usan submétodos para el proceso de desambiguacion de tipo, decidiendose si el ataque es mágico o no mágico, y de cual item específico viene. Esto último implementado nuevamente con double disptach.  

.  
.  
.  
