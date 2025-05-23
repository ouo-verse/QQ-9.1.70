package tencent.kandian.ugc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class topic_info$ModuleInfo extends MessageMicro<topic_info$ModuleInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"id", "name"}, new Object[]{0, ""}, topic_info$ModuleInfo.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt32Field f436063id = PBField.initUInt32(0);
    public final PBStringField name = PBField.initString("");
}
