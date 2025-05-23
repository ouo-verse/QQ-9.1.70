package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class appauth_comm$ApiInfo extends MessageMicro<appauth_comm$ApiInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 48, 56, 64, 74, 82, 90, 96, 104, 112, 122, 128}, new String[]{"api_id", "api_name", "api_title", "need_admin_auth", "status", "need_user_auth", "need_app_auth", "need_ip_auth", "route_addr", "api_method", "api_desc", "need_guild_auth", "token_type", "show_order", "api_class_name", "event_intent"}, new Object[]{0, "", "", 0, 0, 0, 0, 0, "", "", "", 0, 0, 0, "", 0}, appauth_comm$ApiInfo.class);
    public final PBUInt32Field api_id = PBField.initUInt32(0);
    public final PBStringField api_name = PBField.initString("");
    public final PBStringField api_title = PBField.initString("");
    public final PBUInt32Field need_admin_auth = PBField.initUInt32(0);
    public final PBUInt32Field status = PBField.initUInt32(0);
    public final PBUInt32Field need_user_auth = PBField.initUInt32(0);
    public final PBUInt32Field need_app_auth = PBField.initUInt32(0);
    public final PBUInt32Field need_ip_auth = PBField.initUInt32(0);
    public final PBStringField route_addr = PBField.initString("");
    public final PBStringField api_method = PBField.initString("");
    public final PBStringField api_desc = PBField.initString("");
    public final PBUInt32Field need_guild_auth = PBField.initUInt32(0);
    public final PBUInt32Field token_type = PBField.initUInt32(0);
    public final PBUInt32Field show_order = PBField.initUInt32(0);
    public final PBStringField api_class_name = PBField.initString("");
    public final PBUInt32Field event_intent = PBField.initUInt32(0);
}
