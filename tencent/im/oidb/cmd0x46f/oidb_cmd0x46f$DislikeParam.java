package tencent.im.oidb.cmd0x46f;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class oidb_cmd0x46f$DislikeParam extends MessageMicro<oidb_cmd0x46f$DislikeParam> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field uint64_articleid = PBField.initUInt64(0);
    public final PBUInt32Field uint32_reasonid = PBField.initUInt32(0);
    public final PBBytesField bytes_rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<Long> rpt_uint64_tagid = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBRepeatMessageField<oidb_cmd0x46f$UserDisLike> rpt_user_dislike_list = PBField.initRepeatMessage(oidb_cmd0x46f$UserDisLike.class);
    public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0);
    public final PBUInt64Field uint64_biu_uin = PBField.initUInt64(0);
    public final PBRepeatField<ByteStringMicro> rpt_tag_name = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBUInt64Field uint64_topic_id = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 88, 98, 104, 112, 122, 200}, new String[]{"uint64_articleid", "uint32_reasonid", "bytes_rowkey", "rpt_uint64_tagid", "rpt_user_dislike_list", "uint64_feeds_id", "uint64_biu_uin", "rpt_tag_name", "uint64_topic_id"}, new Object[]{0L, 0, byteStringMicro, 0L, null, 0L, 0L, byteStringMicro, 0L}, oidb_cmd0x46f$DislikeParam.class);
    }
}
