package tencent.im.plugin;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ResourceConfig$GetResourceRespV2 extends MessageMicro<ResourceConfig$GetResourceRespV2> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42}, new String[]{"uin", "result", "addedResInfo", "deletedResInfo", "updatedResInfo"}, new Object[]{0, 0, null, null, null}, ResourceConfig$GetResourceRespV2.class);
    public final PBUInt32Field uin = PBField.initUInt32(0);
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBRepeatMessageField<ResourceConfig$GetResourceRespInfoV2> addedResInfo = PBField.initRepeatMessage(ResourceConfig$GetResourceRespInfoV2.class);
    public final PBRepeatMessageField<ResourceConfig$GetResourceRespInfoV2> deletedResInfo = PBField.initRepeatMessage(ResourceConfig$GetResourceRespInfoV2.class);
    public final PBRepeatMessageField<ResourceConfig$GetResourceRespInfoV2> updatedResInfo = PBField.initRepeatMessage(ResourceConfig$GetResourceRespInfoV2.class);
}
