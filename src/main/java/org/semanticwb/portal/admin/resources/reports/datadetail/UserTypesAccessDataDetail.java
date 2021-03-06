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
package org.semanticwb.portal.admin.resources.reports.datadetail;

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

import org.semanticwb.portal.admin.resources.reports.beans.*;
import org.semanticwb.portal.db.SWBRecHits;

// TODO: Auto-generated Javadoc
/**
 * The Class UserTypesAccessDataDetail.
 */
public class UserTypesAccessDataDetail extends SWBDataDetail{
    
    /**
     * Instantiates a new user types access data detail.
     * 
     * @param filterReportBean the filter report bean
     */
    public UserTypesAccessDataDetail(WBAFilterReportBean filterReportBean) {
        super(filterReportBean);
    }
       
    /* (non-Javadoc)
     * @see org.semanticwb.portal.admin.resources.reports.datadetail.SWBDataDetail#doDataList(java.lang.String, java.lang.String, int, java.lang.String)
     */
    public List doDataList(String site, String rfilter, int type, String language) throws IncompleteFilterException {
        List resumeRecHits = new ArrayList();
//        String userTypeName;
//        if(rfilter != null) {
//            for(int i = 0; i < userTypes.size(); i++) {
//                String s_aux = (String) userTypes.get(Integer.toString(i));
//                int i_pipe = s_aux.indexOf("|");
//                String s_val = s_aux.substring(0,i_pipe);
//                if(rfilter.equalsIgnoreCase(s_val))
//                {
//                    userTypeName = s_aux.substring(i_pipe + 1, s_aux.length());
//                    resumeRecHits.addAll(SWBRecHits.getInstance().getResHitsLog(site,rfilter,type, userTypeName));
//                }
//            }            
//        } else{
//            for(int j = 0; j < userTypes.size(); j++) {
//                String s_aux = (String) userTypes.get(Integer.toString(j));
//                int i_pipe = s_aux.indexOf("|");
//                rfilter = s_aux.substring(0,i_pipe);
//                userTypeName = s_aux.substring(i_pipe + 1, s_aux.length());
//                
//                resumeRecHits.addAll(SWBRecHits.getInstance().getResHitsLog(site,rfilter,type, userTypeName));
//            }
//        }
        return resumeRecHits;
    }
    
    /* (non-Javadoc)
     * @see org.semanticwb.portal.admin.resources.reports.datadetail.SWBDataDetail#doDataList(java.lang.String, java.lang.String, int, int, java.lang.String)
     */
    public List doDataList(String site, String rfilter, int type, int year, String language) throws IncompleteFilterException {
        List resumeRecHits = new ArrayList();
//        String userTypeName;        
//        if(rfilter!=null){
//            for(int i = 0; i < userTypes.size(); i++) {
//                String s_aux = (String) userTypes.get(Integer.toString(i));
//                int i_pipe = s_aux.indexOf("|");
//                String s_val = s_aux.substring(0,i_pipe);
//                if(s_val.length() > 0)
//                {
//                    if(rfilter.equalsIgnoreCase(s_val))
//                    {
//                        userTypeName = s_aux.substring(i_pipe + 1, s_aux.length());
//                        resumeRecHits.addAll(SWBRecHits.getInstance().getResHitsLog(site,rfilter,type,year, userTypeName));
//                    }
//                }
//            }
//        }else {
//            for(int i = 0; i < userTypes.size(); i++) {
//                String s_aux = (String) userTypes.get(Integer.toString(i));
//                int i_pipe = s_aux.indexOf("|");
//                rfilter = s_aux.substring(0,i_pipe);
//                userTypeName = s_aux.substring(i_pipe + 1, s_aux.length());
//                resumeRecHits.addAll(SWBRecHits.getInstance().getResHitsLog(site,rfilter,type,year, userTypeName));                
//            }
//        }        
        return resumeRecHits;
    }
    
    /* (non-Javadoc)
     * @see org.semanticwb.portal.admin.resources.reports.datadetail.SWBDataDetail#doDataList(java.lang.String, java.lang.String, int, int, int, int, java.lang.String)
     */
    public List doDataList(String site, String rfilter, int type, int year, int month, int day, String language) throws IncompleteFilterException {
        List resumeRecHits = new ArrayList();        
//        String userTypeName;
//        if(rfilter != null) {
//            for(int i = 0; i < userTypes.size(); i++) {
//                String s_aux = (String) userTypes.get(Integer.toString(i));
//                int i_pipe = s_aux.indexOf("|");
//                String s_val = s_aux.substring(0,i_pipe);
//                if(rfilter.equalsIgnoreCase(s_val))
//                {
//                    userTypeName = s_aux.substring(i_pipe + 1, s_aux.length());
//                    resumeRecHits.addAll(SWBRecHits.getInstance().getResHitsLog(site,rfilter,type,year,month,day, userTypeName));
//                }
//            }            
//        } else{
//            for(int j = 0; j < userTypes.size(); j++) {
//                String s_aux = (String) userTypes.get(Integer.toString(j));
//                int i_pipe = s_aux.indexOf("|");
//                rfilter = s_aux.substring(0,i_pipe);
//                userTypeName = s_aux.substring(i_pipe + 1, s_aux.length());
//                
//                resumeRecHits.addAll(SWBRecHits.getInstance().getResHitsLog(site,rfilter,type,year,month,day, userTypeName));
//            }
//        }
        return resumeRecHits;
    }
    
    /* (non-Javadoc)
     * @see org.semanticwb.portal.admin.resources.reports.datadetail.SWBDataDetail#doDataList(java.lang.String, java.lang.String, int, int, int, int, int, int, int, java.lang.String)
     */
    public List doDataList(String site, String rfilter, int type, int yearI, int monthI, int dayI, int yearF, int monthF, int dayF, String language) throws IncompleteFilterException {
        List resumeRecHits = new ArrayList();        
//        String userTypeName;
//
//        if(rfilter!=null) {
//            for(int i = 0; i < userTypes.size(); i++) {
//                String s_aux = (String) userTypes.get(Integer.toString(i));
//                int i_pipe = s_aux.indexOf("|");
//                String s_val = s_aux.substring(0,i_pipe);
//                if(rfilter.equalsIgnoreCase(s_val))
//                {
//                    userTypeName = s_aux.substring(i_pipe + 1, s_aux.length());
//                    resumeRecHits.addAll(SWBRecHits.getInstance().getResHitsLog(site,rfilter,type,yearI,monthI,dayI,yearF,monthF,dayF, userTypeName));
//                }
//            }
//        } else{                        
//            for(int j = 0; j < userTypes.size(); j++) {
//                String s_aux = (String) userTypes.get(Integer.toString(j));
//                int i_pipe = s_aux.indexOf("|");
//                rfilter = s_aux.substring(0,i_pipe);
//                userTypeName = s_aux.substring(i_pipe + 1, s_aux.length());
//                resumeRecHits.addAll(SWBRecHits.getInstance().getResHitsLog(site,rfilter,type,yearI,monthI,dayI,yearF,monthF,dayF, userTypeName));
//            }
//        }
        return resumeRecHits;
    }
}
