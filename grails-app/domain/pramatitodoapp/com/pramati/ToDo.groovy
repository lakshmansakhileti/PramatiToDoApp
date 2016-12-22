package pramatitodoapp.com.pramati

class ToDo {
    int Sno
    String itemTitle
    Date dueDate
    static constraints = {

        itemTitle blank: false
        dueDate blank:false
    }
}
