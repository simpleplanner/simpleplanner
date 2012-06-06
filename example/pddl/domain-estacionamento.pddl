(define (domain estacionamento-tipado)
(:requirements :typing)
(:types piso carro vaga elevador)
   (:predicates 
		(estacionado ?c - carro)
		(vazio ?e - elevador)
		(vazia ?v - vaga)
		(no-piso ?e - elevador ?p - piso)
		(pertence ?v -vaga ?p - piso)
		(carregando ?c - carro ?e - elevador)
		(na-vaga ?c - carro ?v - vaga)
		(parado ?c - carro ?p - piso))
		
   (:action pegar
       :parameters  (?e - elevador ?c - carro ?p - piso)
       :precondition (and  (parado ?c ?p) (vazio ?e) (no-piso ?e ?p))
       :effect (and  (carregando ?c ?e)
		     (not (vazio ?e)) (not (parado ?c ?p)) ))
		     
	(:action retirar
       :parameters  (?e - elevador ?c - carro ?v - vaga ?p - piso)
       :precondition (and  (pertence ?v ?p) (vazio ?e) (no-piso ?e ?p) (na-vaga ?c ?v))
       :effect (and (vazia ?v)  (carregando ?c ?e)
		     (not (estacionado ?c)) (not (vazio ?e)) (not (na-vaga ?c ?v))))

	
	(:action mover
       :parameters  (?e - elevador ?from ?to - piso)
       :precondition (no-piso ?e ?from)
       :effect (and  (no-piso ?e ?to)
		     (not (no-piso ?e ?from))))
		     
	(:action estacionar
       :parameters  (?e - elevador ?c - carro ?v - vaga ?p - piso)
       :precondition (and (pertence ?v ?p) (vazia ?v) (carregando ?c ?e) (no-piso ?e ?p) )
       :effect (and  (estacionado ?c) (vazio ?e) (na-vaga ?c ?v)
		     (not (vazia ?v)) (not (carregando ?c ?e) )))
		     
	(:action entregar
       :parameters  (?e - elevador ?c - carro ?p - piso)
       :precondition (and (no-piso ?e ?p) (carregando ?c ?e) )
       :effect (and (vazio ?e)  (parado ?c ?p)
		     (not (carregando ?c ?e) )))			     

		     )
		     
