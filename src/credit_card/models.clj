(ns credit-card.models
  (:import java.util.UUID))

(defn new-category
  [key name]
  #:category{:id   (UUID/randomUUID)
             :key  key
             :name name})

(defn new-user
  [cpf name email]
  #:user{:id    (UUID/randomUUID)
         :cpf   cpf
         :name  name
         :email email})

(defn new-card
  [number cvv expiration-date limit]
  #:card{:id              (UUID/randomUUID)
         :number          number
         :cvv             cvv
         :expiration-date expiration-date
         :limit           limit})

(defn new-purchase
  [amount merchant date category]
  #:purchase{:id       (UUID/randomUUID)
             :amount   amount
             :merchant merchant
             :date     date
             :category category})
