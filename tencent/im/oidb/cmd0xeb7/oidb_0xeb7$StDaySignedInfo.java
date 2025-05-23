package tencent.im.oidb.cmd0xeb7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xeb7$StDaySignedInfo extends MessageMicro<oidb_0xeb7$StDaySignedInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, new String[]{"uid", "uidGroupNick", "signedTimeStamp", "signInRank"}, new Object[]{"", "", 0L, 0}, oidb_0xeb7$StDaySignedInfo.class);
    public final PBStringField uid = PBField.initString("");
    public final PBStringField uidGroupNick = PBField.initString("");
    public final PBInt64Field signedTimeStamp = PBField.initInt64(0);
    public final PBInt32Field signInRank = PBField.initInt32(0);
}
