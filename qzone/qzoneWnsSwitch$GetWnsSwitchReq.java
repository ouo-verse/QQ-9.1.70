package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class qzoneWnsSwitch$GetWnsSwitchReq extends MessageMicro<qzoneWnsSwitch$GetWnsSwitchReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"switch_key"}, new Object[]{""}, qzoneWnsSwitch$GetWnsSwitchReq.class);
    public final PBStringField switch_key = PBField.initString("");
}
