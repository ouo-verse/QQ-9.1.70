package tencent.im.oidb.oidb_0xcf4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xcf4$DateTips extends MessageMicro<oidb_0xcf4$DateTips> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_icon_url;
    public final PBBytesField bytes_link_colour;
    public final PBBytesField bytes_link_url;
    public final PBBytesField bytes_link_wording;
    public final PBBytesField bytes_wording;
    public final PBEnumField eDateType = PBField.initEnum(1);
    public final PBEnumField eJumpType;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 64}, new String[]{"eDateType", "bytes_icon_url", "bytes_wording", "bytes_link_url", "bytes_link_wording", "bytes_link_colour", "eJumpType"}, new Object[]{1, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 1}, oidb_0xcf4$DateTips.class);
    }

    public oidb_0xcf4$DateTips() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_icon_url = PBField.initBytes(byteStringMicro);
        this.bytes_wording = PBField.initBytes(byteStringMicro);
        this.bytes_link_url = PBField.initBytes(byteStringMicro);
        this.bytes_link_wording = PBField.initBytes(byteStringMicro);
        this.bytes_link_colour = PBField.initBytes(byteStringMicro);
        this.eJumpType = PBField.initEnum(1);
    }
}
