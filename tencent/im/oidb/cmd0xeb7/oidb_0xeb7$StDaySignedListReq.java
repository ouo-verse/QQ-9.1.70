package tencent.im.oidb.cmd0xeb7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xeb7$StDaySignedListReq extends MessageMicro<oidb_0xeb7$StDaySignedListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40}, new String[]{"dayYmd", "uid", "groupId", "offset", "limit"}, new Object[]{"", "", "", 0, 0}, oidb_0xeb7$StDaySignedListReq.class);
    public final PBStringField dayYmd = PBField.initString("");
    public final PBStringField uid = PBField.initString("");
    public final PBStringField groupId = PBField.initString("");
    public final PBInt32Field offset = PBField.initInt32(0);
    public final PBInt32Field limit = PBField.initInt32(0);
}
