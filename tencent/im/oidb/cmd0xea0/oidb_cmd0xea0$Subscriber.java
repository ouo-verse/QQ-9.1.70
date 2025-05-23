package tencent.im.oidb.cmd0xea0;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xea0$Subscriber extends MessageMicro<oidb_cmd0xea0$Subscriber> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40}, new String[]{"uin", "name", QCircleSchemeAttr.Detail.AVATAR_URL, "jump_url", "avatar_status"}, new Object[]{0L, "", "", "", 0}, oidb_cmd0xea0$Subscriber.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBStringField name = PBField.initString("");
    public final PBStringField avatar_url = PBField.initString("");
    public final PBStringField jump_url = PBField.initString("");
    public final PBUInt32Field avatar_status = PBField.initUInt32(0);
}
