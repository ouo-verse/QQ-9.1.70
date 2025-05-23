package tencent.im.s2c.msgtype0x210.submsgtype0x8f;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0x8f$MsgBody extends MessageMicro<submsgtype0x8f$MsgBody> {
    public static final int MSG_TYPE_ALL_CONFIRM = 2;
    public static final int MSG_TYPE_CONFIRMED = 1;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_ext_msg;
    public final PBBytesField bytes_feeds_id;
    public final PBEnumField enum_msg_type;
    public submsgtype0x8f$SourceID msg_source_id = new MessageMicro<submsgtype0x8f$SourceID>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0x8f.submsgtype0x8f$SourceID
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_source_type", "uint64_source_code"}, new Object[]{0, 0L}, submsgtype0x8f$SourceID.class);
        public final PBUInt32Field uint32_source_type = PBField.initUInt32(0);
        public final PBUInt64Field uint64_source_code = PBField.initUInt64(0);
    };
    public final PBUInt64Field uint64_author_uin;
    public final PBUInt64Field uint64_confirm_uin;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 40, 48}, new String[]{"msg_source_id", "bytes_feeds_id", "enum_msg_type", "bytes_ext_msg", "uint64_author_uin", "uint64_confirm_uin"}, new Object[]{null, byteStringMicro, 1, byteStringMicro, 0L, 0L}, submsgtype0x8f$MsgBody.class);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [tencent.im.s2c.msgtype0x210.submsgtype0x8f.submsgtype0x8f$SourceID] */
    public submsgtype0x8f$MsgBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_feeds_id = PBField.initBytes(byteStringMicro);
        this.enum_msg_type = PBField.initEnum(1);
        this.bytes_ext_msg = PBField.initBytes(byteStringMicro);
        this.uint64_author_uin = PBField.initUInt64(0L);
        this.uint64_confirm_uin = PBField.initUInt64(0L);
    }
}
