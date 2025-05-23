package tencent.im.oidb.cmd0x799;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x799$LongNickInfo extends MessageMicro<oidb_0x799$LongNickInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField StrNick;
    public final PBBytesField StrTopicId;
    public final PBUInt32Field Type;
    public final PBUInt32Field dwCreateTime;
    public final PBUInt32Field dwDelTime;
    public final PBUInt32Field dwModiTime;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 48}, new String[]{"StrTopicId", "StrNick", "Type", "dwCreateTime", "dwModiTime", "dwDelTime"}, new Object[]{byteStringMicro, byteStringMicro, 0, 0, 0, 0}, oidb_0x799$LongNickInfo.class);
    }

    public oidb_0x799$LongNickInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.StrTopicId = PBField.initBytes(byteStringMicro);
        this.StrNick = PBField.initBytes(byteStringMicro);
        this.Type = PBField.initUInt32(0);
        this.dwCreateTime = PBField.initUInt32(0);
        this.dwModiTime = PBField.initUInt32(0);
        this.dwDelTime = PBField.initUInt32(0);
    }
}
