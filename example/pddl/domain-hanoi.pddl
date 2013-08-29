(define (domain hanoi)
(:requirements :typing)
(:types torre disco)
   (:predicates 
		(topo ?d - disco ?t - torre)
		(cima ?d1 ?d2 - disco)
		(maior ?d1 ?d2 - disco)
		(esta ?d - disco ?t - torre))
(:action mover
	:parameters (?d ?bo ?bd - disco ?to ?td - torre)
	:precondition (and (topo ?d ?to) (cima ?d ?bo) (topo ?bd ?td) (maior ?bd ?d))
	:effect	(and (not (topo ?d ?to)) (topo ?d ?td) (not (topo ?bd ?td)) (topo ?bo ?to) (not (esta ?d ?to)) (esta ?d ?td) (not (cima ?d ?bo)) (cima ?d ?bd)))	
)
