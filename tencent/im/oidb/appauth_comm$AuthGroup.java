package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class appauth_comm$AuthGroup extends MessageMicro<appauth_comm$AuthGroup> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField api_admin;
    public final PBRepeatMessageField<appauth_comm$ApiInfo> api_detail;
    public final PBBytesField api_list;
    public final PBUInt32Field auth_flag;
    public final PBBytesField auth_group_desc;
    public final PBBytesField auth_group_name;
    public final PBBytesField icon_code;
    public final PBUInt32Field last_verify_time;
    public final PBUInt32Field need_user_authorize;
    public final PBUInt32Field show_flag;
    public final PBUInt32Field show_order;
    public final PBUInt32Field status;
    public final PBUInt32Field auth_group_type = PBField.initUInt32(0);
    public final PBUInt32Field auth_group_id = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 50, 56, 64, 72, 80, 90, 96, 104, 114}, new String[]{"auth_group_type", "auth_group_id", "auth_group_name", "auth_group_desc", "api_list", "api_admin", "status", "need_user_authorize", "auth_flag", "show_order", "icon_code", "show_flag", "last_verify_time", "api_detail"}, new Object[]{0, 0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0, 0, 0, byteStringMicro, 0, 0, null}, appauth_comm$AuthGroup.class);
    }

    public appauth_comm$AuthGroup() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.auth_group_name = PBField.initBytes(byteStringMicro);
        this.auth_group_desc = PBField.initBytes(byteStringMicro);
        this.api_list = PBField.initBytes(byteStringMicro);
        this.api_admin = PBField.initBytes(byteStringMicro);
        this.status = PBField.initUInt32(0);
        this.need_user_authorize = PBField.initUInt32(0);
        this.auth_flag = PBField.initUInt32(0);
        this.show_order = PBField.initUInt32(0);
        this.icon_code = PBField.initBytes(byteStringMicro);
        this.show_flag = PBField.initUInt32(0);
        this.last_verify_time = PBField.initUInt32(0);
        this.api_detail = PBField.initRepeatMessage(appauth_comm$ApiInfo.class);
    }
}
