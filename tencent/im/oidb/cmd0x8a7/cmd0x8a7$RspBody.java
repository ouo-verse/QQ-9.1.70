package tencent.im.oidb.cmd0x8a7;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x8a7$RspBody extends MessageMicro<cmd0x8a7$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_show_at_all_lable;
    public final PBBytesField bytes_prompt_msg_1;
    public final PBBytesField bytes_prompt_msg_2;
    public final PBBoolField bool_can_at_all = PBField.initBool(false);
    public final PBUInt32Field uint32_remain_at_all_count_for_uin = PBField.initUInt32(0);
    public final PBUInt32Field uint32_remain_at_all_count_for_group = PBField.initUInt32(0);

    static {
        Boolean bool = Boolean.FALSE;
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 48}, new String[]{"bool_can_at_all", "uint32_remain_at_all_count_for_uin", "uint32_remain_at_all_count_for_group", "bytes_prompt_msg_1", "bytes_prompt_msg_2", "bool_show_at_all_lable"}, new Object[]{bool, 0, 0, byteStringMicro, byteStringMicro, bool}, cmd0x8a7$RspBody.class);
    }

    public cmd0x8a7$RspBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_prompt_msg_1 = PBField.initBytes(byteStringMicro);
        this.bytes_prompt_msg_2 = PBField.initBytes(byteStringMicro);
        this.bool_show_at_all_lable = PBField.initBool(false);
    }
}
