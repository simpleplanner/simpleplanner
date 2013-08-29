(define (domain robo)
(:requirements :typing)
(:types local robo)
(:predicates 
		(esta ?r - robo ?l - local))
		
(:action andar
       :parameters  ( ?r - robo ?de - local ?para - local)
       :precondition (and  (esta ?r ?de) (not (esta ?r ?para)))
       :effect (and  (esta ?r ?para) (not (esta ?r ?de))))		     
)
		     