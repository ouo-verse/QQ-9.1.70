package tencent.im.oidb.cmd0xe84;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBSInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xe84$CustomData extends MessageMicro<oidb_0xe84$CustomData> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_data;
    public final PBBytesField bytes_icon_link;
    public final PBBytesField bytes_jump_link;
    public final PBBytesField bytes_png_link;
    public final PBBytesField bytes_text_color;
    public final PBSInt32Field sint32_result = PBField.initSInt32(0);
    public oidb_0xe84$Condition msg_condi = new oidb_0xe84$Condition();

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58}, new String[]{"sint32_result", "msg_condi", "bytes_data", "bytes_jump_link", "bytes_png_link", "bytes_icon_link", "bytes_text_color"}, new Object[]{0, null, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro}, oidb_0xe84$CustomData.class);
    }

    public oidb_0xe84$CustomData() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_data = PBField.initBytes(byteStringMicro);
        this.bytes_jump_link = PBField.initBytes(byteStringMicro);
        this.bytes_png_link = PBField.initBytes(byteStringMicro);
        this.bytes_icon_link = PBField.initBytes(byteStringMicro);
        this.bytes_text_color = PBField.initBytes(byteStringMicro);
    }
}
