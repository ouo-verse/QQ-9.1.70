package trpc.yes.common;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class MessageOuterClass$ArkBaseInfo extends MessageMicro<MessageOuterClass$ArkBaseInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"appid", "view", "version", "prompt", PublicAccountMessageUtilImpl.META_NAME}, new Object[]{"", "", "", "", ""}, MessageOuterClass$ArkBaseInfo.class);
    public final PBStringField appid = PBField.initString("");
    public final PBStringField view = PBField.initString("");
    public final PBStringField version = PBField.initString("");
    public final PBStringField prompt = PBField.initString("");
    public final PBStringField meta = PBField.initString("");
}
