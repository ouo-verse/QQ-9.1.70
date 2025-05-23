package tencent.im.oidb.cmd0xe34;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xe34$RspBody extends MessageMicro<cmd0xe34$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"rpt_unread_info", "ReqInterval"}, new Object[]{null, 0}, cmd0xe34$RspBody.class);
    public final PBRepeatMessageField<cmd0xe34$UnReadInfo> rpt_unread_info = PBField.initRepeatMessage(cmd0xe34$UnReadInfo.class);
    public final PBUInt32Field ReqInterval = PBField.initUInt32(0);
}
