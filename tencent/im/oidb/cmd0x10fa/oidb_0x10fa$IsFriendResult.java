package tencent.im.oidb.cmd0x10fa;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x10fa$IsFriendResult extends MessageMicro<oidb_0x10fa$IsFriendResult> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"openid", "is_friend"}, new Object[]{"", Boolean.FALSE}, oidb_0x10fa$IsFriendResult.class);
    public final PBStringField openid = PBField.initString("");
    public final PBBoolField is_friend = PBField.initBool(false);
}
