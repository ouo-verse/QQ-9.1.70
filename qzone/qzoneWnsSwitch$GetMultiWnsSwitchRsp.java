package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class qzoneWnsSwitch$GetMultiWnsSwitchRsp extends MessageMicro<qzoneWnsSwitch$GetMultiWnsSwitchRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"sws"}, new Object[]{null}, qzoneWnsSwitch$GetMultiWnsSwitchRsp.class);
    public final PBRepeatMessageField<qzoneWnsSwitch$StSwitch> sws = PBField.initRepeatMessage(qzoneWnsSwitch$StSwitch.class);
}
