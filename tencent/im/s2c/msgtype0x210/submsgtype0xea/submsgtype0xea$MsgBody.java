package tencent.im.s2c.msgtype0x210.submsgtype0xea;

import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0xea$MsgBody extends MessageMicro<submsgtype0xea$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_content;
    public final PBBytesField bytes_title;

    static {
        String[] strArr = {"bytes_title", MessageForUniteGrayTip.KEY_BYTES_CONTENT};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, strArr, new Object[]{byteStringMicro, byteStringMicro}, submsgtype0xea$MsgBody.class);
    }

    public submsgtype0xea$MsgBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_title = PBField.initBytes(byteStringMicro);
        this.bytes_content = PBField.initBytes(byteStringMicro);
    }
}
