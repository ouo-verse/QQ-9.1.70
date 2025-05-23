package tencent.im.oidb.oidb_0xcf4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xcf4$SpecialWordInfo extends MessageMicro<oidb_0xcf4$SpecialWordInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_card_id;
    public final PBBytesField bytes_static_url;
    public final PBBytesField bytes_wording_1;
    public final PBBytesField bytes_wording_2;
    public final PBUInt32Field uint32_all_word_light_up_days;
    public final PBUInt32Field uint32_close_flag;
    public final PBUInt32Field uint32_mark_days;
    public final PBUInt32Field uint32_recentchat_msg_count;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 48, 56, 64}, new String[]{"bytes_card_id", "bytes_static_url", "bytes_wording_1", "bytes_wording_2", "uint32_close_flag", "uint32_recentchat_msg_count", "uint32_all_word_light_up_days", "uint32_mark_days"}, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0, 0, 0}, oidb_0xcf4$SpecialWordInfo.class);
    }

    public oidb_0xcf4$SpecialWordInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_card_id = PBField.initBytes(byteStringMicro);
        this.bytes_static_url = PBField.initBytes(byteStringMicro);
        this.bytes_wording_1 = PBField.initBytes(byteStringMicro);
        this.bytes_wording_2 = PBField.initBytes(byteStringMicro);
        this.uint32_close_flag = PBField.initUInt32(0);
        this.uint32_recentchat_msg_count = PBField.initUInt32(0);
        this.uint32_all_word_light_up_days = PBField.initUInt32(0);
        this.uint32_mark_days = PBField.initUInt32(0);
    }
}
