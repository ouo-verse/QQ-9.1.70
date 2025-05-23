package tencent.im.oidb.cmd0xd22;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0xd22$RspBody extends MessageMicro<Oidb_0xd22$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField create_group_url;
    public final PBUInt64Field group_code;
    public final PBInt32Field int32_uin_privilege;
    public final PBBytesField join_group_token;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, new String[]{"create_group_url", "join_group_token", "group_code", "int32_uin_privilege"}, new Object[]{byteStringMicro, byteStringMicro, 0L, 0}, Oidb_0xd22$RspBody.class);
    }

    public Oidb_0xd22$RspBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.create_group_url = PBField.initBytes(byteStringMicro);
        this.join_group_token = PBField.initBytes(byteStringMicro);
        this.group_code = PBField.initUInt64(0L);
        this.int32_uin_privilege = PBField.initInt32(0);
    }
}
