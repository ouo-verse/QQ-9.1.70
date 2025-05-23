package tencent.im.oidb.cmd0x439;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x439$SubscribeInfo extends MessageMicro<oidb_cmd0x439$SubscribeInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_reason;
    public final PBBytesField bytes_subscribe_name;
    public final PBRepeatMessageField<oidb_cmd0x439$ArticleInfo> rpt_article_list;
    public final PBUInt64Field uint64_subscribe_id = PBField.initUInt64(0);
    public final PBRepeatField<Long> rpt_uint64_likely_subscribe_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field uint32_has_more = PBField.initUInt32(0);
    public final PBUInt32Field uint32_friend_subscribed_count = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 74, 82, 162}, new String[]{"uint64_subscribe_id", "rpt_uint64_likely_subscribe_list", "uint32_has_more", "uint32_friend_subscribed_count", "bytes_reason", "bytes_subscribe_name", "rpt_article_list"}, new Object[]{0L, 0L, 0, 0, byteStringMicro, byteStringMicro, null}, oidb_cmd0x439$SubscribeInfo.class);
    }

    public oidb_cmd0x439$SubscribeInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_reason = PBField.initBytes(byteStringMicro);
        this.bytes_subscribe_name = PBField.initBytes(byteStringMicro);
        this.rpt_article_list = PBField.initRepeatMessage(oidb_cmd0x439$ArticleInfo.class);
    }
}
