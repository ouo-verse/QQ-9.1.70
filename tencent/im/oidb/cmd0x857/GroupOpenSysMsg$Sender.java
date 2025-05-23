package tencent.im.oidb.cmd0x857;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GroupOpenSysMsg$Sender extends MessageMicro<GroupOpenSysMsg$Sender> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"uin", "nick", "avatar", "url"}, new Object[]{0L, "", "", ""}, GroupOpenSysMsg$Sender.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBStringField nick = PBField.initString("");
    public final PBStringField avatar = PBField.initString("");
    public final PBStringField url = PBField.initString("");
}
