package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class qzoneWnsSwitch$SetMultiWnsSwitchReq extends MessageMicro<qzoneWnsSwitch$SetMultiWnsSwitchReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"sws"}, new Object[]{null}, qzoneWnsSwitch$SetMultiWnsSwitchReq.class);
    public final PBRepeatMessageField<qzoneWnsSwitch$StSwitch> sws = PBField.initRepeatMessage(qzoneWnsSwitch$StSwitch.class);
}
