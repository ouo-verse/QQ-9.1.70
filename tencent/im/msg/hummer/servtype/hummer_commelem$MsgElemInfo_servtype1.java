package tencent.im.msg.hummer.servtype;

import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class hummer_commelem$MsgElemInfo_servtype1 extends MessageMicro<hummer_commelem$MsgElemInfo_servtype1> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_content;
    public final PBBytesField bytes_reward_id;
    public final PBBytesField bytes_url;
    public final PBUInt32Field uint32_create_timestamp;
    public final PBUInt32Field uint32_pic_type;
    public final PBUInt32Field uint32_reward_money;
    public final PBUInt32Field uint32_reward_type_ext;
    public final PBUInt32Field uint32_size;
    public final PBUInt32Field uint32_status;
    public final PBUInt32Field uint32_video_duration;
    public final PBUInt64Field uint64_sender_uin;
    public final PBUInt64Field uint64_seq;

    static {
        String[] strArr = {"bytes_reward_id", "uint64_sender_uin", "uint32_pic_type", "uint32_reward_money", "bytes_url", MessageForUniteGrayTip.KEY_BYTES_CONTENT, "uint32_create_timestamp", "uint32_status", "uint32_size", "uint32_video_duration", "uint64_seq", "uint32_reward_type_ext"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 42, 50, 56, 64, 72, 80, 88, 96}, strArr, new Object[]{byteStringMicro, 0L, 0, 0, byteStringMicro, byteStringMicro, 0, 0, 0, 0, 0L, 0}, hummer_commelem$MsgElemInfo_servtype1.class);
    }

    public hummer_commelem$MsgElemInfo_servtype1() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_reward_id = PBField.initBytes(byteStringMicro);
        this.uint64_sender_uin = PBField.initUInt64(0L);
        this.uint32_pic_type = PBField.initUInt32(0);
        this.uint32_reward_type_ext = PBField.initUInt32(0);
        this.uint32_reward_money = PBField.initUInt32(0);
        this.bytes_url = PBField.initBytes(byteStringMicro);
        this.bytes_content = PBField.initBytes(byteStringMicro);
        this.uint32_create_timestamp = PBField.initUInt32(0);
        this.uint32_status = PBField.initUInt32(0);
        this.uint32_size = PBField.initUInt32(0);
        this.uint32_video_duration = PBField.initUInt32(0);
        this.uint64_seq = PBField.initUInt64(0L);
    }
}
