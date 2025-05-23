package qz_groupphoto;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes29.dex */
public final class GetLastPicReq extends JceStruct {
    static _LoginInfo cache_stLoginInfo;
    public long cnt;
    public long gid;
    public long lasttime;
    public _LoginInfo stLoginInfo;
    public long uin;

    public GetLastPicReq() {
        this.stLoginInfo = null;
        this.uin = 0L;
        this.gid = 0L;
        this.cnt = 0L;
        this.lasttime = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_stLoginInfo == null) {
            cache_stLoginInfo = new _LoginInfo();
        }
        this.stLoginInfo = (_LoginInfo) jceInputStream.read((JceStruct) cache_stLoginInfo, 0, false);
        this.uin = jceInputStream.read(this.uin, 1, true);
        this.gid = jceInputStream.read(this.gid, 2, true);
        this.cnt = jceInputStream.read(this.cnt, 3, true);
        this.lasttime = jceInputStream.read(this.lasttime, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        _LoginInfo _logininfo = this.stLoginInfo;
        if (_logininfo != null) {
            jceOutputStream.write((JceStruct) _logininfo, 0);
        }
        jceOutputStream.write(this.uin, 1);
        jceOutputStream.write(this.gid, 2);
        jceOutputStream.write(this.cnt, 3);
        jceOutputStream.write(this.lasttime, 4);
    }

    public GetLastPicReq(_LoginInfo _logininfo, long j3, long j16, long j17, long j18) {
        this.stLoginInfo = _logininfo;
        this.uin = j3;
        this.gid = j16;
        this.cnt = j17;
        this.lasttime = j18;
    }
}
