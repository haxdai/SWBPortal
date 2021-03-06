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
 *  http://www.semanticwebbuilder.org.mx
 */
package org.semanticwb.portal.lib;

import java.io.IOException;
import java.util.*;
import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpUpgradeHandler;
import javax.servlet.http.Part;
import org.semanticwb.servlet.SWBVirtualHostFilter;

// TODO: Auto-generated Javadoc
/**
 * Clase que implementa HttpServletRequest, la cual se utiliza para remplazar el
 * Request por defecto para se enviado al recurso.
 * @author Javier Solis Gonzalez
 */
public class SWBRequest implements javax.servlet.http.HttpServletRequest
{

    /** The sess. */
    SWBSession sess;
    /** The parms. */
    Hashtable parms = new Hashtable();
    /** The attr. */
    Hashtable attr = new Hashtable();
    /** The request. */
    javax.servlet.http.HttpServletRequest request = null;

    /**
     * Creates a new instance of WBRequest.
     */
    public SWBRequest()
    {
        sess = new SWBSession();
    }

    /**
     * Instantiates a new sWB request.
     * 
     * @param request the request
     */
    public SWBRequest(javax.servlet.http.HttpServletRequest request)
    {
        this.request = request;
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletRequest#getAttribute(java.lang.String)
     */
    /**
     * Gets the attribute.
     * 
     * @param str the str
     * @return the attribute
     */
    @Override
    public Object getAttribute(String str)
    {
        if (request == null)
        {
            return attr.get(str);
        }
        return request.getAttribute(str);
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletRequest#getAttributeNames()
     */
    /**
     * Gets the attribute names.
     * 
     * @return the attribute names
     */
    @Override
    public java.util.Enumeration getAttributeNames()
    {
        if (request == null)
        {
            return attr.keys();
        }
        return request.getAttributeNames();//(new Vector()).elements();
    }

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServletRequest#getAuthType()
     */
    /**
     * Gets the auth type.
     * 
     * @return the auth type
     */
    @Override
    public String getAuthType()
    {
        if (request == null)
            return null;
        return request.getAuthType();
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletRequest#getCharacterEncoding()
     */
    /**
     * Gets the character encoding.
     * 
     * @return the character encoding
     */
    @Override
    public String getCharacterEncoding()
    {
        if (request == null)
            return null;
        return request.getCharacterEncoding();
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletRequest#getContentLength()
     */
    /**
     * Gets the content length.
     * 
     * @return the content length
     */
    @Override
    public int getContentLength()
    {
        return 0;
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletRequest#getContentType()
     */
    /**
     * Gets the content type.
     * 
     * @return the content type
     */
    @Override
    public String getContentType()
    {
        if (request == null)
            return "text/html";
        return request.getContentType();
    }

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServletRequest#getContextPath()
     */
    /**
     * Gets the context path.
     * 
     * @return the context path
     */
    @Override
    public String getContextPath()
    {
        if (request == null)
            return null;
        return request.getContextPath();
    }

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServletRequest#getCookies()
     */
    /**
     * Gets the cookies.
     * 
     * @return the cookies
     */
    @Override
    public javax.servlet.http.Cookie[] getCookies()
    {
        if (request == null)
            return null;
        return request.getCookies();
    }

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServletRequest#getDateHeader(java.lang.String)
     */
    /**
     * Gets the date header.
     * 
     * @param str the str
     * @return the date header
     */
    @Override
    public long getDateHeader(String str)
    {
        if (request == null)
            return new Date().getTime();//request.getDateHeader(str);
        else
            return request.getDateHeader(str);
    }

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServletRequest#getHeader(java.lang.String)
     */
    /**
     * Gets the header.
     * 
     * @param str the str
     * @return the header
     */
    @Override
    public String getHeader(String str)
    {
        if (request == null)
            return null;
        else
            return request.getHeader(str);
    }

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServletRequest#getHeaderNames()
     */
    /**
     * Gets the header names.
     * 
     * @return the header names
     */
    @Override
    public java.util.Enumeration getHeaderNames()
    {
        if (request == null)
            return new Vector().elements();
        else
            return request.getHeaderNames();
    }

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServletRequest#getHeaders(java.lang.String)
     */
    /**
     * Gets the headers.
     * 
     * @param str the str
     * @return the headers
     */
    @Override
    public java.util.Enumeration getHeaders(String str)
    {
        if (request == null)
            return new Vector().elements();
        else
            return request.getHeaders(str);
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletRequest#getInputStream()
     */
    /**
     * Gets the input stream.
     * 
     * @return the input stream
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @Override
    public javax.servlet.ServletInputStream getInputStream() throws java.io.IOException
    {
        return null;
    }

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServletRequest#getIntHeader(java.lang.String)
     */
    /**
     * Gets the int header.
     * 
     * @param str the str
     * @return the int header
     */
    @Override
    public int getIntHeader(String str)
    {
        if (request == null)
            return -1;
        else
            return request.getIntHeader(str);
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletRequest#getLocale()
     */
    /**
     * Gets the locale.
     * 
     * @return the locale
     */
    @Override
    public java.util.Locale getLocale()
    {
        if (request == null)
            return Locale.getDefault();
        return request.getLocale();
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletRequest#getLocales()
     */
    /**
     * Gets the locales.
     * 
     * @return the locales
     */
    @Override
    public java.util.Enumeration getLocales()
    {
        if (request == null)
            return new Vector().elements();
        return request.getLocales();
    }

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServletRequest#getMethod()
     */
    /**
     * Gets the method.
     * 
     * @return the method
     */
    @Override
    public String getMethod()
    {
        if (request == null)
            return "GET";
        return request.getMethod();
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletRequest#getParameter(java.lang.String)
     */
    /**
     * Gets the parameter.
     * 
     * @param str the str
     * @return the parameter
     */
    @Override
    public String getParameter(String str)
    {
        String ret = null;
        String[] arr = (String[]) parms.get(str);
        if (arr != null)
            ret = arr[0];
        return ret;
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletRequest#getParameterMap()
     */
    /**
     * Gets the parameter map.
     * 
     * @return the parameter map
     */
    @Override
    public java.util.Map getParameterMap()
    {
        return parms;
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletRequest#getParameterNames()
     */
    /**
     * Gets the parameter names.
     * 
     * @return the parameter names
     */
    @Override
    public java.util.Enumeration getParameterNames()
    {
        return parms.keys();
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletRequest#getParameterValues(java.lang.String)
     */
    /**
     * Gets the parameter values.
     * 
     * @param str the str
     * @return the parameter values
     */
    @Override
    public String[] getParameterValues(String str)
    {
        return (String[]) parms.get(str);
    }

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServletRequest#getPathInfo()
     */
    /**
     * Gets the path info.
     * 
     * @return the path info
     */
    @Override
    public String getPathInfo()
    {
        if (request == null)
            return null;
        return request.getPathInfo();
    }

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServletRequest#getPathTranslated()
     */
    /**
     * Gets the path translated.
     * 
     * @return the path translated
     */
    @Override
    public String getPathTranslated()
    {
        if (request == null)
            return null;
        return request.getPathTranslated();
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletRequest#getProtocol()
     */
    /**
     * Gets the protocol.
     * 
     * @return the protocol
     */
    @Override
    public String getProtocol()
    {
        if (request == null)
            return null;
        return request.getProtocol();
    }

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServletRequest#getQueryString()
     */
    /**
     * Gets the query string.
     * 
     * @return the query string
     */
    @Override
    public String getQueryString()
    {
        if (request == null)
        {
            return null;
        }
        else 
        {
            return request.getQueryString();
        }
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletRequest#getReader()
     */
    /**
     * Gets the reader.
     * 
     * @return the reader
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @Override
    public java.io.BufferedReader getReader() throws java.io.IOException
    {
        return null;
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletRequest#getRealPath(java.lang.String)
     */
    /**
     * Gets the real path.
     * 
     * @param str the str
     * @return the real path
     */
    @Override
    public String getRealPath(String str)
    {
        if (request == null)
            return null;
        return request.getRealPath(str);
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletRequest#getRemoteAddr()
     */
    /**
     * Gets the remote addr.
     * 
     * @return the remote addr
     */
    @Override
    public String getRemoteAddr()
    {
        if (request == null)
            return null;
        return request.getRemoteAddr();
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletRequest#getRemoteHost()
     */
    /**
     * Gets the remote host.
     * 
     * @return the remote host
     */
    @Override
    public String getRemoteHost()
    {
        if (request == null)
            return null;
        return request.getRemoteHost();
    }

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServletRequest#getRemoteUser()
     */
    /**
     * Gets the remote user.
     * 
     * @return the remote user
     */
    @Override
    public String getRemoteUser()
    {
        if (request == null)
            return null;
        return request.getRemoteUser();
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletRequest#getRequestDispatcher(java.lang.String)
     */
    /**
     * Gets the request dispatcher.
     * 
     * @param str the str
     * @return the request dispatcher
     */
    @Override
    public javax.servlet.RequestDispatcher getRequestDispatcher(String str)
    {
        if (request == null)
        {
            return SWBVirtualHostFilter.getInstance().getServletConfig().getServletContext().getRequestDispatcher(str);
        }
        return request.getRequestDispatcher(str);
    }

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServletRequest#getRequestURI()
     */
    /**
     * Gets the request uri.
     * 
     * @return the request uri
     */
    @Override
    public String getRequestURI()
    {
        if (request == null)
            return null;
        return request.getRequestURI();
    }

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServletRequest#getRequestURL()
     */
    /**
     * Gets the request url.
     * 
     * @return the request url
     */
    @Override
    public StringBuffer getRequestURL()
    {
        if (request == null)
            return null;
        return request.getRequestURL();
    }

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServletRequest#getRequestedSessionId()
     */
    /**
     * Gets the requested session id.
     * 
     * @return the requested session id
     */
    @Override
    public String getRequestedSessionId()
    {
        if (request == null)
            sess.getId();
        return request.getRequestedSessionId();
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletRequest#getScheme()
     */
    /**
     * Gets the scheme.
     * 
     * @return the scheme
     */
    @Override
    public String getScheme()
    {
        if (request == null)
            return null;
        return request.getScheme();
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletRequest#getServerName()
     */
    /**
     * Gets the server name.
     * 
     * @return the server name
     */
    @Override
    public String getServerName()
    {
        if (request == null)
            return null;
        return request.getServerName();
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletRequest#getServerPort()
     */
    /**
     * Gets the server port.
     * 
     * @return the server port
     */
    @Override
    public int getServerPort()
    {
        if (request == null)
            return 0;
        return request.getServerPort();
    }

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServletRequest#getServletPath()
     */
    /**
     * Gets the servlet path.
     * 
     * @return the servlet path
     */
    @Override
    public String getServletPath()
    {
        if (request == null)
            return null;
        return request.getServletPath();//WBUtils.getInstance().getWebPath();
    }

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServletRequest#getSession()
     */
    /**
     * Gets the session.
     * 
     * @return the session
     */
    @Override
    public javax.servlet.http.HttpSession getSession()
    {
        if (request == null)
            return sess;
        return request.getSession();
    }

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServletRequest#getSession(boolean)
     */
    /**
     * Gets the session.
     * 
     * @param param the param
     * @return the session
     */
    @Override
    public javax.servlet.http.HttpSession getSession(boolean param)
    {
        if (request == null)
            return sess;
        return request.getSession(param);
    }

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServletRequest#getUserPrincipal()
     */
    /**
     * Gets the user principal.
     * 
     * @return the user principal
     */
    @Override
    public java.security.Principal getUserPrincipal()
    {
        if (request == null)
            return null;
        return request.getUserPrincipal();
    }

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServletRequest#isRequestedSessionIdFromCookie()
     */
    /**
     * Checks if is requested session id from cookie.
     * 
     * @return true, if is requested session id from cookie
     */
    @Override
    public boolean isRequestedSessionIdFromCookie()
    {
        if (request == null)
            return false;
        return request.isRequestedSessionIdFromCookie();
    }

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServletRequest#isRequestedSessionIdFromURL()
     */
    /**
     * Checks if is requested session id from url.
     * 
     * @return true, if is requested session id from url
     */
    @Override
    public boolean isRequestedSessionIdFromURL()
    {
        if (request == null)
            return false;
        return request.isRequestedSessionIdFromURL();
    }

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServletRequest#isRequestedSessionIdFromUrl()
     */
    /**
     * Checks if is requested session id from url.
     * 
     * @return true, if is requested session id from url
     */
    @Override
    public boolean isRequestedSessionIdFromUrl()
    {
        if (request == null)
            return false;
        return request.isRequestedSessionIdFromUrl();
    }

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServletRequest#isRequestedSessionIdValid()
     */
    /**
     * Checks if is requested session id valid.
     * 
     * @return true, if is requested session id valid
     */
    @Override
    public boolean isRequestedSessionIdValid()
    {
        if (request == null)
            return false;
        return request.isRequestedSessionIdValid();
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletRequest#isSecure()
     */
    /**
     * Checks if is secure.
     * 
     * @return true, if is secure
     */
    @Override
    public boolean isSecure()
    {
        if (request == null)
            return false;
        return request.isSecure();
    }

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServletRequest#isUserInRole(java.lang.String)
     */
    /**
     * Checks if is user in role.
     * 
     * @param str the str
     * @return true, if is user in role
     */
    @Override
    public boolean isUserInRole(String str)
    {
        if (request == null)
            return false;
        return request.isUserInRole(str);
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletRequest#removeAttribute(java.lang.String)
     */
    /**
     * Removes the attribute.
     * 
     * @param str the str
     */
    @Override
    public void removeAttribute(String str)
    {
        if (request == null)
        {
            attr.remove(str);
        }
        else
        {
            request.removeAttribute(str);
        }
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletRequest#setAttribute(java.lang.String, java.lang.Object)
     */
    /**
     * Sets the attribute.
     * 
     * @param str the str
     * @param obj the obj
     */
    @Override
    public void setAttribute(String str, Object obj)
    {
        if (request == null)
        {
            attr.put(str, obj);
        }
        else
        {
            request.setAttribute(str, obj);
        }
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletRequest#setCharacterEncoding(java.lang.String)
     */
    /**
     * Sets the character encoding.
     * 
     * @param str the new character encoding
     * @throws UnsupportedEncodingException the unsupported encoding exception
     */
    @Override
    public void setCharacterEncoding(String str) throws java.io.UnsupportedEncodingException
    {
        if (request == null)
            return;
        request.setCharacterEncoding(str);
    }

    /**
     * Adds the parameter.
     * 
     * @param name the name
     * @param value the value
     */
    public void addParameter(String name, String value)
    {
        Object obj = parms.get(name);
        if (obj == null)
        {
            parms.put(name, new String[]
                    {
                        value
                    });
        }
        else if (obj instanceof String[])
        {
            String arr[] = (String[]) obj;
            String fin[] = new String[arr.length + 1];
            int x = 0;
            for (; x < arr.length; x++)
            {
                fin[x] = arr[x];
            }
            fin[x] = value;
            parms.put(name, fin);
        }
    }

    @Override
    public int getRemotePort() {
        if (request == null)
            return 0;
        else
            return request.getRemotePort();
    }

    @Override
    public String getLocalName() {
        if (request == null)
            return null;
        else 
            return request.getLocalName();
    }

    @Override
    public String getLocalAddr() {
        if (request == null)
            return null;
        else
            return request.getLocalAddr();
    }

    @Override
    public int getLocalPort() {
        if (request == null)
            return 0;
        else 
            return request.getLocalPort();
    }

    @Override
    public boolean authenticate(HttpServletResponse hsr) throws IOException, ServletException 
    {
        if (request == null)
            return false;
        else
            return request.authenticate(hsr);
    }

    @Override
    public void login(String string, String string1) throws ServletException {
        if (request == null)
            return;
        else
            request.login(string, string1);
    }

    @Override
    public void logout() throws ServletException {
        if (request == null)
            return;
        else
            request.logout();
    }

    @Override
    public Collection<Part> getParts() throws IOException, ServletException {
        if (request == null)
            return null;
        else
            return request.getParts();
    }

    @Override
    public Part getPart(String string) throws IOException, ServletException {
        if (request == null)
        {
            return null;
        }else
        {
            return request.getPart(string);
        }
    }

    @Override
    public ServletContext getServletContext() 
    {
        if (request == null)
        {
            return SWBVirtualHostFilter.getInstance().getServletConfig().getServletContext();
        }else
        {
            return request.getServletContext();
        }
    }

    @Override
    public AsyncContext startAsync() throws IllegalStateException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AsyncContext startAsync(ServletRequest sr, ServletResponse sr1) throws IllegalStateException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isAsyncStarted() {
        if (request == null)
        {
            return false;
        }else
        {
            return request.isAsyncStarted();
        }
    }

    @Override
    public boolean isAsyncSupported() {
        //new Exception().printStackTrace();
        if (request == null)
        {
            return false;
        }else
            return request.isAsyncSupported();
    }

    @Override
    public AsyncContext getAsyncContext() {
        if (request == null)
        {
            return null;
        }else
        {
            return request.getAsyncContext();
        }            
    }

    @Override
    public DispatcherType getDispatcherType() {
        if (request == null)
        {
            return null;
        }else
        {
            return request.getDispatcherType();
        }
    }

    @Override
    public String changeSessionId() {
        if (request != null)
        {
            return request.changeSessionId();
        }
        return null;
    }

    @Override
    public <T extends HttpUpgradeHandler> T upgrade(Class<T> handlerClass) throws IOException, ServletException {
        if (request != null)return request.upgrade(handlerClass);
        return null;
    }

    @Override
    public long getContentLengthLong() {
        if (request != null)return request.getContentLengthLong();
        return -1;
    }
}
