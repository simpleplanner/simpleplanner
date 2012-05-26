(define (domain Blocks)
(:requirements :fluents)

(:predicates (handempty)
	     (clear ?b)
	     (on ?a ?b)
	     (ontable ?b)
	     (holding ?b)
            )

(:action pickup
 :parameters (?b)
 :precondition (and (handempty) (ontable ?b) (clear ?b))
 :effect (and (holding ?b)
              (not (handempty))
              (not (ontable ?b))
              (not (clear ?b))))

(:action putdown
 :parameters (?b)
 :precondition (holding ?b)
 :effect (and (handempty)
              (ontable ?b)
              (clear ?b)
              (not (holding ?b))))

(:action stack
 :parameters (?x ?y)
 :precondition (and (holding ?x) (clear ?y))
 :effect (and (on ?x ?y)
              (handempty)
              (clear ?x)
              (not (holding ?x))
              (not (clear ?y))))

(:action unstack
 :parameters (?x ?y)
 :precondition (and (clear ?x) (on ?x ?y) (handempty))
 :effect (and (clear ?y)
              (holding ?x)
              (not (clear ?x))
              (not (on ?x ?y))
              (not (handempty))))

)
