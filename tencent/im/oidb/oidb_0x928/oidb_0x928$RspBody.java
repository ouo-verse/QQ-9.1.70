package tencent.im.oidb.oidb_0x928;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x928$RspBody extends MessageMicro<oidb_0x928$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"group_id", "notice_info_list"}, new Object[]{0L, null}, oidb_0x928$RspBody.class);
    public final PBUInt64Field group_id = PBField.initUInt64(0);
    public final PBRepeatMessageField<oidb_0x928$NoticeInfo> notice_info_list = PBField.initRepeatMessage(oidb_0x928$NoticeInfo.class);
}
