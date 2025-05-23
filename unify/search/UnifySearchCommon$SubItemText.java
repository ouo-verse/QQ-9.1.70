package unify.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class UnifySearchCommon$SubItemText extends MessageMicro<UnifySearchCommon$SubItemText> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField color;
    public final PBBytesField text;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"text", "color"}, new Object[]{byteStringMicro, byteStringMicro}, UnifySearchCommon$SubItemText.class);
    }

    public UnifySearchCommon$SubItemText() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.text = PBField.initBytes(byteStringMicro);
        this.color = PBField.initBytes(byteStringMicro);
    }
}
