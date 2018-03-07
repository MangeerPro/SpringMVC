Spring MVC常用注解
1、@Controller注解在类上，表明这个类是Spring MVC里的Controller，将其声明为Spring的一个Bean，DisptacherServlet会自动扫描注解了此注解的类。
2、@RequestMapping可以注解在类或者方法上，注解在方法上的@RequestMapping路径会继承注解在类上的路径，@RequestMapping
支持Servlet的request和response作为参数，也支持对request和response的媒体类型设置。
3、@ResponseBody支持返回值放在response体内，而不是返回一个页面。我们在很多基于ajax的程序的时候，可以以此注解返回数据而不是页面。（此注解可以放在返回值前或者方法前）
4、@ResponseBody允许request的参数在request体内，而不是在直接链接在地址后面。（此注解放在参数前）
5、@PathVariable用来接受路径参数，如/news/001/，可以接收001作为参数。（此注解放置在参数前）
6、@RestController是一个组合注解，组合了@Controller和@ResponseBody，当开发一个和页面交互数据的控制的时候，需要此注解。

