 (define (problem est4)
    (:domain estacionamento-tipado)
  (:objects terreo garagem - piso c1 - carro e1 - elevador v1 v2 - vaga)


  (:init 
     (vazio e1) 
     (parado c1 terreo)
     (pertence v1 garagem)
     (pertence v2 garagem) 
	 (vazia v1)
     (vazia v2)
     (no-piso e1 garagem))

  (:goal (estacionado c1)))

(define (problem est5)
    (:domain estacionamento-tipado)
  (:objects terreo garagem - piso c1 c2 - carro e1 - elevador v1 v2 - vaga)


  (:init 
     (vazio e1) 
     (parado c1 terreo)
     (parado c2 terreo)
     (pertence v1 garagem)
     (pertence v2 garagem) 
	 (vazia v1)
     (vazia v2)
     (no-piso e1 garagem))

  (:goal (and (estacionado c1) (estacionado c2))))

(define (problem est6)
    (:domain estacionamento-tipado)
  (:objects terreo garagem - piso c1 c2 c3 - carro e1 - elevador v1 v2 - vaga)


  (:init 
     (vazio e1) 
     (parado c1 terreo)
     (parado c2 terreo)
     (estacionado c3)
     (na-vaga c3 v1)
     (pertence v1 garagem)
     (pertence v2 garagem) 
     (vazia v2)
     (no-piso e1 garagem))

  (:goal (and (estacionado c1) (estacionado c2) (parado c3 terreo))))

