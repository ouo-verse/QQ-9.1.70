package tencent.im.s2c.msgtype0x210.submsgtype0x156;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x156$MsgBody extends MessageMicro<SubMsgType0x156$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{QQHealthReportApiImpl.MSG_TYPE_KEY, "data"}, new Object[]{0, null}, SubMsgType0x156$MsgBody.class);
    public final PBInt32Field msg_type = PBField.initInt32(0);
    public final PBBytesField data = PBField.initBytes(ByteStringMicro.EMPTY);
}
