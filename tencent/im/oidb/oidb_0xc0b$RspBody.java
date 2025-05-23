package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xc0b$RspBody extends MessageMicro<oidb_0xc0b$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 40, 50, 56, 66, 74}, new String[]{"uint32_is_open_coin_entry", "uint32_can_get_coin_count", "bytes_coin_icon_url", "uint64_last_completed_task_stamp", "rpt_cms_wording", "uint64_last_cms_activity_stamp", "msg_kandian_coin_remind", "msg_kandian_task_remind"}, new Object[]{0, 0, ByteStringMicro.EMPTY, 0L, null, 0L, null, null}, oidb_0xc0b$RspBody.class);
    public final PBUInt32Field uint32_is_open_coin_entry = PBField.initUInt32(0);
    public final PBUInt32Field uint32_can_get_coin_count = PBField.initUInt32(0);
    public final PBBytesField bytes_coin_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_last_completed_task_stamp = PBField.initUInt64(0);
    public final PBRepeatMessageField<oidb_0xc0b$KanDianCMSActivityInfo> rpt_cms_wording = PBField.initRepeatMessage(oidb_0xc0b$KanDianCMSActivityInfo.class);
    public final PBUInt64Field uint64_last_cms_activity_stamp = PBField.initUInt64(0);
    public oidb_0xc0b$KanDianCoinRemind msg_kandian_coin_remind = new MessageMicro<oidb_0xc0b$KanDianCoinRemind>() { // from class: tencent.im.oidb.oidb_0xc0b$KanDianCoinRemind
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_wording"}, new Object[]{ByteStringMicro.EMPTY}, oidb_0xc0b$KanDianCoinRemind.class);
        public final PBBytesField bytes_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public oidb_0xc0b$KanDianTaskRemind msg_kandian_task_remind = new MessageMicro<oidb_0xc0b$KanDianTaskRemind>() { // from class: tencent.im.oidb.oidb_0xc0b$KanDianTaskRemind
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_jump_url;
        public final PBBytesField bytes_wording;
        public final PBUInt32Field uint32_task_type;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"bytes_wording", "bytes_jump_url", "uint32_task_type"}, new Object[]{byteStringMicro, byteStringMicro, 0}, oidb_0xc0b$KanDianTaskRemind.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_wording = PBField.initBytes(byteStringMicro);
            this.bytes_jump_url = PBField.initBytes(byteStringMicro);
            this.uint32_task_type = PBField.initUInt32(0);
        }
    };
}
