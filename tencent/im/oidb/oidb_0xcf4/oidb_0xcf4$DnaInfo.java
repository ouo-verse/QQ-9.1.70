package tencent.im.oidb.oidb_0xcf4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xcf4$DnaInfo extends MessageMicro<oidb_0xcf4$DnaInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_icon_url;
    public final PBBytesField bytes_link_colour;
    public final PBBytesField bytes_link_url;
    public final PBBytesField bytes_link_wording;
    public final PBBytesField bytes_vice_title;
    public final PBBytesField bytes_wording;
    public final PBEnumField eDnaType = PBField.initEnum(1);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58}, new String[]{"eDnaType", "bytes_icon_url", "bytes_wording", "bytes_vice_title", "bytes_link_url", "bytes_link_wording", "bytes_link_colour"}, new Object[]{1, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro}, oidb_0xcf4$DnaInfo.class);
    }

    public oidb_0xcf4$DnaInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_icon_url = PBField.initBytes(byteStringMicro);
        this.bytes_wording = PBField.initBytes(byteStringMicro);
        this.bytes_vice_title = PBField.initBytes(byteStringMicro);
        this.bytes_link_url = PBField.initBytes(byteStringMicro);
        this.bytes_link_wording = PBField.initBytes(byteStringMicro);
        this.bytes_link_colour = PBField.initBytes(byteStringMicro);
    }
}
