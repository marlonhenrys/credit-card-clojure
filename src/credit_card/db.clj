(ns credit-card.db
  (:require [credit-card.models :as cc.models]
            [credit-card.schemas :as cc.schemas]
            [datomic.api :as d]))

(def db-uri "datomic:dev://localhost:4334/bank")

(defn init-db! []
  (d/create-database db-uri)
  (def conn (d/connect db-uri))
  (d/transact conn cc.schemas/all-schemas))

(defn reset-db! []
  (d/delete-database db-uri)
  (init-db!))

(defn transact!
  [entities]
  (d/transact conn entities))

(defn get-user-with-card
  [cpf]
  (d/pull (d/db conn)
          '[:user/name
            :user/cpf
            :user/email
            {[:card/_user :as :user/card]
             [:card/number
              :card/limit
              :card/expiration-date]}]
          [:user/cpf cpf]))

(defn get-all-purchases []
  (d/q '[:find (pull ?purchase [:purchase/amount
                                :purchase/merchant
                                :purchase/date
                                {:purchase/category
                                 [:category/name]}])
         :where [?purchase :purchase/amount]]
       (d/db conn)))

(defn search-purchase-by
  [attr value]
  (d/q '[:find (pull ?purchase [:purchase/amount
                                :purchase/merchant
                                :purchase/date
                                {:purchase/category
                                 [:category/name]}])
         :in $ ?attr ?value
         :where [?purchase ?attr ?value]]
       (d/db conn) attr value))

(defn max-purchase-amount []
  (d/q '[:find ?amount (pull ?purchase [:purchase/merchant
                                        {:purchase/card
                                         [:card/number
                                          {:card/user
                                           [:user/name]}]}])
         :where [(q '[:find (max ?amount)
                      :where [_ :purchase/amount ?amount]]
                    $) [[?amount]]]
         [?purchase :purchase/amount ?amount]]
       (d/db conn)))


