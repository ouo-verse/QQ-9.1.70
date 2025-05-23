package tvideo;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes30.dex */
public final class TVideoFloatPr$QqDisplayInfo extends MessageMicro<TVideoFloatPr$QqDisplayInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"displayType", "displayBytes"}, new Object[]{0, ByteStringMicro.EMPTY}, TVideoFloatPr$QqDisplayInfo.class);
    public final PBEnumField displayType = PBField.initEnum(0);
    public final PBBytesField displayBytes = PBField.initBytes(ByteStringMicro.EMPTY);
}
