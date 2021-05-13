(ns credit-card.models)

(defrecord User [id cpf name email])
(defrecord Card [id user-id number cvv validity limit])
(defrecord Purchase [id card-id amount merchant date category])

(defn new-user
  [cpf name email]
  (->User (rand-int 1000000) cpf name email))

(defn new-card
  [user-id number cvv validity limit]
  (->Card (rand-int 1000000) user-id number cvv validity limit))

(defn new-purchase
  [card-id amount merchant date category]
  (->Purchase (rand-int 1000000) card-id amount merchant date category))
