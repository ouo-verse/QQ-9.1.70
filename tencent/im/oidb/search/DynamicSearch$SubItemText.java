package tencent.im.oidb.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class DynamicSearch$SubItemText extends MessageMicro<DynamicSearch$SubItemText> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField color;
    public final PBBytesField text;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"text", "color"}, new Object[]{byteStringMicro, byteStringMicro}, DynamicSearch$SubItemText.class);
    }

    public DynamicSearch$SubItemText() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.text = PBField.initBytes(byteStringMicro);
        this.color = PBField.initBytes(byteStringMicro);
    }
}
