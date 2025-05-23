package tencent.im.cs.cmd0x388;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x388$ExpRoamExtendInfo extends MessageMicro<cmd0x388$ExpRoamExtendInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_resid;
    public final PBBytesField emoji_extend_info;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"bytes_resid", "emoji_extend_info"}, new Object[]{byteStringMicro, byteStringMicro}, cmd0x388$ExpRoamExtendInfo.class);
    }

    public cmd0x388$ExpRoamExtendInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_resid = PBField.initBytes(byteStringMicro);
        this.emoji_extend_info = PBField.initBytes(byteStringMicro);
    }
}
