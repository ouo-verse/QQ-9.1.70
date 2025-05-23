package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class CommonOuterClass$ImageItem extends MessageMicro<CommonOuterClass$ImageItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"url", "type"}, new Object[]{"", ""}, CommonOuterClass$ImageItem.class);
    public final PBStringField url = PBField.initString("");
    public final PBStringField type = PBField.initString("");
}
