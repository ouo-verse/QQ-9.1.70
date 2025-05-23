package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class BaseInterfaceOuterClass$NetInfo extends MessageMicro<BaseInterfaceOuterClass$NetInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"client_ip"}, new Object[]{""}, BaseInterfaceOuterClass$NetInfo.class);
    public final PBStringField client_ip = PBField.initString("");
}
