package tencent.im.group_pro_proto.common;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class common$MsgCoreInfo extends MessageMicro<common$MsgCoreInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField msg_meta;
    public final PBBytesField token;
    public final PBUInt64Field guild_id = PBField.initUInt64(0);
    public final PBUInt64Field channel_id = PBField.initUInt64(0);
    public final PBUInt64Field msg_seq = PBField.initUInt64(0);
    public final PBUInt64Field cnt_seq = PBField.initUInt64(0);
    public final PBUInt64Field msg_time = PBField.initUInt64(0);

    static {
        String[] strArr = {"guild_id", "channel_id", "msg_seq", "cnt_seq", ProtocolDownloaderConstants.HEADER_C2C_MSG_TIME, "msg_meta", "token"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 50, 802}, strArr, new Object[]{0L, 0L, 0L, 0L, 0L, byteStringMicro, byteStringMicro}, common$MsgCoreInfo.class);
    }

    public common$MsgCoreInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.msg_meta = PBField.initBytes(byteStringMicro);
        this.token = PBField.initBytes(byteStringMicro);
    }
}
