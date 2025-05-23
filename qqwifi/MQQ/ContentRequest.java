package qqwifi.MQQ;

import LBS.LBSInfo;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ContentRequest extends JceStruct {
    static LBSInfo cache_lbsInfo;

    /* renamed from: id, reason: collision with root package name */
    public long f429318id;
    public LBSInfo lbsInfo;
    public String version;

    public ContentRequest() {
        this.f429318id = 0L;
        this.lbsInfo = null;
        this.version = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f429318id = jceInputStream.read(this.f429318id, 0, true);
        if (cache_lbsInfo == null) {
            cache_lbsInfo = new LBSInfo();
        }
        this.lbsInfo = (LBSInfo) jceInputStream.read((JceStruct) cache_lbsInfo, 1, false);
        this.version = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f429318id, 0);
        LBSInfo lBSInfo = this.lbsInfo;
        if (lBSInfo != null) {
            jceOutputStream.write((JceStruct) lBSInfo, 1);
        }
        String str = this.version;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
    }

    public ContentRequest(long j3, LBSInfo lBSInfo, String str) {
        this.f429318id = j3;
        this.lbsInfo = lBSInfo;
        this.version = str;
    }
}
