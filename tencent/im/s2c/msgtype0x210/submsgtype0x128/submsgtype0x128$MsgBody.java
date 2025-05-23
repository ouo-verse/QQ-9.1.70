package tencent.im.s2c.msgtype0x210.submsgtype0x128;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.cmd0xe03.oidb_0xe03$MatchUinData;
import tencent.im.oidb.cmd0xe03.oidb_0xe03$TagInfo;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0x128$MsgBody extends MessageMicro<submsgtype0x128$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_nick;
    public final PBBytesField bytes_sig;
    public final PBBytesField bytes_tips_wording;
    public oidb_0xe03$MatchUinData msg_match_uin_data;
    public oidb_0xe03$TagInfo msg_tag;
    public final PBStringField string_report_id;
    public final PBUInt32Field uint32_match_expired_time;
    public final PBUInt64Field uint64_match_uin;
    public final PBUInt64Field uint64_time_stamp;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 40, 48, 58, 66, 74}, new String[]{"bytes_sig", "uint64_match_uin", "bytes_tips_wording", "bytes_nick", "uint64_time_stamp", "uint32_match_expired_time", "string_report_id", "msg_tag", "msg_match_uin_data"}, new Object[]{byteStringMicro, 0L, byteStringMicro, byteStringMicro, 0L, 0, "", null, null}, submsgtype0x128$MsgBody.class);
    }

    public submsgtype0x128$MsgBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_sig = PBField.initBytes(byteStringMicro);
        this.uint64_match_uin = PBField.initUInt64(0L);
        this.bytes_tips_wording = PBField.initBytes(byteStringMicro);
        this.bytes_nick = PBField.initBytes(byteStringMicro);
        this.uint64_time_stamp = PBField.initUInt64(0L);
        this.uint32_match_expired_time = PBField.initUInt32(0);
        this.string_report_id = PBField.initString("");
        this.msg_tag = new oidb_0xe03$TagInfo();
        this.msg_match_uin_data = new oidb_0xe03$MatchUinData();
    }
}
