package zt3;

import android.os.SystemClock;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonParamEnum;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private String f453215a;

    /* renamed from: b, reason: collision with root package name */
    private Document f453216b;

    /* renamed from: c, reason: collision with root package name */
    private int f453217c;

    /* renamed from: d, reason: collision with root package name */
    private int f453218d;

    public a() {
        this.f453215a = "";
        this.f453217c = 0;
        this.f453218d = 0;
    }

    private void f() {
        NodeList elementsByTagName = this.f453216b.getElementsByTagName("em");
        NodeList elementsByTagName2 = this.f453216b.getElementsByTagName("exem");
        if (elementsByTagName.getLength() > 0 && elementsByTagName2.getLength() > 0) {
            this.f453217c = com.tencent.qqlive.superplayer.tools.utils.g.i(elementsByTagName.item(0).getFirstChild().getNodeValue(), 0);
            this.f453218d = com.tencent.qqlive.superplayer.tools.utils.g.i(elementsByTagName2.item(0).getFirstChild().getNodeValue(), 0);
        }
    }

    public Document a() {
        return this.f453216b;
    }

    public String b() {
        return this.f453215a;
    }

    public boolean c() {
        try {
            this.f453216b = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(this.f453215a)));
            f();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean d() {
        NodeList elementsByTagName = this.f453216b.getElementsByTagName(ReportConstant.COSTREPORT_PREFIX);
        NodeList elementsByTagName2 = this.f453216b.getElementsByTagName("em");
        NodeList elementsByTagName3 = this.f453216b.getElementsByTagName("type");
        if (elementsByTagName.getLength() > 0 && elementsByTagName2.getLength() > 0 && elementsByTagName3.getLength() > 0 && elementsByTagName.item(0).getFirstChild().getNodeValue().equals("f")) {
            int i3 = com.tencent.qqlive.superplayer.tools.utils.g.i(elementsByTagName2.item(0).getFirstChild().getNodeValue(), 0);
            int i16 = com.tencent.qqlive.superplayer.tools.utils.g.i(elementsByTagName3.item(0).getFirstChild().getNodeValue(), 0);
            if (i3 == 85 && i16 == -3) {
                if (this.f453216b.getElementsByTagName("curTime").getLength() > 0) {
                    g.f453348a = com.tencent.qqlive.superplayer.tools.utils.g.i(r0.item(0).getFirstChild().getNodeValue(), 0);
                }
                NodeList elementsByTagName4 = this.f453216b.getElementsByTagName("rand");
                if (elementsByTagName4.getLength() > 0) {
                    g.f453350c = elementsByTagName4.item(0).getFirstChild().getNodeValue();
                }
                g.f453349b = SystemClock.elapsedRealtime();
                return true;
            }
        }
        return false;
    }

    public boolean e() {
        NodeList elementsByTagName = this.f453216b.getElementsByTagName(TVKCommonParamEnum.REQ_PARAM_KEY_RETRY);
        if (elementsByTagName.getLength() <= 0 || com.tencent.qqlive.superplayer.tools.utils.g.i(elementsByTagName.item(0).getFirstChild().getNodeValue(), 0) <= 0) {
            return false;
        }
        return true;
    }

    public a(String str) {
        this();
        this.f453215a = str;
    }
}
