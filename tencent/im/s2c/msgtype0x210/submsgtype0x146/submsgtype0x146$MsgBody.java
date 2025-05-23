package tencent.im.s2c.msgtype0x210.submsgtype0x146;

import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0x146$MsgBody extends MessageMicro<submsgtype0x146$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"uint32_push_from", "uint32_push_type", MessageForUniteGrayTip.KEY_BYTES_CONTENT, "tab_data"}, new Object[]{0, 0, ByteStringMicro.EMPTY, null}, submsgtype0x146$MsgBody.class);
    public final PBEnumField uint32_push_from = PBField.initEnum(0);
    public final PBEnumField uint32_push_type = PBField.initEnum(0);
    public final PBBytesField bytes_content = PBField.initBytes(ByteStringMicro.EMPTY);
    public submsgtype0x146$TabData tab_data = new submsgtype0x146$TabData();
}
