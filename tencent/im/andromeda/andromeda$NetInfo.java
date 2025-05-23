package tencent.im.andromeda;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class andromeda$NetInfo extends MessageMicro<andromeda$NetInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field bussinessid;
    public final PBUInt32Field clientversion;
    public final PBUInt32Field ispcode;
    public final PBBytesField last_srvmessage;
    public final PBUInt32Field lastbyte_recv;
    public final PBUInt32Field lastlost_rate;
    public final PBUInt32Field lastrtt;
    public final PBUInt32Field lastrtt_mean;
    public final PBUInt32Field lastspeed;
    public final PBUInt32Field mcc;
    public final PBUInt32Field mnc;
    public final PBUInt32Field nettype = PBField.initUInt32(0);
    public final PBUInt32Field optype;
    public final PBBytesField ssid;

    static {
        String[] strArr = {TPReportKeys.LiveExKeys.LIVE_EX_NET_TYPE, TPDownloadProxyEnum.USER_SSID, "mcc", "mnc", "ispcode", "lastrtt", "lastspeed", "lastrtt_mean", "lastlost_rate", "lastbyte_recv", "bussinessid", "clientversion", "last_srvmessage", "optype"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, 106, 112}, strArr, new Object[]{0, byteStringMicro, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, byteStringMicro, 0}, andromeda$NetInfo.class);
    }

    public andromeda$NetInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.ssid = PBField.initBytes(byteStringMicro);
        this.mcc = PBField.initUInt32(0);
        this.mnc = PBField.initUInt32(0);
        this.ispcode = PBField.initUInt32(0);
        this.lastrtt = PBField.initUInt32(0);
        this.lastspeed = PBField.initUInt32(0);
        this.lastrtt_mean = PBField.initUInt32(0);
        this.lastlost_rate = PBField.initUInt32(0);
        this.lastbyte_recv = PBField.initUInt32(0);
        this.bussinessid = PBField.initUInt32(0);
        this.clientversion = PBField.initUInt32(0);
        this.last_srvmessage = PBField.initBytes(byteStringMicro);
        this.optype = PBField.initUInt32(0);
    }
}
