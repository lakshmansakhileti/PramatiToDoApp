package pramatitodoapp.com.pramati

import grails.converters.JSON
import pramatitodoapp.com.pramati.ToDo


class ToDoController {
    def toDoService

    def beforeInterceptor = {
        println "Tracing action ${actionUri}"
    }
    static  scaffold = ToDo

    def store () {
       def xmlfilePath = servletContext.getRealPath("/") + "/xmls/" + "todolist.xml"
        println xmlfilePath
        def res = toDoService.store(xmlfilePath)
        render res as JSON

    }
    def list () {
        def list = toDoService.list()
       render list as JSON

    }

}
