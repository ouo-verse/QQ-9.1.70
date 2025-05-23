package wns_proxy;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class HttpReq extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static int cache_method;
    public String body;
    public String domain;
    public String header;
    public int method;

    public HttpReq() {
        this.header = "";
        this.body = "";
        this.domain = "";
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    @Override // com.qq.taf.jce.JceStruct
    public void display(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.display(this.method, "method");
        jceDisplayer.display(this.header, "header");
        jceDisplayer.display(this.body, "body");
        jceDisplayer.display(this.domain, "domain");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.displaySimple(this.method, true);
        jceDisplayer.displaySimple(this.header, true);
        jceDisplayer.displaySimple(this.body, true);
        jceDisplayer.displaySimple(this.domain, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        HttpReq httpReq = (HttpReq) obj;
        if (!JceUtil.equals(this.method, httpReq.method) || !JceUtil.equals(this.header, httpReq.header) || !JceUtil.equals(this.body, httpReq.body) || !JceUtil.equals(this.domain, httpReq.domain)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0;
        }
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.method = jceInputStream.read(this.method, 0, false);
        this.header = jceInputStream.readString(1, false);
        this.body = jceInputStream.readString(2, false);
        this.domain = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.method, 0);
        String str = this.header;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.body;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.domain;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
    }

    public HttpReq(int i3, String str, String str2, String str3) {
        this.method = i3;
        this.header = str;
        this.body = str2;
        this.domain = str3;
    }
}
