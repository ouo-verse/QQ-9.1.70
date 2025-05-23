package tencent.im.s2c.msgtype0x210.submsgtype0x6f;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ extends MessageMicro<SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_coverstory;
    public final PBBytesField bytes_nick;
    public final PBBytesField bytes_wording;
    public final PBRepeatMessageField<SubMsgType0x6f$VideoInfo> rpt_msg_video_info;
    public final PBUInt32Field uint32_age;
    public final PBUInt32Field uint32_gender;
    public final PBUInt64Field uint64_qq_uin;
    public final PBUInt64Field uint64_storys_total_num;
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42, 48, 58, 66, 72}, new String[]{"uint64_uin", "bytes_nick", "uint32_gender", "uint32_age", "bytes_coverstory", "uint64_storys_total_num", "rpt_msg_video_info", "bytes_wording", "uint64_qq_uin"}, new Object[]{0L, byteStringMicro, 0, 0, byteStringMicro, 0L, null, byteStringMicro, 0L}, SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ.class);
    }

    public SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_nick = PBField.initBytes(byteStringMicro);
        this.uint32_gender = PBField.initUInt32(0);
        this.uint32_age = PBField.initUInt32(0);
        this.bytes_coverstory = PBField.initBytes(byteStringMicro);
        this.uint64_storys_total_num = PBField.initUInt64(0L);
        this.rpt_msg_video_info = PBField.initRepeatMessage(SubMsgType0x6f$VideoInfo.class);
        this.bytes_wording = PBField.initBytes(byteStringMicro);
        this.uint64_qq_uin = PBField.initUInt64(0L);
    }
}
