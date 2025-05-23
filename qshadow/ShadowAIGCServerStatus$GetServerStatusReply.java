package qshadow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ShadowAIGCServerStatus$GetServerStatusReply extends MessageMicro<ShadowAIGCServerStatus$GetServerStatusReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"capacity", "collection_capacity"}, new Object[]{0, 0}, ShadowAIGCServerStatus$GetServerStatusReply.class);
    public final PBInt32Field capacity = PBField.initInt32(0);
    public final PBInt32Field collection_capacity = PBField.initInt32(0);
}
