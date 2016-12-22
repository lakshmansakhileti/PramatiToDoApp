package pramatitodoapp.com.pramati

import com.pramati.User

class LoginController {

    def index() {}
    def login = {
        if (request.method == 'POST') {
            def u = User.findByUsernameAndPassword(params.username, params.password)
            if (u) {
                // username and password match -> log in
                session.user = u
                redirect(controller: "toDo")
            } else {
                flash.message = "User not found"
                redirect(controller: "login")
            }
        } else if (session.user) {
            // don't allow login while user is logged in
            redirect(view:'main')
        }
    }

    def register = {
        // new user posts his registration details
        if (request.method == 'POST') {
            // create domain object and assign parameters using data binding
            def u = new User(params)
            u.password = u.password
            if (! u.save()) {
                // validation failed, render registration page again
                return [user:u]
            } else {
                // validate/save ok, store user in session, redirect to homepage
                session.user = u
                redirect(controller: "toDo")
            }
        } else if (session.user) {
            // don't allow registration while user is logged in
            redirect(controller: "toDo")
        }
    }

    def logout = {
        session.invalidate()
        redirect(view:'main')
    }

}
