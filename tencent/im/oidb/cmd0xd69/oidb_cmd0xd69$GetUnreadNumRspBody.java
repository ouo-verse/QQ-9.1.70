package tencent.im.oidb.cmd0xd69;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xd69$GetUnreadNumRspBody extends MessageMicro<oidb_cmd0xd69$GetUnreadNumRspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"doubt_unread_num"}, new Object[]{0}, oidb_cmd0xd69$GetUnreadNumRspBody.class);
    public final PBUInt32Field doubt_unread_num = PBField.initUInt32(0);
}
