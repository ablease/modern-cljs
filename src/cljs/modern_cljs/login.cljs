(ns modern-cljs.login)

;; define the fucntion to be attached to the form submission event
(defn validate-form []
  ;; get email and password element from their ids in the HTML form
  (let [email (.getElementById js/document "email")
        password (.getElementById js/document "password")]

    (if (and (> (count (.-value email)) 0)
             (> (count (.-value password)) 0))
      true
      (do (js/alert "Please, complete the form!")
          false))))

;; define the function to attach validate-form to on-submit event of the form
(defn init []
  ;; verify that js/document exists and that it has a getElementById property
  (if (and js/document
           (.-getElementById js/document))

    ;; get loginForm by element id and set its on-submit property to our
    ;; validate-form function

    (let [login-form (.getElementById js/document "loginForm")]
      (set! (.-onsubmit login-form) validate-form))))

;; initialize the HTML page in unobtusive way
(set! (.-onload js.window) init)
