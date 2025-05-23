package tencent.im.oidb.cmd0xa28;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xa28$RoleInfo extends MessageMicro<oidb_0xa28$RoleInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_role_name;
    public final PBBytesField bytes_role_score;
    public final PBStringField str_role_url;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"bytes_role_name", "bytes_role_score", "str_role_url"}, new Object[]{byteStringMicro, byteStringMicro, ""}, oidb_0xa28$RoleInfo.class);
    }

    public oidb_0xa28$RoleInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_role_name = PBField.initBytes(byteStringMicro);
        this.bytes_role_score = PBField.initBytes(byteStringMicro);
        this.str_role_url = PBField.initString("");
    }
}
