package responses;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/responses/ImageDownload")
public class ImageDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ImageDownload() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType( "image/jpg" );
        response.setHeader( "Content-Disposition", "attachment; filename=smit.jpg" );

        FileInputStream in = new FileInputStream( "S:/smit.jpg" );
        OutputStream out = response.getOutputStream();

        byte buffer[] = new byte[2048];
        int bytesRead;
        while( (bytesRead = in.read( buffer )) > 0 )
            out.write( buffer, 0, bytesRead );

        in.close();
     
	}
	
}
