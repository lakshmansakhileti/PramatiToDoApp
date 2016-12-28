package pramatitodoapp.com.pramati

import grails.rest.*

@Resource(uri='/todos', formats = ["json"])
class ToDo {
    int Sno
    String itemTitle
    Date dueDate
    static constraints = {

        itemTitle blank: false
        dueDate blank:false
    }
}
