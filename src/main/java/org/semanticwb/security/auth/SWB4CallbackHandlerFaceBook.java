/*
 * SemanticWebBuilder es una plataforma para el desarrollo de portales y aplicaciones de integración,
 * colaboración y conocimiento, que gracias al uso de tecnología semántica puede generar contextos de
 * información alrededor de algún tema de interés o bien integrar información y aplicaciones de diferentes
 * fuentes, donde a la información se le asigna un significado, de forma que pueda ser interpretada y
 * procesada por personas y/o sistemas, es una creación original del Fondo de Información y Documentación
 * para la Industria INFOTEC, cuyo registro se encuentra actualmente en trámite.
 *
 * INFOTEC pone a su disposición la herramienta SemanticWebBuilder a través de su licenciamiento abierto al público (‘open source’),
 * en virtud del cual, usted podrá usarlo en las mismas condiciones con que INFOTEC lo ha diseñado y puesto a su disposición;
 * aprender de él; distribuirlo a terceros; acceder a su código fuente y modificarlo, y combinarlo o enlazarlo con otro software,
 * todo ello de conformidad con los términos y condiciones de la LICENCIA ABIERTA AL PÚBLICO que otorga INFOTEC para la utilización
 * del SemanticWebBuilder 4.0.
 *
 * INFOTEC no otorga garantía sobre SemanticWebBuilder, de ninguna especie y naturaleza, ni implícita ni explícita,
 * siendo usted completamente responsable de la utilización que le dé y asumiendo la totalidad de los riesgos que puedan derivar
 * de la misma.
 *
 * Si usted tiene cualquier duda o comentario sobre SemanticWebBuilder, INFOTEC pone a su disposición la siguiente
 * dirección electrónica:
 *  http://www.semanticwebbuilder.org
 */
package org.semanticwb.security.auth;

import java.io.IOException;
import java.util.logging.Level;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.TextInputCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class SWB4CallbackHandlerFaceBook.
 * 
 * @author serch
 */
public class SWB4CallbackHandlerFaceBook extends SWB4CallbackHandler
{

    /** The log. */
    private static Logger log = SWBUtils.getLogger(SWB4CallbackHandlerLoginPasswordImp.class);
    
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 12896L;
    
    /** The request. */
    private HttpServletRequest request;
    
    /** The response. */
    private HttpServletResponse response;
    
    /** The auth type. */
    private String authType;
    
    /** The website. */
    private String website;

    /**
     * Instantiates a new sW b4 callback handler face book.
     */
    public SWB4CallbackHandlerFaceBook()
    {
        log.trace("Simple CallbackHandler");
        this.request = null;
        this.response = null;
        this.authType = (String) SWBPortal.getServletContext().getAttribute("authType");
        this.website = null;
    }

    /**
     * Instantiates a new sW b4 callback handler face book.
     * 
     * @param request the request
     * @param response the response
     * @param authType the auth type
     * @param website the website
     */
    public SWB4CallbackHandlerFaceBook(HttpServletRequest request, HttpServletResponse response, String authType, String website)
    {
        log.trace("Complete CallbackHandler");
        this.request = request;
        this.response = response;
        this.authType = authType;
        this.website = website;
    }

    /**
     * Manejo de los parámetros para enviarlos al JAAS
     * parameter management as required by JAAS.
     * 
     * @param callbacks the callbacks
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws UnsupportedCallbackException the unsupported callback exception
     */
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException
    {
        String login = request.getParameter("code");
//        String password = request.getParameter("wb_password");
//        String session = request.getParameter("session");
//        String sesid = null;
//        String secret = null;
//        String key = null;
//        String sig = null;
//        try
//        {
//            JSONObject obj = new JSONObject(session);
//            sesid = obj.getString("uid");
//            secret = obj.getString("secret");
//            key = obj.getString("session_key");
//            sig = obj.getString("sig");
//        } catch (JSONException ex)
//        {
//        }
        for (int i = 0; i < callbacks.length; i++)
        {
            if (callbacks[i] instanceof NameCallback)
            {
                NameCallback nameCallback = (NameCallback) callbacks[i];
                nameCallback.setName(login);

            }
//            else if (callbacks[i] instanceof PasswordCallback)
//            {
//                PasswordCallback passwordCallback = (PasswordCallback) callbacks[i];
//                passwordCallback.setPassword(password == null ? null : password.toCharArray());
//            }
            else if (callbacks[i] instanceof TextInputCallback)
            {
                TextInputCallback textInputCallback = (TextInputCallback) callbacks[i];
                if (textInputCallback.getPrompt().equals("Site"))
                {
                    textInputCallback.setText(website);
                }
//                if (textInputCallback.getPrompt().equals("Session"))
//                {
//                    textInputCallback.setText(sesid);
//                }
//                if (textInputCallback.getPrompt().equals("Secret"))
//                {
//                    textInputCallback.setText(secret);
//                }
//                if (textInputCallback.getPrompt().equals("key"))
//                {
//                    textInputCallback.setText(key);
//                }
//                if (textInputCallback.getPrompt().equals("sig"))
//                {
//                    textInputCallback.setText(sig);
//                }
            }
        }
    }

    /**
     * Gets the form credentials.
     * 
     * @param callbacks the callbacks
     * @return the form credentials
     */
    private void getFormCredentials(Callback[] callbacks)
    {
    }
}
