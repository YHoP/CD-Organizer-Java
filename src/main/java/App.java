import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

  get("/", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();
    model.put("cdList", request.session().attribute("cdList"));

    model.put("template", "templates/index.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  get("/cdList", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();
    // get all the CD info from our class, and put it into webpage
    model.put("cdList", CDOrganizer.all());
    model.put("template", "templates/cdList.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  get("cdList/new", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();
    model.put("template", "templates/cd-form.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  post("/cdList", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();
    // ArrayList<Task> tasks = request.session().attribute("tasks");
    // if (tasks == null) {
    //   tasks = new ArrayList<Task>();
    //   request.session().attribute("tasks", tasks);
    // }
    String cdTitle = request.queryParams("cdTitle");
    String cdArtist = request.queryParams("cdArtist");
    CDOrganizer newCDOrganizer = new CDOrganizer(cdTitle, cdArtist);
    // tasks.add(newTask);
    model.put("template", "templates/success.vtl");
    return new ModelAndView(model, layout);
  },  new VelocityTemplateEngine());

  get("/cdList/:id", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();


    CDOrganizer cd = CDOrganizer.find(Integer.parseInt(request.params(":id")));

    model.put("cd", cd);
    // model.put("cdTitle", cdTitle);
    // model.put("cdArtist", cdArtist);
    model.put("template", "templates/cd.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

 }
}
