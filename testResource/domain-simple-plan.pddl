(define (domain robo)
(:requirements :typing :fluents)

(:types local atrobby)
(:predicates 
		(atrobby ?l - local)
)
(:functions (distancia ?local1 ?local2 - local)
	    	(consumo ?local1 ?local2 - local)
            (gasolina)
            (total-percorrido)
)		
(:action move
       :parameters  (?from - local ?to - local)
       :precondition (and  (atrobby ?from) 
                           (not  (atrobby ?to)) 
                      )
       :effect (and  (atrobby ?to) 
                     (not (atrobby ?from))
	             (increase (total-percorrido) (distancia ?from ?to))
                     (decrease (gasolina) (consumo ?from ?to))
                )
	   )		     
)