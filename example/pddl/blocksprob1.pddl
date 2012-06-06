(define (problem blocks1)
    (:domain Blocks)
    (:objects a b c)
    (:init (ontable a)
	   (on b a)
           (on c b)
	   (clear c)
	   (handempty)
    )

    (:goal (and (ontable b) (on a b) (on c a)))

)
