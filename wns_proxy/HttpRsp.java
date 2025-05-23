package wns_proxy;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class HttpRsp extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String HTTP_HEADER_END = "\r\n\r\n";
    public static final String HTTP_HEADER_START = "HTTP";
    public String body;
    public String rspinfo;

    public HttpRsp() {
        this.rspinfo = "";
        this.body = "";
    }

    public static byte[] copyOfRange(byte[] bArr, int i3, int i16) {
        if (i3 <= i16) {
            int length = bArr.length;
            if (i3 >= 0 && i3 <= length) {
                int i17 = i16 - i3;
                int min = Math.min(i17, length - i3);
                byte[] bArr2 = new byte[i17];
                System.arraycopy(bArr, i3, bArr2, 0, min);
                return bArr2;
            }
            throw new ArrayIndexOutOfBoundsException();
        }
        throw new IllegalArgumentException();
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
        new JceDisplayer(sb5, i3).display(this.rspinfo, "rspinfo");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(StringBuilder sb5, int i3) {
        new JceDisplayer(sb5, i3).displaySimple(this.rspinfo, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return JceUtil.equals(this.rspinfo, ((HttpRsp) obj).rspinfo);
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
        int indexOf;
        String readString = jceInputStream.readString(0, true);
        this.rspinfo = readString;
        if (readString == null || readString.indexOf("HTTP") < 0 || (indexOf = this.rspinfo.indexOf(HTTP_HEADER_END)) < 0) {
            return;
        }
        this.body = this.rspinfo.substring(indexOf + 4);
    }

    public int search(byte[] bArr, int i3, byte[] bArr2) {
        if (bArr != null && bArr.length > i3 && bArr2 != null && bArr.length >= bArr2.length) {
            while (i3 < bArr.length && bArr.length >= bArr2.length + i3 && i3 < Integer.MAX_VALUE) {
                int i16 = 0;
                while (i16 < bArr2.length && bArr[i3 + i16] == bArr2[i16]) {
                    i16++;
                }
                if (i16 == bArr2.length) {
                    return i3;
                }
                i3++;
            }
        }
        return -1;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.rspinfo, 0);
    }

    public HttpRsp(String str) {
        this.body = "";
        this.rspinfo = str;
    }
}
