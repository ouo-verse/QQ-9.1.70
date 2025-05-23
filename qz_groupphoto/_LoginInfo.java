package qz_groupphoto;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class _LoginInfo extends JceStruct {
    public String strAuthKey;
    public String strCookie;
    public long uAuthOption;
    public long uAuthType;
    public long uHostUin;
    public long uPtId;
    public long uUserIpNet;

    public _LoginInfo() {
        this.uAuthType = 0L;
        this.strAuthKey = "";
        this.uUserIpNet = 0L;
        this.uHostUin = 0L;
        this.uPtId = 0L;
        this.strCookie = "";
        this.uAuthOption = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uAuthType = jceInputStream.read(this.uAuthType, 0, false);
        this.strAuthKey = jceInputStream.readString(1, false);
        this.uUserIpNet = jceInputStream.read(this.uUserIpNet, 2, false);
        this.uHostUin = jceInputStream.read(this.uHostUin, 3, false);
        this.uPtId = jceInputStream.read(this.uPtId, 4, false);
        this.strCookie = jceInputStream.readString(5, false);
        this.uAuthOption = jceInputStream.read(this.uAuthOption, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uAuthType, 0);
        String str = this.strAuthKey;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.uUserIpNet, 2);
        jceOutputStream.write(this.uHostUin, 3);
        jceOutputStream.write(this.uPtId, 4);
        String str2 = this.strCookie;
        if (str2 != null) {
            jceOutputStream.write(str2, 5);
        }
        jceOutputStream.write(this.uAuthOption, 6);
    }

    public _LoginInfo(long j3, String str, long j16, long j17, long j18, String str2, long j19) {
        this.uAuthType = j3;
        this.strAuthKey = str;
        this.uUserIpNet = j16;
        this.uHostUin = j17;
        this.uPtId = j18;
        this.strCookie = str2;
        this.uAuthOption = j19;
    }
}
