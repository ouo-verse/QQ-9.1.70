package tencent.im.oidb.cmd0x89e;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x89e$RspBody extends MessageMicro<oidb_0x89e$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField str_client_prompt;
    public final PBBytesField str_errorinfo;
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBUInt64Field uint64_old_owner = PBField.initUInt64(0);
    public final PBUInt32Field uint64_new_owner = PBField.initUInt32(0);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 50}, new String[]{"uint64_group_code", "uint64_old_owner", "uint64_new_owner", "uint32_result", "str_errorinfo", "str_client_prompt"}, new Object[]{0L, 0L, 0, 0, byteStringMicro, byteStringMicro}, oidb_0x89e$RspBody.class);
    }

    public oidb_0x89e$RspBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.str_errorinfo = PBField.initBytes(byteStringMicro);
        this.str_client_prompt = PBField.initBytes(byteStringMicro);
    }
}
