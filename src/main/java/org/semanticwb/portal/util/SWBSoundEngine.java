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
package org.semanticwb.portal.util;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import com.sun.speech.freetts.audio.AudioPlayer;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

/**
 *
 * @author serch
 */
public class SWBSoundEngine {

    public byte[] voice(String word) throws IOException {
        byte[] ret = null;
        VoiceManager voiceManager = VoiceManager.getInstance();
        Voice helloVoice = voiceManager.getVoice("kevin16");
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        AudioPlayer player = new SWBAudioPlayer(bos);
        helloVoice.allocate();
        helloVoice.setAudioPlayer(player);

        helloVoice.speak(word);
        ret = ((ByteArrayOutputStream) bos).toByteArray();
        InputStream is = new ByteArrayInputStream(ret);
        AudioInputStream ais = new AudioInputStream(is,
                player.getAudioFormat(), ret.length / player.getAudioFormat().getFrameSize());
        bos = new ByteArrayOutputStream();
        AudioSystem.write(ais, AudioFileFormat.Type.WAVE, bos);
        bos.flush();
        ret = bos.toByteArray();

        helloVoice.deallocate();
        bos.close();
        return ret;
    }
}
