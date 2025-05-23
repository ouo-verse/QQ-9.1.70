package tencent.im.oidb.cmd0xc7a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.qqconnect$Appinfo;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xc7a$UinInfo extends MessageMicro<oidb_cmd0xc7a$UinInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 90}, new String[]{"uin", "nick", "face_url", "face_url_simple", "appinfo"}, new Object[]{0L, "", "", "", null}, oidb_cmd0xc7a$UinInfo.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBStringField nick = PBField.initString("");
    public final PBStringField face_url = PBField.initString("");
    public final PBStringField face_url_simple = PBField.initString("");
    public qqconnect$Appinfo appinfo = new qqconnect$Appinfo();
}
