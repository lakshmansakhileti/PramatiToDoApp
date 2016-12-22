package pramatitodoapp.com.pramati

import pramatitodoapp.com.pramati.ToDo

class ToDoController {

    static  scaffold = ToDo

    def index = {
        parse()
        redirect(action:display)
    }


    def display = {
       // def stream = getClass().classLoader.getResourceAsStream("grails-app/conf/sample.xml")

        return [data: ToDo.list()]
    }

    def getTodoList() {
       ToDo.findAll()

    }
    def parse ( ) {
        // Getting context path here
        def webRootDir = servletContext.getRealPath ("/")

        // Create a new file instance
        def f = new File (webRootDir + "/xmls/" + "todolist.xml")

        // Parxing XML file here
        def items = new XmlParser ( ).parseText( f.text )

        // iterating through XML blocks here
        items.todo.each {
            // Creating domain class object to save in DB
            def toDo = new ToDo ( )
            def node = it
            toDo.with {
                sno= node.sno.text()
                itemTitle = node.title.text()

                dueDate =  Date.parse("YYYY-MM-DD", node.duedate.text())
                if (!hasErrors() && save(flush: true)) {
                    log.info "mcq saved successfully"
                } else
                    errors.allErrors.each {
                        err->
                            log.error err.getField() + ": "
                            log.error err.getRejectedValue() + ": " + err.code
                    }
            }
        }
    }

}
