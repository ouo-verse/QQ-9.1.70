package tencent.im.group;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class group_member_info$GBarInfo extends MessageMicro<group_member_info$GBarInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_gbar_name;
    public final PBBytesField str_head_portrait;
    public final PBUInt32Field uint32_gbar_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_uin_lev = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"uint32_gbar_id", "uint32_uin_lev", "str_head_portrait", "bytes_gbar_name"}, new Object[]{0, 0, byteStringMicro, byteStringMicro}, group_member_info$GBarInfo.class);
    }

    public group_member_info$GBarInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.str_head_portrait = PBField.initBytes(byteStringMicro);
        this.bytes_gbar_name = PBField.initBytes(byteStringMicro);
    }
}
