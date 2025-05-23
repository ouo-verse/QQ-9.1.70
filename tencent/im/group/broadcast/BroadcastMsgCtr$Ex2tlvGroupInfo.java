package tencent.im.group.broadcast;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class BroadcastMsgCtr$Ex2tlvGroupInfo extends MessageMicro<BroadcastMsgCtr$Ex2tlvGroupInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_group_name;
    public final PBBytesField bytes_tribe_info;
    public BroadcastMsgCtr$ConfInfo conf_info;
    public BroadcastMsgCtr$ExtGroupKeyInfo ext_group_key_info;
    public final PBUInt32Field uint32_disable_fetch_remark;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 1018}, new String[]{"bytes_group_name", "uint32_disable_fetch_remark", "bytes_tribe_info", "ext_group_key_info", "conf_info"}, new Object[]{byteStringMicro, 0, byteStringMicro, null, null}, BroadcastMsgCtr$Ex2tlvGroupInfo.class);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [tencent.im.group.broadcast.BroadcastMsgCtr$ExtGroupKeyInfo] */
    /* JADX WARN: Type inference failed for: r0v3, types: [tencent.im.group.broadcast.BroadcastMsgCtr$ConfInfo] */
    public BroadcastMsgCtr$Ex2tlvGroupInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_group_name = PBField.initBytes(byteStringMicro);
        this.uint32_disable_fetch_remark = PBField.initUInt32(0);
        this.bytes_tribe_info = PBField.initBytes(byteStringMicro);
        this.ext_group_key_info = new MessageMicro<BroadcastMsgCtr$ExtGroupKeyInfo>() { // from class: tencent.im.group.broadcast.BroadcastMsgCtr$ExtGroupKeyInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"uint32_cur_max_seq", "uint64_cur_time", "uint32_operate_by_parents", "bytes_ext_group_info"}, new Object[]{0, 0L, 0, ByteStringMicro.EMPTY}, BroadcastMsgCtr$ExtGroupKeyInfo.class);
            public final PBUInt32Field uint32_cur_max_seq = PBField.initUInt32(0);
            public final PBUInt64Field uint64_cur_time = PBField.initUInt64(0);
            public final PBUInt32Field uint32_operate_by_parents = PBField.initUInt32(0);
            public final PBBytesField bytes_ext_group_info = PBField.initBytes(ByteStringMicro.EMPTY);
        };
        this.conf_info = new MessageMicro<BroadcastMsgCtr$ConfInfo>() { // from class: tencent.im.group.broadcast.BroadcastMsgCtr$ConfInfo
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBBytesField bytes_conf_name;
            public final PBBytesField bytes_sig;
            public final PBUInt32Field uint32_appid;
            public final PBUInt32Field uint32_conf_flag;
            public final PBUInt32Field uint32_member_flag;
            public final PBUInt32Field uint32_type;

            static {
                ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 40, 48}, new String[]{"bytes_conf_name", "uint32_member_flag", "uint32_type", "bytes_sig", "uint32_appid", "uint32_conf_flag"}, new Object[]{byteStringMicro2, 0, 0, byteStringMicro2, 0, 0}, BroadcastMsgCtr$ConfInfo.class);
            }

            {
                ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                this.bytes_conf_name = PBField.initBytes(byteStringMicro2);
                this.uint32_member_flag = PBField.initUInt32(0);
                this.uint32_type = PBField.initUInt32(0);
                this.bytes_sig = PBField.initBytes(byteStringMicro2);
                this.uint32_appid = PBField.initUInt32(0);
                this.uint32_conf_flag = PBField.initUInt32(0);
            }
        };
    }
}
