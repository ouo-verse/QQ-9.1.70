package tencent.im.oidb.cmd0x857;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class TroopTips0x857$VideoChangePushInfo extends MessageMicro<TroopTips0x857$VideoChangePushInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_ext_info;
    public final PBBytesField bytes_gray_tips;
    public final PBUInt32Field uint32_join_nums;
    public final PBUInt32Field uint32_join_state;
    public final PBUInt64Field uint64_seq = PBField.initUInt64(0);
    public final PBUInt32Field uint32_action_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_id = PBField.initUInt64(0);
    public final PBUInt64Field uint64_oper_uin = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 48, 56, 802}, new String[]{"uint64_seq", "uint32_action_type", "uint64_group_id", "uint64_oper_uin", "bytes_gray_tips", "uint32_join_nums", "uint32_join_state", "bytes_ext_info"}, new Object[]{0L, 0, 0L, 0L, byteStringMicro, 0, 0, byteStringMicro}, TroopTips0x857$VideoChangePushInfo.class);
    }

    public TroopTips0x857$VideoChangePushInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_gray_tips = PBField.initBytes(byteStringMicro);
        this.uint32_join_nums = PBField.initUInt32(0);
        this.uint32_join_state = PBField.initUInt32(0);
        this.bytes_ext_info = PBField.initBytes(byteStringMicro);
    }
}
