package tencent.im.oidb.cmd0x857;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TroopTips0x857$QQGroupDigestMsg extends MessageMicro<TroopTips0x857$QQGroupDigestMsg> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt32Field ext_info;
    public final PBBytesField feed_url;
    public final PBInt32Field msg_type;
    public final PBBytesField oper_nick;
    public final PBBytesField sender_nick;
    public final PBUInt64Field group_code = PBField.initUInt64(0);
    public final PBUInt32Field msg_seq = PBField.initUInt32(0);
    public final PBUInt32Field msg_random = PBField.initUInt32(0);
    public final PBInt32Field op_type = PBField.initInt32(0);
    public final PBUInt64Field msg_sender = PBField.initUInt64(0);
    public final PBUInt64Field digest_oper = PBField.initUInt64(0);
    public final PBUInt32Field op_time = PBField.initUInt32(0);
    public final PBUInt32Field lastest_msg_seq = PBField.initUInt32(0);

    static {
        String[] strArr = {"group_code", "msg_seq", "msg_random", "op_type", "msg_sender", "digest_oper", "op_time", "lastest_msg_seq", "oper_nick", "sender_nick", "ext_info", "feed_url", QQHealthReportApiImpl.MSG_TYPE_KEY};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64, 74, 82, 88, 98, 104}, strArr, new Object[]{0L, 0, 0, 0, 0L, 0L, 0, 0, byteStringMicro, byteStringMicro, 0, byteStringMicro, 0}, TroopTips0x857$QQGroupDigestMsg.class);
    }

    public TroopTips0x857$QQGroupDigestMsg() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.oper_nick = PBField.initBytes(byteStringMicro);
        this.sender_nick = PBField.initBytes(byteStringMicro);
        this.ext_info = PBField.initInt32(0);
        this.feed_url = PBField.initBytes(byteStringMicro);
        this.msg_type = PBField.initInt32(0);
    }
}
