package tencent.im.s2c.msgtype0x210.submsgtype0x6b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x6b$MsgBody extends MessageMicro<SubMsgType0x6b$MsgBody> {
    public static final int BYTES_NO_TEXT_FIELD_NUMBER = 4;
    public static final int BYTES_TIPS_CONTENT_FIELD_NUMBER = 2;
    public static final int BYTES_YES_TEXT_FIELD_NUMBER = 3;
    public static final int UINT64_TO_UIN_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_no_text;
    public final PBBytesField bytes_tips_content;
    public final PBBytesField bytes_yes_text;
    public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"uint64_to_uin", "bytes_tips_content", "bytes_yes_text", "bytes_no_text"}, new Object[]{0L, byteStringMicro, byteStringMicro, byteStringMicro}, SubMsgType0x6b$MsgBody.class);
    }

    public SubMsgType0x6b$MsgBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_tips_content = PBField.initBytes(byteStringMicro);
        this.bytes_yes_text = PBField.initBytes(byteStringMicro);
        this.bytes_no_text = PBField.initBytes(byteStringMicro);
    }
}
