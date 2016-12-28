package pramatitodoapp

import grails.transaction.Transactional
import pramatitodoapp.com.pramati.ToDo

@Transactional
class ToDoService {

    def store(String xmlFilePath) {
        parse(xmlFilePath)
    }
    def list(){
        ToDo.list()
    }

    def parse (String xmlFilePath ) {
        // Getting context path here

        // Create a new file instance
        def f = new File (xmlFilePath)

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
                   return "Data saved successfully"
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
