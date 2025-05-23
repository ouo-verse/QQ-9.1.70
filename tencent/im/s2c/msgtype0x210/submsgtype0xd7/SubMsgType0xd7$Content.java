package tencent.im.s2c.msgtype0x210.submsgtype0xd7;

import appoint.define.appoint_define$RichText;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0xd7$Content extends MessageMicro<SubMsgType0xd7$Content> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_buluo_word;
    public final PBBytesField bytes_from_user;
    public final PBBytesField bytes_plain_text;
    public appoint_define$RichText rich_fresh_word;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"bytes_from_user", "bytes_plain_text", "bytes_buluo_word", "rich_fresh_word"}, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro, null}, SubMsgType0xd7$Content.class);
    }

    public SubMsgType0xd7$Content() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_from_user = PBField.initBytes(byteStringMicro);
        this.bytes_plain_text = PBField.initBytes(byteStringMicro);
        this.bytes_buluo_word = PBField.initBytes(byteStringMicro);
        this.rich_fresh_word = new appoint_define$RichText();
    }
}
