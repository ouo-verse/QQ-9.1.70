package tencent.im.troop_search_searchtab;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.group.group_label.GroupLabel$Label;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class searchtab$Item1 extends MessageMicro<searchtab$Item1> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_algorithm;
    public final PBBytesField bytes_group_finger_memo;
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBStringField str_name = PBField.initString("");
    public final PBStringField str_img_url = PBField.initString("");
    public final PBStringField str_loc = PBField.initString("");
    public final PBUInt32Field uint32_mem_cnt = PBField.initUInt32(0);
    public final PBStringField str_oper_desc = PBField.initString("");
    public final PBStringField str_oper_transfer_url = PBField.initString("");
    public final PBStringField str_transfer_url = PBField.initString("");
    public final PBRepeatMessageField<GroupLabel$Label> rpt_msg_group_label = PBField.initRepeatMessage(GroupLabel$Label.class);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 50, 58, 66, 74, 82, 90}, new String[]{"uint64_group_code", "str_name", "str_img_url", "str_loc", "uint32_mem_cnt", "str_oper_desc", "str_oper_transfer_url", "str_transfer_url", "rpt_msg_group_label", "bytes_group_finger_memo", "bytes_algorithm"}, new Object[]{0L, "", "", "", 0, "", "", "", null, byteStringMicro, byteStringMicro}, searchtab$Item1.class);
    }

    public searchtab$Item1() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_group_finger_memo = PBField.initBytes(byteStringMicro);
        this.bytes_algorithm = PBField.initBytes(byteStringMicro);
    }
}
