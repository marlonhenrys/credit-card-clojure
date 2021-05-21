(ns credit-card.core
  (:require [credit-card.mocks :as cc.mocks]
            [credit-card.models :as cc.models]
            [credit-card.db :as cc.db])
  (:use [clojure pprint]))

(cc.db/init-db!)
;(cc.db/reset-db!)

(def user (cc.models/new-user "123.456.789-10" "Marlon Henrique" "marlon@henrique.com.br"))
(def card (cc.models/new-card "1010202030304040" "123" "2023-06-01T00:00:00" 3050))

(def mocked-categories (cc.mocks/load-mocked-categories))
(def mocked-purchases (cc.mocks/load-mocked-purchases))

(def card-with-user (assoc card :card/user user))
(def card-purchases (map #(assoc % :purchase/card card) mocked-purchases))

(cc.db/transact! [card-with-user])
(cc.db/transact! mocked-categories)
(cc.db/transact! card-purchases)

(cc.db/get-all-purchases)
(def purchases (map first (cc.db/get-all-purchases)))

(print-table purchases)

(map pprint ["User with card:" (cc.db/get-user-with-card "123.456.789-10")
             "Search by Merchant:" (cc.db/search-purchase-by :purchase/merchant "Netflix")
             "Search by Amount:" (cc.db/search-purchase-by :purchase/amount 30)
             "Max Purchase Amount:" (cc.db/max-purchase-amount)])