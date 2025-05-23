package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class nt_msg_common$Group extends MessageMicro<nt_msg_common$Group> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField ext_group_key_info;
    public final PBBytesField group_card;
    public final PBUInt32Field group_card_type;
    public final PBUInt32Field group_level;
    public final PBBytesField group_name;
    public final PBUInt32Field msg_flag;
    public final PBUInt64Field group_code = PBField.initUInt64(0);
    public final PBUInt32Field group_type = PBField.initUInt32(0);
    public final PBUInt64Field group_info_seq = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40, 48, 58, 66, 72}, new String[]{"group_code", "group_type", "group_info_seq", "group_card", "group_card_type", "group_level", "group_name", "ext_group_key_info", "msg_flag"}, new Object[]{0L, 0, 0L, byteStringMicro, 0, 0, byteStringMicro, byteStringMicro, 0}, nt_msg_common$Group.class);
    }

    public nt_msg_common$Group() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.group_card = PBField.initBytes(byteStringMicro);
        this.group_card_type = PBField.initUInt32(0);
        this.group_level = PBField.initUInt32(0);
        this.group_name = PBField.initBytes(byteStringMicro);
        this.ext_group_key_info = PBField.initBytes(byteStringMicro);
        this.msg_flag = PBField.initUInt32(0);
    }
}
