package tencent.im.oidb.cmd0xac5;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xac5$NearbyLabelInfo extends MessageMicro<cmd0xac5$NearbyLabelInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field font_colour;
    public final PBUInt32Field label_colour;
    public final PBUInt32Field label_id = PBField.initUInt32(0);
    public final PBBytesField label_name;
    public final PBBytesField label_pic;
    public final PBUInt32Field show_day;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 48}, new String[]{"label_id", "label_pic", "label_name", "label_colour", "font_colour", "show_day"}, new Object[]{0, byteStringMicro, byteStringMicro, 0, 0, 0}, cmd0xac5$NearbyLabelInfo.class);
    }

    public cmd0xac5$NearbyLabelInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.label_pic = PBField.initBytes(byteStringMicro);
        this.label_name = PBField.initBytes(byteStringMicro);
        this.label_colour = PBField.initUInt32(0);
        this.font_colour = PBField.initUInt32(0);
        this.show_day = PBField.initUInt32(0);
    }
}
