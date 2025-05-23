package qqwifi;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class WiFiAccountReq extends JceStruct {
    public byte barsetting;
    public long crc;
    public long seqno;
    public long uin;

    public WiFiAccountReq() {
        this.uin = 0L;
        this.seqno = 0L;
        this.crc = 0L;
        this.barsetting = (byte) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, true);
        this.seqno = jceInputStream.read(this.seqno, 1, true);
        this.crc = jceInputStream.read(this.crc, 2, true);
        this.barsetting = jceInputStream.read(this.barsetting, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.seqno, 1);
        jceOutputStream.write(this.crc, 2);
        jceOutputStream.write(this.barsetting, 3);
    }

    public WiFiAccountReq(long j3, long j16, long j17, byte b16) {
        this.uin = j3;
        this.seqno = j16;
        this.crc = j17;
        this.barsetting = b16;
    }
}
