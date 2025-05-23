package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class qqconnect$MsgUinInfo extends MessageMicro<qqconnect$MsgUinInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 802, 810, 818}, new String[]{"uin", QQHealthReportApiImpl.MSG_TYPE_KEY, "appid", "app_type", "ctime", "mtime", "mp_type", "nick", "face_url", "face_url_simple"}, new Object[]{0L, 0, 0, 0, 0, 0, 0, "", "", ""}, qqconnect$MsgUinInfo.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt32Field msg_type = PBField.initUInt32(0);
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBUInt32Field app_type = PBField.initUInt32(0);
    public final PBUInt32Field ctime = PBField.initUInt32(0);
    public final PBUInt32Field mtime = PBField.initUInt32(0);
    public final PBUInt32Field mp_type = PBField.initUInt32(0);
    public final PBStringField nick = PBField.initString("");
    public final PBStringField face_url = PBField.initString("");
    public final PBStringField face_url_simple = PBField.initString("");
}
