(define (problem robo)
  (:domain robo)
  (:objects sala1 sala2 - local r1 r2 - robo)
  (:init
    (esta r1 sala1) 
	(esta r2 sala2))
  
  (:goal (and (esta r1 sala2)
    (esta r2 sala1)))
)