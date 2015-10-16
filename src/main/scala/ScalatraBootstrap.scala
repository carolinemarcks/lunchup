import com.lunchup.LunchupController
import com.lunchup.init.DatabaseInit
import org.scalatra.LifeCycle
import javax.servlet.ServletContext

class ScalatraBootstrap extends LifeCycle with DatabaseInit {

  override def init(context: ServletContext) {
    configureDb()
    context mount (new LunchupController, "/*")
  }
  
  override def destroy(context:ServletContext) {
    closeDbConnection()
  }
}