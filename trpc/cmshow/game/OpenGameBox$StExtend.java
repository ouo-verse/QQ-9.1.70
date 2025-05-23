package trpc.cmshow.game;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OpenGameBox$StExtend extends MessageMicro<OpenGameBox$StExtend> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"str2str", "str2bytes", "attachInfo"}, new Object[]{null, null, ""}, OpenGameBox$StExtend.class);
    public final PBRepeatMessageField<OpenGameBox$Entry> str2str = PBField.initRepeatMessage(OpenGameBox$Entry.class);
    public final PBRepeatMessageField<OpenGameBox$BytesEntry> str2bytes = PBField.initRepeatMessage(OpenGameBox$BytesEntry.class);
    public final PBStringField attachInfo = PBField.initString("");
}
