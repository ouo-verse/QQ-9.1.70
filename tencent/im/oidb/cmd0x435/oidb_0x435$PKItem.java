package tencent.im.oidb.cmd0x435;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class oidb_0x435$PKItem extends MessageMicro<oidb_0x435$PKItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40, 50, 56, 64}, new String[]{"uint32_pk_item_id", "bytes_pk_description", "uint32_start_time", "uint32_end_time", "uint32_valid_time", "rpt_msg_vote", "uint32_interval_time", "uint32_pk_is_over"}, new Object[]{0, ByteStringMicro.EMPTY, 0, 0, 0, null, 0, 0}, oidb_0x435$PKItem.class);
    public final PBUInt32Field uint32_pk_item_id = PBField.initUInt32(0);
    public final PBBytesField bytes_pk_description = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_start_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_end_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_valid_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_interval_time = PBField.initUInt32(0);
    public final PBRepeatMessageField<oidb_0x435$VoteItem> rpt_msg_vote = PBField.initRepeatMessage(oidb_0x435$VoteItem.class);
    public final PBUInt32Field uint32_pk_is_over = PBField.initUInt32(0);
}
