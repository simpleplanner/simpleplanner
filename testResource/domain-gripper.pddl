(define (domain gripper)
(:requirements :typing)
(:types local gripper ball)
(:predicates 
		(atrobby ?l - local)
		(atball?b - ball ?l - local)
		(carry ?b - ball ?g - gripper)
		(free ?g - gripper))
		
(:action move
       :parameters  (?from - local ?to - local)
       :precondition (and  (atrobby ?from) (not (atrobby ?to)))
       :effect (and  (atrobby ?to) (not (atrobby ?from))))
		     
(:action pick
       :parameters  (?ball - ball ?room - local ?gripper - gripper)
       :precondition (and  (atball ?ball ?room) (atrobby ?room) (free ?gripper))
       :effect (and (carry ?ball ?gripper) (not (atball ?ball ?room)) (not (free ?gripper))))

	
(:action drop
       :parameters  (?ball - ball ?room - local ?gripper - gripper)
       :precondition (and (carry ?ball ?gripper) (atrobby ?room))
       :effect (and  (atball ?ball ?room) (not (carry ?ball ?gripper)) (free ?gripper)))

)
		     