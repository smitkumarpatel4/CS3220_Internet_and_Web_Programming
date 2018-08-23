package databases;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/database/EditComment")
public class DbEditCommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 /**
     * Given an id, retrieve the GuestBookEntry.
     */
    private GuestBookEntry getEntry( Integer id ) throws ServletException
    {
        GuestBookEntry entry = null;
        Connection c = null;
        try
        {
        	String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu79";
            String username = "cs3220stu79";
            String password = "DwHAs9GA";

            String sql = "select * from guestbook where id = ?";

            c = DriverManager.getConnection( url, username, password );
            PreparedStatement pstmt = c.prepareStatement( sql );
            pstmt.setInt( 1, id );
            ResultSet rs = pstmt.executeQuery();

            if( rs.next() )
                entry = new GuestBookEntry( rs.getInt( "id" ),
                    rs.getString( "name" ), rs.getString( "message" ) );
        }
        catch( SQLException e )
        {
            throw new ServletException( e );
        }
        finally
        {
            try
            {
                if( c != null ) c.close();
            }
            catch( SQLException e )
            {
                throw new ServletException( e );
            }
        }

        return entry;
    }



	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		// get the entry to be edited
        Integer id = Integer.valueOf( request.getParameter( "id" ) );
        GuestBookEntry entry = getEntry( id );

        // pass the entry to jsp using request scope
        request.setAttribute( "entry", entry );
        request.getRequestDispatcher( "/WEB-INF/mvc/EditComment.jsp" ).forward(
            request, response );
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		  // get the entry to be edited
        Integer id = Integer.valueOf( request.getParameter( "id" ) );
        String name = request.getParameter( "name" );
        String message = request.getParameter( "message" );

        Connection c = null;
        try
        {
        	String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu79";
            String username = "cs3220stu79";
            String password = "DwHAs9GA";

            String sql = "update guestbook set name = ?, message = ? where id = ?";

            c = DriverManager.getConnection( url, username, password );
            PreparedStatement pstmt = c.prepareStatement( sql );
            pstmt.setString( 1, name );
            pstmt.setString( 2, message );
            pstmt.setInt( 3, id );
            pstmt.executeUpdate();
        }
        catch( SQLException e )
        {
            throw new ServletException( e );
        }
        finally
        {
            try
            {
                 if( c != null ) c.close();
            }
            catch( SQLException e )
            {
                throw new ServletException( e );
            }
        }

        // send the user back to the guest book page
        response.sendRedirect( "GuestBook" );
    }

}