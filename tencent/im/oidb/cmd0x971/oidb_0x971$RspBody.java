package tencent.im.oidb.cmd0x971;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x971$RspBody extends MessageMicro<oidb_0x971$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"notices"}, new Object[]{null}, oidb_0x971$RspBody.class);
    public final PBRepeatMessageField<oidb_0x971$NoticeInfo> notices = PBField.initRepeatMessage(oidb_0x971$NoticeInfo.class);
}
