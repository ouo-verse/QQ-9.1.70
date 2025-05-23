package tencent.im.mutualmark;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class mutualmark$SpecialWordAttribute extends MessageMicro<mutualmark$SpecialWordAttribute> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_card_color;
    public final PBBytesField bytes_card_id;
    public mutualmark$SpecialWordCardGetInfo msg_max_special_word_card_get_info;
    public mutualmark$SpecialWordCardGetInfo msg_min_special_word_card_get_info;
    public final PBUInt64Field uint64_last_off_time;
    public final PBUInt64Field uint64_last_on_time;
    public final PBUInt64Field uint64_last_set_time;
    public final PBUInt64Field uint64_set_uin;
    public final PBUInt64Field uint64_word_light_up_time;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 48, 56, 66, 74}, new String[]{"bytes_card_id", "bytes_card_color", "uint64_set_uin", "uint64_last_set_time", "uint64_last_on_time", "uint64_last_off_time", "uint64_word_light_up_time", "msg_min_special_word_card_get_info", "msg_max_special_word_card_get_info"}, new Object[]{byteStringMicro, byteStringMicro, 0L, 0L, 0L, 0L, 0L, null, null}, mutualmark$SpecialWordAttribute.class);
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [tencent.im.mutualmark.mutualmark$SpecialWordCardGetInfo] */
    /* JADX WARN: Type inference failed for: r0v5, types: [tencent.im.mutualmark.mutualmark$SpecialWordCardGetInfo] */
    public mutualmark$SpecialWordAttribute() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_card_id = PBField.initBytes(byteStringMicro);
        this.bytes_card_color = PBField.initBytes(byteStringMicro);
        this.uint64_set_uin = PBField.initUInt64(0L);
        this.uint64_last_set_time = PBField.initUInt64(0L);
        this.uint64_last_on_time = PBField.initUInt64(0L);
        this.uint64_last_off_time = PBField.initUInt64(0L);
        this.uint64_word_light_up_time = PBField.initUInt64(0L);
        this.msg_min_special_word_card_get_info = new MessageMicro<mutualmark$SpecialWordCardGetInfo>() { // from class: tencent.im.mutualmark.mutualmark$SpecialWordCardGetInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint64_uin", "uint32_can_get_card_count", "uint64_last_give_card_time"}, new Object[]{0L, 0, 0L}, mutualmark$SpecialWordCardGetInfo.class);
            public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
            public final PBUInt32Field uint32_can_get_card_count = PBField.initUInt32(0);
            public final PBUInt64Field uint64_last_give_card_time = PBField.initUInt64(0);
        };
        this.msg_max_special_word_card_get_info = new MessageMicro<mutualmark$SpecialWordCardGetInfo>() { // from class: tencent.im.mutualmark.mutualmark$SpecialWordCardGetInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint64_uin", "uint32_can_get_card_count", "uint64_last_give_card_time"}, new Object[]{0L, 0, 0L}, mutualmark$SpecialWordCardGetInfo.class);
            public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
            public final PBUInt32Field uint32_can_get_card_count = PBField.initUInt32(0);
            public final PBUInt64Field uint64_last_give_card_time = PBField.initUInt64(0);
        };
    }
}
