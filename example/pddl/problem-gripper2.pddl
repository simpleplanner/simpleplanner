(define (problem gripper8)
  (:domain gripper)
  (:objects ball1 ball2 - ball left right - gripper roomA roomB - local)
  (:init
    (atrobby roomA) 
    (atball ball1 roomB)
    (atball ball2 roomB)
    (free left)
    (free right))
  
  (:goal (and (atball ball1 roomA)
    (atball ball2 roomA)))
)