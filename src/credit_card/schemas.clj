(ns credit-card.schemas)

(def category-schema [{:db/ident       :category/id
                       :db/valueType   :db.type/uuid
                       :db/cardinality :db.cardinality/one
                       :db/unique      :db.unique/identity}
                      {:db/ident       :category/key
                       :db/valueType   :db.type/keyword
                       :db/cardinality :db.cardinality/one
                       :db/unique      :db.unique/identity}
                      {:db/ident       :category/name
                       :db/valueType   :db.type/string
                       :db/cardinality :db.cardinality/one}])

(def user-schema [{:db/ident       :user/id
                   :db/valueType   :db.type/uuid
                   :db/cardinality :db.cardinality/one
                   :db/unique      :db.unique/identity}
                  {:db/ident       :user/cpf
                   :db/valueType   :db.type/string
                   :db/cardinality :db.cardinality/one
                   :db/unique      :db.unique/identity}
                  {:db/ident       :user/name
                   :db/valueType   :db.type/string
                   :db/cardinality :db.cardinality/one}
                  {:db/ident       :user/email
                   :db/valueType   :db.type/string
                   :db/cardinality :db.cardinality/one}])

(def card-schema [{:db/ident       :card/id
                   :db/valueType   :db.type/uuid
                   :db/cardinality :db.cardinality/one
                   :db/unique      :db.unique/identity}
                  {:db/ident       :card/number
                   :db/valueType   :db.type/string
                   :db/cardinality :db.cardinality/one}
                  {:db/ident       :card/cvv
                   :db/valueType   :db.type/string
                   :db/cardinality :db.cardinality/one}
                  {:db/ident       :card/expiration-date
                   :db/valueType   :db.type/string
                   :db/cardinality :db.cardinality/one}
                  {:db/ident       :card/limit
                   :db/valueType   :db.type/long
                   :db/cardinality :db.cardinality/one}
                  {:db/ident       :card/user
                   :db/valueType   :db.type/ref
                   :db/cardinality :db.cardinality/one}])

(def purchase-schema [{:db/ident       :purchase/id
                       :db/valueType   :db.type/uuid
                       :db/cardinality :db.cardinality/one
                       :db/unique      :db.unique/identity}
                      {:db/ident       :purchase/amount
                       :db/valueType   :db.type/long
                       :db/cardinality :db.cardinality/one}
                      {:db/ident       :purchase/merchant
                       :db/valueType   :db.type/string
                       :db/cardinality :db.cardinality/one}
                      {:db/ident       :purchase/date
                       :db/valueType   :db.type/string
                       :db/cardinality :db.cardinality/one}
                      {:db/ident       :purchase/category
                       :db/valueType   :db.type/ref
                       :db/cardinality :db.cardinality/one}
                      {:db/ident       :purchase/card
                       :db/valueType   :db.type/ref
                       :db/cardinality :db.cardinality/one}])

(def all-schemas (concat category-schema user-schema card-schema purchase-schema))
