package tencent.im.medal;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.view.FilterEnum;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class common$MedalTaskInfo extends MessageMicro<common$MedalTaskInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 256, 264, 272, FilterEnum.MIC_PTU_TRANS_XINXIAN}, new String[]{"uint32_taskid", "int32_task_value", "uint32_tar_value", "uint32_tar_value_level2", "uint32_tar_value_level3"}, new Object[]{0, 0, 0, 0, 0}, common$MedalTaskInfo.class);
    public final PBUInt32Field uint32_taskid = PBField.initUInt32(0);
    public final PBInt32Field int32_task_value = PBField.initInt32(0);
    public final PBUInt32Field uint32_tar_value = PBField.initUInt32(0);
    public final PBUInt32Field uint32_tar_value_level2 = PBField.initUInt32(0);
    public final PBUInt32Field uint32_tar_value_level3 = PBField.initUInt32(0);
}
