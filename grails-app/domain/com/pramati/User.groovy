package com.pramati

class User {
    String username
    String password

    static constraints = {
        username blank:false, unique:true
        password  blank:false, size:5..15, matches:/[\S]+/
    }
}
