package tencent.im.oidb.cmd0xf8b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xf8b$BiuOneLevelItem extends MessageMicro<oidb_cmd0xf8b$BiuOneLevelItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 48, 58}, new String[]{"uint64_feeds_id", "uint64_uin", "uint32_biu_time", "bytes_biu_comments", "op_type", "msg_jump_info"}, new Object[]{0L, 0L, 0, ByteStringMicro.EMPTY, 0, null}, oidb_cmd0xf8b$BiuOneLevelItem.class);
    public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_biu_time = PBField.initUInt32(0);
    public final PBBytesField bytes_biu_comments = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField op_type = PBField.initEnum(0);
    public oidb_cmd0xf8b$JumpInfo msg_jump_info = new MessageMicro<oidb_cmd0xf8b$JumpInfo>() { // from class: tencent.im.oidb.cmd0xf8b.oidb_cmd0xf8b$JumpInfo
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_jump_url;
        public final PBBytesField bytes_wording;
        public final PBUInt64Field uint64_id = PBField.initUInt64(0);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint64_id", "bytes_wording", "bytes_jump_url"}, new Object[]{0L, byteStringMicro, byteStringMicro}, oidb_cmd0xf8b$JumpInfo.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_wording = PBField.initBytes(byteStringMicro);
            this.bytes_jump_url = PBField.initBytes(byteStringMicro);
        }
    };
}
