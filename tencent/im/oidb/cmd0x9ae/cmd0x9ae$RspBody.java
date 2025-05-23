package tencent.im.oidb.cmd0x9ae;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x9ae$RspBody extends MessageMicro<cmd0x9ae$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_jwt;
    public final PBBytesField bytes_token;
    public cmd0x9ae$SmallTips msg_small_tips;
    public final PBUInt32Field uint32_notify_type;
    public final PBUInt32Field uint32_scene;
    public final PBBoolField bool_has_been_authenticated = PBField.initBool(false);
    public final PBBoolField bool_need_auth_tips = PBField.initBool(false);
    public cmd0x9ae$AuthTips msg_auth_tips = new cmd0x9ae$AuthTips();

    static {
        Boolean bool = Boolean.FALSE;
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 48, 56, 66}, new String[]{"bool_has_been_authenticated", "bool_need_auth_tips", "msg_auth_tips", "bytes_jwt", "msg_small_tips", "uint32_notify_type", "uint32_scene", "bytes_token"}, new Object[]{bool, bool, null, byteStringMicro, null, 0, 0, byteStringMicro}, cmd0x9ae$RspBody.class);
    }

    public cmd0x9ae$RspBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_jwt = PBField.initBytes(byteStringMicro);
        this.msg_small_tips = new cmd0x9ae$SmallTips();
        this.uint32_notify_type = PBField.initUInt32(0);
        this.uint32_scene = PBField.initUInt32(0);
        this.bytes_token = PBField.initBytes(byteStringMicro);
    }
}
