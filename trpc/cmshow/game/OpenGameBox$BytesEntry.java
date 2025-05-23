package trpc.cmshow.game;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OpenGameBox$BytesEntry extends MessageMicro<OpenGameBox$BytesEntry> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"key", "value"}, new Object[]{"", ByteStringMicro.EMPTY}, OpenGameBox$BytesEntry.class);
    public final PBStringField key = PBField.initString("");
    public final PBBytesField value = PBField.initBytes(ByteStringMicro.EMPTY);
}
