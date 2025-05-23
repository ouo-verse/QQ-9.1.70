package tencent.im.group_pro_proto.eventflow;

import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import cooperation.qqcircle.report.QCircleLpReportDc05502;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class msg_event$GetRsp extends MessageMicro<msg_event$GetRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field begin_time;
    public final PBBytesField cookie;
    public final PBUInt64Field end_time;
    public final PBUInt64Field err_code = PBField.initUInt64(0);
    public final PBBytesField err_msg;
    public final PBRepeatMessageField<msg_event$MsgEvent> msg_events;

    static {
        String[] strArr = {CheckForwardServlet.KEY_ERR_CODE, "err_msg", "msg_events", "cookie", QCircleLpReportDc05502.KEY_BEGIN_TIME, "end_time"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 48}, strArr, new Object[]{0L, byteStringMicro, null, byteStringMicro, 0L, 0L}, msg_event$GetRsp.class);
    }

    public msg_event$GetRsp() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.err_msg = PBField.initBytes(byteStringMicro);
        this.msg_events = PBField.initRepeatMessage(msg_event$MsgEvent.class);
        this.cookie = PBField.initBytes(byteStringMicro);
        this.begin_time = PBField.initUInt64(0L);
        this.end_time = PBField.initUInt64(0L);
    }
}
