package tencent.im.s2c.msgtype0x210.submsgtype0xc7;

import com.tencent.mobileqq.app.MessageHandlerConstants;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0xc7$RelationalChainInfo extends MessageMicro<submsgtype0xc7$RelationalChainInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_attr;
    public final PBBytesField bytes_intimate_info;
    public final PBBytesField bytes_music_switch;
    public final PBBytesField bytes_mutualmark_alienation;
    public final PBEnumField uint64_type = PBField.initEnum(1);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, MessageHandlerConstants.NOTIFY_TYPE_REQ_BLESS_DIRTY_TEXT_CHECK, 728010, 808010}, new String[]{"uint64_type", "bytes_attr", "bytes_intimate_info", "bytes_music_switch", "bytes_mutualmark_alienation"}, new Object[]{1, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro}, submsgtype0xc7$RelationalChainInfo.class);
    }

    public submsgtype0xc7$RelationalChainInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_attr = PBField.initBytes(byteStringMicro);
        this.bytes_intimate_info = PBField.initBytes(byteStringMicro);
        this.bytes_music_switch = PBField.initBytes(byteStringMicro);
        this.bytes_mutualmark_alienation = PBField.initBytes(byteStringMicro);
    }
}
