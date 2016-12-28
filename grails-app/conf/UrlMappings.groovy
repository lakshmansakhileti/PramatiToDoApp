class UrlMappings {

	static mappings = {

      "/todos" (controller: "toDo") {
          action=[POST:"store",GET:"list"]

      }


        "/"(view:"/login/index")    
        "404" (view: '/error')

        "500"(view:'/error')
	}


}
